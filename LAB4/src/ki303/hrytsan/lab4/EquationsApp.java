package ki303.hrytsan.lab4;
import java.util.Scanner;
import java.io.*;
import static java.lang.System.out;
public class EquationsApp {
	public static void main(String[] args) {
		try
		{
		out.print("Enter file name: ");
		Scanner in = new Scanner(System.in);
		String fName = in.nextLine();
		PrintWriter fout = new PrintWriter(new File(fName));
		try
		{
		try
		{
		Equations eq = new Equations();
		out.print("Enter X: ");
		double b=in.nextDouble();
;		fout.print(eq.calculate(b));
		System.out.println("Result: "+eq.calculate(b));
		}
		finally
		{
		// Цей блок виконається за будь-яких обставин
		fout.flush();
		fout.close();
		}
		}
		catch (CalcException ex)
		{
		// Блок перехоплює помилки обчислень виразу
		out.print(ex.getMessage());
		}
		}
		catch (FileNotFoundException ex)
		{
		// Блок перехоплює помилки роботи з файлом навіть якщо вони
		// виникли у блоці finally
		out.print("Exception reason: Perhaps wrong file path");
		}
	}
}
