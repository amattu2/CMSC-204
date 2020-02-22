/**
 * @author Alec M.
 * @date 02/19/2020
 * @version 0.01
 */
@SuppressWarnings("unchecked")
public class MyQueue<T> implements QueueInterface<T> {
	// Variables
	private Object queue[];
	private int max = 0;
	private int current = 0;
	private int first = 0;
	private int last = -1;
	
	/**
	 * Constructor method
	 */
	public MyQueue() {
		this.max = 10;
		this.queue = new Object[this.max];
	}
	
	/**
	 * Constructor method
	 * 
	 * @param Int size
	 */
	public MyQueue(int size) {
		this.max = size;
		this.queue = new Object[this.max];
	}
	
	/**
	 * Determine if queue is full
	 * 
	 * @return Boolean full
	 */
	@Override
	public boolean isFull() {
		return this.current == this.max;
	}
	
	/**
	 * Determine current queue size
	 * 
	 * @return Integer size
	 */
	@Override
	public int size() {
		// Variables
		int length = 0;
		
		// Loops
		for (int i = 0; i < this.queue.length; i++) {
			if (this.queue[i] == null) { continue; }
			
			length++;
		}
		
		// Return
		return length;
	}
	
	/**
	 * Determine if current queue is empty
	 * 
	 * @return Boolean empty
	 */
	@Override
	public boolean isEmpty() {
		return this.current == 0;
	}
	
	/**
	 * Add new object to queue
	 * 
	 * @param T object
	 * @return Boolean success
	 */
	@Override
	public boolean enqueue(T e) {
		// Checks
		if (this.isFull()) { return false; }
		
		// Variables
		this.last += 1;
		this.current += 1;
		this.queue[this.last % this.max] = e;
		
		// Return
		return true;
	}

	@Override
	public T dequeue() {
		// Checks
		if (this.isEmpty()) {
			return null;
		}
		
		// Variables
		int index = this.first % this.max;
		T item = (T) this.queue[index];
		this.queue[index] = null;
		this.first += 1;
		this.current -= 1;
		
		// Return
		return item;
	}
	
	@Override
	public T[] toArray() {
		// Variables
		Object[] a = new Object[this.size()];
		int ci = 0;
		
		// Loops
		for (int i = 0; i < this.size(); i++) {
			// Variables
			T item = this.getElement(i);
			
			// Checks
			if (null != item) {
				a[ci++] = item;
			}
		}
		
		// Return
		return (T[]) a;
	}
	
	/**
	 * Access element at specified index
	 * 
	 * @param Int index
	 * @return T element
	 */
	private T getElement(int i) {
		return (T) this.queue[i];
	}
}
