package ki303.hrytsan.lab6;

import java.util.*;
import java.io.*;

 class Wardrobe <T extends Data>
{
	 private ArrayList<T> arr;
	 public Wardrobe() {
		 arr = new ArrayList<T>(); 
	 }
	 public T findMax()
	 {
		 if (!arr.isEmpty())
		 {
			 T max = arr.get(0);
			 for (int i=1; i< arr.size(); i++)
			 {
				 if ( arr.get(i).compareTo(max) > 0 )
					 max = arr.get(i);

			 }
			 return max;
		 }
	 return null;
	 }
	 public void AddData(T data)
	 { 
	 arr.add(data);
	 System.out.print("Element added: ");
	 data.print();
	 }
	 public void DeleteData(int i)
	 {
	 arr.remove(i);
	 }
	 public void AA () {
		 int footwearCount = 0;
		 int trousersCount = 0;
		 int outerwearCount = 0;
		 for (T item : arr) {
		        if (item instanceof Footwear)
		            footwearCount++;
		        else if (item instanceof Trousers)
		            trousersCount++;
		        else if (item instanceof Outerwear)
		            outerwearCount++;
		    }
		 System.out.println("Ount Footwear: "+ footwearCount + " Ount Trousers: " +trousersCount + " Ount Outerwear: " +outerwearCount);
	 }
	 public List<T> findByBrand(String brand) {
		    List<T> result = new ArrayList<>();
		    for (T item : arr) {
		        if (item.getBrand().equalsIgnoreCase(brand)) {
		            result.add(item);
		        }
		    }

		    if (result.isEmpty()) {
		        System.out.println("No items found for brand: " + brand);
		    } else {
		        System.out.println("Items of brand '" + brand + "':");
		        for (T item : result) {
		            item.print();
		        }
		        System.out.println("Total found: " + result.size());
		    }

		    return result;
		}
	 
}
 interface Data extends Comparable<Data>
 {
	 
	 public int getSize();
	 public void print();
	 public String getBrand();
	 
 }
class Footwear implements Data{
	private String brand;
	private String type;
	private int size;
	public static int count;
	public Footwear (String brand,String type,int size){
		this.brand=brand;
		this.type=type;
		this.size=size;
		count++;
	}
	public String getBrand() {
		return brand;
	}
	public int getSize() {
		return size;
	}
	public void print() {
		System.out.print("Footwear" +"\n"+ "Brand: " + brand +

				", Type: " + type + ", Size: "+ size+"\n");
	}
	public int compareTo(Data p) {
		Integer s = size;
		return s.compareTo(p.getSize()); 
	}
	
}
class Trousers implements Data{
	private String brand;
	private String type;
	private int size;
	public Trousers (String brand,String type,int size){
		this.brand=brand;
		this.type=type;
		this.size=size;
	}
	public String getBrand() {
		return brand;
	}
	public int getSize() {
		return size;
	}
	public void print() {
		System.out.print("Trousers" +"\n"+ "Brand: " + brand +

				", Type: " + type + ", Size: "+ size+"\n");
	}
	public int compareTo(Data p) {
		Integer s = size;
		return s.compareTo(p.getSize()); 
	}
	
}
class Outerwear implements Data{
	private String brand;
	private String season;
	private int size;
	public static int count;
	public Outerwear (String brand,String season,int size){
		this.brand=brand;
		this.season=season;
		this.size=size;
		count++;
	}
	public String getBrand() {
		return brand;
	}
	public int getSize() {
		return size;
	}
	public void print() {
		System.out.print("Outerwear" +"\n"+ "Brand: " + brand +

				", Season: " + season + ", Size: "+ size+"\n");
	}
	public int compareTo(Data p) {
		Integer s = size;
		return s.compareTo(p.getSize()); 
	}
	
}
