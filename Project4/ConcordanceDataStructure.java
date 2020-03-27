import java.util.Collections;

/**
 * A ConcordanceDataStructure implementation
 * 
 * @author Alec M.
 * @date 03/26/2020
 * @version 0.01
 * @see ConcordanceDataStructure(3).html
 */
public class ConcordanceDataStructure implements ConcordanceDataStructureInterface {
	// Class Variables
    private java.util.Hashtable<Integer, ConcordanceDataElement> table; 
    private int size = 0; 
    private final double factor = 1.5; 
    
    /**
     * Class Constructor
     * 
     * @param String words
     * @param Integer size
     * @throws None
     */
	public ConcordanceDataStructure(String w, int s) {
		// TODO Calculate size, add words
		table = new java.util.Hashtable<Integer, ConcordanceDataElement>();
	}

	/**
	 * Class Constructor
	 * 
     * @param Integer size
     * @throws None
	 */
	public ConcordanceDataStructure(int s) {
		// TODO Calculate size
		table = new java.util.Hashtable<Integer, ConcordanceDataElement>();
	}	 

	/**
	 * Add New Word
	 * 
	 * We don't need to address the capitalization of the word because ConcordanceDataElement
	 * already handles that internally.
	 * 
	 * @param String word
	 * @param Integer line
	 * @throws None
	 */
	public void add(String w, int l) {
		// Variables
		ConcordanceDataElement element = new ConcordanceDataElement(w);

		// Checks
		if (this.table.containsKey(element.hashCode()) == true) {
			this.table.get(element.hashCode()).addPage(l);
			return;
		} else {
			this.table.put(element.hashCode(), element);
			return;
		}
	} 

	/**
	 * Display All Elements
	 * 
	 * @param None
	 * @return String elements (name: pg, pg, pg)
	 * @throws None
	 */
	public java.util.ArrayList<String> showAll() {
		// TODO Sort then convert to string, then return
		
		// Variables
		java.util.ArrayList<ConcordanceDataElement> unsortedList = new java.util.ArrayList<ConcordanceDataElement>(this.table.values());
		
		// Return
		return new java.util.ArrayList<String>();
	}
	
	/**
	 * Get Size Of Table
	 * 
	 * @param None
	 * @return Integer table size
	 * @throws None
	 */
	public int getTableSize() {
		return this.size;
	}
	
	public java.util.ArrayList<String> getWords(int index) {
		// TODO
		return null;
	}
	   
	public java.util.ArrayList<java.util.LinkedList<Integer>> getPageNumbers(int index) {
		// TODO
		return null;
	}	
}
