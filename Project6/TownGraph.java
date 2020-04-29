/**
 * A graph manager class
 * 
 * @author Alec M.
 * @date 04/29/2020
 * @version 0.02a
 * @see GraphInterface.java
 */
public class TownGraph implements GraphInterface<Town, Road> {
	// Class Variables
	protected java.util.Set<Town> towns = new java.util.HashSet<Town>();
	protected java.util.Set<Road> roads = new java.util.HashSet<Road>();
	protected java.util.Map<Town, Road> distanceMap = new java.util.HashMap<Town, Road>();
	
	/**
	 * Add Edge (Road) To Graph
	 * 
	 * @param Town town1
	 * @param Town town2
	 * @param Integer weight
	 * @param String name
	 * @return Road result
	 * @throws IllegalArgumentException, NullPointerException
	 */
	@Override
	public Road addEdge(Town s, Town d, int w, String n) throws IllegalArgumentException, NullPointerException {
		// Checks
		if (s == null || d == null) { throw new NullPointerException("Vertex provided is null"); }
		if (this.towns.contains(s) == false || this.towns.contains(d) == false) { throw new IllegalArgumentException("Vertex provided is not in the graph"); }
		
		// Variables
		Road result = new Road(s, d, w, n);
		
		// Return
		this.towns.add(s);
		this.towns.add(d);
		this.roads.add(result);
		return result;
	}
	
	/**
	 * Remove Specified Edge
	 * 
	 * @param Town town1
	 * @param Town town2
	 * @param Integer weight||-1
	 * @param String name||null
	 */
	@Override
	public Road removeEdge(Town s, Town d, int w, String n) {
		// Variables
		Road result = null;
		
		// Loops
		for (Road r : this.roads) {
			// Checks
			if (r.contains(s) == false || r.contains(d) == false) { continue; }	
			if (w > -1 && r.weight != w) { continue; }
			if (n != null && r.name.toLowerCase().equals(n.toLowerCase()) == false) { continue; }
			
			// Found
			this.roads.remove(r);
			result = r;
			break;
		}
		
		// Return
		return result;
	}
	
	/**
	 * Finds A Road Connecting Two Towns
	 * Undirected graph, source/destination are bidirectional
	 * 
	 * @param Town town1
	 * @param Town town2
	 * @return Road result || null
	 * @throws None
	 */
	@Override
	public Road getEdge(Town s, Town d) {
		// Variables
		Road result = null;
		
		// Loops
		for (Road r : this.roads) {
			// Checks
			if (r.contains(s) == false || r.contains(d) == false) { continue; }

			// Found Road
			result = r;
			break;
		}

		// Return
		return result;
	}
	
	/**
	 * Determine If A Graph Contains An Edge
	 * 
	 * @param Town town1
	 * @param Town town2
	 * @return Boolean contains edge
	 * @throws None
	 */
	@Override
	public boolean containsEdge(Town s, Town d) {
		return this.getEdge(s, d) != null ? true : false;
	}
	
	/**
	 * Add Vertex (Town) If Not Existent
	 * 
	 * @param Town town
	 * @return Boolean added
	 * @throws None
	 */
	@Override
	public boolean addVertex(Town v) {
		// Checks
		if (this.towns.contains(v)) { return false; }
		
		// Add
		this.towns.add(v);
		
		// Return
		return true;
	}

	/**
	 * Remove Specified Vertex
	 * 
	 * @param Town town
	 * @return Boolean removed
	 * @throws None
	 */
	@Override
	public boolean removeVertex(Town v) {
		// Checks
		if (v == null) { return false; }
		if (this.towns.contains(v) == false) { return false; }
		
		// Loops
		for (Road r : this.edgesOf(v)) {
			this.removeEdge(r.source, r.destination, r.weight, r.name);
		}
		
		// Return
		this.towns.remove(v);
		return true;
	}
	
	/**
	 * Determine If A Graph Contains A Vertex
	 * 
	 * @param Town town
	 * @return Boolean contains vertex
	 * @throws None
	 */
	@Override
	public boolean containsVertex(Town v) {		
		return this.towns.contains(v);
	}

	/**
	 * Get All Edges (Roads) From Graph
	 * 
	 * @param None
	 * @return Set<Road> set
	 * @throws None
	 */
	@Override
	public java.util.Set<Road> edgeSet() {
		return this.roads;
	}

	/**
	 * Get All Edges (Roads) Of Town
	 * 
	 * @param Town town
	 * @return Set<Road> set
	 * @throws None
	 */
	@Override
	public java.util.Set<Road> edgesOf(Town v) {
		// Variables
		java.util.Set<Road> result = new java.util.HashSet<Road>();
		
		// Loop
		for (Road r : this.roads) {
			// Checks
			if (!r.contains(v)) { continue; }
			
			// Add
			result.add(r);
		}
		
		// Return
		return result;
	}

	/**
	 * Get All Vertices (Towns) From Graph
	 * 
	 * @param None
	 * @return Set<Town> vertices
	 * @throws None
	 */
	@Override
	public java.util.Set<Town> vertexSet() {
		return this.towns;
	}

	@Override
	public java.util.ArrayList<String> shortestPath(Town s, Town d) {
		return null;
	}

	@Override
	public void dijkstraShortestPath(Town v) {	
		// https://users.cs.fiu.edu/~kraynek/COP3530-examples/Graphs/WeightedGraph.java
		// https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/
		// calculate the shortest distance between the source (shortestPath.s) and all endpoints
		// store everything in the hashmap and only return the results containing shortestPath.d
		// use getEdge(s, d) to get roadname
	}
}
