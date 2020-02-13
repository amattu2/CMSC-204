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
	
	/**
	 * Create a customer instance
	 * 
	 * @param Int clock
	 * @param Int transactionTime
	 * @param Int numberOfArrivals
	 */
	public Customer(int clock, int transactionTime, int numberOfArrivals) {
		this.clock = clock;
		this.transactionTime = transactionTime;
		this.numberOfArrivals = numberOfArrivals;
	}
	
	/*
	 * Return transaction occurance time
	 * 
	 * @return Int transactionTime
	 */
	public int getTransactionTime() {
		return this.transactionTime;
	}

	/*
	 * Return number of previous arrivals
	 * 
	 * @return Int numberOfArrivals
	 */
	public int getArrivalTime() {
		return this.numberOfArrivals;
	}
	
	/*
	 * Return customer reference number
	 * 
	 * @return Int numberOfArrivals
	 */
	public String getCustomerNumber() {
		return Integer.toString(this.numberOfArrivals);
	}
}
