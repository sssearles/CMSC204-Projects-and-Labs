
//* Assignment 2 Notation
//* Author: Susan Searles
//* CMSC 204 with Professor Alexander
//* Due September 30, 2020

/**
 * This exception is thrown when an dequeue method is called on an empty queue.
 * @author Susan Searles
 *
 */
public class QueueUnderflowException extends RuntimeException {

	/**
	 * No-arg construction with message shown for a queue underflow.
	 */
	public QueueUnderflowException() {
		super("The queue is empty.");
	}
}