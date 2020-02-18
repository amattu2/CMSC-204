public class ArraySum {
	public int sumOfArray(Integer a[], int size) {
		// Return
		return sum(a, size, 0, 0);
	}
	
	private int sum(Integer a[], int size, int index, int total) {
		if (index > size) {
			return total;
		} else {			
			return sum(a, size, index + 1, total + a[index]);
		}
	}
}
