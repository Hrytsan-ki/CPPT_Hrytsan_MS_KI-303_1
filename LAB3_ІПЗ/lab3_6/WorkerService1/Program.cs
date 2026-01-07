using test;
using test.api;
using WorkerService1.service;

var builder = Host.CreateApplicationBuilder(args);
builder.Services.AddScoped<TCPServer>();

builder.Services.AddDbContext<AppDbContext>();

builder.Services.AddScoped<UserService>();
builder.Services.AddScoped<TrainService>();
builder.Services.AddScoped<TripService>();
builder.Services.AddScoped<RatingService>();

builder.Services.AddHostedService<Worker>();

var host = builder.Build();

using (var scope = host.Services.CreateScope())
{
    var dbContext = scope.ServiceProvider.GetRequiredService<AppDbContext>();
    dbContext.Database.EnsureCreated();
}



await host.RunAsync();