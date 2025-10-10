package ki303.hrytsan.lab2;
import static java.lang.System.out;
import java.io.*;
public class PlaneApp {
	public static void main(String[] args) throws FileNotFoundException
	{
		
		Plane A = new Plane("Boing",1500.0,10.0);
		A.displayInfo();
		A.startEngine();
		A.takeOff();
	}
}
