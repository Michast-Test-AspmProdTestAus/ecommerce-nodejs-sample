const express = require('express');
const { exec } = require('child_process');
const mysql = require('mysql');

const app = express();

app.get('/user/:id', (req, res) => {
    const userId = req.params.id;
    // Potential SQL injection
    const query = `SELECT * FROM users WHERE id = ${userId}`;
    
    // Potential XSS
    res.send(`<html><body>User: ${req.query.name}</body></html>`);
});

app.post('/exec', (req, res) => {
    // Potential command injection
    exec(req.body.command, (error, stdout) => {
        res.send(stdout);
    });
});

app.listen(3000, () => {
    console.log('Server running on port 3000');
});
