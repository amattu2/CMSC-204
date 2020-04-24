/**
 * A graph manager class
 * 
 * @author Alec M.
 * @date 04/24/2020
 * @version 0.01b
 * @see GraphInterface.java
 */
public class Graph implements GraphInterface<Town, Road> {

	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addVertex(Town v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public java.util.Set<Road> edgeSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.Set<Road> edgesOf(Town vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeVertex(Town v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public java.util.Set<Town> vertexSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		// TODO Auto-generated method stub

	}

}
