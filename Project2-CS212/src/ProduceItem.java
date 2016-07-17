//ProduceItem.java

/**
 * Stores the code, name and price of a single
 * produce item. Stores them on private variables 
 * and access them through set and get methods.
 * Overrides Object.toString() and Object.equals() method
 * 
 * @author Muhammad Islam
 */
public abstract class ProduceItem {
	
	//Code of a produce item
	private String code; 
	//Name of a produce item
	protected String name;
	//Price of a produce item
	protected String price;
	//Weight of an item
	private String weight;
	
	protected String ItemType;
	/**
	 * Constructor of the class. Initializes
	 * all 3 private variables of ProduceItem
	 * 
	 * @param in_code to be set equal to code
	 * @param in_name to be set equal to name
	 * @param in_price to be set equal to price
	 */
	ProduceItem(String code, String weight){
		this.code = code;
		this.weight = weight;
	}
	
	ProduceItem(String ItemType, String code, String name, String price){
		this.ItemType = ItemType;
		this.code = code;
		this.name = name;
		this.price = price;
	} // end of constructor
	
	/**
	 * @return String the code of a produce item
	 */
	public String getCode(){
		return code;
	}
	/**
	 * @return String the name of a produce item
	 */
	public String getName(){
		return name;
	}
	/**
	 * @return String the price of a produce item
	 */
	public String getPrice(){
		return price;
	}
	
	public String getItemType(){
		return ItemType;
	}
	
	public Float getWeight(){
		return Float.parseFloat(weight);
	}

	/**
	 * sets the code equal to argument
	 * @param in_code to be set equal to code
	 */
	public void setCode(String in_code){
		code = in_code;
	}
	
	/**
	 * sets the name equal to argument
	 * @param in_name to be set equal to name
	 */
	public void setName(String in_name){
		name = in_name;
	}
	/**
	 * sets the price equal to argument
	 * @param in_price to be set equal to price
	 */
	public void setPrice(String in_price){
		price = in_price;
	}
	
	public void setItemType(String in_price){
		ItemType = in_price;
	}
	
	/**
	 * Overrides Object.toString()
	 * @return String the string representation of
	 * the object
	 */
	
	
	public String toString(){
		return code + " " + name + " " + price;
	}
	/**
	 * Overrides Object.equals(). If code,
	 * name and price of 2 objects are equal
	 * and the object isn't null and of the same
	 * class, true is returned. Otherwise false.
	 * @return boolean returns true or false 
	 */
	public boolean equals(Object other){
		return (other !=null && getClass() ==other.getClass()
							 && ItemType.equals(((ProduceItem)other).ItemType)//check for null and same class 
							 && code.equals(((ProduceItem)other).code)	// check for same code
							 && name.equals(((ProduceItem)other).name)	// check for same name
							 && price == (((ProduceItem)other).price));	// check for equal price
	}	// end of equals method
	
}	//end of class ProduceItem 
