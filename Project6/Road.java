/**
 * A road between town data class
 * 
 * @author Alec M.
 * @date 04/23/2020
 * @version 0.01a
 * @see Road.html
 */
public class Road implements java.lang.Comparable<Road> {

	public Road(Town source, Town destination, int weight, String name) {

	}

	public Road(Town source, Town destination, String name) {
		
	}
	
	public String getName() {
		return null;
	}
	
	public String getSource() {
		return null;
	}
	
	public String getDestination() {
		return null;
	}
	
	public int getWeight() {
		return 0;
	}
	
	public int hashcode() {
		return 0;
	}
	
	public String toString() {
		return null;
	}
	
	public boolean contains(Town t) {
		return false;
	}

	public boolean equals(Road r) {
		return false;
	}
	
	@Override
	public int compareTo(Road r) {
		return 0;
	}

}
