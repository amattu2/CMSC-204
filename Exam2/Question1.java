
public class Question1 {
	public class BST<T extends Comparable> {
		Node<T> root;
		int count;
		
		/**
		 * Question 1A
		 */
		public int countLeaves() {
			// Checks
			if (this.root == null) {
				return 0;
			} else if (this.root.left == null && this.root.right == null) {
				return 1;
			} else {
				int cnt = this.countSide(this.root.left) + this.countSide(this.root.right);
				this.count = cnt;
				return cnt;
			}
		}
	    
	    // Count nodes per side, an extension for Question 1A
	    private int countSide(Node<T> node) {
	    	// Check param node
	    	if (node == null) {
	    		return 0;
	    	// check node's left/right
	    	} else if (node.left == null && node.right == null) {
	    		return 1;
	    	// count subnodes
	    	} else {
	    		return this.countSide(node.left) + this.countSide(node.right);
	    	}
	    }
	    
	    /**
	     * Question 1B
	     */
	    public void printSingleBranches() {
	    	java.util.ArrayList<Node> nodes = this.getNodes();
	    	
	    	/**
	    	 * I ran out of time to finish this properly
	    	 */
	    	for (Node node : nodes) {
	    		System.out.println(node.toString());
	    	}    	
	    }
	    
	    /**
	     * Question 1C
	     */
	    public void reverseOrder() {
	    	java.util.ArrayList<Node> nodes = this.getNodes();
	    	
	    	/**
	    	 * I ran out of time to finish this properly
	    	 */
	    	for (Node node : nodes) {
	    		System.out.println(node.toString());
	    	}
	    }
	    
	    private java.util.ArrayList<Node> getNodes() {
	    	java.util.ArrayList<Node> nodes = new java.util.ArrayList<Node>();
	    	
	    	if (this.root == null) {
	    		return nodes;
	    	} else {
	    		nodes.add(this.root);
	    	}
	    	if (this.root.left == null && this.root.right == null) {
	    		return nodes;
	    	}
	    	
	    	// start node adding 
	    	Node<T> currentLeft = this.root.left;
	    	Node<T> currentRight = this.root.right;
	    	
	    	// add left and right nodes
	    	while (currentLeft != null) {
	    		nodes.add(currentLeft);
	    		currentLeft = currentLeft.left;
	    	}
	    	while (currentRight != null) {
	    		nodes.add(currentRight);
	    		currentRight = currentRight.right;
	    	}
	    	
	    	// return nodes
	    	return nodes;
	    }
	    
		private class Node<T extends Comparable> {
			T value; 
			Node left;
			Node right; 
			
			public Node(T value) {
				this.value = value;
				left = right = null;
			}
		}
	}
}
