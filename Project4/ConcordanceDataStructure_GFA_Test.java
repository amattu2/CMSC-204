
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
public class ConcordanceDataStructure_GFA_Test {
	ConcordanceDataStructureInterface testStructure;
	String text;
	ArrayList<String> array;

	@Before
	public void setUp() throws Exception {
		testStructure = new ConcordanceDataStructure("Testing", 20);
	}

	@After
	public void tearDown() throws Exception {
		testStructure = null;
	}

	/**
	 * Test the tableSize for concordanceDataStructures constructed
	 * with both constructors
	 */
	@Test
	public void testGetTableSize()
	{
		assertEquals(20, testStructure.getTableSize());		
	}
	
}
