package _solution;

/**
 * A simple driver for the WaitLine.java class implementation
 * 
 * @author Alec M
 * @version 0.02
 */
public class WaitLineDriver {
	public static void main(String[] args) {
		// Variables
		WaitLine line = new WaitLine();
		
		// Simulate
		line.simulate(10, 0.95, 4);
	}
}
