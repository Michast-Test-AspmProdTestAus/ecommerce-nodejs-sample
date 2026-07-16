use std::process::Command;
use std::io::{self, BufRead};

fn main() {
    println!("Sample Rust Application");
    
    let stdin = io::stdin();
    let user_input = stdin.lock().lines().next().unwrap().unwrap();
    
    // Potential command injection
    let output = Command::new("sh")
        .arg("-c")
        .arg(&user_input)
        .output()
        .expect("Failed to execute");
    
    // Unsafe file path construction
    let path = format!("/data/{}", user_input);
    let contents = std::fs::read_to_string(path).unwrap();
    
    println!("{}", String::from_utf8_lossy(&output.stdout));
}
