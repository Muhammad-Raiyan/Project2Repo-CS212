//Transaction.java
import java.util.StringTokenizer;

/**
 * Reads in the transaction.txt file; creates a database for 
 * all the transaction files
 * 
 * @author Muhammad Islam
 */
public class Transaction {
	
	// all transaction items are stored here
	private ItemList<ProduceItem> data = new ItemList();
	private ProduceItem item;
	// number of items on the transaction.txt
	private int length;
	
	/**
	 * constructor of the class, initializes length to 0
	 * and calls initialize() method.
	 */
	public Transaction(){
		length = 0;
		initialize();
	} // end of constructor
	
	void initialize(){
		/*
		 * temp[0] -> code
		 * temp[1] -> weight
		 */
		String temp[] = new String[2];
		// Initialize TextFileInpout object
		TextFileInput fileIn = new TextFileInput("transaction.txt");
		// Declare tokenizer object
		StringTokenizer myToken;
		// to hold string from the .txt file
		String line;
		
		
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
				 temp[i]=myToken.nextToken();
		         i++; 
			}
			//creates a new data after each iteration and calls constructor
			
			item = new UserItem(temp[0], temp[1]);
			
			data.append(item);
			//increment length
			length++;
		}while(line!=null);

	}	// end of initialize()
	
	public ListNode Iterator(){
		return data.getIterator();
	}
	
	/**
	 * to get the code at a particular index
	 * @param i index of a transaction item
	 * @return String the code of that Item
	 */
	public String getCode(ListNode i){
		return ((ProduceItem) i.data).getName();
	}
	
	/**
	 * to get the weight of a item at a particular index
	 * @param i index of an item
	 * @return float the weight of that item
	 */
	public float getWeight(ListNode i){
		return ((ProduceItem) i.data).getWeight();
		
	}
	/**
	 * @return int length of the bought[] array.
	 */
	public int getLength(){
		return length;
	}
	
	/**
	 * Dummy Method to check all elements on bought. Used
	 * during project development.
	 */
	public String toString(){
		
		return data.toString();
		
	}

}
