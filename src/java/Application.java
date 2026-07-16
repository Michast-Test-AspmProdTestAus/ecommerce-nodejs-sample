package com.sample;

import java.sql.*;
import java.io.*;

public class Application {
    public static void main(String[] args) throws Exception {
        System.out.println("Sample Java Application");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();
        
        // Potential SQL injection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE name = '" + userInput + "'");
        
        // Potential command injection
        Runtime.getRuntime().exec("cmd /c " + userInput);
        
        // Potential path traversal
        FileInputStream fis = new FileInputStream("/data/" + userInput);
    }
}
