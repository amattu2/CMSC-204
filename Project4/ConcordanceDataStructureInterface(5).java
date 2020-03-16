
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * This is the Concordance Data Structure Class.  It is the data structure
 * class that is used with the Concordance Data Manager class.
 * This is a hash table with buckets.  Your hash table with be an array of 
 * linked lists of ConcordanceDataElements. Use the hashcode for an 
 * ConcordanceDataElement and the size of the hash table to place in the hashtable.
 * Do not enter duplicate words or duplicate line numbers for a word.
 * 
 * There should be two constructors.  The first one takes in an integer which represents the
 * estimated number of words in the text.  Determine the size of the table by using a loading
 * factor of 1.5 and a 4K+3 prime.  Example: if you estimated 500 words, 500/1.5 = 333.  
 * The next 4K+3 prime over 333 is 347.  So the tableSize would be 347.
 * 
 * The other constructor will take in a String and an int.  The string will be "Testing"
 * and the int will be the size of the hash table.  This is used only for testing.
 * 
 * @author Professor Kartchner
 *
 */

   public interface ConcordanceDataStructureInterface{
	   
	   /**
	    * Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	    */
	   public int getTableSize();
	   
	   /**
	    * Returns an ArrayList of the words at this index
	    * [0] of the ArrayList holds the first word in the "bucket" (index)
	    * [1] of the ArrayList holds the next word in the "bucket", etc.
	    * This is used for testing
	    * @param index location within the hash table
	    * @return an Arraylist of the words at this index
	    */
	   public ArrayList<String> getWords(int index);
	   
	   /**
	    * Returns an ArrayList of the Linked list of page numbers for each word at this index
	    * [0] of the ArrayList holds the LinkedList of page numbers for the first word in the "bucket" (index)
	    * [1] of the ArrayList holds the LinkedList of page numbers for next word in the "bucket", etc.
	    * This is used for testing
	    * @param index location within the hash table
	    * @return an ArrayList of the Linked list of page numbers for each word at this index
	    */
	   public ArrayList<LinkedList<Integer>> getPageNumbers(int index);

	   /** 
	    * Use the hashcode of the ConcordanceDataElement to see if it is 
	    * in the hashtable.
	    * 
	    * If the word does not exist in the hashtable - Add the ConcordanceDataElement 
	    * to the hashtable. Put the line number in the linked list
	    *  
	    * If the word already exists in the hashtable
	    * 1. add the line number to the end of the linked list in the ConcordanceDataElement 
	    * (if the line number is not currently there).  
	    * 
	    * @param word the word to be added/updated with a line number.
	    * @param lineNum the line number where the word is found
	    */
      public void add(String word, int lineNum); 
      
      
      /** 
       * Display the words in Alphabetical Order followed by a :, 
       * followed by the line numbers in numerical order, followed by a newline
       * here's an example:
       * after: 129, 175
	   * agree: 185
       * agreed: 37
       * all: 24, 93, 112, 175, 203
       * always: 90, 128
	   * 
       * @return an ArrayList of Strings.  Each string has one word,
       * followed by a :, followed by the line numbers in numerical order,
       * followed by a newline.
       */
      public ArrayList<String> showAll();
      
   }// end of ConcordanceDataStructureInterface

 