
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import _solution.InvalidSequenceException;
import _solution.LengthException;
import _solution.NoDigitException;
import _solution.NoLowerAlphaException;
import _solution.NoUpperAlphaException;
import _solution.PasswordCheckerUtility;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @Alec M. 
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> passwords = null;
	
	@Before
	public void setUp() throws Exception {
		// Variables
		String[] list = {"ValidPassword1", "INVALIDPASSWORD1", "ValidPassword2", "invalidpassword2", "invalidpasswordthree"};
		passwords = new ArrayList<String>();
		
		// Add Passwords
		passwords.addAll(Arrays.asList(list));		
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
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("ValidPassword1"));
			PasswordCheckerUtility.isValidPassword("inval");
			assertTrue("No exception thrown", false);
		} catch(LengthException e) {
			assertTrue("Threw lengthExcepetion", true);
		} catch(Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("ValidPassword2"));
			PasswordCheckerUtility.isValidPassword("invalidpassword");
			assertTrue("No exception thrown", false);
		} catch(NoUpperAlphaException e) {
			assertTrue("Threw NoUpperAlphaException", true);
		} catch(Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("ValidPassword2"));
			PasswordCheckerUtility.isValidPassword("INVALIDPASSWORD");
			assertTrue("No exception thrown", false);
		} catch(NoLowerAlphaException e) {
			assertTrue("Threw NoLowerAlphaException", true);
		} catch(Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("ValidPassword3"));
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("WeakPW1");
			assertTrue(weakPwd);
		} catch(Exception e) {			
			assertTrue("Invalid exception thrown", false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("ValidPassword4"));
			PasswordCheckerUtility.isValidPassword("SEQUENCEEE3");
			assertTrue("No exception thrown", false);
		} catch(InvalidSequenceException e) {
			assertTrue("Threw InvalidSequenceException", true);
		} catch(Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("ValidPassword5"));
			PasswordCheckerUtility.isValidPassword("NoDigitPassword");
			assertTrue("No exception thrown", false);
		} catch(NoDigitException e) {
			assertTrue("Threw NoDigitException", true);
		} catch(Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("ValidPassword6"));
			PasswordCheckerUtility.isValidPassword("CompletelyValidPassword1233");
			assertTrue("No exception thrown", true);
		} catch(Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	
	/**
	 * Test the validPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testValidPasswords() {
		// Variables
		ArrayList<String> results = PasswordCheckerUtility.validPasswords(passwords);
		
		assertEquals(true, results.get(0).contains("INVALIDPASSWORD1"));
		assertEquals(true, results.get(1).contains("invalidpassword2"));
		assertEquals(true, results.get(2).contains("invalidpasswordthree"));
	}
	
}
