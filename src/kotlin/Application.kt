package com.sample

import java.io.File
import java.sql.DriverManager

fun main(args: Array<String>) {
    println("Sample Kotlin Application")
    
    val userInput = readLine() ?: ""
    
    // Potential SQL injection
    val conn = DriverManager.getConnection("jdbc:mysql://localhost/db")
    val stmt = conn.createStatement()
    stmt.executeQuery("SELECT * FROM users WHERE name = '$userInput'")
    
    // Potential command injection
    Runtime.getRuntime().exec("cmd /c $userInput")
    
    // Potential path traversal
    val file = File("/data/$userInput")
    println(file.readText())
}
