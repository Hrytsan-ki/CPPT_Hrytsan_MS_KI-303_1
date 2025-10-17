package ki303.hrytsan.lab3;
/**
* Інтерфейс fire 
* 
* @author Hrytsan
* @version 1.0
* @since 1.0
*/
interface fire{
	void dropAshell();
	void scanning();
}
/**
 * Клас bomber розширює абстрактний клас Plane
 * 
 * @author Hrytsan
 * @version 1.0
 * @since 1.0
 */
public class bomber extends Plane implements fire  {
	private int numberOfShells;
	private int storageSize;
	
	/**
     * Конструктор класу bomber.
     * 
     * @param storageSize максимальна кількість снарядів, яку може нести літак
     */	
public bomber(int storageSize) {
	super("QQ1",1000,120);	
	numberOfShells=0;
	this.storageSize=storageSize;
}
/**
 * Реалізація методу dropAshell() з інтерфейсу fire.
 * Запитує у користувача кількість снарядів для скидання 
 * та перевіряє, чи достатньо їх у відсіку.
 */
public void dropAshell(){
	System.out.println("Введіть кількість снарядів які бажаєте скинути: ");
	int B =in.nextInt();
	if(B>numberOfShells) {
		System.out.println("У вас немає такої кількості снарядів");
	}else {
		System.out.println("Скинуто " + B + " снарядів");
	}
	
}
/**
 * Реалізація методу scanning() з інтерфейсу fire.
 * Генерує випадкову кількість виявлених цілей.
 */
public void scanning() {
	int S=(int)(Math.random()*51);
	System.out.println("Виявлено " + S + " цілей");
}
/**
 * Метод для завантаження снарядів у бомбовий відсік.
 * Перевіряє, щоб кількість не перевищувала допустиму місткість.
 */
public void loadShells() {
	System.out.println("Введіть кількість снаряді що хочете завантажити: ");
	numberOfShells=in.nextInt();
	if(numberOfShells>storageSize) {
		System.out.println("Бомбардувальник не може вмістити таку кількість снарядів");
		return;
	}
	System.out.println("Завантаженно " + numberOfShells + " снарядів");
}
/**
 * Метод для вивантаження снарядів.
 * Якщо користувач вводить більшу кількість, ніж є — 
 * вивантажуються всі наявні снаряди.
 */
public void unloadingShells() {
	int A;
	System.out.println("Введіть кількість снаряді що хочете вивантажити: ");
	A=in.nextInt();
	if(A>numberOfShells) {
		System.out.println("Кількість яку ви бажаєте вивантажити перевищує наявну кількість, вивантажуються усі снаряди");
		numberOfShells=0;
	}else {
	numberOfShells-=A;
	System.out.println("Вивантажено " + A + " снарядів");
	}
}

}
