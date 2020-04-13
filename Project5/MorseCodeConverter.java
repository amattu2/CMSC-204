/**
 * A morse code converter utility
 * 
 * @author Alec M.
 * @date 04/13/2020
 * @version 0.02
 * @see MorseCodeConverter(2).html
 */
public class MorseCodeConverter {
	// Class Variables
	protected static MorseCodeTree tree = null;
	
	public static String convertToEnglish(String code) {
		// Todo... parse code... etc. assign tree to the parsed tree
		return null;
	}

	public static String convertToEnglish(java.io.File file) throws java.io.FileNotFoundException {
		// Todo... parse code... etc. assign tree to the parsed tree
		return null;
	}

	/**
	 * Print A Previously Generated MorseCodeTree
	 * 
	 * @return String tree
	 * @throws None
	 */
	public static String printTree() {
		// Checks
		if (tree == null) { return ""; }
		
		// Variables
		java.util.ArrayList<String> list = tree.toArrayList();
		String result = "";
		
		// Loop
		for (String letter : list) {
			result += letter + " ";
		}
		
		// Return
		return result.trim();
	}
}
