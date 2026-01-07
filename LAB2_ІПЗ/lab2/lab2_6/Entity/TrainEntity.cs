namespace lab2_6.Entity;

public class TrainEntity(string name, int? maxSeats, int? number)
{
    public string Name { get; set; } = name;
    public int? Number { get; set; } = number;
    public int? MaxSeats { get; set; } = maxSeats;

    public TrainEntity() : this(string.Empty, 0, 0) { }
}