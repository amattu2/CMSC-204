/**
 * A town representation data class
 * 
 * @author Alec M.
 * @date 05/02/2020
 * @version 0.02c
 * @see Town.html
 */
public class Town implements java.lang.Comparable<Town> {
	// Class Variables
	protected String name = "";
	protected java.util.Set<Town> towns = new java.util.HashSet<Town>();
	protected int weight = Integer.MAX_VALUE;
	protected Town previous = null;
	
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
		this.weight = t.weight;
		this.towns = t.towns;
		this.previous = t.previous;
	}
	
	/**
	 * Reset Local Variables
	 * 
	 * @param None
	 * @return None
	 * @throws None
	 */
	public void reset() {
		this.weight = Integer.MAX_VALUE;
		this.previous = null;
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
		return this.name.compareTo(t.name);
	}
}
