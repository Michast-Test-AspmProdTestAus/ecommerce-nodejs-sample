package main

import (
    "database/sql"
    "fmt"
    "net/http"
    "os/exec"
)

func handler(w http.ResponseWriter, r *http.Request) {
    userInput := r.URL.Query().Get("input")
    
    // Potential command injection
    cmd := exec.Command("sh", "-c", userInput)
    output, _ := cmd.Output()
    
    // Potential SQL injection
    db, _ := sql.Open("mysql", "user:pass@/dbname")
    db.Query("SELECT * FROM users WHERE name = '" + userInput + "'")
    
    // Potential XSS
    fmt.Fprintf(w, "<html><body>%s</body></html>", userInput)
}

func main() {
    http.HandleFunc("/", handler)
    http.ListenAndServe(":8080", nil)
}
