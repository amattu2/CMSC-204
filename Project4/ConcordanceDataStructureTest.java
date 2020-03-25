
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the ConcordanceDataManager
 * which is implemented from the ConcordanceDataManagerInterface
 * @author Professor Kartchner
 */
public class ConcordanceDataStructureTest {
	ConcordanceDataStructureInterface concordanceDataStructure, testStructure;
	String text;
	ArrayList<String> array;

	@Before
	public void setUp() throws Exception {
		concordanceDataStructure = new ConcordanceDataStructure(500);
		testStructure = new ConcordanceDataStructure("Testing", 20);
	}

	@After
	public void tearDown() throws Exception {
		concordanceDataStructure = testStructure = null;
	}

	/**
	 * Test that words that hash to the same index are put in the same
	 * "bucket" for that index
	 */
	@Test
	public void testAddA() {
		testStructure.add("dog", 1);
		//banana should be stored at index 7
		//Math.abs("banana".hashCode()%20)
		assertEquals("dog", testStructure.getWords(4).get(0));
		assertEquals(1, testStructure.getPageNumbers(4).get(0).get(0), .001);
		testStructure.add("cat", 2);
		//carrot should be stored at index 5
		assertEquals("cat", testStructure.getWords(2).get(0));
		assertEquals(2, testStructure.getPageNumbers(2).get(0).get(0), .001);
		testStructure.add("horse", 3);
		//apple should be stored at index 10
		assertEquals("horse", testStructure.getWords(5).get(0));
		assertEquals(3, testStructure.getPageNumbers(5).get(0).get(0), .001);
		testStructure.add("chicken", 2);
		//cucumber should also be stored at index 10
		assertEquals("chicken", testStructure.getWords(9).get(0));
		assertEquals(2, testStructure.getPageNumbers(9).get(0).get(0), .001);
	}
	
	/**
	 * Test that the same word is only entered once in the "bucket"
	 * for that index
	 */
	@Test
	public void testAddB() {
		testStructure.add("pig",1);
		//pig should be stored at index 4
		assertEquals("pig", testStructure.getWords(10).get(0));
		testStructure.add("pig", 2);
		testStructure.add("wolf", 2);
		//wolf should also be stored at index 10
		assertEquals("wolf", testStructure.getWords(10).get(1));		
	}
	
	/**
	 * Test that the same linenumber for a word is only entered once
	 * for that word
	 */
	@Test
	public void testAddC() {
		testStructure.add("dog",1);
		//dog should be stored at index 4
		assertEquals(1, testStructure.getPageNumbers(4).get(0).get(0), .001);
		testStructure.add("dog", 1);
		testStructure.add("dog", 2);
		assertEquals(2, testStructure.getPageNumbers(4).get(0).get(1), .001);
				
	}


	/**
	 * Test the tableSize for concordanceDataStructures constructed
	 * with both constructors
	 */
	@Test
	public void testGetTableSize()
	{
		assertEquals(347, concordanceDataStructure.getTableSize());
		assertEquals(20, testStructure.getTableSize());		
	}
	
	/**
	 * Test that the resulting ArrayList is in alphabetical order
	 */
	@Test
	public void testShowAll() {
		testStructure.add("dog", 1);
		testStructure.add("cat", 2);
		testStructure.add("horse", 3);
		testStructure.add("chicken", 4);
		array = testStructure.showAll();
		assertTrue(array.get(0).contains("cat: 2"));
		assertTrue(array.get(1).contains("chicken: 4"));
		assertTrue(array.get(2).contains("dog: 1"));
		assertTrue(array.get(3).contains("horse: 3"));
	}

}
