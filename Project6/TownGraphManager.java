/**
 * A town i/o manager class
 * 
 * @author Alec M.
 * @date 04/30/2020
 * @version 0.02a
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

	/**
	 * Remove Town From Graph
	 * 
	 * @param String source name
	 * @return Boolean success
	 * @throws None
	 */
	@Override
	public boolean deleteTown(String s) {
		return this.graph.removeVertex(new Town(s));
	}

	/**
	 * Get Road Between Towns
	 * 
	 * @param String source
	 * @param String destination
	 * @return Boolean contains road
	 * @throws None
	 */
	@Override
	public boolean containsRoadConnection(String s, String d) {
		return this.graph.containsEdge(new Town(s), new Town(d));
	}
	
	/**
	 * Remove Road Between Towns
	 * 
	 * @param String source
	 * @param String destination
	 * @param String road name
	 * @return Boolean success
	 * @throws None
	 */
	@Override
	public boolean deleteRoadConnection(String s, String d, String n) {
		return this.graph.removeEdge(new Town(s), new Town(d), -1, n) == null ? false : true;
	}

	/**
	 * Get Sorted Road List
	 * 
	 * @param None
	 * @return ArrayList<String> result
	 * @throws None
	 */
	@Override
	public java.util.ArrayList<String> allRoads() {
		// Variables
		java.util.ArrayList<String> result = new java.util.ArrayList<String>();
		java.util.Set<Road> roads = this.graph.edgeSet();
		
		// Loops
		for (Road r : roads) {
			result.add(r.toString());
		}
		
		// Sort
		java.util.Collections.sort(result, new java.util.Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return java.text.Collator.getInstance().compare(s1, s2);
			}
		});
		
		// Return
		return result;
	}
	
	/**
	 * Get Sorted Town List
	 * 
	 * @param None
	 * @return ArrayList<String> result
	 * @throws None
	 */
	@Override
	public java.util.ArrayList<String> allTowns() {
		// Variables
		java.util.ArrayList<String> result = new java.util.ArrayList<String>();
		java.util.Set<Town> towns = this.graph.vertexSet();
		
		// Loops
		for (Town t : towns) {
			result.add(t.toString());
		}
		
		// Sort
		java.util.Collections.sort(result, new java.util.Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return java.text.Collator.getInstance().compare(s1, s2);
			}
		});
		
		// Return
		return result;
	}

	/**
	 * Get Shortest Paths To Town
	 * 
	 * @param String source name
	 * @param String destination name
	 * @return ArrayList<String> paths
	 * @throws None
	 */
	@Override
	public java.util.ArrayList<String> getPath(String s, String d) {
		return this.graph.shortestPath(new Town(s), new Town(d));
	}
}
