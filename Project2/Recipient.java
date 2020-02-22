/**
 * @author Alec M.
 * @date 02/13/2020
 * @version 0.01a
 */
public class Recipient {
	// Variables
	private String n;
	
	/**
	 * Create a new Recipient instance
	 * 
	 * @param String name
	 */
	public Recipient(String name) {
		this.n = name;
	}
	
	/**
	 * Get recipient name
	 * 
	 * @return String name
	 */
	public String getName() {
		return this.n;
	}
	
	/**
	 * Create a stringified version of class
	 * 
	 * @return String name
	 */
	public String toString() {
		return this.n;
	}
}
