import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A basic unsorted CIRCULAR singly-linked implementation
 * 
 * @author Alec M.
 * @date 02/26/2020
 * @version 0.011d
 */
@SuppressWarnings("unused")
public class BasicCircularLinkedList<T> {
	// Variables
	protected Node head;
	protected Node tail;
	protected int size;
	
	/**
	 * Add new node to front of list
	 * 
	 * @param T data
	 * @throws None
	 */
	public BasicCircularLinkedList<T> addToFront(T data) {
		// Variables
		Node newNode = new Node(data);
		this.size++;
		
		// Checks
		if (head == null) {
			this.head = newNode;
			this.tail = newNode;
			newNode.setNext(this.head);
		} else {
			tail.setNext(newNode);
			this.tail = newNode;
			this.tail.setNext(this.head);
		}
		
		// Return
		return this;
	}

	/**
	 * Add new node to end of list
	 * 
	 * @param T data
	 * @throws None
	 */
	public BasicCircularLinkedList<T> addToEnd(T data) {
		// Variables
		Node newNode = new Node(data);
		this.size++;
		
		// Checks
		if (head == null) {
			this.head = newNode;
			this.tail = newNode;
			newNode.setNext(this.head);
		} else {
			this.tail.setNext(newNode);
			this.tail = newNode;
			this.tail.setNext(this.head);
		}
		
		// Return
		return this;
	}
	
	/**
	 * Get data from first node and remove
	 * 
	 * @return T data || null
	 * @throws None
	 */
	public T retrieveFirstElement() {
		// Checks
		if (this.head != null) {
			// Variables
			Node element = this.head;
			this.head = element.getNext();
			this.tail.setNext(head);
			this.size--;
			
			// Return
			return element.getData();
		}
		
		// Default
		return null;
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
		// Checks
		if (this.tail == null && this.head == null) {
			return null;
		} else if (this.head.equals(this.tail)) {
			// Variables
			Node element = this.head;
			this.size = 0;
			this.head = null;
			this.tail = null;
			
			// Return
			return element.getData();
		} else {
			// Variables
			Node element = this.tail;
			Node secondLast = null;
			Node current = this.head;
			
			// Loops
			while (element.equals(current) == false) {
				secondLast = current;
				current = current.getNext();
			}
			
			// Return
			this.tail = secondLast;
			this.tail.setNext(this.head);
			this.size--;
			return element.getData();
		}
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

	/**
	 * Remove the specified data from list
	 * 
	 * @param T data
	 * @param Comparator data comparator
	 * @return BasicCircularLinkedList this
	 */
	public BasicCircularLinkedList<T> remove(T data, Comparator<T> comparator) {
		// Variables
		Node previous = this.tail;
		Node current = this.head;
		Node next = this.head.getNext();
		int index = 0;
		
		// Loops
		while (current != null) {
			// Checks
			if (index > 0 && head.equals(current)) { break; }
			if (comparator.compare(data, current.getData()) == 0) {
				previous.setNext(next);
				this.size--;
				break;
			}
			
			// Variables
			previous = current;
			current = current.getNext();
			next = current.getNext();
			index++;
		}
		
		// Return
		return this;
	}
	
	/**
	 * Return monitored circular list size
	 * 
	 * @return Integer size
	 * @throws None
	 */
	public int getSize() {
		return this.size;
	}	
	
	/**
	 * Return list iterator
	 * 
	 * @return ListIterator<T> iterator
	 * @throws None
	 */
	public ListIterator<T> iterator() {
		return new Iterator(this.head);
	}
	
	/**
	 * Return ArrayList of objects
	 * 
	 * @return ArrayList<T> arraylist
	 * @throws None
	 */
	public ArrayList<T> toArrayList() {
		// Variables
		ArrayList<T> a = new ArrayList<T>();
		Node head = this.head;
		Node current = this.head;
		int index = 0;
		
		// Loops
		while (current != null) {
			// Checks
			if (index > 0 && head.equals(current)) { break; }

			// Add Element, Continue
			a.add(current.getData());
			current = current.getNext();
			index++;
		}
		
		// Return
		return a;
	}
	
	/**
	 * A data container class
	 * 
	 * @author Alec M
	 * @date 02/26/2020
	 */
	protected class Node {
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
		
		/**
		 * Get next node
		 * 
		 * @return Node next
		 * @throws None
		 */
		public Node getNext() {
			return this.next;
		}
	}

	/**
	 * A data iterator implementation of ListIterator
	 * 
	 * @author Alec M
	 * @date 02/26/2020
	 */
	protected class Iterator implements ListIterator<T> {
		// Variables
		private Node head;
		private Node current;
		private Node previous;
		
		public Iterator(Node start) {
			current = start;
			head = start;
			previous = null;
		}
		
		@Override
		public boolean hasNext() {
			return this.current != null;
		}

		@Override
		public boolean hasPrevious() {
			return this.previous != null;
		}

		@Override
		public T next() {
			// Checks
			if (this.current == null) {
				throw new NoSuchElementException("No further elements");
			}
			
			// Variables
			this.previous = this.current;
			this.current = current.getNext();
			
			// Return
			return this.current.getData();
		}
		
		@Override
		public T previous() {
			// Checks
			if (this.previous == null) {
				throw new NoSuchElementException("No further elements");
			}
			
			// Variables
			this.current = this.previous;
			this.previous = null;
			
			// Return
			return this.current.getData();
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