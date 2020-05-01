/**
 * A road between towns data class
 * 
 * @author Alec M.
 * @date 04/30/2020
 * @version 0.02a
 * @see Road.html
 */
public class Road implements java.lang.Comparable<Road> {
	// Class Variables
	protected Town source = null;
	protected Town destination = null;
	protected String name = "";
	protected int weight = 0;
	
	/**
	 * Class Constructor
	 * 
	 * @param Town source
	 * @param Town destination
	 * @param Integer weight
	 * @param String name
	 * @return this
	 * @throws None
	 */
	public Road(Town s, Town d, int w, String n) {
		// Variables
		this.source = s;
		this.destination = d;
		this.weight = w;
		this.name = n;
	}

	/**
	 * Class Constructor
	 * 
	 * @param Town source
	 * @param Town destination
	 * @param String name
	 * @return this
	 * @throws None
	 */
	public Road(Town s, Town d, String n) {
		// Variables
		this.source = s;
		this.destination = d;
		this.weight = 1;
		this.name = n;
	}
	
	/**
	 * Get Road Name
	 * 
	 * @param None
	 * @return String name
	 * @throws None
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get Road Source
	 * 
	 * @param None
	 * @return Town source
	 * @throws None
	 */
	public Town getSource() {
		return this.source;
	}
	
	/**
	 * Get Road Destination
	 * 
	 * @param None
	 * @return Town destination
	 * @throws None
	 */
	public Town getDestination() {
		return this.destination;
	}
	
	/**
	 * Get Road Weight
	 * 
	 * @param None
	 * @return Integer weight
	 * @throws None
	 */
	public int getWeight() {
		return this.weight;
	}
	
	/**
	 * Get Road Hash Code
	 * Generated from road name
	 * 
	 * @param None
	 * @return Integer hash code
	 * @throws None
	 */
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	/**
	 * Road toString
	 * 
	 * @param None
	 * @return String stringified
	 * @throws None
	 */
	@Override
	public String toString() {
		return this.name;
	}
	
	/**
	 * Road Contains Town
	 * 
	 * @param Town town
	 * @return Boolean contains town
	 * @throws None
	 */
	public boolean contains(Town t) {
		return this.source.equals(t) || this.destination.equals(t);
	}

	/**
	 * Road Equals Road
	 * Compares Road (this) to Road (r)
	 * 
	 * @param Road road
	 * @return Boolean identical
	 * @throws None
	 */
	@Override
	public boolean equals(Object r) {	
		// Variables
		boolean smatch = this.source.equals(((Road) r).source) || this.source.equals(((Road) r).destination);
		boolean dmatch = this.destination.equals(((Road) r).source) || this.destination.equals(((Road) r).destination);
		boolean result = r == this || (smatch && dmatch);
		
		// Return
		return result;
	}
	
	/**
	 * Compare Two Roads
	 * Compares Road (this) to Road (r)
	 * 0 = Equal
	 * 1 = Not Equal (No way to determine -1/1)
	 * 
	 * @param Road road
	 * @return Integer comparison
	 * @throws None
	 */
	@Override
	public int compareTo(Road r) {
		return this.equals(r) == true ? 0 : 1;
	}
}
