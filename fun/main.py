import json
import os

token = False
data = json.load(open(os.path.join(os.path.dirname(__file__), 'data.json')))

class UserNotFound(Exception):
    pass

class UserAlreadyExists(Exception):
    pass

class InvalidPassword(Exception):
    pass



def login(username, password):
    if username in data["users"] and data['users'][username]["password"] == password:
        return data['users'][username]["token"]
    return InvalidPassword

def get_user(token):
    for user in data["users"]:
        if data["users"][user]["token"] == token:
            return user
    return UserNotFound

def add_user(username, password):
    if username in data["users"]:
        return UserAlreadyExists
    data["users"][username] = {"password": password, "token": os.urandom(16).hex()}
    json.dump(data, open(os.path.join(os.path.dirname(__file__), 'data.json'), 'w'))
    return True

def add_task():
    taskname = input("Task name: ")
    task = input("Task: ")
    deadline = input("Deadline (input None if no deadline): ")
    if deadline == "None":
        deadline = None
    while True:
        try:
            priority = int(input("Priority: "))
        except ValueError:
            print("Priority must be an integer, bozo")
            continue
        break
    data['users'][get_user(token)]["tasks"][taskname] = {"task": task, "deadline": deadline, "priority": priority}

def remove_task():
    taskname = input("Task name: ")
    if taskname in data['users'][get_user(token)]["tasks"]:
        del data['users'][get_user(token)]["tasks"][taskname]
    else:
        print("Task not found")

def view_tasks():
    for task in data['users'][get_user(token)]["tasks"]:
        print(f"Task: {task}\n{data['users'][get_user(token)]['tasks'][task]}")

while not token:
    command = input("Login or Sign-up: ")
    if command == "Sign-up":
        if add_user(input("Username: "), input("Password: ")):
            print("Signed up successfully")
        else:
            print("User already exists")
    else:
        token = login(input("Username: "), input("Password: "))
    if not token:
        print("Invalid username or password")
print("Logged in successfully")
while True:
    command = input("Command: ")
    match command:
        case "add":
            add_task()
        case "remove":
            remove_task()
        case "view":
            view_tasks()
        case "exit":
            break
        case "help":
            print("Commands: add, remove, view, exit, help")
        case _:
            print("Invalid command")

