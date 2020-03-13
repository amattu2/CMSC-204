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
public class SortedCircularLinkedList_STUDENT {
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

	private class StringComparator implements Comparator<String> {
		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
		
	}
}
