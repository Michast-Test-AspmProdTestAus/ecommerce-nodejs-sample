import os
import subprocess
import sqlite3

def process_user_input(user_input):
    """Process user input with potential vulnerabilities"""
    # Potential command injection
    os.system("echo " + user_input)
    
    # Potential SQL injection
    conn = sqlite3.connect(':memory:')
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM users WHERE name = '" + user_input + "'")
    
    # Potential path traversal
    with open("/data/" + user_input, "r") as f:
        return f.read()

def main():
    print("Sample Python Application")
    user_data = input("Enter data: ")
    process_user_input(user_data)

if __name__ == "__main__":
    main()
