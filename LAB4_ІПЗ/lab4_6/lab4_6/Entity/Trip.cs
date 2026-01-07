namespace lab2_6.Entity;

public class Trip
{
    public int Id { get; set; }
    public string TripName { get; set; }
    public int TrainId { get; set; }
    public string TrainName { get; set; }
    public int Number { get; set; }
    public double Mark { get; set; }
    public int AmountSeats { get; set; }
    
    public DateTime StartDate { get; set; }
    public DateTime EndDate { get; set; }
}