// Imports
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TownGraph.java test cases
 * 
 * @author Alec M.
 * @date 05/02/2020
 * @version 0.01
 * @see GraphTest.java
 */
public class TownGraph_STUDENT_Test {
	// Class Variables
	private GraphInterface<Town, Road> graph;
	private Town[] town;

	@Before
	public void setUp() {
		// Variables
		graph = new TownGraph();
		town = new Town[6];
		
		// Add Towns
		for (int i = 1; i < 6; i++) {
			town[i] = new Town("Town_XYZ_" + i);
			graph.addVertex(town[i]);
		}
		
		graph.addEdge(town[1], town[2], 5, "Road_12");
		graph.addEdge(town[2], town[3], 3, "Road_23");
		graph.addEdge(town[3], town[5], 8, "Road_35");
	}
	
	@After
	public void tearDown() throws Exception {
		graph = null;
	}
	
	@Test
	public void testGetEdge() {
		assertEquals(new Road(town[1], town[2], 6, "Road_12"), graph.getEdge(town[1], town[2]));
		assertEquals(new Road(town[3], town[5], 8, "Road_35"), graph.getEdge(town[3], town[5]));
	}

	@Test
	public void testAddEdge() {
		assertEquals(false, graph.containsEdge(town[1], town[5]));
		graph.addEdge(town[1], town[5], 1, "Road_15");
		assertEquals(true, graph.containsEdge(town[1], town[5]));
	}

	@Test
	public void testAddVertex() {
		Town newTown = new Town("Town_XYZ_7");
		assertEquals(false, graph.containsVertex(newTown));
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
	}

	@Test
	public void testContainsEdge() {
		assertEquals(true, graph.containsEdge(town[1], town[2]));
		assertEquals(false, graph.containsEdge(town[1], town[4]));
	}

	@Test
	public void testContainsVertex() {
		assertEquals(true, graph.containsVertex(new Town("Town_XYZ_3")));
		assertEquals(false, graph.containsVertex(new Town("Town_XYZ_8")));
	}

	@Test
	public void testEdgeSet() {
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_12", roadArrayList.get(0));
		assertEquals("Road_23", roadArrayList.get(1));
		assertEquals("Road_35", roadArrayList.get(2));
	}

	@Test
	public void testEdgesOf() {
		Set<Road> roads = graph.edgesOf(town[1]);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_12", roadArrayList.get(0));
	}

	@Test
	public void testRemoveEdge() {
		assertEquals(true, graph.containsEdge(town[2], town[3]));
		graph.removeEdge(town[2], town[3], 3, "Road_23");
		assertEquals(false, graph.containsEdge(town[2], town[3]));
	}

	@Test
	public void testRemoveVertex() {
		assertEquals(true, graph.containsVertex(town[2]));
		graph.removeVertex(town[2]);
		assertEquals(false, graph.containsVertex(town[2]));
	}

	@Test
	public void testVertexSet() {
		Set<Town> roads = graph.vertexSet();
		assertEquals(true, roads.contains(town[1]));
		assertEquals(true, roads.contains(town[3]));
		assertEquals(true, roads.contains(town[5]));
	}

	 @Test
	  public void testTown_1ToTown_2() {
		  String beginTown = "Town_XYZ_1", endTown = "Town_XYZ_2";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while (iterator.hasNext()) {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if (beginIndex != null && endIndex != null) {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_XYZ_1 via Road_12 to Town_XYZ_2 5 mi",path.get(0).trim());
		  } else
			  fail("Town names are not valid");
	  }

}
