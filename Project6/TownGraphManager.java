/**
 * A town i/o manager class
 * 
 * @author Alec M.
 * @date 04/29/2020
 * @version 0.01c
 * @see TownGraphManagerInterface.java
 */
public class TownGraphManager implements TownGraphManagerInterface {
	// Class Variables
	GraphInterface<Town, Road> graph = new TownGraph();
	
	/**
	 * Add Road To Graph
	 * 
	 * @param String source name
	 * @param String dest name
	 * @param Integer weight
	 * @param String road name
	 * @return Boolean success
	 * @throws None
	 */
	@Override
	public boolean addRoad(String sName, String dName, int w, String n) {
		// Variables
		Town source = new Town(sName);
		Town dest = new Town(dName);
		
		// Checks
		if (this.graph.containsVertex(source) == false || this.graph.containsVertex(dest) == false) {
			return false; 
		}
		if (this.graph.containsEdge(source, dest) == false) {
			this.graph.addEdge(source, dest, w, n);
		}
		
		// Default
		return true;
	}

	/**
	 * Get Road Connecting Two Towns
	 * 
	 * @param String source
	 * @param String destination
	 * @return String road name
	 * @throws None
	 */
	@Override
	public String getRoad(String s, String d) {
		// Variables
		Road result = this.graph.getEdge(new Town(s), new Town(d));
		
		// Return
		return result == null ? "" : result.getName();
	}
	
	/**
	 * Add Town To Graph
	 * 
	 * @param String source name
	 * @return Boolean success
	 * @throws None
	 */
	@Override
	public boolean addTown(String s) {
		return this.graph.addVertex(new Town(s));
	}

	/**
	 * Get Town If It Exists
	 * 
	 * @param String source name
	 * @return Town result || null
	 * @throws None
	 */
	@Override
	public Town getTown(String s) {
		return this.containsTown(s) == true ? new Town(s) : null;
	}
	
	/**
	 * Check If Town Exists
	 * 
	 * @param String source name
	 * @return Boolean contains
	 * @throws None
	 */
	@Override
	public boolean containsTown(String s) {
		return this.graph.containsVertex(new Town(s));
	}

	@Override
	public boolean deleteTown(String v) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public java.util.ArrayList<String> allRoads() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public java.util.ArrayList<String> allTowns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void populateTownGraph(java.io.File selectedFile) throws java.io.FileNotFoundException, java.io.IOException {
		// TODO Auto-generated method stub
		
	}
}
