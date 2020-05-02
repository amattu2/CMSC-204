import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TownGraphManager.java test cases
 * 
 * @author Alec M.
 * @date 05/02/2020
 * @version 0.01
 * @see TownGraphManagerTest.java
 */
public class TownGraphManager_STUDENT_Test {
	// Class Variables
	private TownGraphManager graph;
	private String[] town;
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  town = new String[7];
		  
		  for (int i = 1; i < 7; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[1], town[2], 2, "Road_1");
		  graph.addRoad(town[1], town[3], 4, "Road_2");
		  graph.addRoad(town[1], town[5], 6, "Road_3");
		  graph.addRoad(town[3], town[6], 1, "Road_4");
		  graph.addRoad(town[4], town[6], 3, "Road_6");
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_2", roads.get(1));
		assertEquals("Road_3", roads.get(2));
		assertEquals("Road_4", roads.get(3));
		assertEquals("Road_6", roads.get(4));
		graph.addRoad(town[2], town[5], 1, "Road_7");
		roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_2", roads.get(1));
		assertEquals("Road_3", roads.get(2));
		assertEquals("Road_4", roads.get(3));
		assertEquals("Road_6", roads.get(4));
		assertEquals("Road_7", roads.get(5));
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("Road_1", graph.getRoad(town[1], town[2]));
		assertEquals("Road_4", graph.getRoad(town[3], town[6]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, graph.containsTown("Town_10"));
		graph.addTown("Town_10");
		assertEquals(true, graph.containsTown("Town_10"));
	}
	
	@Test
	public void testDisjointGraph() {
		assertEquals(false, graph.containsTown("Town_10"));
		graph.addTown("Town_10");
		ArrayList<String> path = graph.getPath(town[1], "Town_10");
		assertFalse(path.size() > 0);
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, graph.containsTown("Town_1"));
		assertEquals(false, graph.containsTown("Town_23"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[1], town[2]));
		assertEquals(false, graph.containsRoadConnection(town[1], town[6]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_2", roads.get(1));
		assertEquals("Road_3", roads.get(2));
		assertEquals("Road_4", roads.get(3));
		assertEquals("Road_6", roads.get(4));
	}

	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[1], town[2]));
		graph.deleteRoadConnection(town[1], town[2], "Road_1");
		assertEquals(false, graph.containsRoadConnection(town[1], town[2]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, graph.containsTown("Town_2"));
		graph.deleteTown(town[2]);
		assertEquals(false, graph.containsTown("Town_2"));
	}
	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = graph.allTowns();
		assertEquals("Town_1", roads.get(0));
		assertEquals("Town_2", roads.get(1));
		assertEquals("Town_3", roads.get(2));
		assertEquals("Town_4", roads.get(3));
		assertEquals("Town_5", roads.get(4));
	}

	@Test
	public void testGetPath() {
		ArrayList<String> path = graph.getPath(town[1], town[2]);
		assertNotNull(path);
		assertTrue(path.size() > 0);
		assertEquals("Town_1 via Road_1 to Town_2 2 mi", path.get(0).trim());
	}
	
	@Test
	public void testGetPathA() {
		ArrayList<String> path = graph.getPath(town[3], town[6]);
		assertNotNull(path);
		assertTrue(path.size() > 0);
		assertEquals("Town_3 via Road_4 to Town_6 1 mi",path.get(0).trim());
	}
}
