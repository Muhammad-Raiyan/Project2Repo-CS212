//Project2.java

import java.text.DecimalFormat;
/**
 * Holds the main method, creates objects of database
 * transaction and passes the data to ReceiptGUI to display
 * them with JFrame.
 * 
 * @author Muhammad Islam
 */
public class Project2 {
	
	public static void main(String[] args) {
		/**
		 * Initialize Database and Transaction objects
		 * which tokenize and store the data from database.txt
		 * and shopping.txt
		 */
		Database DB = new Database();
		Transaction ti = new Transaction();
		
		// Initialize DecimalFormat object which controls number of decimal places
		DecimalFormat df = new DecimalFormat();
		// Set decimal places to 2
		df.setMaximumFractionDigits(2);
		
		/** Iterator to the first node of the linked list */
		ListNode itr = ti.Iterator();
		// Stores the subtotal for each term and adds them
		float total = 0;
		
		/**
		 * Iterates through the whole list. Gets code for each transection
		 * item. Uses find method to get the a pointer to that node from database.
		 * Using that gets the name and price per lbs
		 */
		while(itr != null){
			String name = DB.getName(((ProduceItem) itr.data).getCode());
			String price = ""+DB.getPrice(((ProduceItem) itr.data).getCode());
			// Sets the name of the transection item
			((ProduceItem) itr.data).setName(name);
			// Sets rthe price of the item
			((ProduceItem) itr.data).setPrice(price);
			float temp = (ti.getWeight(itr));
			total += (DB.getPrice(((ProduceItem) itr.data).getCode())*temp);
			
			// Shifts to next node
			itr = itr.next;
		}
		
		// Formats the total and converts that to a string
		String temp = "" + df.format(total);
		RecGUI ob = new RecGUI(ti, temp);
		
	}	// End of main method
}	// End of class Project1


