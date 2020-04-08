/**
 * A morse code tree node
 * 
 * @author Alec M.
 * @date 04/07/2020
 * @version 0.01
 * @see TreeNode(3).html
 */
public class TreeNode<T> {
	// Class Variables
	protected T data = null;
	
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
	 * Retrieve Node Data
	 * 
	 * @return T data
	 * @throws None
	 */
	public T getData() {
		return this.data;
	}
}
