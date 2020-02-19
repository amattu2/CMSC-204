import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {
	// Variables
	MyStack<String> stack;
	
	@Before
	public void setUp() throws Exception {
		stack = new MyStack<String>(3);
	}

	@After
	public void tearDown() throws Exception {
		stack = null;
	}
	
	@Test
	public void test1() {
		System.out.println("Add 1 element: " + stack.push("ABC"));
		System.out.println("Stack full: " + stack.isFull());
		System.out.println("Stack size: " + stack.size());
		System.out.println("Add 2 element: " + stack.push("DEF"));
		System.out.println("Stack full: " + stack.isFull());
		System.out.println("Stack size: " + stack.size());
		System.out.println("Stack pop 1: " + stack.pop());
		System.out.println("Stack pop 2: " + stack.pop());
		System.out.println("Stack pop 3: " + stack.pop());
		
		stack.push("bb");
		String[] a = stack.toArray();
		
		for (int i = 0; i < a.length; i++) {
			System.out.println("String " + a[i] + " at index" + i);
		}
	}
}
