using System.Threading.Tasks;
using System.Windows;
using lab2_6.Entity;

namespace lab2_6.Request
{
    public class RegisterRequest
    {
        public static async Task<bool> RegisterAsync(string username, string password, string passwordConfirmation)
        {
            await Task.Delay(200);

            if (password != passwordConfirmation)
            {
                MessageBox.Show("Паролі не співпадають.");
                return false;
            }

            if (string.IsNullOrWhiteSpace(username))
            {
                MessageBox.Show("Ім'я користувача не може бути порожнім.");
                return false;
            }
            
            AuthEntity.userId = 42; 
            MessageBox.Show("Користувача успішно зареєстровано.");
            return true;
        }

        public class ResponseWrapper
        {
            public bool success { get; set; }
            public string message { get; set; }
        }
    }
}