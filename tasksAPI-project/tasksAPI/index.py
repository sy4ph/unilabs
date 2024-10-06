
import os
import json
from flask import Flask, jsonify, request
from flask_jwt_extended import JWTManager, create_access_token, jwt_required, get_jwt_identity
import hashlib
import itertools

app = Flask(__name__)
app.config['JWT_SECRET_KEY'] = "1029384756qweewq"
app.config["JWT_TOKEN_LOCATION"] = ["headers"]

jwt = JWTManager(app)
db = json.load(open(os.path.join(os.path.dirname(__file__), "tasks.json")))
def save_db():
    json.dump(db, open(os.path.join(os.path.dirname(__file__), "tasks.json"), "w"))

@app.route("/register", methods = ['POST'])
def register():
    data = request.get_json()
    if data is None or not all([data.get('name'), data.get('email'), data.get('password')]):
        return jsonify({"error" : "Missing fields"}), 400
    if data is None or any(user['email'] == data['email'] for user in db["users"]):
        return jsonify({"error" : "User already exists"}), 400
    data['id'] = len(db["users"]) + 1
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
        access_token = create_access_token(identity=user['id'], additional_claims={"sub": user['id']})
        return jsonify(access_token = access_token, sub = user['id'])
    return jsonify({"error" : "Invalid credentials"}), 401

@app.route("/db_reread", methods = ['POST'])
def reread():
    data = request.get_json()
    if "secret" not in data:
        return jsonify({"error" : "Missing fields"}), 400
    if data['secret'] != "qwerty":
        return jsonify({"error" : "Invalid secret"}), 401
    global db
    db = json.load(open(os.path.join(os.path.dirname(__file__), "tasks.json")))
    return jsonify({"message" : "Successful"}), 200

@app.route("/tasks", methods = ['GET'])
@jwt_required()
def get_tasks():
    #pagination
    page = int(request.args.get('page', 1))
    limit = int(request.args.get('limit', 10))
    start = (page - 1) * limit
    end = start + limit
    if page < 1:
        return jsonify({"error" : "Invalid page"}), 400
    if limit < 1:
        return jsonify({"error" : "Invalid limit"}), 400
    if start > len(db["users"][get_jwt_identity() - 1]['tasks']):
        return jsonify({"error" : "No content"}), 204
    if end > len(db["users"][get_jwt_identity() - 1]['tasks']):
        end = len(db["users"][get_jwt_identity() - 1]['tasks'])
    if start == end:
        return jsonify({"error" : "No content"}), 204
    tasks = []
    for i in range(len(db["users"][get_jwt_identity() - 1]['tasks'])):
        if i >= start and i < end:
            tasks.append(db["users"][get_jwt_identity() - 1]['tasks'][str(i)])
    response_data = {
        "tasks": tasks,
        "page": page,
        "limit": limit,
        "total": len(db["users"][get_jwt_identity() - 1]['tasks'])
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
    task_id = len(db["users"][get_jwt_identity() - 1]['tasks']) + 1
    response_data = {"task_id" : task_id, "title" : data['title'], "description" : data['description'], "status" : data['status'], "due" : data['due']}
    db["users"][get_jwt_identity() - 1]['tasks'][task_id - 1] = response_data
    save_db()
    return jsonify({"message" : "Successful"}), 201

@app.route("/tasks/<int:task_id>", methods = ['GET'])
@jwt_required()
def get_task(task_id):
    if task_id < 1 or task_id > len(db["users"][get_jwt_identity() - 1]['tasks']):
        return jsonify({"error" : "Not found"}), 404
    return jsonify(db["users"][get_jwt_identity() - 1]['tasks'][task_id - 1]), 200

@app.route("/tasks/<int:task_id>", methods = ['PUT'])
@jwt_required()
def update_task(task_id):
    data = request.get_json()
    db["users"][get_jwt_identity() - 1]['tasks'][task_id - 1] = data
    return jsonify({"message" : "Successful"}), 200

@app.route("/tasks/<int:task_id>", methods = ['DELETE'])
@jwt_required()
def delete_task(task_id):
    del db ["users"][get_jwt_identity() - 1]['tasks'][str(task_id - 1)]
    return jsonify({"message" : "Successful"}), 204

@jwt.unauthorized_loader
def unauthorized_response(callback):
    return jsonify({"error" : "Unathorized"}), 401

if __name__ == ("__main__"):
    app.run(debug=True)