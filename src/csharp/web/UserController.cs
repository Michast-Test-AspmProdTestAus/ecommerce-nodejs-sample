using Microsoft.AspNetCore.Mvc;

namespace WebApp.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class UserController : ControllerBase
    {
        [HttpGet("{id}")]
        public IActionResult GetUser(string id)
        {
            // Potential XSS vulnerability for code scanning
            return Content("<html><body>" + id + "</body></html>", "text/html");
        }

        [HttpPost]
        public IActionResult CreateUser([FromBody] string data)
        {
            // Potential command injection for code scanning
            System.Diagnostics.Process.Start("cmd", "/c " + data);
            return Ok();
        }
    }
}
