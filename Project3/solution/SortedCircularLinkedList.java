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
	
	public SortedCircularLinkedList(Comparator<T> c) {
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
		Node newNode = new Node(data);
		
		// Checks
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
			this.size++;
			this.head.setNext(this.tail);
		} else {
			// Variables
			Node previous = this.tail;
			Node current = this.head;
			Node next = null; 
			int index = 0;
					
			// Loops
			while (current != null) {
				// Variables
				int result = this.comparator.compare(data, current.getData());
				int end = 0;
				
				System.out.println("Comparing: " + data + " to " + current.getData() + ". "+ result);
				
				// Checks
				if (index > 0 && this.head.equals(current)) { end = 1; }
				if (result == -1) {
					previous.setNext(newNode);
					newNode.setNext(current);
					this.size++;
					break;
				} else if (result == 0 || end == 1) {
					current.setNext(newNode);
					newNode.setNext(next);
					this.size++;
					break;
				}
				
				// Variables
				previous = current;
				current = current.getNext();
				next = current.getNext();
				index++;
			}
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
