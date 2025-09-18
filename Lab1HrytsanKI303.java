import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Клас Lab1HrytsanKI303 реалізує приклад програми до лабораторної роботи №1
 * @author Hrytsan Marian
 * @version 1.0
 * @since version 1.0
 *
 */

public class Lab1HrytsanKI303 {
	/**
	 * Статичний метод main є точкою входу в програму
	 * @param args
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */

	
	public static void main(String[] args) throws FileNotFoundException  {
		// Створення об’єкта файлу і потоку для запису
		File dataFile = new File("MyFile.txt");
		PrintWriter fout = new PrintWriter(dataFile);
		Scanner in = new Scanner(System.in);
		// Ввід розміру матриці і символа заповнювача
		System.out.print("Введіть розмір квадратної матриці: ");
		int n=in.nextInt();
		in.nextLine();
		System.out.print("Введіть символ-заповнювач: ");
		String filler = in.nextLine();
		// перевірка на првавильність символу заповнювача
		if (filler.length() != 1) {
		    if (filler.length() == 0) {
		        System.out.println("Не введено символ заповнювач");
		    } else {
		        System.out.println("Забагато символів заповнювачів");
		    }
		    fout.flush();
		    fout.close();
		    return; 
		}
		//Створення масиву і виділення пам'яті для нього
		char [][] arr;
		arr = new char[n][];
		if(n%2==0) {
			for(int i=0;i<=n/2;i++) {
				arr[i]=new char[(i+1)*2];
				arr[n-i-1]=new char[(i+1)*2];
			} 			
		}
		else {
			arr[n/2]=new char[n];
			for(int i=0;i<n/2;i++) {
				arr[i]=new char[(i+1)*2];
				arr[n-(i+1)]=new char[(i+1)*2];
			}
		}
		// Заповнення масиву символом заповнювачем
		if(n%2==0) {
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<(i+1)*2;j++) {
				arr[i][j] = (char) filler.codePointAt(0);
				
			}
		}
		for(int i=n-1;i>=n/2;i--) {
			for(int j=0;j<(n-i)*2;j++) {
				arr[i][j] = (char) filler.codePointAt(0);
			}
		}
		}else {
			for(int i=0;i<n/2;i++) {
				for(int j=0;j<(i+1)*2;j++) {
					arr[i][j]=(char) filler.codePointAt(0);
				}
			}
			for(int j=0;j<n;j++) {
				arr[n/2][j]=(char) filler.codePointAt(0);
			}
			for(int i=(n/2)+1;i<n;i++) {
				for(int j=0;j<=((n - i)*2) - 1;j++) {
					arr[i][j]=(char) filler.codePointAt(0);
				}
			}
			
		}
		//Вивід фігури в консоль і в файл
		
		for (int i = 0; i < n; i++) {
		    int L = arr[i].length;         
		    int left = L / 2;              
		    int spaces = n - L;            

		    // виводимо ліву частину
		    for (int j = 0; j < left; j++) {
		    	System.out.print(arr[i][j]);
		    	fout.print(arr[i][j]);
		    }

		    if (spaces > 0) {
		    	System.out.print(" ".repeat(spaces));
		    	fout.print(" ".repeat(spaces));
		    }
		    
		    for (int j = left; j < L; j++) {
		    	System.out.print(arr[i][j]);
		    	fout.print(arr[i][j] );
		    }

		    System.out.println();
		    fout.println();
		}
		fout.flush();
		fout.close();
	}
	
	}
	
	
	
	

