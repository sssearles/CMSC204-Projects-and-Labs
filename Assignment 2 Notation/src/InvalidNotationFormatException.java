
//* Assignment 2 Notation
//* Author: Susan Searles
//* CMSC 204 with Professor Alexander
//* Due September 30, 2020


/**
 * This exception is thrown when a Notation format is incorrect
 * @author Susan Searles
 *
 */
public class InvalidNotationFormatException extends RuntimeException {

	public InvalidNotationFormatException() {
		super("The Notation format is invalid.");
	}
}

