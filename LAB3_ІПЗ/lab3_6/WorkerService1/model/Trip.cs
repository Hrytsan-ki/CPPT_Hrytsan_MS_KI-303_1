namespace WorkerService1.model;

public class Trip
{
    public int Id { get; set; }
    public string Name { get; set; }
    public int TrainId { get; set; }
    public DateTime StartDate { get; set; }
    public DateTime EndDate { get; set; }
    public Train Train { get; set; }
}