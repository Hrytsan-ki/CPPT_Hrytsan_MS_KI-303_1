using Microsoft.EntityFrameworkCore;
using test.api;
using WorkerService1.model;

namespace WorkerService1.service;

public class TrainService
{
    private readonly AppDbContext _context;
    private readonly ILogger<TrainService> _logger;

    public TrainService(AppDbContext context, ILogger<TrainService> logger)
    {
        _context = context;
        _logger = logger;
    }

    public async Task<(bool success, string message)> CreateTrain(string name, int number, int amountSeats)
    {
        try
        {
            var existingTrain = await _context.Trains
                .FirstOrDefaultAsync(t => t.Number == number);

            if (existingTrain != null)
            {
                return (false, $"Потяг з номером {number} вже існує");
            }
            
            var train = new Train
            {
                Name = name,
                Number = number,
                AmountSeats = amountSeats
            };

            await _context.Trains.AddAsync(train);
            await _context.SaveChangesAsync();
            
            var seats = new List<Seat>();
            for (int i = 1; i <= amountSeats; i++)
            {
                var seat = new Seat
                {
                    Number = i,
                    IsAvailable = true,
                    TrainId = train.Id
                };
                seats.Add(seat);
            }

            await _context.Seats.AddRangeAsync(seats);
            await _context.SaveChangesAsync();


            _logger.LogInformation($"Створено новий потяг: {name} (#{number}) з {seats.Count} місцями");
            return (true, $"Потяг успішно створено з {seats.Count} місцями");
        }
        catch (Exception ex)
        {
            _logger.LogError(ex, "Помилка при створенні потяга");
            return (false, "Сталася помилка при створенні потяга");
        }
    }

    public async Task<(bool success, string message)> TakeASeat(long userId, int trainId, int seatNumber)
        {
            using var transaction = await _context.Database.BeginTransactionAsync();
            try
            {
                var user = await _context.Users
                    .FirstOrDefaultAsync(u => u.Id == userId);
                
                if (user == null)
                {
                    return (false, "Користувача не існує");
                }

                var seat = await _context.Seats
                    .Include(s => s.Bookings)
                    .FirstOrDefaultAsync(s => s.TrainId == trainId && s.Number == seatNumber);

                if (seat == null)
                {
                    return (false, "Місце не існує в цьому потязі");
                }
                
                var hasActiveBooking = seat.Bookings.Any(b => b.IsActive);
                if (hasActiveBooking)
                {
                    return (false, "Місце вже заброньоване");
                }
                
                var booking = new Booking
                {
                    UserId = userId,
                    SeatId = seat.Id,
                    BookingDate = DateTime.UtcNow,
                    IsActive = true
                };

                await _context.Bookings.AddAsync(booking);
                seat.IsAvailable = false;
                
                await _context.SaveChangesAsync();
                await transaction.CommitAsync();

                _logger.LogInformation($"Місце {seatNumber} у потязі {trainId} успішно заброньовано користувачем {userId}");
                return (true, "Місце успішно заброньовано");
            }
            catch (Exception ex)
            {
                await transaction.RollbackAsync();
                _logger.LogError(ex, "Помилка при бронюванні місця");
                return (false, "Сталася помилка при бронюванні місця");
            }
        }
}