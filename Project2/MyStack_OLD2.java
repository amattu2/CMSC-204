public class MyStack_OLD2<E> implements StackInterface<E> {
	private GenericObjectArray[] elements;
	private int size;
	
	public MyStack_OLD2() {
		elements = (new GenericObjectArray[10]);
		size = 0;	
	}
	
	// Constructs a new empty stack.
	public MyStack_OLD2(int size) {
		elements = (new GenericObjectArray[size]);
		size = 0;
	}
	
	// Returns true if the stack does not contain any elements.
	public boolean isEmpty() {
		return size == 0;
	}
	
	// Returns the top element of this stack without removing it.
	// Throws an EmptyStackException if the stack is empty.
	public E peek() {
		if (size == 0) {
			
		}
		return (E) elements[size - 1];
	}

	// Removes and returns the top element of this stack.
	// Throws an EmptyStackException if the stack is empty.
	public E pop() {
		if (size == 0) {
			return null;
		}
		
		E top = (E) elements[size - 1];
		elements[size - 1] = null;
		size--;
		return top;
	}

	// Adds the given value to the top of this stack.
	public boolean push(E value) {
		if (size == elements.length) {
			return false;
		}
		elements[size] = (GenericObjectArray) value;
		size++;
		return true;
	}

	// Returns the number of elements contained in this stack.
	public int size() {
		return size;
	}
	

	@Override
	public boolean isFull() {
		// Return
		return size >= elements.length;
	}
	
	/**
	 * to stirng
	 */
	@Override
	public E[] toArray() {
		E[] array = (E[]) new Object[size];
		
		for (int i = 0; i < size; i++) {
			array[i] = (E) elements[i];
		}
		
		return array;
	}
	

	/*
	@Override
	public E[] toArray() {
		E[] array = (E[]) new Object[size];
		
		for (int i = 0; i < size; i++) {
			array[i] = elements[i];
		}
		
		return array;
	}
	*/
	
	private class GenericObjectArray<E> {
		private Object[] a;
		
		public GenericObjectArray(int size) {
			a = new Object[size];
		}
		
		E get(int index) {
			return (E) a[index];
		}
	}
}