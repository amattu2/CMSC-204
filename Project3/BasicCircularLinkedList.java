import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

/**
 * A basic unsorted CIRCULAR singly-linked implementation
 * 
 * @author Alec M.
 * @date 02/26/2020
 * @version 0.01a
 */
@SuppressWarnings("unused")
public class BasicCircularLinkedList<T> {
	// Variables
	private Node head;
	private Node tail;
	private int size;
	
	/**
	 * Add new data to list
	 * 
	 * @param T data
	 * @throws None
	 */
	public void add(T data) {
		// Variables
		Node newNode = new Node(data);
		
		// Checks
		if (head == null) {
			this.head = newNode;
			this.tail = newNode;
			newNode.setNext(head);
		} else {
			tail.setNext(newNode);
			this.tail = newNode;
			this.tail.setNext(this.head);
		}
	}
	
	public void addToFront(T data) {
		// TODO Auto-generated method stub
		
	}

	public void addToEnd(T data) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Get data from first node and remove
	 * 
	 * @return T data || null
	 * @throws None
	 */
	public T retrieveFirstElement() {
		// TODO remove element on return
		return this.head != null ? this.head.getData() : null;
	}
	
	/**
	 * Get data from first node
	 * 
	 * @return T data || null
	 * @throws None
	 */
	public T getFirst() {
		return this.head != null ? this.head.getData() : null;
	}
	
	/**
	 * Get data from last node and remove
	 * 
	 * @return T data || null
	 * @throws None
	 */
	public T retrieveLastElement() {
		// TODO remove element on return
		return this.tail != null ? this.tail.getData() : null;
	}

	/**
	 * Get data from last node
	 * 
	 * @return T data || null
	 * @throws None
	 */
	public T getLast() {
		return this.tail != null ? this.tail.getData() : null;
	}

	public void remove(T element, Comparator<T> comparator) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Return list iterator
	 * 
	 * @return ListIterator<T> iterator
	 * @throws None
	 */
	public ListIterator<T> iterator() {
		return new Iterator();
	}
	
	/**
	 * Return ArrayList of objects
	 * 
	 * @return ArrayList<T> arraylist
	 * @throws None
	 */
	public ArrayList<T> toArrayList() {
		return null;
	}
	
	/**
	 * A data container class
	 * 
	 * @author Alec M
	 * @date 02/26/2020
	 */
	private class Node {
		// Variables
		private T data;
		private Node next;
		
		/**
		 * Create new node
		 * 
		 * @param T data
		 * @throws None
		 */
		public Node(T data) {
			this.data = data;
		}
		
		/**
		 * Set next node
		 * 
		 * @param Node next
		 * @throws None
		 */
		public void setNext(Node next) {
			this.next = next;
		}
		
		/**
		 * Get node data
		 * 
		 * @return T data
		 * @throws None
		 */
		public T getData() {
			return this.data;
		}
	}

	private class Iterator implements ListIterator<T> {
		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public boolean hasPrevious() {
			return false;
		}

		@Override
		public T next() {
			return null;
		}
		
		@Override
		public T previous() {
			return null;
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) {
			throw new UnsupportedOperationException();
		}
	}	
}