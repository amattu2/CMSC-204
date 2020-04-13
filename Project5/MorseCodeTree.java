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
	protected String lastLetter;
	
	/**
	 * Generic Constructor
	 */
	public MorseCodeTree() {
		buildTree();
	}
	
	/**
	 * Insert New Node
	 * 
	 * @param String placement code
	 * @param String letter
	 * @throws None
	 */
	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String letter) {
		// Add
		this.addNode(this.root, code, letter);
		
		// Return
		return this;
	}

	/**
	 * Add New Node
	 * 
	 * @param TreeNode<String> new node
	 * @param String placement code
	 * @param String letter
	 */
	@Override
	public void addNode(TreeNode<String> node, String code, String letter) {
		// Variables
		TreeNode<String> newNode = new TreeNode<String>(letter);
		
		// Checks
		if (code.length() == 1) {
			if (code.equals(".")) {
				node.setLeft(newNode);
			} else {
				node.setRight(newNode);
			}
		} else if (code.substring(0, 1).equals(".")) {
			this.addNode(node.getLeft(), code.substring(1), letter);
		} else {
			this.addNode(node.getRight(), code.substring(1), letter);
		}
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

	/**
	 * Set Root Node
	 * 
	 * @param Node new nod
	 * @return None
	 * @throws None
	 */
	@Override
	public void setRoot(TreeNode<String> node) {
		this.root = node;		
	}
	
	/**
	 * Finds A Node Given A Code
	 * 
	 * @param String code
	 * @return String data
	 * @throws None
	 */
	@Override
	public String fetch(String code) {
		return this.fetchNode(this.root, code);
	}

	/**
	 * Iterate Through Nodes To Find Value
	 * 
	 * @param TreeNode<String> start node
	 * @param String code
	 * @return String data
	 * @throws None
	 */
	@Override
	public String fetchNode(TreeNode<String> node, String code) {
		// Checks
		if (code.length() == 1) {
			this.lastLetter = code.equals(".") ? node.getLeft().getData() : node.getRight().getData();
		} else {
			if (code.substring(0, 1).equals(".")) {
				this.fetchNode(node.getLeft(), code.substring(1));
			} else {
				this.fetchNode(node.getRight(), code.substring(1));
			}
		}
		
		// Return
		return this.lastLetter;
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

	/**
	 * Initialize Tree With Values
	 */
	@Override
	public void buildTree() {
		// Variables
		this.root = new TreeNode<String>("");
		
		// Add Templates
		this.insert(".", "e");
		this.insert("-", "t");
		this.insert("..", "i");
		this.insert(".-", "a");
		this.insert("-.", "n");
		this.insert("--", "m");
		this.insert("...", "s");
		this.insert("..-", "u");
		this.insert(".-.", "r");
		this.insert(".--", "w");
		this.insert("-..", "d");
		this.insert("-.-", "k");
		this.insert("--.", "g");
		this.insert("---", "o");
		this.insert("....", "h");
		this.insert("...-", "v");
		this.insert("..-.", "f");
		this.insert(".-..", "l");
		this.insert(".--.", "p");
		this.insert(".---", "j");
		this.insert("-...", "b");
		this.insert("-..-", "x");
		this.insert("-.-.", "c");
		this.insert("-.--", "y");
		this.insert("--..", "z");
		this.insert("--.-", "q");
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
		
		System.out.println("LNR: " + node.getData());
		
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
