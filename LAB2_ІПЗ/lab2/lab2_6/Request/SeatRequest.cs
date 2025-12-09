using System.Threading.Tasks;
using System.Windows;

namespace lab2_6.Request
{
    public class SeatRequest
    {
        public static async Task<bool> SeatAsync(int userId, int trainNumber, int? seatNumber)
        {
            await Task.Delay(150);

            if (seatNumber is null)
            {
                MessageBox.Show("Місце не вибрано.");
                return false;
            }
            int seat = (seatNumber.Value + 1);
            MessageBox.Show(
                $"Користувач #{userId} зайняв місце #{seat} у поїзді #{trainNumber}.");

            return true;
        }

        public class ResponseWrapper
        {
            public bool success { get; set; }
            public string message { get; set; }
        }
    }
}