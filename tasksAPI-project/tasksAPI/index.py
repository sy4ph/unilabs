
import os
import json
from flask import Flask, jsonify, request
from flask_jwt_extended import JWTManager, create_access_token, jwt_required, get_jwt
import hashlib

app = Flask(__name__)
app.config['JWT_SECRET_KEY'] = "1029384756qweewq"
app.config["JWT_TOKEN_LOCATION"] = ["headers"]

jwt = JWTManager(app)
tasks_json_path = os.path.join(os.path.dirname(__file__), "tasks.json")
if not os.path.exists(tasks_json_path):
    with open(tasks_json_path, "w") as f:
        json.dump({"users" : []}, f) # типа миграция пон

with open(tasks_json_path, "r+") as tasks_json_file:
    global db
    db = json.load(tasks_json_file)
 
def save_db():
    with open(tasks_json_path, "w") as f:
        json.dump(db, f)

def reload_db():
    global db
    db = json.load(open(tasks_json_path))

@app.route("/register", methods = ['POST'])
def register():
    data = request.get_json()
    if data is None or not all([data.get('name'), data.get('email'), data.get('password')]):
        return jsonify({"error" : "Missing fields"}), 400
    if data is None or any(user['email'] == data['email'] for user in db["users"]):
        return jsonify({"error" : "User already exists"}), 400
    data['id'] = len(db["users"])
    data['password'] = hashlib.sha256(data['password'].encode()).hexdigest()
    data['tasks'] = {}
    data_parsed = {"id" : data["id"],  "name" : data['name'], "email" : data['email'], "password" : data['password'], "tasks" : data['tasks']}
    db["users"].append(data_parsed)
    save_db()
    return jsonify({"message" : "Successful"}), 201


@app.route("/login", methods = ['POST'])
def login():
    data = request.json
    user = next((user for user in db["users"] if user['email'] == data['email']), None)
    if user and user['password'] == hashlib.sha256(data['password'].encode()).hexdigest():
        access_token = create_access_token(identity=None, additional_claims={"sub": user['id']})
        return jsonify(access_token = access_token)
    return jsonify({"error" : "Invalid credentials"}), 401

@app.route("/db_reread", methods = ['POST'])
def reread():
    data = request.get_json()
    if "secret" not in data:
        return jsonify({"error" : "Missing fields"}), 400
    if data['secret'] != "qerty":
        return jsonify({"error" : "Invalid secret"}), 401
    global db
    db = json.load(open(tasks_json_path))
    return jsonify({"message" : "Successful"}), 200

@app.route("/tasks", methods = ['GET'])
@jwt_required()
def get_tasks():
    #pagination
    reload_db()
    page = int(request.args.get('page', 1))
    limit = int(request.args.get('limit', 10))
    start = (page - 1) * limit
    end = start + limit
    user_id = get_jwt()["sub"]
    db_tasks = db["users"][user_id]['tasks']
    if page < 1:
        return jsonify({"error" : "Invalid page"}), 400
    if limit < 1:
        return jsonify({"error" : "Invalid limit"}), 400
    if start > len(db_tasks):
        return jsonify({"error" : "No content"}), 204
    if end > len(db_tasks):
        end = len(db_tasks)
    if start == end:
        return jsonify({"error" : "No content"}), 204
    tasks = []
    for i in range(len(db_tasks)):
        tasks.append(db_tasks[str(i)])
    response_data = {
        "tasks": tasks,
        "page": page,
        "limit": limit,
        "total": len(db["users"][user_id]['tasks'])
    }
    return jsonify(response_data), 200


@app.route("/tasks", methods = ['POST'])
@jwt_required()
def add_task():
    data = request.get_json()
    if data is None or not all([data.get('title'), data.get('description')]):
        return jsonify({"error" : "Missing fields"}), 400
    if data.get('status') is None:
        data['status'] = "pending"
    if data.get('due') is None:
        data['due'] = "None"
    user_id = get_jwt()["sub"]
    task_id = len(db["users"][user_id]['tasks'])
    response_data = {"task_id" : task_id, "title" : data['title'], "description" : data['description'], "status" : data['status'], "due" : data['due']}
    db["users"][user_id]['tasks'][task_id] = response_data
    save_db()
    return jsonify({"message" : "Successful"}), 201

@app.route("/tasks/<int:task_id>", methods = ['GET'])
@jwt_required()
def get_task(task_id):
    user_id = get_jwt()["sub"]
    if task_id < 1 or task_id > len(db["users"][user_id]['tasks']):
        return jsonify({"error" : "Not found"}), 404
    return jsonify(db["users"][user_id]['tasks'][task_id]), 200

@app.route("/tasks/<int:task_id>", methods = ['PUT'])
@jwt_required()
def update_task(task_id):
    user_id = get_jwt()["sub"]
    data = request.get_json()
    db["users"][user_id]['tasks'][task_id] = data
    return jsonify({"message" : "Successful"}), 200

@app.route("/tasks/<int:task_id>", methods = ['DELETE'])
@jwt_required()
def delete_task(task_id):
    user_id = get_jwt()["sub"]
    del db ["users"][user_id]['tasks'][str(task_id)]
    return jsonify({"message" : "Successful"}), 204

@jwt.unauthorized_loader
def unauthorized_response(callback):
    return jsonify({"error" : "Unathorized"}), 401

if __name__ == ("__main__"):
    app.run(debug=True)