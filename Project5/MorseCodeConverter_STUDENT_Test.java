// Imports
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A MorseCodeConverter Test Unit
 * 
 * @author Alec M.
 * @date 04/14/2020
 * @version 0.02
 */
public class MorseCodeConverter_STUDENT_Test {
	/**
	 * Generic LNR Test
	 */
	@Test
	public void testPrintTree()	{
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}
	
	/**
	 * Code to English
	 */
	@Test
	public void testConvertToEnglishString() {
		assertEquals("hello my name is alec", MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / -- -.-- / -. .- -- . / .. ... / .- .-.. . -.-."));
	}

	/**
	 * File to English
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testConvertToEnglishFile() throws FileNotFoundException {
		assertEquals("give me your answer do", MorseCodeConverter.convertToEnglish(this.getFile("Daisy.txt")));
	}

	/**
	 * Fetch File
	 * 
	 * @param String filename
	 * @return File fetched file
	 * @throws None
	 */
	protected File getFile(String name) {
		// Variables
		JFileChooser fchooser = new JFileChooser();
		String result = "";
		
		// Options
		fchooser.setDialogTitle("Select Input File: " + name);
		
		// Checks
		if (fchooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				return fchooser.getSelectedFile();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		// Default
		return null;
	}
}
