import java.util.ArrayList;
import java.util.Set;

/**
 * A graph manager class
 * 
 * @author Alec M.
 * @date 04/23/2020
 * @version 0.01a
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
	public Set<Road> edgeSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
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
	public Set<Town> vertexSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		// TODO Auto-generated method stub

	}

}
