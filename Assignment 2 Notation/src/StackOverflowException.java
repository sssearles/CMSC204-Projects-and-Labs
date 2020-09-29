
//* Assignment 2 Notation
//* Author: Susan Searles
//* CMSC 204 with Professor Alexander
//* Due September 30, 2020

/**
 * This exception is thrown when an push method is called on a full stack.
 * @author Susan Searles
 *
 */
public class StackOverflowException extends RuntimeException {

	/**
	 * No-arg construction with message shown for a queue overflow.
	 */
	public StackOverflowException() {
		super("The stack is full.");
	}
}

