public class Question8 {
	public class BST<T extends Comparable> {
		Node<T> root;
		int count;
		
		/**
		 * Question 8A
		 * Generate a hashcode by using node.hashCode
		 */
		public int hashcode() {
			// Variables
			int hk = 0; 
			
			// Checks
			if (this.root != null && this.root.left != null) {
				hk = this.countSide(this.root.left);
			}
			if (this.root != null && this.root.right != null) {
				hk += this.countSide(this.root.right);
			}
			
			// Return
			return hk > 0 ? hk * 23 : 1; // Add some "uniqueness" (not really unique) to the code
		}
		
		/**
		 * Excerpt from Question 1, count leafs on one side of a tree
		 */
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
