/**
 * A graph manager class
 * 
 * @author Alec M.
 * @date 05/02/2020
 * @version 0.04b
 * @see GraphInterface.java
 */
public class TownGraph implements GraphInterface<Town, Road> {
	// Class Variables
	protected java.util.Set<Town> towns = new java.util.HashSet<Town>();
	protected java.util.Set<Road> roads = new java.util.HashSet<Road>();
	protected java.util.Set<Town> checked;
	protected java.util.Set<Town> unchecked;
	
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
		s.towns.add(d);
		d.towns.add(s);
		Road result = new Road(s, d, w, n);
		
		// Return
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
			s.towns.remove(d);
			d.towns.remove(s);
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
	 * Remove Specified Vertex (Town)
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
		return this.towns.remove(v);
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
	 * Get Shortest Paths Between Two Towns
	 * 
	 * @param Town source
	 * @param Town destination
	 * @return ArrayList<String> paths
	 * @throws None
	 */
	@Override
	public java.util.ArrayList<String> shortestPath(Town s, Town d) {
		// Variables
		java.util.ArrayList<String> paths = new java.util.ArrayList<String>();
		this.checked = new java.util.HashSet<Town>();
		this.unchecked = new java.util.HashSet<Town>(this.towns);
		this.checked.add(s);
		this.unchecked.remove(s);
		
		// Loops
		for (Town t : this.towns) {
			t.reset();
		}
		
		// Reset Weight (From INF), Get/Sort Paths, Return
		s.weight = 0;
		this.dijkstraShortestPath(s);
		this.buildPaths(paths, s, d);
		java.util.Collections.reverse(paths);
		return paths;
	}

	/**
	 * Calculate Shortest Pathways From Source To XYZ
	 * 
	 * @param Town source
	 * @return None
	 * @throws None
	 */
	@Override
	public void dijkstraShortestPath(Town s) {
		// Variables
		Boolean found = false;
		
		// Loops
		while (found == false && this.unchecked.isEmpty() == false) {
			// Variables
			found = true; // default
			Town shortestTown = null;
			int shortestDistance = Integer.MAX_VALUE;
			
			// Loops
			for (Town visited : this.checked) {
				// Variables
				java.util.Set<Town> c = visited.towns;
				java.util.Set<Town> uc = new java.util.HashSet<Town>();
				
				// Loops
				for (Town t : c) {
					// Checks
					if (unchecked.contains(t) == false) { continue; }
					
					// Found
					uc.add(t);
				}
				for (Town t : uc) {
					// Variables
					int weight = this.calculateWeights(t, visited, s);
					
					// Checks
					if (weight < shortestDistance) {
						shortestDistance = weight;
						shortestTown = t;
						t.previous = visited;
					}
				}

			}
			
			// Checks
			if (shortestTown != null) {
				found = false;
				shortestTown.weight = shortestDistance;
				checked.add(shortestTown);
				unchecked.remove(shortestTown);
			}
		}
	}
	
	/**
	 * Build Path To Destination ArrayList
	 * 
	 * @param ArrayList<String> paths
	 * @param Town source
	 * @param Town destination
	 * @return None
	 * @throws None
	 */
	protected void buildPaths(java.util.ArrayList<String> paths, Town s, Town d) {
		// Checks
		try {
			// Variables
			StringBuilder path = new StringBuilder();
			Road r = this.getEdge(d.previous, d); // Throws NPTR
			
			// Build Path String
			path.append(d.previous.getName());
			path.append(" via ");
			path.append(r.getName());
			path.append(" to ");
			path.append(d.getName());
			path.append(" ");
			path.append(r.getWeight());
			path.append(" mi");
			paths.add(path.toString());
			
			// Checks
			if (d.previous.equals(s) == false) {
				this.buildPaths(paths, s, d.previous);
			}
		} catch(Exception e) {
			paths.clear();
		}
	}
	
	/**
	 * Calculate Total Weight For Towns
	 * 
	 * @param Town unvisited
	 * @param Town visited
	 * @param Town source
	 * @return Integer weight
	 * @throws None
	 */
	protected int calculateWeights(Town u, Town v, Town s) {
		return u.equals(s) ? 0 : v.weight + this.getEdge(v, u).weight;
	}
	
}
