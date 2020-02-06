// Namespace
package _solution;

// Imports
import java.util.ArrayList;

/**
 * @author Alec M.
 * @date 02/06/2020
 * @version 0.01a
 */
public class PasswordCheckerUtility {
	/**
	 * Returns true for valid passwords, throws errors for invalid passwords.
	 * 
	 * @param String password
	 * @author Alec M.
	 * @date 01/29/2020
	 * @version 0.01
	 * @throws Exception 
	 * @throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException
	 */
	public static boolean isValidPassword(String passwordString) throws Exception {
		// Variables
		boolean valid = true;
		boolean digit = false, upper = false, lower = false, sequence = false;
		
		// Loops
		for (int i = 0; i < passwordString.length(); i++) {
			// Variables
			char c = passwordString.charAt(i);
			
			// Checks
			if (i > 1 && passwordString.charAt(i - 1) == c && passwordString.charAt(i - 2) == c) {
				sequence = true;
			}
			if (Character.isDigit(c)) {
				digit = true;
			}
			if (Character.isUpperCase(c)) {
				upper = true;
			}
			if (Character.isLowerCase(c)) {
				lower = true;
			}
		}
		
		// Checks
		if (passwordString.length() < 6) {
			valid = false;
			throw new LengthException(passwordString + " The password must be at least 6 characters long");
		}
		if (sequence == true) {
			valid = false;
			throw new InvalidSequenceException(passwordString + " The password cannot contain more than two of the same character in sequence.");
		}
		if (upper == false) {
			valid = false;
			throw new NoUpperAlphaException(passwordString + " The password must contain at least one uppercase alphabetic character");
		}
		if (lower == false) {
			valid = false;
			throw new NoLowerAlphaException(passwordString + " The password must contain at least one lowercase alphabetic character");
		}
		if (digit == false) {
			valid = false;
			throw new NoDigitException(passwordString + " The password must contain at least one digit");
		}
		
		// Return
		return valid;
	}

	/**
	 * Returns true for valid passwords, false for weak passwords
	 * 
	 * @param String password
	 * @author Alec M.
	 * @date 01/29/2020
	 * @version 0.01
	 * @throws None
	 * @return Boolean weak
	 */
	public static boolean isWeakPassword(String passwordString) {
		// Return
		return (passwordString.length() >= 6 && passwordString.length() <= 9);
	}
	
	/**
	 * Returns a arraylist of INVALID (per documentation) passwords
	 * 
	 * @param ArrayList password
	 * @author Alec M.
	 * @date 01/29/2020
	 * @version 0.01
	 * @throws None
	 * @return ArrayList<String> invalid passwords
	 */	
	public static ArrayList<String> validPasswords(ArrayList<String> passwords) {
		// Variables
		ArrayList<String> invalid = new ArrayList<String>();
		
		// Loop
		passwords.forEach((password) -> {
			try {
				PasswordCheckerUtility.isValidPassword(password);
			} catch (Exception e) {
				invalid.add(e.getMessage());
			}
		});
		
		// Return
		return invalid;
	}
}
