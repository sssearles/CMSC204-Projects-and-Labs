/**
 * This generic class is used in the MorseCodeTree classes. It is the
 * external tree node for Linked Trees. The class consists
 * of a reference to the data and a reference to the left and right chld.
 * @author Susan Searles
 * CMSC204, Professor Alexander
 * Due November 11, 2020
 *
 */
public class TreeNode<T> {

	/** 
	 * Fields needed for the Data Element:
	 *   Left and Right child nodes and 
	 *   data field for current node
	 */ 
	protected TreeNode<T> left;
	protected TreeNode<T> right;
	protected T data;
	
	
	/**
	 * Constructor to create a new TreeNode with left and right
	 * child set to null and data set to dataNode
	 * @param dataNode the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) {
		data = dataNode;
		left = right = null;
	}
	
	/**
	 * Constructor used for making deep copies
	 * @param node to make a copy of
	 */
	public TreeNode(TreeNode<T> node) {
		left = new TreeNode<T> (node.left);
		right = new TreeNode<T> (node.right);
		data = node.data;
	}

	/** 
	 * Gets the data of the current node.
	 * @return data
	 */
	public T getData() {
		return data;
	}
}
