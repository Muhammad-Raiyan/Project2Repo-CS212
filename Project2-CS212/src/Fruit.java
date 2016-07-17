
public class Fruit extends ProduceItem{
	
	/**
	 * Constructor. Uses super to pass argument to super class
	 * @param code Code of an item
	 * @param name Name of an item
	 * @param price Price of an item
	 */
	public Fruit(String code, String name, String price){
		// call to constructor of super class
		super("Fruit", code, name, price);
	}
	
	public String toString(){
		return super.toString() + "\n";
	}
}
