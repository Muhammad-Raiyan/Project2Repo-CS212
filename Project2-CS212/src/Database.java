//Database.java

import java.util.StringTokenizer;

/**
 * Reads the database.txt; stores all the items and creates the database.
 * @author Muhammad Islam
 *
 */
public class Database {
	
	// All items are stored here.
	private ItemList<ProduceItem> data = new ItemList();
	private ProduceItem item;
	// Tracks the length of the array
	private int length;
	
	/**
	 * Class constructor. No arguments.
	 * initializes length to zero and 
	 * calls initialize()
	 */
	public Database(){
		length = 0;		// so data[0] stores first value 
		initialize();	// Calls to initialize method
	} // end of constructor
	/**
	 * Reads database.txt, tokenizes each line and stores
	 * them to data[]; increments the length in each iteration
	 * thus giving the number of produce items
	 */
	private void initialize(){
		/*
		 * produce[0] -> F/V
		 * produce[1] -> Code
		 * produce[2] -> Name
		 * produce[3] -> Price
		 */
		String produce[] = new String[4];
		//Initialize TextFileInput object
		TextFileInput fileIn = new TextFileInput("database.txt");
		//Declare StringTokenizer Object
		StringTokenizer myToken;
		//to store each line from text file.
		String line;
		//Iterates through the file; each time read a new line and tokenize
		do {
			//read a new line
			line = fileIn.readLine();
			//break at end of file
			if(line==null) break;
			
			//initialize StringTokenizer object with line as string and ',' as token
			myToken = new StringTokenizer(line, ",");
			
			
			int i=0; // loop iterator 
			while(myToken.hasMoreTokens()){
				//tokenize line and store to produce[]
				 produce[i]=myToken.nextToken();
		         i++; 
			}
			//creates a new data after each iteration and calls constructor
			if(produce[0].equals("F"))	
				item = new Fruit(produce[1], produce[2], produce[3]);
			else if(produce[0].equals("V"))
				item = new Vegetable(produce[1], produce[2], produce[3]);
			data.append(item);
			//increment length
			length++;
		}while(line!=null);
	} // end of initialize()
	
	/**
	 * Dummy Method to check all elements on data. Used
	 * during project development.
	 */
	public String toString(){
		
		return data.toString();
		
	}
	/**
	 * @return int length of the data[] array.
	 */
	public int getLength(){
		return length;
	}
	
	/**
	 * Takes the code of a produce item; uses search method
	 * to get the index of that item. Then returns the name
	 * stored in that produce item object
	 * 
	 * @param code the code of any produce item
	 * @return String the name of the produce item whose code was passed
	 */
	public String getName(String code){
		// calls search method and passes the code
		ListNode i = data.find(code);
		return ((ProduceItem) i.data).getName();
	}
	
	/**
	 * Finds the price of the produce item whose code
	 * was passed as argument. Uses search method to get the index
	 * of that produce item. 
	 * 
	 * @param code the code of any produce item
	 * @return float the price of the produce item whose code was passed
	 */
	public float getPrice(String code){
		// calls the search method with the code, uses the index to get the price as string
		ListNode i = (data.find(code));
		String temp = ((ProduceItem) i.data).getPrice();
		// converts the String to a float
		return Float.parseFloat(temp);  
	}
	
} // end of class Database.java
