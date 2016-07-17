import java.awt.*;
import java.text.DecimalFormat;

import javax.swing.*;

public class RecGUI extends JFrame{
	private Transaction data;
	private String total;
	private JFrame frame;
	private static Container myContentPane;
	private static TextArea allName, allPrice, allCost;
	private static JLabel label;

	public RecGUI (Transaction ti, String total)
	{
		this.data = ti;
		this.total = total;
		createGUI();
		appendText();
		
		allCost.setEditable(false);
		allName.setEditable(false);
		allPrice.setEditable(false);
		frame.setVisible(true);
	}
	
	public void createGUI ()
	{
		frame=new JFrame();
	    setSize(100,100);
	    setLocation(100, 100);
	    setTitle("Customeer Receipt");
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    frame.pack();
	    //frame.setVisible(true);
	}
	
	public void appendText ()
	{
		// Initialize contentPane
		myContentPane = frame.getContentPane();
		// Initialize TextArea for data
		allName = new TextArea();
		allPrice = new TextArea();
		allCost = new TextArea();
		// Initialize label to display the sum
		label = new JLabel();
		label.setText("Total: $" + total);
				
		/** 
		* Set location of textAreas
		* Name(WEST) 	Price(Center)	Cost(EAST) 
		* label(South)								
		*/
		myContentPane.add(allName, BorderLayout.WEST);
		myContentPane.add(allPrice, BorderLayout.CENTER);
		myContentPane.add(allCost, BorderLayout.EAST);
		myContentPane.add(label, BorderLayout.SOUTH);
				
		// To give title of all textAreas
		allName.append("Produce Items\n");
		allPrice.append("Price per lbs\n");
		allCost.append("Cost per Item\n");
		int j = 0;
		for (ListNode i=data.Iterator(); i!=null; i = i.next)
		{
			// Initialize DecimalFormat object which controls number of decimal places
			DecimalFormat df = new DecimalFormat();
			// Set decimal places to 2
			df.setMaximumFractionDigits(2);
			
			float temp = (float)((UserItem) i.data).getWeight() + Float.parseFloat(((UserItem) i.data).getPrice());
			allName.append( "Item #  " + Integer.toString(++j) + "  " + ((UserItem) i.data).getName() + "\n");
			allPrice.append(((UserItem) i.data).getPrice() + "\n");
			allCost.append(""+df.format(temp) + "\n");
		}
	
	}
	
	
}
