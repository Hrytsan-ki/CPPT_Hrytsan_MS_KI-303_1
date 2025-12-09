using System.Collections.ObjectModel;
using System.Linq;
using System.Windows;
using lab2_6.Entity;
using lab2_6.Response;

namespace lab2_6.Pages
{
    public partial class TrainRating : Window
    {
        public ObservableCollection<Trip> Trips { get; set; }
        public ObservableCollection<Trip> TripsInit { get; set; }

        public TrainRating()
        {
            InitializeComponent();
            Trips = new ObservableCollection<Trip>();
            TripsInit = new ObservableCollection<Trip>();
            GetTrips();
        }
        
        private async void GetTrips()
        {
            var (successful, tripsList) = await TripsRatingResponse.TripsAsync();
            if (successful)
            {
                foreach (var trip in tripsList)
                {
                    Trips.Add(trip);
                    TripsInit.Add(trip);
                }

                UpdateTripList();
            }
        }
        
        private void UpdateTripList()
        {
            TripsListView.ItemsSource = Trips;
        }

        private void SortByRatingClick(object sender, RoutedEventArgs e)
        {
            var sortedTrips = new ObservableCollection<Trip>(Trips.OrderByDescending(t => t.Mark));
            Trips.Clear();
            foreach (var trip in sortedTrips)
            {
                Trips.Add(trip);
            }
        }
        
        private void CloseClick(object sender, RoutedEventArgs e)
        {
            this.Close();
        }
    }
}