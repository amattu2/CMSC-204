/**
 * A town representation data class
 * 
 * @author Alec M.
 * @date 04/30/2020
 * @version 0.02b
 * @see Town.html
 */
public class Town implements java.lang.Comparable<Town> {
	// Class Variables
	protected String name = "";
	
	/**
	 * Class Constructor
	 * 
	 * @param String name
	 * @return this
	 * @throws None
	 */
	public Town(String n) {
		// Variables
		this.name = n;
	}

	/**
	 * Class Constructor
	 * 
	 * @param Town town
	 * @return this
	 * @throws None
	 */
	public Town(Town t) {
		// Variables
		this.name = t.name;
	}
	
	/**
	 * Get Town Name
	 * 
	 * @param None
	 * @return String name
	 * @throws None
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get Town Hashcode
	 * Generated from town name
	 * 
	 * @param None
	 * @return Integer hashcode
	 * @throws None
	 */
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	/**
	 * Stringify Town
	 * 
	 * @param None
	 * @return None
	 * @throws None
	 */
	public String toString() {
		return this.getName();
	}

	/**
	 * Compare Two Towns
	 * 
	 * @param Town town
	 * @return Boolean equal
	 * @throws None
	 */
	@Override
	public boolean equals(Object t) {
		return t == this || this.name.toLowerCase().equals(((Town) t).name.toLowerCase());
	}
	
	/**
	 * Compare Two Towns
	 * 0 = Equal
	 * 1 = Not Equal (No way to determine -1/1)
	 * 
	 * @param Town town
	 * @return Integer comparison
	 * @throws None
	 */
	@Override
	public int compareTo(Town t) {
		return this.name.toLowerCase().equals(t.name.toLowerCase()) ? 0 : 1;
	}
}
