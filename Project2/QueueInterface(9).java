



/** Interface for a Queue data structure
 * 
 * @author Professor Kartchner
 *
 * @param <T> data type
 */
public interface QueueInterface<T> {
	/** provide two constructors 
	 * 1. takes an int as the size of the queue
	 * 2. default constructor - uses a default as the size of the queue
	 * 
	 */

	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty();

	/**
	 * Determines of the Queue is empty
	 * @return
	 */
	public boolean isFull();
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	public T dequeue();

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size();
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	public boolean enqueue(T e);
	
	/**
	 * Returns the elements of the Queue in an array, [0] is front of Queue, [1] is next in Queue, etc.
	 * @return an array of the Object elements in the Queue
	 */
	 
	public T[] toArray();
	
 

}
