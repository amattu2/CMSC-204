public class Node {
		// Variables
		private T data;
		private Node next;
		
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

		public LinkedQueue<T>.Node getNextNode() {
			return next;
		}

		public T getData() {
			return data;
		}
		
	}
