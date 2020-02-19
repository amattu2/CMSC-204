import java.util.ArrayList;

/**
 * @author Alec M.
 * @date 02/13/2020
 * @version 0.01a
 */
@SuppressWarnings("unchecked")
public class MyStack<T> implements StackInterface<T> {
	// Variables
	private ArrayList<T> stack = new ArrayList<T>();
	private int max;
	
	/**
	 * Constructor method
	 */
	public MyStack() {
		this.max = 10;
	}
	
	/**
	 * Constructor method
	 * 
	 * @param Int size
	 */
	public MyStack(int size) {
		max = size;
	}
	
	/**
	 * Determine if the stack is empty
	 * 
	 * @return Boolean empty
	 */
	@Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    /**
     * Determine if the stack is full
     * 
     * @return Boolean full
     */
    @Override
    public boolean isFull() {
        return this.stack.size() >= max;
    }

	@Override
	public int size() {
		return this.stack.size();
	}
	
    /**
     * Add new item to stack
     * 
     * @return Boolean success
     */
    public boolean push(T item) {
        // Checks
    	if (this.isFull()) { return false; }
    	
    	// Add
    	return this.stack.add(item);
    }

    /**
     * Return the item at the top of the stack
     * 
     * @return T item
     */
    public T pop() {
        // Return
    	return this.isEmpty() ? null : this.stack.remove(0);
    }

    /**
     * Return an array of items in the stack
     * 
     * @return T array
     */
	@Override
	public T[] toArray() {
		// Variables
		T[] a = (T[]) new Object[this.size()];
		int ci = 0;
		
		// Loops
		for (int i = 0; i < this.size(); i++) {
			// Variables
			T item = this.stack.get(i);
			
			// Checks
			if (!item.equals(null)) {
				a[ci++] = item;
			}
		}
		
		// Return
		return a;
	}
}
