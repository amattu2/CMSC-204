

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import _solution.InvalidSequenceException;
import _solution.LengthException;
import _solution.NoLowerAlphaException;
import _solution.NoUpperAlphaException;
import _solution.PasswordCheckerUtility;

/**
 * Test the methods of PasswordChecker
 * @author Professor Kartchner
 *
 */
public class PasswordCheckerTest {
	ArrayList<String> passwords;
	String password1, password2;

	@Before
	public void setUp() throws Exception {
		String[] p = {"334455BB", "Im2cool4U", "george2ZZZ", "4sale", "bertha22", "4wardMarch", 
				"august30", "abcdef", "Applesxx", "aa11b", "pilotProject", "myPassword", 
				"myPassword2"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p)); // puts strings into the ArrayList
		
		
		/* ************* STUDENT  ***************
		   Create another Arraylist of String to
		   use for the testValidPasswordsSTUDENT test
		*/
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("abcABC12"));
			PasswordCheckerUtility.isValidPassword("abc12");
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("1234567aA"));
			PasswordCheckerUtility.isValidPassword("1234567a");
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("1234567Aa"));
			PasswordCheckerUtility.isValidPassword("1234567A");
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("1234aaAA"));
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("1234aaAA");
			assertTrue(weakPwd);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("1234aaAA"));
			PasswordCheckerUtility.isValidPassword("1234aAAA");
			assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
	}

	/**
	 * Test the validPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testValidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.validPasswords(passwords);
		Scanner scan = new Scanner(results.get(0)); //
		assertEquals(scan.next(), "334455BB");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		//assertEquals(scan.nextLine(), " The password must contain at least one lowercase alphabetic character.");
		scan = new Scanner(results.get(1)); //
		assertEquals(scan.next(), "george2ZZZ");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("more than two"));
		//assertEquals(scan.nextLine(), " The password cannot contain more than two of the same character in sequence.");
		scan = new Scanner(results.get(3)); //
		assertEquals(scan.next(), "bertha22");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		//assertEquals(scan.nextLine(), " The password must contain at least one uppercase alphabetic character.");
		scan = new Scanner(results.get(5)); //
		assertEquals(scan.next(), "abcdef");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
		//assertEquals(scan.nextLine(), " The password must contain at least one digit.");
		scan = new Scanner(results.get(6)); //a
		assertEquals(scan.next(), "Applesxx");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
		//assertEquals(scan.nextLine(), " The password must contain at least one digit.");
	}
}
