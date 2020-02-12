package _solution;

/**
 * A ADT bag customer implementation
 * 
 * @author Alec
 * @date 02/11/2020
 * @version 0.01
 */
public class Customer {
	// Variables
	private int clock, transactionTime, numberOfArrivals;
	
	// Constructor
	public Customer(int clock, int transactionTime, int numberOfArrivals) {
		this.clock = clock;
		this.transactionTime = transactionTime;
		this.numberOfArrivals = numberOfArrivals;
	}
	
	public int getTransactionTime() {
		return this.transactionTime;
	}

	public int getArrivalTime() {
		return this.numberOfArrivals;
	}

	public String getCustomerNumber() {
		return Integer.toString(this.numberOfArrivals);
	}
}
