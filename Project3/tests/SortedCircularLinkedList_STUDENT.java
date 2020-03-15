// Package
package tests;

// Imports
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import solution.SortedCircularLinkedList;

/**
 * BasicCircularLinkedList Test Cases
 * 
 * @author Alec M.
 * @date 3/15/2020
 */
public class SortedCircularLinkedList_STUDENT {
	// Variables
	SortedCircularLinkedList<String> str;

	@Before
	public void setUp() throws Exception {
		// Variables
		str = new SortedCircularLinkedList<String>(new StringComparator());
	}

	@After
	public void tearDown() throws Exception {
		str = null;
	}

	@Test
	public void testAddToFrontThrowsException() {
		try {
			str.addToFront("Should fail");
			assertTrue("Did not throw exception", false);
		} catch (UnsupportedOperationException e) {
			assertTrue("Threw exception", true);
		} catch (Exception e) {
			assertTrue("Threw other exception", false);
		}
	}
	
	@Test
	public void testAddToEndThrowsException() {
		try {
			str.addToEnd("Should fail");
			assertTrue("Did not throw exception", false);
		} catch (UnsupportedOperationException e) {
			assertTrue("Threw exception", true);
		} catch (Exception e) {
			assertTrue("Threw other exception", false);
		}
	}
	
	@Test
	public void testAdd() {
		str.add("b");
		assertEquals(str.getFirst(), "b");
		str.add("a");
		assertEquals(str.getFirst(), "a");
		str.add("1b");
		assertEquals(str.getFirst(), "1b");
		str.add("z");
		assertEquals(str.getLast(), "z");
		str.add("1A");
		assertEquals(str.getFirst(), "1A");
		str.add("zz");
		assertEquals(str.getLast(), "zz");
	}
	
	private class StringComparator implements Comparator<String> {
		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
		
	}
}
