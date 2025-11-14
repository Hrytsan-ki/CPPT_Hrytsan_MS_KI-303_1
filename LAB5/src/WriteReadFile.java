
import java.io.*;
import java.util.*;


public class WriteReadFile extends Equations {
	public void writeResTxt(String fName) throws FileNotFoundException
	{
	PrintWriter f = new PrintWriter(fName);
	f.printf("%f ",y);
	f.close();
	}
	public void readResTxt(String fName)
	{
	try
	{
	File f = new File (fName);
	if (f.exists())
	{
	Scanner s = new Scanner(f);
	y = s.nextDouble();
	s.close();
	}
	else
	throw new FileNotFoundException("File " + fName + "not found");
	}
	catch (FileNotFoundException ex)


	{
	System.out.print(ex.getMessage());
	}
	}
	public void writeResBin(String fName) throws FileNotFoundException, IOException
	{
	DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
	f.writeDouble(y);
	f.close();
	}
	public void readResBin(String fName) throws FileNotFoundException, IOException
	{
	DataInputStream f = new DataInputStream(new FileInputStream(fName));
	y = f.readDouble();
	f.close();
	}
	public double getResult()
	{
	return y;
	}
	
	}

