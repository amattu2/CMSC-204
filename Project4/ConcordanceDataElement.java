/**
 * A basic data element implementation
 * 
 * @author Alec M.
 * @date 03/26/2020
 * @version 0.01
 * @see ConcordanceDataElement(4).html
 */
public class ConcordanceDataElement implements java.lang.Comparable<ConcordanceDataElement> {
	// Class Variables
	protected String word;
	protected java.util.LinkedList<Integer> lines;
	
	/**
	 * Standard constructor
	 * 
	 * @param String word
	 * @throws None
	 */
	public ConcordanceDataElement(String w) {
		// Variables
		this.word = w.toLowerCase();
		this.lines = new java.util.LinkedList<Integer>();
	}
	
	/**
	 * Add page number to page list
	 * 
	 * @param Integer page num
	 * @throws None
	 */
	public void addPage(int p) {
		this.addLine(p);
	}
	
	/**
	 * A logically named implementation of addPage
	 * 
	 * @param Integer line num
	 * @throws None
	 */
	public void addLine(int l) {
		// Checks
		if (this.lines.indexOf(l) >= 0) { return; }
		
		// Add
		this.lines.add(l);
	}
	
	/**
	 * Get ConcordanceDataElement Word
	 * 
	 * @param None
	 * @return String word
	 * @throws None
	 */
	public String getWord() {
		return this.word;
	}
	
	/**
	 * Get ConcordanceDataElement Line List
	 * 
	 * @param None
	 * @return LinkedList lines
	 * @throws None
	 */
	public java.util.LinkedList<Integer> getList() {
		return this.lines;
	}
	
	/**
	 * Get ConcordanceDataElement HashCode
	 * 
	 * @param None
	 * @return Integer hashcode
	 * @throws None
	 */
	public int hashCode() {
		return this.word.hashCode();
	}
	
	/**
	 * Stringify ConcordanceDataElement Class
	 * 
	 * @param None
	 * @return String stringified class
	 * @throws None
	 */
	public String toString() {
		return this.word + ": " + this.lines.toString().replace("[", "").replace("]", "");
	}
	
	/**
	 * Compare two ConcordanceDataElements
	 * 
	 * @param ConcordanceDataElement e1
	 * @return Integer comparison
	 * @throws None
	 */
	public int compareTo(ConcordanceDataElement e1) {
		return e1.getWord().compareTo(this.getWord());
	}
}
