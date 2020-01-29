

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import _solution.PasswordCheckerUtility;

/**
 * Test the methods of PasswordChecker
 * @author Professor Kartchner
 *
 */
public class PasswordChecker_GFA_Test {
	ArrayList<String> passwords;
	String password1, password2;

	@Before
	public void setUp() throws Exception {
		passwords = new ArrayList<String>();
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}
	
	/**
	 * Test if the password is valid 
	 */
	@Test
	public void testIsValidPassword()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("strongPWD1"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
	}
}
