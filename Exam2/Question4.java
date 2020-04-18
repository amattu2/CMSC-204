import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Question4 {
	/**
	 * Question 4A
	 * 
	 * My plan is to use an arraylist for the properly spelled words and iterate through all of the
	 * words in the file that needs to be spellchecked. If the word does not appear in the arraylist
	 * then we can assume that the word is incorrectly spelled or some unknown variant.
	 */
	
	/**
	 * Question 4B: Implementation
	 */	
	public static void main() {
		ArrayList<String> words = readFile("wordlist.txt");
		ArrayList<String> inputRaw = readFile("input.txt");
		ArrayList<String> input = new ArrayList<String>();
		
		// Checks
		if (words == null) {
			System.out.println("The wordlist was unable to be read: wordlist.txt");
			return;
		}
		if (inputRaw == null) {
			System.out.println("The input was unable to be read: input.txt");
			return;
		}
		
		// add words by line from input.txt
		for (String line : inputRaw) {
			String wordLineList[] = line.split(" ");
			
			for (String word : wordLineList) {
				input.add(word.trim());
			}
		}
		
		// find incorrectly spelled words
		for (String word : input) {
			// Checks
			if (!words.contains(word)) {
				System.out.println(word + " is misspelled");
			}
		}
	}
	/**
	 * Read a input text file
	 * A null return string means failure to read a file
	 * 
	 * @param String file name
	 * @return String result
	 */
	private static ArrayList<String> readFile(String filename) {
		try {
			File file = new File(filename);
			ArrayList<String> lines = new ArrayList<String>();
			Scanner scanner = new Scanner(file);
		
			while (scanner.hasNext()) {
				lines.add(scanner.nextLine());
			}
			
			return lines;
		} catch (Exception e) { return null; }
	}
}
