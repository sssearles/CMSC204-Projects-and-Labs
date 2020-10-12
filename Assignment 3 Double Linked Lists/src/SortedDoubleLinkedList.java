import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Assignment 3: Double Linked Lists
 * @author Susan Searles
 * CMSC 204, Professor Alexander
 * Due: October 14, 2020
 * @param <T>
 */

/**
 * This class is a generic sorted double linked list that is constructed
 * using a comparator to determine where new nodes should be placed in
 * the list. It extends BasicDoubleLinkedList
 *
 * @param <T> generic data type
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

	/** 
	 * Comparator interface sorts the doubly linked list
	 */
	protected Comparator<T> comparator = null;

	/**
	 * Constructor for the Double Linked List sorter
	 * @param comparator tool that sorts the list
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	/**
	 * This method inserts the specified element at the correct position in the
	 * sorted list. The same element can be inserted several times. The implementation
	 * must traverse the list only once to perform the insertion, and it should not
	 * be implemented using iterators or by calling any of the super class methods.
	 * @param data value to be entered
	 * @return updated instance of the sorted double linked list
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;

		} else if (comparator.compare(head.data, data) > 0){
			head.previous = newNode;
			newNode.next = head;
			head = newNode;

		}else if (comparator.compare(tail.data, data) < 0) {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		} else {
			// fix this last section of the algorithm
			Node current = head;
			while (current != null) {
				if (comparator.compare(current.data, data) <= 0) {
					Node before = current; 
					Node after = current.next;
					after.previous = newNode;
					before.next = newNode;
					newNode.next = after;
					newNode.previous = before;
				}
				current = current.next;
			}
		}
		size++;
		return this;

	}

	/**
	 * This method implements the remove operation by calling the super class
	 * remove method.
	 */
	@Override
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
		super.remove(data, comparator);
		return this;
	}

	@Override
	public ListIterator<T> iterator() {
		return super.iterator();
	}
	/**
	 * Add to End is not applicable to a sorted linked list, so 
	 * this method throws an Unsupported Operation Exception.
	 * 
	 */
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data)throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

	/**
	 * AddToFront is not applicable to a sorted linked list, so 
	 * this method throws an Unsupported Operation Exception.
	 */
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

	// testing method to display nodes of the list
	public void display() {
		Node pointer = head;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Nodes of DLL: ");
		while(pointer != null) {
			System.out.print(pointer.data + "");
			pointer = pointer.next;
		}
		System.out.println();

	}

}
