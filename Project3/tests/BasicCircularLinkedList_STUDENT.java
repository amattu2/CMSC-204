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
import solution.BasicCircularLinkedList;

/**
 * BasicCircularLinkedList Test Cases
 * 
 * @author Alec M.
 * @date 3/13/2020
 */
public class BasicCircularLinkedList_STUDENT {
	// Variables
	BasicCircularLinkedList<String> str;
	BasicCircularLinkedList<Double> dbl;
	StringComparator comparator;

	@Before
	public void setUp() throws Exception {
		// Variables
		str = new BasicCircularLinkedList<String>();
		dbl = new BasicCircularLinkedList<Double>();
		comparator = new StringComparator();
		
		// Add Values
		str.addToEnd("Alec");
		str.addToFront("K");
		str.addToEnd("M.");
		dbl.addToFront(99.0);
		dbl.addToEnd(7.0);
		dbl.addToFront(1.0);
		dbl.addToEnd(3.0);
	}

	@After
	public void tearDown() throws Exception {
		str = null;
		dbl = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(3, str.getSize());
		assertEquals(4, dbl.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("M.", str.getLast());
		str.addToEnd("Beep Boop");
		assertEquals("Beep Boop", str.getLast());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("K", str.getFirst());
		str.addToFront("MATUTUTUTUTUT");
		assertEquals("MATUTUTUTUTUT", str.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		str.addToFront("New front");
		assertEquals("New front", str.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("M.", str.getLast());
		str.addToEnd("New end");
		assertEquals("New end", str.getLast());
	}
	
	@Test
	public void testToArrayList() {
		// Variables
		ArrayList<String> sA = str.toArrayList();
	
		assertEquals("K", sA.get(0));
		assertEquals("Alec", sA.get(1));
		assertEquals("M.", sA.get(2));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		/* Not implemented - See BasicCircularLinkedListTest.java */
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		/* Not implemented - See BasicCircularLinkedListTest.java */
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		/* Not implemented - See BasicCircularLinkedListTest.java */
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		/* Not implemented - See BasicCircularLinkedListTest.java */
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		/* Not implemented - See BasicCircularLinkedListTest.java */
	}
	
	@Test
	public void testRemove() {
		str.remove("Alec", comparator);
		assertEquals("K", str.getFirst());
	}

	@Test
	public void testRetrieveFirstElement() {
		str.addToFront("New ELELE");
		assertEquals("New ELELE", str.getFirst());
		str.retrieveFirstElement();
		assertFalse("New ELELE".equals(str.getFirst()));
	}

	@Test
	public void testRetrieveLastElement() {
		str.addToEnd("New ELELE");
		assertEquals("New ELELE", str.getLast());
		assertEquals(str.retrieveLastElement(), "New ELELE");
	}

	private class StringComparator implements Comparator<String> {
		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double> {
		@Override
		public int compare(Double arg0, Double arg1) {
			return arg0.compareTo(arg1);
		}
		
	}
}
