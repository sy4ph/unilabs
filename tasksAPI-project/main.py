import tkinter as tk
import requests

root = tk.Tk()
root.title("Tasks API")

canvas = tk.Canvas(root, height=600, width=800)
canvas.pack()

frame = tk.Frame(root, bg='white')
frame.place(relwidth=0.8, relheight=0.8, relx=0.1, rely=0.1)

label = tk.Label(frame, text='Tasks API', bg='white')
label.pack()

token = None

if token == None:
    login_frame = tk.Frame(frame, bg='white')
    login_frame.pack()

    email_label = tk.Label(login_frame, text='Email', bg='white')
    email_label.pack()

    email_entry = tk.Entry(login_frame)
    email_entry.pack()

    password_label = tk.Label(login_frame, text='Password', bg='white')
    password_label.pack()

    password_entry = tk.Entry(login_frame, show='*')
    password_entry.pack()

    def login():
        global token
        response = requests.post('http://localhost:5000/login', json={'email': email_entry.get(), 'password': password_entry.get()})
        print(response.text)
        if response.status_code == 200:
            token = response.json()['access_token']
            login_frame.destroy()
        if response.status_code == 401:
            error_label = tk.Label(login_frame, text='Invalid credentials', bg='white')
            error_label.pack()
    
    login_button = tk.Button(login_frame, text='Login', command=login)
    login_button.pack()

    def register():
        register_frame = tk.Frame(frame, bg='white')
        register_frame.pack()

        name_label = tk.Label(register_frame, text='Name', bg='white')
        name_label.pack()

        name_entry = tk.Entry(register_frame)
        name_entry.pack()

        email_label = tk.Label(register_frame, text='Email', bg='white')
        email_label.pack()

        email_entry = tk.Entry(register_frame)
        email_entry.pack()

        password_label = tk.Label(register_frame, text='Password', bg='white')
        password_label.pack()

        password_entry = tk.Entry(register_frame, show='*')
        password_entry.pack()

        def register_user():
            response = requests.post('http://localhost:5000/register', json={'name': name_entry.get(), 'email': email_entry.get(), 'password': password_entry.get()})
            if response.status_code == 201:
                register_frame.destroy()
                login()
            if response.status_code == 400:
                error_label = tk.Label(register_frame, text='Missing fields', bg='white')
                error_label.pack()
            if response.status_code == 401:
                error_label = tk.Label(register_frame, text='User already exists', bg='white')
                error_label.pack()
            
        register_button = tk.Button(register_frame, text='Register', command=register_user)
        register_button.pack()

    send_to_register = tk.Button(login_frame, text='Register', command=register)
    send_to_register.pack()

root.mainloop()

 