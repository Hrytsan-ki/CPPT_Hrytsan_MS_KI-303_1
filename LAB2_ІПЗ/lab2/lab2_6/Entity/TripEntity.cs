namespace lab2_6.Entity;

public class TripEntity(string tripName, string tripDescription, string tripTimeFrame, double? mark,TrainEntity? train)
{
    public string TripName { get; set; } = tripName;
    public string TripDescription { get; set; } = tripDescription;
    public string TripTimeFrame { get; set; } = tripTimeFrame;
    public double? Mark { get; set; } = mark;
    public TrainEntity? Train { get; set; } = train;

    public TripEntity() : this(string.Empty, string.Empty, string.Empty, 0, null)
    {
    }
}