import requests

# Assuming you have a token from your login route
token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJmcmVzaCI6ZmFsc2UsImlhdCI6MTcyODIzMjg3OCwianRpIjoiYjUyYTIwZjEtODEyYS00MWNiLWFiYTgtOGZmN2ExMDlhNTc0IiwidHlwZSI6ImFjY2VzcyIsInN1YiI6MywibmJmIjoxNzI4MjMyODc4LCJjc3JmIjoiM2M3M2RhMmMtMDcwZS00YWRhLTg5ZDctZWIwZTE2OTdiYmIwIiwiZXhwIjoxNzI4MjMzNzc4fQ.SKbr8BNFDUELYmT4VyrndWP9ef1B31wnImi4UmuQVO4"

headers = {
    'Authorization': f'Bearer {token}'
}

response = requests.get('http://localhost:5000/tasks', headers=headers)
print(response.text)