// LinkedList.java
// 
// This version uses three instance variables,
// a pointer to the first node, a pointer to
// the last node, and length, to make our
// append and getLength methods more efficient
// than the would be if our only instance
// variable were a pointer to the first node.
//
// This version uses a dummy first node.  Hence
// it needs less decision-making than it would
// need if a dummy first node were not used.
//

/**
 * Encapsulates a linked list of <code>String</code>.
 */
public class ItemList<T>  {

/**  First node in linked list - dummy node  */
   private ListNode first = new ListNode(null);

/**  Last node in linked list  */
   private ListNode last = first;

/**  Number of data items in the list.  */
   private int length = 0;

   private ListNode shortNode = first;
  
   /**
    * Gets the number of data values currently
    * stored in this LinkedList.
    *
    * @return the number of elements in the list.
    */
   public int getLength()  { 
      return length; 
   }
   
   /** Iterator for the list */
   public ListNode getIterator(){
	   return shortNode.next;
   }
   
   /**
    * Shift iterator to the next node
    * @return ProduceItem object reference to that iterator
    */
   public T next()  {
	      if ( shortNode == null )
	         throw new NullPointerException("Linked list empty.");
	      T currentData = (T) shortNode.data;
	      shortNode = shortNode.next;
	      return currentData;
   }
   
   /**
    * Checks if next node is the last one
    * @return boolean true if next node is last one, false otherwise
    */
   public boolean hasNext()  {
	      return ( shortNode.next != null );
   }

   /**
    * Appends a String data element to this
    * LinkedList.
    *
    * @param data the data element to be appended.
    */
   public void append(T d)
   {

     //  write the code here for append
	   ListNode toAppend=new ListNode(d);
	   last.next=toAppend;
	   last=toAppend;
	   length++;
   }  // method append(String)
   
   /**
    * Finds reference to a object given the code of that item
    * @param s code of an item
    * @return ListNode reference to the object with same code
    */
   public ListNode find (String s) {
	   ListNode p = first.next;
	   while (p != null && !(((ProduceItem) p.data).getCode()).equals(s)) {
	     p = p.next;
	   } // while
	   return p;
	 }

  /**
   *  Prints the contents of the Linked List
   *  @return String Represents the entire object as a string
   */
   public String toString() {
      ListNode p = first.next;
      String returnString = "";
      while (p != null) {
         returnString += p.data;
         p=p.next;
      }
      return returnString;
   }

  
   /**
    * Determines whether this ShortSequenceLinkedList is
    * equal in value to the parameter object.
    * They are equal if the parameter is of
    * class ShortSequenceLinkedList and the two objects
    * contain the same short integer values at
    * each index.
    *
    * @param other the object to be compared
    *          to this ShortSequenceLinkedList
    *
    * @return <code>true</code> if the parameter
    *        object is a ShortSequenceLinkedList containing
    *        the same numbers at each index as
    *        this ShortSequenceLinkedList, <code>false</code>
    *        otherwise.
    */
   public boolean equals(Object other)
   {
      if ( other == null 
              || getClass() != other.getClass()
              || length != ((ItemList) other).length )
          return false;

      ListNode nodeThis = first;
      ListNode nodeOther = ((ItemList) other).first;
      while ( nodeThis != null )
      {
          // Since the two linked lists are the same length,
          // they should reach null on the same iteration.

          if ( nodeThis.data != nodeOther.data )
             return false;

          nodeThis = nodeThis.next;
          nodeOther = nodeOther.next;
      }  // while

      return true;
   }  // method equals

  

}  // class LinkedList
