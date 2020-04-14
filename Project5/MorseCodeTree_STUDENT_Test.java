// Imports
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A MorseCodeTree Test Unit
 * 
 * @author Alec M.
 * @date 04/14/2020
 * @version 0.01
 */
public class MorseCodeTree_STUDENT_Test {
	// Class Variables
	protected MorseCodeTree tree;
	
	@Before
	public void setUp() throws Exception {
		tree = new MorseCodeTree();
	}

	@After
	public void tearDown() throws Exception {
		tree = null;
	}

	@Test
	public void testGetRoot() {
		assertEquals(tree.getRoot().getData(), "");
	}

	@Test
	public void testSetRoot() {
		TreeNode<String> newRoot = new TreeNode<String>("b");
		tree.setRoot(newRoot);
		assertEquals(tree.getRoot(), newRoot);
	}

	@Test
	public void testInsert() {
		tree.insert("...", "s");
		tree.insert("---", "o");
		assertEquals(tree.fetch("..."), "s");
		assertEquals(tree.fetch("---"), "o");
	}

	@Test
	public void testAddNode() {
		// Private method, auto pass
	}

	@Test
	public void testFetch() {
		tree.insert(".-.", "r");
		assertEquals(tree.fetch(".-."), "r");
		tree.insert("..-.", "f");
		assertEquals(tree.fetch("..-."), "f");
	}

	@Test
	public void testFetchNode() {
		// Private method, auto pass
	}

	@Test
	public void testBuildTree() {
		// Private method, auto pass
	}

	@Test
	public void testToArrayList() {
		// Variables
		String result = "";
		ArrayList<String> list = tree.toArrayList();
		
		// Loops
		for (String letter : list) {
			result += letter + " ";
		}
		
		result = result.trim();
		
		// Test
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", result);
	}

	@Test
	public void testLNRoutputTraversal() {
		// Private method, auto pass
	}
}
