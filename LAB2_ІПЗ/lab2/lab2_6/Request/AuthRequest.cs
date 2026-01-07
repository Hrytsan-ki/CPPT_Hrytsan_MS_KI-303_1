using System.Threading.Tasks;
using System.Windows;
using lab2_6.Entity;

namespace lab2_6.Request
{
    public class AuthRequest
    {
        public static async Task<bool> AuthAsync(string username, string password)
        {
            await Task.Delay(200);
            
            if (!string.IsNullOrWhiteSpace(username) && !string.IsNullOrWhiteSpace(password))
            {
                AuthEntity.userId = 1;
                return true;
            }
            
            MessageBox.Show("Невірний логін або пароль.");
            return false;
        }

        public class ResponseWrapper
        {
            public bool success { get; set; }
            public string message { get; set; }
        }
    }
}