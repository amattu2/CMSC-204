import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Town.java test cases
 * 
 * @author Alec M.
 * @date 05/02/2020
 * @version 0.01
 * @see Town.java
 */
public class Town_STUDENT_Test {
	@Test
	public void testGetName() {
		Town t1 = new Town("T1");
		Town t2 = new Town("T2");
		assertEquals("T1", t1.getName());
		assertEquals("T2", t2.getName());
	}

	@Test
	public void testHashcode() {
		Town t1 = new Town("T1");
		Town t2 = new Town("T2");
		assertEquals(2653, t1.hashCode());
		assertEquals(2654, t2.hashCode());
	}

	@Test
	public void testToString() {
		Town t1 = new Town("T1");
		Town t2 = new Town("T2");
		assertEquals("T1", t1.toString());
		assertEquals("T2", t2.toString());
	}

	@Test
	public void testEqualsTown() {
		Town t1 = new Town("T1");
		Town t2 = new Town("T2");
		assertFalse(t1.equals(t2));
		assertTrue(t2.equals(t2));
	}
}
