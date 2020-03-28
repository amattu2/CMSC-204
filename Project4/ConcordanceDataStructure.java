/**
 * A ConcordanceDataStructure implementation
 * 
 * @author Alec M.
 * @date 03/26/2020
 * @version 0.04
 * @see ConcordanceDataStructure(3).html
 */
public class ConcordanceDataStructure implements ConcordanceDataStructureInterface {
	// Class Variables
    protected java.util.Hashtable<Integer, java.util.LinkedList<ConcordanceDataElement>> table; 
    protected int size = 0; 
    protected double factor = 1.5;
    protected int minimum = 2;
    protected java.util.ArrayList<String> blocked = new java.util.ArrayList<String>(java.util.Arrays.asList("and", "the"));
    
    /**
     * Class Constructor
     * 
     * @param String words
     * @param Integer size
     * @throws None
     */
	public ConcordanceDataStructure(String w, int s) {
		// Variables
		table = new java.util.Hashtable<Integer, java.util.LinkedList<ConcordanceDataElement>>(s, (float) this.factor);
		String[] lines = w.split("\n");
		
		// Loops
		for (int line = 0; line < lines.length; line++) {
			for (String word : lines[line].split(" ")) {
				this.add(word, line);
			}
		}
	}

	/**
	 * Class Constructor
	 * 
     * @param Integer size
     * @throws None
	 */
	public ConcordanceDataStructure(int s) {
		table = new java.util.Hashtable<Integer, java.util.LinkedList<ConcordanceDataElement>>(s, (float) this.factor);
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
		if (element.getWord().length() <= this.minimum) { return; }
		if (this.blocked.indexOf(element.getWord()) >= 0) { return; }
		if (this.table.containsKey(element.hashCode()) == true) {
			/*
			 * Notes:
			 * The has table already has a word at the specified index
			 * We have to find the correct word, and add the new page to that word
			 */
			// Variables
			java.util.LinkedList<ConcordanceDataElement> item = this.table.get(element.hashCode());
			
			item.forEach((v) -> {
				// Checks
				if (!v.getWord().equals(element.getWord())) { return; }
				
				v.addLine(l);
			});
		} else {
			/* 
			 * Notes:
			 * The hash table does not have anything at the specified index
			 * We create a new linked list at the index, and add the word + page
			 */
			this.table.put(element.hashCode(), new java.util.LinkedList<ConcordanceDataElement>());
			this.table.get(element.hashCode()).push(element);
			this.table.get(element.hashCode()).get(0).addPage(l);
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
		// Variables
		java.util.ArrayList<String> result = new java.util.ArrayList<String>();
		
		// Loop (HashMap)
		this.table.forEach((k, list) -> {
			// Loop (LinkedList)
			list.forEach((word) -> {
				result.add(word.toString());
			});
		});
		
		// Return
		return result;
	}
	
	/**
	 * Get Size Of Table
	 * 
	 * @param None
	 * @return Integer table size
	 * @throws None
	 */
	public int getTableSize() {
		return this.table.size();
	}
	
	/**
	 * Get An ArrayList of Words At Specified Index
	 * 
	 * @param Integer index
	 * @return ArrayList<String> words
	 * @throws None
	 */
	public java.util.ArrayList<String> getWords(int index) {
		// Variables
		java.util.ArrayList<String> words = new java.util.ArrayList<String>();
		java.util.LinkedList<ConcordanceDataElement> element = this.table.get(index);
		
		// Checks
		if (element != null) {
			element.iterator().forEachRemaining((e) -> {
				words.add(e.getWord());
			});
		}
		
		// Return
		return words;
	}
	   
	/**
	 * Get An ArrayList of Pages At Specified Inex
	 * 
	 * @param Integer index
	 * @return ArrayList<LinkedList<Integer>> pages
	 * @throws None
	 */
	public java.util.ArrayList<java.util.LinkedList<Integer>> getPageNumbers(int index) {
		// Variables
		java.util.ArrayList<java.util.LinkedList<Integer>> pages = new java.util.ArrayList<java.util.LinkedList<Integer>>();
		java.util.LinkedList<ConcordanceDataElement> element = this.table.get(index);
		
		// Checks
		if (element != null) {
			element.iterator().forEachRemaining((e) -> {
				pages.add(e.getList());
			});
		}
		
		// Return
		return pages;
	}	
}
