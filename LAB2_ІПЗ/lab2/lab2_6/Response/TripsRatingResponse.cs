using System.Collections.Generic;
using System.Threading.Tasks;
using System.Windows;
using lab2_6.Entity;

namespace lab2_6.Response
{
    public class TripsRatingResponse
    {

        public static async Task<(bool, List<Trip>)> TripsAsync()
        {
            await Task.Delay(200);
            
            var trips = new List<Trip>
            {
                new Trip
                {
                    Id = 1,
                    TripName = "Київ - Львів",
                    TrainId = 101,
                    TrainName = "Інтерсіті+",
                    Number = 1,
                    Mark = 4.8,
                    AmountSeats = 60,
                    StartDate = DateTime.Now.AddHours(2),
                    EndDate = DateTime.Now.AddHours(7)
                },
                new Trip
                {
                    Id = 2,
                    TripName = "Львів - Одеса",
                    TrainId = 85,
                    TrainName = "Нічний експрес",
                    Number = 22,
                    Mark = 4.3,
                    AmountSeats = 80,
                    StartDate = DateTime.Now.AddDays(1),
                    EndDate = DateTime.Now.AddDays(1).AddHours(9)
                },
                new Trip
                {
                    Id = 3,
                    TripName = "Харків - Дніпро",
                    TrainId = 201,
                    TrainName = "Регіональний",
                    Number = 5,
                    Mark = 3.9,
                    AmountSeats = 120,
                    StartDate = DateTime.Now.AddHours(5),
                    EndDate = DateTime.Now.AddHours(8)
                },
                new Trip
                {
                    Id = 4,
                    TripName = "Запоріжжя - Київ",
                    TrainId = 74,
                    TrainName = "Експрес",
                    Number = 19,
                    Mark = 4.6,
                    AmountSeats = 70,
                    StartDate = DateTime.Now.AddHours(10),
                    EndDate = DateTime.Now.AddHours(16)
                },
                new Trip
                {
                    Id = 5,
                    TripName = "Івано-Франківськ - Львів",
                    TrainId = 33,
                    TrainName = "Приміський",
                    Number = 7,
                    Mark = 3.5,
                    AmountSeats = 90,
                    StartDate = DateTime.Now.AddHours(1),
                    EndDate = DateTime.Now.AddHours(3)
                },
            };

            var responseObject = new ResponseWrapper
            {
                success = true,
                trips = trips
            };

            if (responseObject.success)
            {
                return (true, responseObject.trips);
            }

            MessageBox.Show("Сталася помилка.");
            return (false, new List<Trip>());
        }

        public class ResponseWrapper
        {
            public bool success { get; set; }
            public List<Trip> trips { get; set; }
        }
    }
}