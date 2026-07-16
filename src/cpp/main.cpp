#include <iostream>
#include <cstdlib>
#include <fstream>
#include <string>

int main() {
    std::string userInput;
    std::cout << "Sample C++ Application" << std::endl;
    std::cin >> userInput;
    
    // Potential command injection
    std::string command = "echo " + userInput;
    system(command.c_str());
    
    // Potential buffer overflow
    char buffer[10];
    strcpy(buffer, userInput.c_str());
    
    // Potential path traversal
    std::string filepath = "/data/" + userInput;
    std::ifstream file(filepath);
    
    return 0;
}
