namespace WorkerService1.dto;

public class TripGetResponse
{
    public int Id { get; set; }
    public string TripName { get; set; }
    public DateTime StartDate { get; set; }
    public DateTime EndDate { get; set; }
    public string TrainName { get; set; }
    public int Number { get; set; }
    public int AmountSeats { get; set; }
}