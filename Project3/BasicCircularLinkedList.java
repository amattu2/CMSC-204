/**
 * A CIRCULAR singly-linked implementation
 * 
 * @author Alec M.
 * @date 02/26/2020
 * @version 0.01a
 */
public class BasicCircularLinkedList<T> {
	// Variables
	private Node head;
	private Node tail;
	
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
	
	private class Node<T> {
		// Variables
		private T data;
		private Node next;
		
		public Node(T data) {
			this.data = data;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
	}
}