/**
 * A road between towns data class
 * 
 * @author Alec M.
 * @date 04/24/2020
 * @version 0.01b
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
	public int hashcode() {
		return this.name.hashCode();
	}
	
	/**
	 * Road toString
	 * 
	 * @param None
	 * @return String stringified
	 * @throws None
	 */
	public String toString() {
		return this.name +": "+ this.source.toString() + " -> " + this.destination.toString();
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
	public boolean equals(Road r) {
		// Variables
		boolean smatch = this.source.equals(r.source) || this.source.equals(r.destination);
		boolean dmatch = this.destination.equals(r.source) || this.destination.equals(r.destination);
		
		// Return
		return smatch && dmatch;
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
