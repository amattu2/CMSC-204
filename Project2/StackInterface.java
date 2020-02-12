



/** Interface for a generic Stack data structure
 * 
 * @author Professor Kartchner
 *
 * @param <T> data type
 */
public interface StackInterface<T> {

	/**
	 * Provide two constructors
	 * 1. takes in an int as the size of the stack
	 * 2. default constructor - uses default as the size of the stack
	 */
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty();

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull();
	

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	public T pop();

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size();
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	public boolean push(T e);
	
	/**
	 * Returns the elements of the Stack in an array, [0] is top of Stack, [1] is next in Stack, etc.
	 * @return an array of the Objects in the Stack
	 */
	public T[] toArray();
 
}
