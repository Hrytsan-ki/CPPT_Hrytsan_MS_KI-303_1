using Microsoft.EntityFrameworkCore;
using test.api;
using WorkerService1.dto;
using WorkerService1.model;

public class TripService
{
    private readonly AppDbContext _context;
    private readonly ILogger<TripService> _logger;

    public TripService(AppDbContext context, ILogger<TripService> logger)
    {
        _context = context;
        _logger = logger;
    }

    public async Task<(bool success, string message)> CreateTrip(string name, int trainId, DateTime startDate, DateTime endDate)
    {
        try
        {
            var train = await _context.Trains
                .FirstOrDefaultAsync(t => t.Id == trainId);

            if (train == null)
            {
                return (false, $"Потяга з id {trainId} не існує");
            }

            if (startDate >= endDate)
            {
                return (false, "Дата початку повинна бути раніше дати закінчення");
            }

            if (startDate < DateTime.Now)
            {
                return (false, "Дата початку не може бути в минулому");
            }
            
            var hasOverlap = await _context.Trips
                .AnyAsync(t => t.TrainId == trainId && 
                             ((t.StartDate <= startDate && t.EndDate >= startDate) ||
                              (t.StartDate <= endDate && t.EndDate >= endDate) ||
                              (t.StartDate >= startDate && t.EndDate <= endDate)));

            if (hasOverlap)
            {
                return (false, "Цей потяг вже має рейс на вказаний період");
            }
            
            var trip = new Trip
            {
                Name = name,
                TrainId = trainId,
                StartDate = startDate,
                EndDate = endDate
            };
            
            await _context.Trips.AddAsync(trip);
            await _context.SaveChangesAsync();
            
            _logger.LogInformation($"Створено новий рейс: {name}");
            return (true, $"Створено новий рейс: {name}");
        }
        catch (Exception ex)
        {
            _logger.LogError(ex, "Помилка при створенні рейсу");
            return (false, "Сталася помилка при створенні рейсу");
        }
    }
    
    public async Task<List<TripGetResponse>> GetTrips()
    {
        try
        {
            var trips = await _context.Trips
                .Include(t => t.Train)
                .Select(t => new TripGetResponse
                {
                    Id = t.Id,
                    TripName = t.Name,
                    StartDate = t.StartDate,
                    EndDate = t.EndDate,
                    TrainName = t.Train.Name,
                    Number = t.Train.Number,
                    AmountSeats = t.Train.AmountSeats})
                .ToListAsync();

            return trips;
        }
        catch (Exception ex)
        {
            return new List<TripGetResponse>();
        }
    }
    
    public async Task<List<TripGetResponse>> SearchTripsByName(string searchTerm)
    {
        try
        {
            var trips = await _context.Trips
                .Include(t => t.Train)
                .Where(t => t.Name.Contains(searchTerm))
                .Select(t => new TripGetResponse
                {
                    Id = t.Id,
                    TripName = t.Name,
                    StartDate = t.StartDate,
                    EndDate = t.EndDate,
                    TrainName = t.Train.Name,
                    Number = t.Train.Number,
                    AmountSeats = t.Train.AmountSeats
                })
                .ToListAsync();

            return trips;
        }
        catch (Exception ex)
        {
            _logger.LogError(ex, "Error searching trips");
            return new List<TripGetResponse>();
        }
    }
    
    public async Task<List<TripGetResponse>> SearchTripsByStartDate(DateTime startDate)
    {
        try
        {
            var trips = await _context.Trips
                .Include(t => t.Train)
                .Where(t => t.StartDate >= startDate) 
                .Select(t => new TripGetResponse
                {
                    Id = t.Id,
                    TripName = t.Name,
                    StartDate = t.StartDate,
                    EndDate = t.EndDate,
                    TrainName = t.Train.Name,
                    Number = t.Train.Number,
                    AmountSeats = t.Train.AmountSeats
                })
                .ToListAsync();

            return trips;
        }
        catch (Exception ex)
        {
            _logger.LogError(ex, "Error searching trips by start date");
            return new List<TripGetResponse>();
        }
    }
}