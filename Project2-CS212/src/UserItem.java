import java.text.DecimalFormat;

public class UserItem extends ProduceItem{
	
	/**
	 * Constructor of class
	 * @param code Of an item
	 * @param weight OF an Item
	 */
	public UserItem(String code, String weight){
		
		// passes arguments to super class
		super(code, weight);
		
	}
	
	/**
	 * @param name Sets the name of a object
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * @param price Set the price of a object
	 */
	public void setPrice(String price){
		this.price = price;
	}
	
	/**
	 * 
	 * @param Itemtype Either vegetable or fruit
	 */
	public void setType(String Itemtype){
		this.ItemType = ItemType;
	}
	
	/**
	 * @return String Represents the list as a string
	 */
	public String toString(){
		// Initialize DecimalFormat object which controls number of decimal places
		DecimalFormat df = new DecimalFormat();
		// Set decimal places to 2
		df.setMaximumFractionDigits(2);
		float temp = (super.getWeight() * Float.parseFloat(super.getPrice()));
		return super.getName() + "\t\t" + super.getPrice() + "\t" + super.getWeight() + "\t" 
				+ df.format(temp);
	}
}
