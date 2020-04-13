/**
 * A morse code tree node
 * 
 * @author Alec M.
 * @date 04/13/2020
 * @version 0.03
 * @see TreeNode(3).html
 */
public class TreeNode<T> {
	// Class Variables
	protected T data = null;
	protected TreeNode<T> left = null;
	protected TreeNode<T> right = null;
	
	/**
	 * Class Constructor
	 * 
	 * @param T data
	 * @throws None
	 */
	public TreeNode(T d) {
		this.data = d;
	}
	
	/**
	 * Class Constructor
	 *
	 * @param T TreeNode
	 * @throws None
	 */
	public TreeNode(TreeNode<T> node) {
		this.data = node.getData();
	}
	
	/**
	 * Set Left Node
	 * 
	 * @param TreeNode<T> node
	 * @throws None
	 */
	public void setLeft(TreeNode<T> node) {
		this.left = node;
	}
	
	/**
	 * Set Right Node
	 * 
	 * @param TreeNode<T> node
	 * @throws None
	 */
	public void setRight(TreeNode<T> node) {
		this.right = node;
	}
	
	/**
	 * Retrieve Node Data
	 * 
	 * @return T data
	 * @throws None
	 */
	public T getData() {
		return this.data;
	}
	
	/**
	 * Retrieve Left Node
	 * 
	 * @return TreeNode<T> left node
	 * @throws None
	 */
	public TreeNode<T> getLeft() {
		return this.left;
	}
	
	/**
	 * Retrieve Right Node
	 * 
	 * @return TreeNode<T> right node
	 * @throws None
	 */	
	public TreeNode<T> getRight() {
		return this.right;
	}
}
