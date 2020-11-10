import java.util.ArrayList;
/**
 * A generic linked binary tree which inherits from the LinkedConverterTreeInterface
 * The class uses an external generic TreeNode class parameterized as a String:
 * TreeNode<String>. 
 * This class uses a private member of root. Nodes are added based on their Morse
 * code value where a dot means to traverse left and a dash means traverse right.
 * The constructor calls the method buildTree
 * @author 13015
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	// Declare root field for the class.
	protected TreeNode<String> root;

	/**
	 * Constructor calls the buildTree method.
	 */
	public MorseCodeTree() {
		buildTree();
	}
	
	/**
	 * This is a recursive method that adds an element to the correct position
	 * in the tree based on the code.
	 * @param root  node of the tree	 
	 * @param code  code being translated to a letter
	 * @param letter  letter indicated by the given code
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		// First assign the letter for codes that are 1 character (base case)
		if (code.length() == 1) {
			if (code.equals(".")) {
				root.left = new TreeNode<>(letter);								// Do I need to put "String" in the <> ?
			} else if (code.equals("-")) {
				root.right = new TreeNode<>(letter);
			}
			// Next continue going through the code as a series of substrings until the full code is read and a letter assigned
		} else {
			if (code.charAt(0) == '.') {
				addNode(root.left, code.substring(1), letter);
			} else if (code.charAt(0) == '-') {
				addNode(root.right, code.substring(1), letter);
			}
		}

	}

	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("This method is not yet supported.");
	}

	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("This method is not yet supported.");
	}

	/*
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by
	 * level based on the code. The root will have am empty string and insert letters at 
	 * each level based on the length of the code and whether it has a dot or dash in a
	 * given position
	 */
	@Override
	public void buildTree() {
		// First set the root node (at level 0) to null
		setRoot(new TreeNode<String>(""));

		// Next go to level one and assign "e" or "t" if the code stops at one character
		insert(".", "e"); insert ("-", "t");

		// Next go to level two and assign "i" "a" "n" or "m" if the code stops at two chars
		insert("..", "i"); insert(".-", "a"); insert ("-.", "n"); insert ("--", "m");

		// Next go to level three and assign "s", "u", "r", "w", "d", "k", "g", or "o"
		insert("...", "s"); insert("..-", "u"); insert (".-.", "r"); insert (".--", "w");
		insert("-..", "d"); insert("-.-", "k"); insert ("--.", "g"); insert ("---", "o");

		// Next go to level four and assign "h", "v", "f", "l", "p", "j", "b", "x", "c", "y", "z", and "q"
		insert("....", "h"); insert("...-", "v"); insert ("..-.", "f"); 
		insert(".-..", "l"); insert (".--.", "p"); insert (".---", "j");
		insert("-...", "b"); insert("-..-", "x"); insert ("-.-.", "c"); insert ("-.--", "y");
		insert("--..", "z"); insert("--.-", "q"); 
	}

	/**
	 * This is a recursive method that adds elements to the correct position in the tree
	 * based on the code.
	 */
	@Override
	public MorseCodeTree insert(String code, String letter) {
		TreeNode<String> root = getRoot();

		// If no root exists, make the new element into the root
		if (root == null) {
			setRoot(new TreeNode<String>(letter));
		} else {
			// add the node to the appropriate spot by calling addNode
			addNode(root, code, letter);
		} return this;
	}

	/**
	 * This method returns an ArrayList of the items in the Linked Tree LNRoutputTraversal
	 * with LNR (inorder) traversal and is used to test and make sure the tree is
	 * built correctly
	 * @return treeList the ArrayList of inorder elements
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> treeList = new ArrayList<>();
		LNRoutputTraversal(root, treeList);
		return treeList;
	}

	/**
	 * This method fetches the data in the tree based on the code by calling the recursive
	 * method fetchNode.
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);

	}

	/**
	 * This method returns a reference to the root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 * Sets the root node of the tree
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		// set the root of the MorseCodeTree
		root = newNode;
	}


	/**
	 * This is a recursive method that fetches the data of the TreeNode that corresponds with 
	 * the code where a '.' (dot) traverses left and a '-' traverses right. The code is passed
	 * in and getches the data of the TreeNode stored in place of that particular code. 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @return letter (String) corresponding to the code.
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		// Instantiate the letter field as null
		String letter = "";
		
		// Set up the base case where the code has 1 character
		if (code.length() == 1) {
			if (code.equals(".")) {
				letter = root.left.data;
			}else if (code.equals("-")) {
				letter = root.right.data;
			} 		
			
		// Set up the recursion where the code string is checked to make sure it's not empty and
		// proceeds to the next leaf/child of the tree.
		} else {
			if (!code.isEmpty()) {
			if (code.charAt(0) == '.') {
				letter = fetchNode(root.left, code.substring(1));
			} else if (!code.isEmpty() && code.charAt(0) == '-') {
				letter = fetchNode(root.right, code.substring(1));
			}
		}
	}
		return letter;
	}

	/**
	 * This is a recursive method used to put the contents of the tree in an 
	 * ArrayList in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root != null) {
			LNRoutputTraversal(root.left, list);
			list.add(root.data);
			LNRoutputTraversal(root.right, list);
		}

	}

}
