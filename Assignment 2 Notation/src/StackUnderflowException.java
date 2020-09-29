
//* Assignment 2 Notation
//* Author: Susan Searles
//* CMSC 204 with Professor Alexander
//* Due September 30, 2020

/**
 * This exception is thrown when an pop or a peek method is called on an empty stack.
 * @author Susan Searles
 *
 */
public class StackUnderflowException extends RuntimeException {

	/**
	 * No-arg construction with message shown for a stack underflow.
	 */
	public StackUnderflowException() {
		super("The stack is empty.");
	}
}
