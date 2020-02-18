public class ArraySumDriver {
	private final static int ARRAY_SIZE = 6;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int index = 0;
		Integer[] myArray = new Integer[ARRAY_SIZE];
		ArraySum arraySum = new ArraySum();
		
		myArray[index++] = 3;
		myArray[index++] = 5;
		myArray[index++] = 2;
		myArray[index++] = 6;
		
		int sum = arraySum.sumOfArray(myArray, 3);
		System.out.println("Sum of indexes 0-3: " + sum); // 16 (Index 0-3)
		
		myArray[index++] = 7;
		myArray[index++] = 1;
		
		sum = arraySum.sumOfArray(myArray, 5);
		System.out.println("Sum of indexes 0-5: " + sum); // 24 (Index 0-5)
		
		// <<<<<<<------>>>>>>>>
		// Fibonacci Testing
		System.out.println("Fibonacci of 1: " + Fibonacci.calculate(1)); // 1 (Confirmed by https://omnicalculator.com)	
		System.out.println("Fibonacci of 12: " + Fibonacci.calculate(12)); // 144 (Confirmed by https://omnicalculator.com)
		System.out.println("Fibonacci of 24: " + Fibonacci.calculate(24)); // 46368 (Confirmed by https://omnicalculator.com)
	}
}