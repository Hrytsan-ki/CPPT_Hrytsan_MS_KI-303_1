using Microsoft.EntityFrameworkCore;
using WorkerService1.model;

namespace test.api
{
    public class AppDbContext : DbContext
    {
        public DbSet<User> Users { get; set; }
        public DbSet<Train> Trains { get; set; }
        public DbSet<Seat> Seats { get; set; }
        public DbSet<Trip> Trips { get; set; }
        public DbSet<Booking> Bookings { get; set; }
        public DbSet<Rating> Ratings { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlite("Data Source=users.db");
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            // Конфігурація зв'язку між Train і Seat
            modelBuilder.Entity<Seat>()
                .HasOne(s => s.Train)
                .WithMany(t => t.Seats)
                .HasForeignKey(s => s.TrainId)
                .OnDelete(DeleteBehavior.Cascade);

            // Конфігурація зв'язку між Seat і Booking
            modelBuilder.Entity<Booking>()
                .HasOne(b => b.Seat)
                .WithMany(s => s.Bookings)
                .HasForeignKey(b => b.SeatId)
                .OnDelete(DeleteBehavior.Cascade);

            // Конфігурація зв'язку між User і Booking
            modelBuilder.Entity<Booking>()
                .HasOne(b => b.User)
                .WithMany(u => u.Bookings)
                .HasForeignKey(b => b.UserId)
                .OnDelete(DeleteBehavior.Cascade);

            // Налаштування властивостей для Booking
            modelBuilder.Entity<Booking>()
                .Property(b => b.BookingDate)
                .IsRequired();

            modelBuilder.Entity<Booking>()
                .Property(b => b.IsActive)
                .HasDefaultValue(true);
            
            // Конфігурація Rating
            modelBuilder.Entity<Rating>()
                .Property(r => r.Id)
                .ValueGeneratedOnAdd();
            
            modelBuilder.Entity<Rating>()
                .Property(r => r.Number)
                .HasPrecision(3, 1);
        }
    }
}