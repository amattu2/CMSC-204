import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * A ConcordanceDataStructure implementation
 * 
 * @author Alec M.
 * @date 03/26/2020
 * @version 0.04
 * @see ConcordanceDataManagerInterface.java
 */
public class ConcordanceDataManager implements ConcordanceDataManagerInterface {
	/**
	 * Parse provided text to form a Concordance
	 * 
	 * @param String text
	 * @return ArrayList<String> formatted result
	 * @throws None
	 */
	public ArrayList<String> createConcordanceArray(String text) {
		// Variables
		ConcordanceDataStructure structure = new ConcordanceDataStructure(text, text.split(" ").length);
		
		// Return
		return structure.showAll();
	}
	
	/**
	 * Parse provided text file to form a Concordance
	 * 
	 * @param File read
	 * @param File write
	 * @return Boolean success
	 * @throws FileNotFoundException
	 */
	public boolean createConcordanceFile(File r, File w) throws FileNotFoundException {
		// Variables
		String text = this.readFile(r);
		ConcordanceDataStructure structure = new ConcordanceDataStructure(text, text.split(" ").length);
		
		// Return
		return this.writeFile(w, structure.showAll());
	}
	
	/**
	 * Internal function to read text to a file
	 * 
	 * @param File handle
	 * @return String file text
	 * @throws None
	 */
	protected String readFile(File handle) {
		try {
			// Variables
			java.lang.StringBuilder string = new java.lang.StringBuilder();
			java.util.Scanner scanner = new java.util.Scanner(handle);
			
			// Loops
			while (scanner.hasNextLine()) {
				string.append(scanner.nextLine() + "\n");
			}
			
			// Return
			scanner.close();
			return string.toString();
		} catch (Exception e) { return ""; }
	}
	
	/**
	 * Internal function to write text to a file
	 * 
	 * @param File handle
	 * @param ArrayList<String> lines
	 * @return Boolean success
	 * @throws None
	 */
	protected boolean writeFile(File handle, ArrayList<String> lines) {
		try {
			// Variables
			java.io.FileWriter writer = new java.io.FileWriter(handle);
			
			// Write
			for (String line : lines) {
				writer.write(line + "\n");
			}
			
			// Return
			writer.close();
			return true;
		} catch (Exception e) { return false; }
	}
}
