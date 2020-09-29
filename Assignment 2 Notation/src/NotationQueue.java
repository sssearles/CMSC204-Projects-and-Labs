import java.util.ArrayList;

/** 
 * This generic class implements a queue data structure.
 * @author Susan Searles
 * CMSC 204 with Professor Alexander
 * Due September 30, 2020
 * @param <T> generic data type for queue
 */
public class NotationQueue<T> implements QueueInterface<T> {

	/**
	 * Data structure to be used as a queue 
	 */
	private ArrayList<T> queue;

	/**
	 * This field holds the size of the queue
	 */
	private int capacity;

	/**
	 * No-arg constructor containing default values for the 
	 * queue data fields
	 */
	public NotationQueue() {
		queue = new ArrayList<T>(1000);
		capacity = 1000;
	}

	/**
	 * single-arg constructor to instantiate the queue and
	 * set the capacity of the queue
	 * @param capacity
	 */
	public NotationQueue(int capacity) {
		queue = new ArrayList<>(capacity);
		this.capacity = capacity;
	}

	/**
	 * Determines if the queue is empty
	 * @return true if the queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		if (queue.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * Determiens if the queue is full
	 * @return true if it is full and false if it is empty
	 */
	@Override
	public boolean isFull() {
		if (queue.size() == capacity) {
			return true;
		}
		return false;
	}

	/**
	 * Deletes and returns the element at the front of the queue
	 * @return frontElement front the element at the front of the queue
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}else {
			T frontElement = queue.get(0);
			queue.remove(0);
			return frontElement;
		}
	}

	/**
	 * The number of elements in the queue
	 * @return the number of elements in the queue
	 */
	@Override
	public int size() {

		return queue.size();
	}

	/**
	 * Adds an element to the end of the queue
	 * @param e the element to add to the end of the queue
	 * @return true if the element was added successfully, false if not
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		} else 
			return queue.add(e);
	}

	/**
	 * Returns the string representation of the elements in the queue.
	 * The beginning of the string is the front of the queue.
	 * @return string representation of the queue with elements
	 */
	@Override
	public String toString() {
		String queueString = "";
		for (T e: queue) {
			queueString = queueString + e;
		}
		return queueString;
	}
	
	/**
	 * Returns the string representation of the elements in the queue.
	 * The beginning of the string is the front of the queue.
	 * Place the delmiter between all elements of the queue
	 * @return string representation of the queue with elements separated by commas
	 */
	@Override
	public String toString(String delimiter) {
		String queueString = "";
		for (T e: queue) {
			queueString = queueString + e + delimiter;
		}
		return queueString.substring(0, queueString.length()-1);
	}

	/**
	 * This method fills the queue with the elements of the ArrayList.
	 */
	@Override
	public void fill(ArrayList<T> list) {
		for (T e : list) {
			enqueue(e);
		}

	}


}
