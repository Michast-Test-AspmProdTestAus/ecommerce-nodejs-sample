import express, { Request, Response } from 'express';
import { exec } from 'child_process';

const app = express();

interface UserQuery {
    name: string;
    command: string;
}

app.get('/search', (req: Request<{}, {}, {}, UserQuery>, res: Response) => {
    const query = req.query.name;
    
    // Potential SQL injection
    const sqlQuery = `SELECT * FROM users WHERE name = '${query}'`;
    
    // Potential XSS
    res.send(`<div>Results for: ${query}</div>`);
});

app.post('/execute', (req: Request, res: Response) => {
    // Potential command injection
    exec(req.body.cmd, (err, stdout) => {
        res.json({ output: stdout });
    });
});

app.listen(3000);
