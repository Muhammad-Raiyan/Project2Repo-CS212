
public class Vegetable extends ProduceItem{
	/**
	 * Constructor. Uses super to pass argument to super class
	 * @param code Code of an item
	 * @param name Name of an item
	 * @param price Price of an item
	 */
	public Vegetable(String code, String name, String price){
		super("Vegetables", code, name, price);
	}
	
	public String toString(){
		return super.toString() + "\n";
	}
}
