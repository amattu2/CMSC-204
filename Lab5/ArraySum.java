/*
 * A class to manage array calculations
 * 
 * @author Alec M
 * @date 02/18/2020
 * @version 0.01
 */
public class ArraySum {
	/**
	 * Calculate the sum of an array
	 * 
	 * @param Integer array
	 * @param Integer size of array
	 * @return Integer sum of array
	 */
	public int sumOfArray(Integer a[], int size) {
		// Return
		return sum(a, size, 0, 0);
	}
	
	/**
	 * Recursive method to calculate the running sum of an array
	 * 
	 * @param Integer array
	 * @param Integer size of array
	 * @param Integer current index in array
	 * @param Integer current total of array (0-to-index)
	 * @return Integer sum of array (0-to-index)
	 */
	private int sum(Integer a[], int size, int index, int total) {
		if (index > size) {
			return total;
		} else {			
			return sum(a, size, index + 1, total + a[index]);
		}
	}
}
