/**
 * A morse code tree class
 * 
 * @author Alec M.
 * @date 04/13/2020
 * @version 0.02a
 * @see MorseCodeTree(2).html
 * @see LinkedConverterTreeInterface(2).html
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	// Class Variables
	protected TreeNode<String> root = null;
	
	public MorseCodeTree() {
		buildTree();
	}
	
	@Override
	public void setRoot(TreeNode<String> newNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		this.addNode(root, code, letter);
		
	}
	
	/**
	 * Get Root Node
	 * 
	 * @param None
	 * @return TreeNode<String> root
	 * @throws None
	 */
	@Override
	public TreeNode<String> getRoot() {
		return this.root;
	}	

	@Override
	public String fetch(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Convert Tree To ArrayList
	 * 
	 * @param None
	 * @return ArrayList<String> sorted list
	 * @throws None
	 */
	@Override
	public java.util.ArrayList<String> toArrayList() {
		// Variables
		java.util.ArrayList<String> list = new java.util.ArrayList<String>();
		
		// Sort
		this.LNRoutputTraversal(this.root, list);
		
		// Return
		return list;
	}

	@Override
	public void buildTree() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Recursively Sort Tree (LNR, In order)
	 * 
	 * @param TreeNode<String> node
	 * @param ArrayList<String> list
	 * @throws None
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> node, java.util.ArrayList<String> list) {
		// Checks
		if (node == null) { return; }
		
		// Sort
		this.LNRoutputTraversal(node.getLeft(), list);
		list.add(node.getData());
		this.LNRoutputTraversal(node.getRight(), list);
	}
	
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Unsupported method");
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Unsupported method");
	}
}
