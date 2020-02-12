package _solution;

/**
 * A LinkedQueue implementation based on Pearson Module #8 - Queues
 * 
 * @author Alec M.
 * @date 02/11/2020
 * @version 0.03
 */
public class LinkedQueue<T> implements QueueInterface<T> {
	// Class Variables
	private Node firstnode = null;
	private Node lastnode = null;
	
	public void enqueue(T newEntry) {
		// Variables
		Node newNode = new Node(newEntry);
		
		// Checks
		if (isEmpty()) {
			firstnode = newNode;
		} else {
			lastnode.setNextNode(newNode);
		}
		
		lastnode = newNode;
	}

	public T dequeue() {
		// Variables
		T front = null;
		
		// Try
		try {
			front = this.getFront();
			firstnode.setData(front);
			firstnode = firstnode.getNextNode();
		} catch(Exception e) {}
		
		// Checks
		if (firstnode == null) {
			lastnode = null;
		}
		
		// Return
		return front;
	}

	public T getFront() {
		// Checks
		if (this.isEmpty()) {
			return null;
		} else {
			return (T) firstnode.getData();
		}
	}

	public boolean isEmpty() {
		return firstnode == null && lastnode == null;
	}

	public void clear() {
		firstnode = null;
		lastnode = null;
	}
	
	private class Node {
		// Variables
		private T data = null;
		private Node next = null;
		
		// Constructor
		public Node(T newNode) {
			data = newNode;
		}
		
		public void setNextNode(Node nextNode) {
			next = nextNode;
		}
		
		public void setData(T newData) {
			data = newData;
			
		}
		
		public Node getNextNode() {
			return next;
		}
		
		public T getData() {
			return data;
		}		
	}
}
