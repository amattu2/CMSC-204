
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
				int cnt =  this.countSide(this.root.left) + this.countSide(this.root.right);
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
	    	
	    }
	    
	    /**
	     * Question 1C
	     */
	    public void reverseOrder() {
	    	
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
