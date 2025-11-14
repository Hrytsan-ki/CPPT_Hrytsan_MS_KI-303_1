import java.io.*;
import java.util.*;


public class WriteReadFileApp {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		WriteReadFile A = new WriteReadFile();
		Scanner in =new Scanner(System.in);
		System.out.print("Enter data: ");
		double data = in.nextDouble();
		A.calculate(data);
		
		System.out.println("Result is: " + A.getResult());
		A.writeResTxt("textRes.txt");
		A.writeResBin("BinRes.bin");
		A.readResBin("BinRes.bin");
		System.out.println("Result is: " + A.getResult());
		A.readResTxt("textRes.txt");
		System.out.println("Result is: " + A.getResult());
	}
}
