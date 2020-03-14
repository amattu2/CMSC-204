// Packages
package solution;

// Imports
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A basic unsorted CIRCULAR singly-linked implementation
 * 
 * @author Alec M.
 * @date 03/13/2020
 * @version 1.01a
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
			newNode.setNext(this.head);
			this.head = newNode;			
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
			this.size = this.size <= 0 ? 0 : this.size - 1;
			
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
		if (this.tail == null || this.head == null) {
			return null;
		}
		if (this.head.equals(this.tail)) {
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
			Node previous = this.tail;
			Node current = this.head;
			
			// Loops
			while (current != element) {
				previous = current;
				current = current.getNext();
			}
			
			previous.setNext(this.head);
			this.tail = previous;
			this.size = this.size <= 0 ? 0 : this.size - 1;
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
		Node next = null;
		int index = 0;
		
		// Loops
		while (current != null) {
			// Checks
			if (index > 0 && head.equals(current)) { break; }
			if (comparator.compare(data, current.getData()) == 0) {
				if (current.equals(this.head) && this.size > 1) {
					this.head = current.getNext();
				} else if (current.equals(this.tail) && this.size > 1) {
					this.tail = previous;
				} else if (current.equals(this.head) && current.equals(this.tail)) {
					this.head = null;
					this.tail = null;
				}
				
				previous.setNext(next);
				this.size = this.size <= 0 ? 0 : this.size - 1;
				break;
			}
			
			// Variables
			previous = current;
			current = current.getNext();
			next = current != null ? current.getNext() : null;
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
		do {
			// Checks
			if (current == null || head == null) { break; }
			if (index++ > this.size + 1) { break; }
			
			// Add Element, Continue
			a.add(current.getData());
			current = current.getNext();
		} while (current != null && !current.equals(head));
		
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
		
		/**
		 * Stringify current data
		 * 
		 * @param None
		 * @return String data
		 * @throws None
		 */
		public String toString() {
			return this.data.toString();
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
		private int index;
		
		public Iterator(Node start) {
			current = start;
			head = start;
			previous = null;
			index = 0;
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
			if (this.current == null || (index > 0 && this.current.equals(this.head))) {
				throw new NoSuchElementException("No further elements");
			}
			
			// Variables
			this.previous = this.current;
			this.current = current.getNext();
			this.index++;
			
			// Return
			return this.previous.getData();
		}
		
		@Override
		public T previous() {
			// Variables
			Node truePrevious = null;
			Node next = this.head;
			
			// Checks
			if (this.previous == null) {
				throw new NoSuchElementException("No previous elements");
			}
			if (!this.previous.equals(this.head)) {						
				while (!next.getNext().equals(this.previous)) {
					next = next.getNext();
				}
				
				truePrevious = next;
			}
			
			// Return
			this.current = this.previous;
			this.previous = truePrevious;
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