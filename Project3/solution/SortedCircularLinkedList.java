// Package
package solution;

// Imports
import java.util.Comparator;
import java.util.ListIterator;

/**
 * A CIRCULAR singly-linked implementation
 * 
 * @author Alec M.
 * @date 03/13/2020
 * @version 0.04a
 */
public class SortedCircularLinkedList<T> extends BasicCircularLinkedList<T> {
	// Variables
	protected Comparator<T> comparator = null;
	
	/**
	 * Constructor
	 * 
	 * @param Comparator<T> comparator
	 * @throws None
	 */
	public SortedCircularLinkedList(Comparator<T> c) {
		this.head = null;
		this.tail = null;
		this.comparator = c;
	}
	
	/**
	 * Add element to node list in appropriate position
	 * 
	 * @param T data
	 * @return SortedCircularLinkedList<T> this
	 * @throws None
	 */
	public SortedCircularLinkedList<T> add(T data) {
		// Variables
		Node previous = this.tail;
		Node current = this.head;
		Node next = this.head != null ? this.head.getNext() : null;
		Node newNode = new Node(data);
		
		// Checks
		if (current == null) { // Nothing to compare

			this.head = newNode; // set head as newNode
			newNode.setNext(this.head); // set next as head
			this.tail = this.head; // set tail as newNode
			this.size++;
		} else if (this.comparator.compare(current.getData(), data) >= 0) { // data > head.data
			this.head = newNode; // set head as newNode 
			this.head.setNext(current); // set newNode next as old head
			this.tail.setNext(this.head); // set tail next as newNode
			this.size++;
		} else if (this.comparator.compare(previous.getData(), data) <= -1) { // data < tail.data
			this.tail.setNext(newNode);
			this.tail = newNode;
			this.tail.setNext(this.head);
			this.size++;
		} else { // data < head.data
			while (current != null && this.comparator.compare(current.getData(), data) < 0) {
				previous = current;
				current = current.getNext() != this.head ? current.getNext() : null; //current.getNext();
				next = current != null ? current.getNext() : null; //current.getNext() != this.head ? current.getNext() : null;
			}

			this.tail = previous == this.tail ? newNode : this.tail;
			previous.setNext(newNode);
			newNode.setNext(current == null ? this.head : current);		
			this.size++;
		}

		// Return
		return this;
	}
	
	public SortedCircularLinkedList<T> remove(T d, Comparator<T> c) {
		super.remove(d, c);
		
		return this;
	}
	
	public ListIterator<T> iterator() {
		return super.iterator();
	}
	
	public BasicCircularLinkedList<T> addToEnd() {
		throw new UnsupportedOperationException("Not supported");
	}
	
	public BasicCircularLinkedList<T> addToFront() {
		throw new UnsupportedOperationException("Not supported");
	}	
}
