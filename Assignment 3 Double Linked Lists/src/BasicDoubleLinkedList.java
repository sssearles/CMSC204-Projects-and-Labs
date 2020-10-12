import java.util.ListIterator;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Comparator;


/**
 * This class is a generic double singly linked list with a head and tail. 
 * @author-Susan Searles
 * CMSC 204 with Dr. Alexander
 * October 14, 2020
 */
public class BasicDoubleLinkedList<T> {

	// Instantiate the head and tail node as well as the size field.
	protected Node head;
	protected Node tail;
	protected int size = 0;


	/**
	 * No-arg constructor sets the head and tail to null.
	 */
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * Adds element to the tail of the linked list, OR
	 * if the linked list is null, creates a new Node
	 *  for it and adds as both first and last. Then,
	 *  the size is incremented.
	 * @param data element to be inserted at the tail.
	 * @return the doubly linked list with the addition
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data){
		if (tail == null && head == null) {
			tail = new Node(data);
			head = tail;
		} else {
			Node newNode = new Node(data);
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}
		// increment the size of the doubly linked list
		size++;
		return this;
	}

	/**
	 * Adds a new element to the head of the list and increments size
	 * @param data the data to be added to the beginning of the list
	 * @return the updated instance of the doubly linked list
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) {
		if (head == null) {
			head = new Node(data);
			tail = head;
		} else {
			Node newNode = new Node(data);
			head.previous = newNode;			// creating a pointer back to the new head where it used to be null
			newNode.next = head;				// bumping the original head back a space to be "next" after the new head
			head = newNode;						// re-defining the new node as the head
		}
		size++;
		return this;
	}

	/**
	 * Returns the data contained in the first element in the doubly-
	 * linked list but does not remove the element from the list
	 * @return data of the element in the head of the list
	 */
	public T getFirst() {
		return head.data;
	}

	/**
	 * Returns the data contained in the last element of the doubly-
	 * linked list but does not remove the element from the list
	 * @return the data of the element in the tail of the list
	 */
	public T getLast() {
		return tail.data;
	}

	/**
	 * Getter for the size of the doubly linked list
	 * @return
	 */
	public int getSize() {
		return size;
	}

	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException{
		MyIterator iterator = new MyIterator();
		return iterator;
	}

	/**
	 * Removes the first instance of the targetData from the list. Elements are removed by 
	 * performing a single transversal over the list using the comparator to find elements
	 * that match the target. If the element is found and removed, size is decremented.
	 * @param targetData data element to be removed
	 * @param comparator determines the equality of the data elements
	 * @return the list without the element
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		// if the DLL is empty
		if (head == null) {
			return this;														
		}
		// if the DLL only has one Node and that is the target
		if (comparator.compare(head.data, targetData)==0) {
			if (head.next == null) {
				head = null;
				tail = null;
				size--;
				return this;
			}
			// if the target is the head of the DLL with other Nodes to follow
			head = head.next;
			head.previous = null;												
			size--;
			return this;
		} else {
			// if the target data is in a Node in the DLL that is not the head
			Node current = head;
			while (current.next != null) {
				if (comparator.compare(current.next.data, targetData)==0) {
					current.next = current.next.next;
					// if the iterator makes it through the DLL and it is the tail, remove the tail node
					if (current.next == null) {
						tail = current;
						size--;
						return this;
					} else {
						// if the iterator finds the target and removes it
						current.next.previous = current;
						size--;
						return this;
					}
				}
				// go back through the while loop to check the next element
				current = current.next;
			}
		}	return this;

	}

	/**
	 * Retrieves first element and deletes it from the linked list. If there
	 * are no elements, the method returns null.
	 * @return first element
	 */
	public T retrieveFirstElement() {

		if (head == null) {
			return null;
		} 

		T firstElement = head.data;
		head = head.next;
		head.previous = null;
		return firstElement;
	}

	/**
	 * Retrieves last element and deletes it from the linked list.
	 * If there are no elements, the method returns null.
	 * @return last element
	 */
	public T retrieveLastElement() {

		if (tail == null) {
			return null;
		} 

		T lastElement = tail.data;
		tail = tail.previous;
		tail.next = null;
		return lastElement;
	}
	/**
	 * This is an inner class that constructs nodes to hold
	 * elements in the doubly linked list, including the 
	 * data, the location of the next node, and the location
	 * of the previous node.
	 */
	protected class Node {

		// Create fields for the current, next, and previous elements
		protected T data;
		protected Node next;
		protected Node previous;

		/**
		 * Constructor for a node that doesn't have links
		 * @param element data of the current element
		 */
		Node (T element) {
			this.data = element;
			this.next = null;
			this.previous = null;
		}

		/**
		 * Constructor for a node with or without links
		 * @param previous previous element of the list
		 * @param element data of the current element
		 * @param next next element of the list
		 */
		Node (Node previous, T element, Node next) {
			this.data = element;
			this.next = next;
			this.previous = previous;
		}
	}

	/**
	 * This is an inner class that implements ListIterator for the 
	 * iterator method. It only implements the hasNext, next, hasPrevious
	 * and previous methods of ListIterator and throws an Unsupported Operation
	 * exception fo rall the other methods.
	 *
	 */
	protected class MyIterator implements ListIterator<T> {
		/**
		 * Instantiate a pointer for the iterator.
		 */
		Node current;													// should these be private or protected?
		int size;

		/**
		 * Place the pointer to before the first element.
		 */
		public MyIterator() {
			current = new Node(null, null, head);
		}


		@Override
		public boolean hasNext() {					
			return current.next != null;
		}

		@Override
		public boolean hasPrevious() {			
			return current.previous != null;
		}

		@Override
		public T next() {	
			if (!hasNext()) {
				throw new NoSuchElementException("There is no next element.");
			}
			else {
				current.previous = current.next;
				current.next = current.previous.next;
				return current.previous.data;
			}
		}

		@Override
		public T previous() {					

			if (!hasPrevious()) {
				throw new NoSuchElementException("There is no previous element.");

			} else {
				current.next = current.previous;
				current.previous = current.next.previous;
				return current.next.data;
			}
		}

		/**
		 * The following methods are not yet supported for this class. 
		 * Thus, the UnsupportedOperationException is thrown.
		 */
		@Override
		public void add(T argument) throws UnsupportedOperationException {
			throw new UnsupportedOperationException("Unsupported operation");
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException("Unsupported operation");
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException("Unsupported operation");
		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException("Unsupported operation");
		}

		@Override
		public void set(T argument) throws UnsupportedOperationException {
			throw new UnsupportedOperationException("Unsupported operation");

		}


	}

	/**
	 * This method returns an arraylist of the items in the list
	 * from the head to the tail.
	 * @return an array list of the node information
	 */
	public ArrayList<T> toArrayList(){
		ArrayList<T> arrayList = new ArrayList<>();
		Node newNode = head;
		while(newNode != null) {
			arrayList.add(newNode.data);
			newNode = newNode.next;
		}
		return arrayList;
	}




}
