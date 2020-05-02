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
		if (this.containsVertex(s) == false || this.containsVertex(d) == false) { throw new IllegalArgumentException("Vertex provided is not in the graph"); }

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
	 * @return Road result
	 * @throws None
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
		// Variables
		boolean result = false;

		// Loops
		for (Town t : this.towns) {
			if (v.equals(t)) {
				result = true;
				break;
			}
		}
		
		// Return
		return result;
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
	
	/**
	 * Find Shortest Path Between Two Towns
	 * 
	 * @param Town source
	 * @param Town destination
	 * @return ArrayList<String> paths
	 * @throws None
	 */
	@Override
	public java.util.ArrayList<String> shortestPath(Town s, Town d) {
		// Variables
		this.dijkstraShortestPath(s);
		java.util.ArrayList<String> result = new java.util.ArrayList<String>();
		java.util.LinkedList<Town> paths = d.paths;
		paths.add(d);
		
		// Loops
		for (Town t : paths) {
			String r = this.getPathDescription(s, t);
			
			System.out.println(r);
			
			result.add(r);
		}
		
		// Return
		return result;
	}
	
	/**
	 * Calculate Shortest Distance Between Source And Everything Else
	 * 
	 * @param Town source
	 * @return None
	 * @throws None
	 */
	@Override
	public void dijkstraShortestPath(Town s) {
		// Variables
		java.util.Set<Town> checked = new java.util.HashSet<Town>();
		java.util.Set<Town> unchecked = new java.util.HashSet<Town>();
		s.distance = 0;
		unchecked.add(s);
		
		// Loops
		while (unchecked.isEmpty() == false) {
			// Variables
			Town t = this.getShortestPath(unchecked);
			unchecked.remove(t);
			
			// Loops
			for (java.util.Map.Entry<Town, Integer> e : t.towns.entrySet()) {
				// Variables
				Town k = e.getKey();
				int distance = e.getValue();
				
				System.out.println(k);
				
				// Checks
				if (checked.contains(k) == false) {
					this.getShortestDistance(k, t, distance);
					checked.add(k);
				}
			}
			checked.add(t);
		}
	}
	
	/**
	 * Calculate Shortest Distance Between Next Town
	 * 
	 * @param Set<Town> towns
	 * @return Town result || null
	 * @throws None
	 */
	protected Town getShortestPath(java.util.Set<Town> towns) {
		// Variables
		Town result = null;
		int shortest = Integer.MAX_VALUE;
		
		// Loops
		for (Town t : towns) {
			if (t.distance < shortest) {
				result = t;
				shortest = t.distance;
			} else {
				System.out.println(t + "'s weight was greater than " + result);
			}
		}
		
		// Return
		return result;
	}
	
	/**
	 * Calculate Minimum Distance Between Towns
	 * 
	 * @param Town source
	 * @param Town destination
	 * @param Integer weight
	 */
	protected void getShortestDistance(Town s, Town d, int w) {
		// Checks
		if ((d.distance + w) < s.distance) {
			// Variables
			s.distance = d.distance + w;
			java.util.LinkedList<Town> list = new java.util.LinkedList<Town>(d.paths);
			list.add(d);
			s.paths = list;
		}
	}
	
	/**
	 * Build Path Description
	 * 
	 * @param Town source
	 * @param Town destination
	 * @return String description
	 * @throws None
	 */
	protected String getPathDescription(Town s, Town d) {
		// Variables
		String result = "";
		Road r = this.getEdge(s, d);
		
		if (r == null) {
			return "No such path between " + s.toString() + " and " + d.toString();
		}
		
		// Build
		result += s.getName();
		result += " via ";
		result += r.getName();
		result += " to ";
		result += d.getName();
		result += " ";
		result += r.getWeight();
		result += " mi";
		
		// Return
		return result;
	}
}
