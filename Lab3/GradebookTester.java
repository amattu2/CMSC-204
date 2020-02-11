// Imports
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit 4 Test For GradeBook.java
 * 
 * @author Alec M
 * @version 0.01
 * @date 02/11/2020
 */
public class GradebookTester {
	// Variables
	GradeBook gb1, gb2;
	
	@Before
	public void setUp() throws Exception {
		// Initialize Variables
		gb1 = new GradeBook(3);
		gb2 = new GradeBook(3);	
		
		// Add Mock Values
		gb1.addScore(62);
		gb1.addScore(79);
		gb1.addScore(74);
		gb2.addScore(76);
		gb2.addScore(87);
		gb2.addScore(89);		
	}

	@After
	public void tearDown() throws Exception {
		gb1 = gb2 = null;
	}

	@Test
	public void testSum() {
		assertTrue(215.0 == gb1.sum());
		assertTrue(252.0 == gb2.sum());
	}

	@Test
	public void testMinimum() {
		// Test .minimum
		assertTrue(62.0 == gb1.minimum());
		assertTrue(76.0 == gb2.minimum());
	}

	@Test
	public void testFinalScore() {
		assertTrue(153.0 == gb1.finalScore());
		assertTrue(176.0 == gb2.finalScore());	
	}

	@Test
	public void testGetScoreSize() {
		assertEquals(3, gb1.getScoreSize());
		assertEquals(3, gb2.getScoreSize());
	}

	@Test
	public void testToString() {
		assertTrue("62.0 79.0 74.0".equals(gb1.toString()));
		assertTrue("76.0 87.0 89.0".equals(gb2.toString()));
	}
}
