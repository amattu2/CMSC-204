import java.util.Iterator;

public class MyStack<E> implements StackInterface<E> {
	private E[] elements;
	private int size;
	
	public MyStack() {
		elements = (E[]) (new Object[10]);
		size = 0;	
	}
	
	// Constructs a new empty stack.
	public MyStack(int size) {
		elements = (E[]) (new Object[size]);
		size = 0;
	}
	
	// Returns true if the stack does not contain any elements.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns an Iterator to traverse the elements of this stack.
	public Iterator<E> iterator() {
		return new ArrayStackIterator();
	}
	
	// Returns the top element of this stack without removing it.
	// Throws an EmptyStackException if the stack is empty.
	public E peek() {
		if (size == 0) {
			
		}
		return elements[size - 1];
	}

	// Removes and returns the top element of this stack.
	// Throws an EmptyStackException if the stack is empty.
	public E pop() {
		if (size == 0) {
			return null;
		}
		
		E top = elements[size - 1];
		elements[size - 1] = null;
		size--;
		return top;
	}

	// Adds the given value to the top of this stack.
	public boolean push(E value) {
		if (size == elements.length) {
			return false;
		}
		elements[size] = value;
		size++;
		return true;
	}

	// Returns the number of elements contained in this stack.
	public int size() {
		return size;
	}
	
	// An iterator class to traverse the elements of this stack
	// from top to bottom.
	private class ArrayStackIterator implements Iterator<E> {
		private int index;
		
		// Constructs an iterator at the beginning (bottom) of this stack.
		public ArrayStackIterator() {
			index = size - 1;
		}
		
		// Returns true if there are any more elements for this iterator to return.
		public boolean hasNext() {
			return index >= 0;
		}

		// Returns the next element from the stack and advances iterator by one slot.
		public E next() {
			if (!hasNext()) {
				
			}
			E result = elements[index];
			index--;
			return result;
		}
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E[] toArray() {
		E[] array = (E[]) new Object[size];
		
		for (int i = 0; i < size; i++) {
			array[i] = elements[i];
		}
		
		return array;
	}
}