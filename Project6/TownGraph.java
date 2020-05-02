import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * A graph manager class
 * 
 * @author Alec M.
 * @date 05/02/2020
 * @version 0.03a
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
	 * Get Vertex In Graph
	 * 
	 * @param Town town
	 * @return Town result || null
	 * @throws None
	 */
	public Town getVertex(Town v) {
		// Variables
		Town result = null;

		// Loops
		for (Town t : this.towns) {
			if (v.equals(t)) {
				result = t;
				break;
			}
		}
		
		// Return
		return result;
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

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		path.clear();
		visitedTowns = new HashSet();
		unVisitedTowns = new HashSet(setOfTowns);
		Town townS,townD;
		townS =townD=null;
		for(Town t : setOfTowns)
		{
			if(t.getName().equals(sourceVertex.getName())) {
				townS =t;
				townS.setAdjecentTowns(t.getAdjecentTowns());
			}
			if(t.getName().equals(destinationVertex.getName())) {
				townD =t;
			}

		}
		townS.setWeight(0);
		visitedTowns.add(townS);
		unVisitedTowns.remove(townS);
		this.dijkstraShortestPath(townS);
		for (Town t : unVisitedTowns) {
			// if(t.getBackpath()!=null)
//			 System.out.println(t.getBackpath());
			// else
//			System.out.println(t.getName().equals(townD.getName()));

		}
		getShortestPath(townS, townD);

		Collections.reverse(path);
		for (Town town : setOfTowns) {
			town.resetPathVarbs();
		}
		return path;
	}

	private void getShortestPath(Town sourceVertex, Town destinationVertex) {
		// Town_1 via Road_1 to Town_2 2 mi"
		try {
		Road tempRoad = getEdge(destinationVertex.getBackpath(), destinationVertex);
		StringBuilder str = new StringBuilder();
		str.append(destinationVertex.getBackpath().getName());
		str.append(" via ");
		str.append(tempRoad.getName());
		str.append(" to ");
		str.append(destinationVertex.getName());
		str.append(" ");
		str.append(tempRoad.getWeight());
		str.append(" mi");

		path.add(str.toString());
		if (!(destinationVertex.getBackpath().equals(sourceVertex))) {
			getShortestPath(sourceVertex, destinationVertex.getBackpath());

		}}catch(NullPointerException e) {

		path.clear();
		path.add("No such path found");
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		Boolean finiding = false;
		while (!unVisitedTowns.isEmpty() && !finiding) {
			finiding = true;
			int shortest = Integer.MAX_VALUE;
			Town closestTown = null;
			for (Town visitedTown : visitedTowns) {

				Set<Town> adjTowns = visitedTown.getAdjecentTowns();

				System.out.println("Adj towns " + adjTowns);
				Set<Town> adjTownsUnVisited = new HashSet<>();
				for (Town town : adjTowns) {
					if (unVisitedTowns.contains(town)) {
						adjTownsUnVisited.add(town);
					}
				}
				for (Town unvisitedTown : adjTownsUnVisited) {
					int totalWeight = getTotalWeight(unvisitedTown, visitedTown, sourceVertex);
					if (totalWeight < shortest) {
						shortest = totalWeight;

						closestTown = unvisitedTown;

						unvisitedTown.setBackpath(visitedTown);
					}
				}

			}
			if (closestTown != null) {
				closestTown.setWeight(shortest);
				visitedTowns.add(closestTown);
				unVisitedTowns.remove(closestTown);
				finiding = false;
			}
		}

	}

	private int getTotalWeight(Town unvisitedTown, Town visitedTown, Town sourceVertex) {
		if (unvisitedTown.equals(sourceVertex))
			return 0;

		return visitedTown.getWeight() + getEdge(visitedTown, unvisitedTown).getWeight();
	}
}
