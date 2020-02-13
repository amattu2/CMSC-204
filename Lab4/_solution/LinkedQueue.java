package _solution;

/**
 * A LinkedQueue implementation based on Pearson Module #8 - Queues
 * 
 * @author Alec M.
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @date 02/11/2020
 * @version 0.03
 */
public class LinkedQueue<T> implements QueueInterface<T> {
	// Class Variables
	private Node firstnode = null;
	private Node lastnode = null;
	
	/*
	 * Queue a new "Customer" entry
	 * 
	 * @date 02/11/2020
	 */
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

	/*
	 * Remove the front "Customer" entry
	 * 
	 * @date 02/11/2020
	 */
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

	/*
	 * Get next in line "Customer" entry
	 * 
	 * @date 02/11/2020
	 */
	public T getFront() {
		// Checks
		if (this.isEmpty()) {
			return null;
		} else {
			return (T) firstnode.getData();
		}
	}

	/*
	 * Check if the queue is empty
	 * 
	 * @date 02/11/2020
	 */
	public boolean isEmpty() {
		return firstnode == null && lastnode == null;
	}

	/*
	 * Empty the queue
	 * 
	 * @date 02/11/2020
	 */
	public void clear() {
		firstnode = null;
		lastnode = null;
	}
	
	/*
	 * Queue entry Node class
	 * 
	 * @date 02/11/2020
	 */
	private class Node {
		// Variables
		private T data = null;
		private Node next = null;
		
		/*
		 * Create a new node
		 */
		public Node(T newNode) {
			data = newNode;
		}
		
		/*
		 * Update local node reference
		 * 
		 * @return None
		 */
		public void setNextNode(Node nextNode) {
			next = nextNode;
		}
		
		/*
		 * Update node data
		 * 
		 * @return None
		 */
		public void setData(T newData) {
			data = newData;
		}
		
		/*
		 * Get next node in line
		 * 
		 * @return Node next node
		 */
		public Node getNextNode() {
			return next;
		}
		
		/*
		 * Get node data
		 * 
		 * @return T data
		 */
		public T getData() {
			return data;
		}		
	}
}
