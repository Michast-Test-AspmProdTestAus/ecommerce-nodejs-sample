using System;

namespace ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello from C# Console App!");
            var userInput = Console.ReadLine();
            // Potential SQL injection for code scanning
            var query = "SELECT * FROM users WHERE name = '" + userInput + "'";
            Console.WriteLine(query);
        }
    }
}
