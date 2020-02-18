public class Fibonacci {
	public static long calculate(int num) {
		// Checks
		if (num == 1 || num == 2) {
			return 1;
		} else {
			return Fibonacci.calculate(num - 1) + Fibonacci.calculate(num - 2);
		}
	}
}
