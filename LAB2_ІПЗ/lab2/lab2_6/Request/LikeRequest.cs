using System.Threading.Tasks;
using System.Windows;

namespace lab2_6.Request
{
    public class LikeRequest
    {

        public static async Task<bool> LikeAsync(int number, int tripId)
        {
            await Task.Delay(100);
            
            if (number < 1 || number > 5)
            {
                MessageBox.Show("Рейтинг має бути від 1 до 5.");
                return false;
            }
            MessageBox.Show($"Рейтинг {number} для подорожі #{tripId} збережено.");
            return true;
        }

        public class ResponseWrapper
        {
            public bool success { get; set; }
            public string message { get; set; }
        }
    }
}