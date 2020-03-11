package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solution.BasicCircularLinkedList;

public class BasicCircularLinkedList_GFA_Test {
	BasicCircularLinkedList<String> linkedString;
	BasicCircularLinkedList<Double> linkedDouble;


	@Before
	public void setUp() throws Exception {
		linkedString = new BasicCircularLinkedList<String>();
		linkedString.addToEnd("Hello");
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(1,linkedString.getSize());
	}	
}
