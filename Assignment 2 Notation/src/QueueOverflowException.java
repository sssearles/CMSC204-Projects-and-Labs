
//* Assignment 2 Notation
//* Author: Susan Searles
//* CMSC 204 with Professor Alexander
//* Due September 30, 2020

/**
 * This exception is thrown when an enqueue method is called on a full queue.
 * @author Susan Searles
 *
 */
public class QueueOverflowException extends RuntimeException {

	/**
	 * No-arg construction with message shown for a queue overflow.
	 */
	public QueueOverflowException() {
		super("The queue is full.");
	}
}
