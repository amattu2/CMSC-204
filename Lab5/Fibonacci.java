/*
 * A class to manage Fibonacci sequence calculations
 * 
 * @author Alec M
 * @date 02/18/2020
 * @version 0.01
 */
public class Fibonacci {
	/**
	 * Calculate the Fibonacci sequence for a number
	 * 
	 * @param Integer number
	 * @return Long calculated number
	 */
	public static long calculate(int num) {
		// Checks
		if (num == 1 || num == 2) {
			return 1;
		} else {
			return Fibonacci.calculate(num - 1) + Fibonacci.calculate(num - 2);
		}
	}
}
