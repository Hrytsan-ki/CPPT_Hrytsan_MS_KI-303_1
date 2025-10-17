package ki303.hrytsan.lab3;

	import java.io.*;
import java.util.*;
/**
 * Клас  Plane реалізує приклад програми для Лабораторної роботи №2
 *
 * @author Hrytsan Marian
 * @version 1.0
 * @since 1.0
 */
abstract public class Plane   {
	
	Scanner in = new Scanner(System.in);
	private String model;
	private double fuelLevel;
	private Engine engine;
	private Pilot pilot;
	private Wing wing;
	private double distance;
	/**
	* Constructor
	* @param model      
    * @param fuelLevel  
    * @param distance   
	* @throws FileNotFoundException
	*/
	public Plane(String model,double fuelLevel,double distance)  {
		this.model = model;
		this.distance=distance;
        engine = new Engine();
        pilot = new Pilot();
        wing = new Wing();
        this.fuelLevel = fuelLevel;
	}
	/**
	* Constructor
	* */
	public Plane() {}
	/**
     * Метод для запуску двигуна.
     * Виводить повідомлення та записує дію в файл.
     */
	public void startEngine() {
        System.out.println(model + " запускає двигун " );
        logToFile("Літак "+model + " запускає двигун " );
    }
	 /**
     * Метод для симуляції зльоту літака.
     * Перевіряє рівень палива і, якщо його достатньо, виконує зліт,
     * зменшуючи кількість палива. Вся записується у файл.
     */
	public void takeOff() {
        if (fuelLevel > 50.0) {
            System.out.println(model + " злітає під керуванням " + pilot.name);
            fuelLevel -=fuelConsumption(distance,engine.power);
            logToFile( "Літак"+ model + " злітає під керуванням " + pilot.name);
        } else {
            System.out.println("Недостатньо палива для зльоту!");
            logToFile("Недостатньо палива для зльоту!");
        }
    }
	/**
     * Метод для симуляції посадки літака.
     * Виводить повідомлення та записує дію у файл.
     */
	public void land() {
	        System.out.println(model + " здійснює посадку.");
	        logToFile("Літак " + model + " здійснює посадку.");
	}
	/**
     * Метод для дозаправки літака.
     * @param amount Кількість палива для дозаправки в літрах.
     */
	public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println(model + " заправлено на " + amount + " літрів. Поточний рівень палива: " + fuelLevel);
        logToFile(model + " заправлено на " + amount + " літрів. Поточний рівень палива: " + fuelLevel);
    }
	public void displayInfo() {
		logToFile("=======Данні про літак=======");
        System.out.println("Модель: " + model);
        logToFile("Модель: " + model);
        System.out.println("Пілот: " + pilot.name);
        logToFile("Пілот: " + pilot.name);
        System.out.println("Двигун: " + engine.type);
        logToFile("Двигун: " + engine.type);
        System.out.println("Крило: " + wing.span);
        logToFile("Крило: " + wing.span);
        System.out.println("Паливо: " + fuelLevel + " л");
        logToFile("Паливо: " + fuelLevel + " л");
    }
	public double calculateAspectRatio() {
	    double B=Math.pow(wing.span, 2) / wing.area;
		System.out.println("Ефективність крила: " + B);
		logToFile("Ефективність крила: " + B);
	    return B;
	}
	public String pilotRank() {
		String rank;
		if(pilot.experienceYears<2) {
			rank ="Курсант";
		}
		else if(pilot.experienceYears<5) {
			rank ="Другий пілот";
		}
		else if (pilot.experienceYears<10){
			rank="Старший пілот";
		}
		else {
			rank="Капітан";
		}
		System.out.println("Звання пілота: " + rank);
		logToFile("Звання пілота: " + rank);
		return rank;
	}
	public double flightTime(double distance) {
		 double baseSpeed = engine.power * 0.8;
		 double flightTimes = (distance / baseSpeed) + 0.5;
		 System.out.println("Час польоту приблизно: " + flightTimes);
		 logToFile("Час польоту приблизно: " + flightTimes);
		return flightTimes;
	}
	public void maxDistance() {
			double max = fuelLevel/(distance*0.1*engine.power);
			System.out.println("Максимальна дистанція польоту:" + max);
			logToFile("Максимальна дистанція польоту:" + max);
	}
	 private void logToFile(String message)   {
	        // Ключовий момент тут - FileWriter("Log.txt", true)
	        try (PrintWriter writer = new PrintWriter(new FileWriter("Log.txt", true))) {
	            writer.println(message);
	        } catch (IOException e) {
	            System.err.println("Помилка запису в лог-файл: " + e.getMessage());
	        }
	 }
	public double fuelConsumption(double distance,int power) {
		double A =distance*power*0.01;
		return A;
	}
	

class Engine{
	private int power;
	private String type;
	public Engine() {
		System.out.print("Enter engine power:");
	    power=in.nextInt();
	    if(power<0) {
	    	System.out.println("power повинен бути більше 0");
	    	System.exit(power);
	    }
	    in.nextLine();
	    System.out.print("Enter engine type:");
	    type=in.nextLine();
	}
}
class Pilot{
	private String name;
    private int experienceYears;
    public Pilot() {
    	System.out.print("Enter pilot name:");
        name=in.nextLine();
        System.out.print("Enter pilot experience:");
        experienceYears=in.nextInt();
    }
	
}
class Wing{
	 private double span; // розмах крил (м)
	 private double area; // площа крила (м²)
	 public Wing() {
		 System.out.print("Enter span to wing:");
	    span =in.nextDouble(); 
	    System.out.print("Enter wing area:");
	    area =in.nextDouble();
	   }
}
}

