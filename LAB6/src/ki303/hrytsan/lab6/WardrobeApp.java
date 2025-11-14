package ki303.hrytsan.lab6;

public class WardrobeApp {
	public static void main(String[] args) {
		Wardrobe <? super Data> A = new Wardrobe <Data>();
		A.AddData(new Footwear("Nike","sneakers",42));
		A.AddData(new Footwear("Puma","sneakers",40));
		A.AddData(new Trousers("Nike","jeans",34));
		A.AddData(new Outerwear("TNF","winter",50));
		Data res=A.findMax();
		//A.AA();
		System.out.print("The greatest data on Wardrobe is: \n");
		System.out.println(Footwear.count);
		System.out.println(Outerwear.count);
		res.print();
		A.findByBrand("Nike");
	}
}
