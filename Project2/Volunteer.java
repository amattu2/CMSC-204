/**
 * @author Alec M.
 * @date 02/13/2020
 * @version 0.01a
 */
public class Volunteer {
	// Variables
	private String n;
	
	/**
	 * Create a Volunteer instance
	 * 
	 * @param String name
	 */
	public Volunteer(String name) {
		this.n = name;
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
