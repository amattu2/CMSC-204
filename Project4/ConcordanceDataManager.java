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
	public java.util.ArrayList<String> createConcordanceArray(String text) {
		// Variables
		ConcordanceDataStructure structure = new ConcordanceDataStructure(text.split(" ").length);
		String[] lines = text.split("\n");
		java.util.ArrayList<String> result = new java.util.ArrayList<String>();
		
		// Loops
		for (int line = 0; line < lines.length; line++) {
			for (String word : lines[line].split(" ")) {
				structure.add(word, line + 1);
			}
		}
		for (String line : structure.showAll()) {
			result.add(line + "\n");
		}
		
		// Return
		return result;
	}
	
	/**
	 * Parse provided text file to form a Concordance
	 * 
	 * @param File read
	 * @param File write
	 * @return Boolean success
	 * @throws FileNotFoundException
	 */
	public boolean createConcordanceFile(java.io.File r, java.io.File w) throws java.io.FileNotFoundException {
		// Variables
		String text = this.readFile(r);
		ConcordanceDataStructure structure = new ConcordanceDataStructure(text.split(" ").length);
		String[] lines = text.split("\n");
		
		// Loops
		for (int line = 0; line < lines.length; line++) {
			for (String word : lines[line].split(" ")) {
				structure.add(word, line + 1);
			}
		}
		
		// Return
		return this.writeFile(w, structure.showAll());
	}
	
	/**
	 * Internal function to read text to a file
	 * 
	 * @param File handle
	 * @return String file text
	 * @throws java.io.FileNotFoundException
	 */
	protected String readFile(java.io.File handle) throws java.io.FileNotFoundException {
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
	}
	
	/**
	 * Internal function to write text to a file
	 * 
	 * @param File handle
	 * @param ArrayList<String> lines
	 * @return Boolean success
	 * @throws java.io.FileNotFoundException 
	 */
	protected boolean writeFile(java.io.File handle, java.util.ArrayList<String> lines) throws java.io.FileNotFoundException {
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
		} catch(Exception e) {
			throw new java.io.FileNotFoundException("File Not Found");
		}
	}
}
