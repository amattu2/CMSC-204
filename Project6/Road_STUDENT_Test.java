// Imports
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Road.java test cases
 * 
 * @author Alec M.
 * @date 05/02/2020
 * @version 0.01
 * @see Road.java
 */
public class Road_STUDENT_Test {
	@Test
	public void testGetName() {
		Road r = new Road(new Town("T1"), new Town("T2"), 45, "Road_Test_01");
		assertEquals("Road_Test_01", r.getName());
	}

	@Test
	public void testGetSource() {
		Town t1 = new Town("T1");
		Town t2 = new Town("T2");
		Road r = new Road(t1, t2, 45, "Road_Test_02");
		assertEquals(t1, r.getSource());
	}

	@Test
	public void testGetDestination() {
		Town t1 = new Town("T1");
		Town t2 = new Town("T2");
		Road r = new Road(t1, t2, 45, "Road_Test_02");
		assertEquals(t2, r.getDestination());
	}

	@Test
	public void testGetWeight() {
		Road r = new Road(new Town("T1"), new Town("T2"), 45, "Road_Test_03");
		assertEquals(45, r.getWeight());
	}

	@Test
	public void testHashcode() {
		Road r = new Road(new Town("T1"), new Town("T2"), 45, "Road_Test_04");
		assertEquals(463402674, r.hashCode());
	}

	@Test
	public void testToString() {
		Road r = new Road(new Town("T1"), new Town("T2"), 45, "Road_Test_04");
		assertEquals("Road_Test_04", r.toString());
	}

	@Test
	public void testContains() {
		Town t1 = new Town("T1");
		Town t2 = new Town("T2");
		Road r = new Road(t1, t2, 45, "Road_Test_02");
		assertEquals(true, r.contains(t2));
		assertEquals(false, r.contains(new Town("Fake Town")));
	}
}
