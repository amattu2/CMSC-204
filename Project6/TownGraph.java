/**
 * A graph manager class
 * 
 * @author Alec M.
 * @date 04/25/2020
 * @version 0.01c
 * @see GraphInterface.java
 */
public class TownGraph implements GraphInterface<Town, Road> {
	// Class Variables
	protected java.util.Set<Town> towns = new java.util.HashSet();
	protected java.util.Set<Road> roads = new java.util.HashSet();
	
	@Override
	public Road addEdge(Town s, Town d, int w, String n) {
		return null;
	}
	
	@Override
	public Road getEdge(Town s, Town d) {
		return null;
	}

	@Override
	public boolean addVertex(Town v) {
		return false;
	}

	@Override
	public boolean containsEdge(Town sv, Town dv) {
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		return false;
	}

	@Override
	public java.util.Set<Road> edgeSet() {
		return null;
	}

	@Override
	public java.util.Set<Road> edgesOf(Town v) {
		return null;
	}

	@Override
	public Road removeEdge(Town sv, Town dv, int w, String n) {
		return null;
	}

	@Override
	public boolean removeVertex(Town v) {
		return false;
	}

	@Override
	public java.util.Set<Town> vertexSet() {
		return null;
	}

	@Override
	public java.util.ArrayList<String> shortestPath(Town sv, Town dv) {
		return null;
	}

	@Override
	public void dijkstraShortestPath(Town sv) {

	}
}
