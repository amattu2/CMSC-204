/**
 * A LinkedQueue implementation based on Pearson Module #8 - Queues
 * 
 * @author Alec M.
 * @date 02/11/2020
 * @version 0.03
 */
public final class LinkedQueue<T> implements QueueInterface<T> {
	// Class Variables
	private Node firstnode = null;
	private Node lastnode = null;
	
	@Override
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

	@Override
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

	@Override
	public T getFront() {
		// Checks
		if (this.isEmpty()) {
			return null;
		} else {
			return firstnode.getData();
		}
	}

	@Override
	public boolean isEmpty() {
		return firstnode == null && lastnode == null;
	}

	@Override
	public void clear() {
		firstnode = null;
		lastnode = null;
	}
}
