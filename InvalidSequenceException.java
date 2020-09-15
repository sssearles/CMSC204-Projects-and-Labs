/** This specialized exception is invoked when a password
 * has more than two of the same character in a sequence
 * 
 * @author SusanSearles
 *
 */
public class InvalidSequenceException extends Exception{

	/** No-arg constructor for the exception message that
	 * is displayed when the user enters an invalid 
	 * sequence.
	 */
	
	public InvalidSequenceException() {}
	
	/**
	 * Constructor for the exception message that is
	 * displayed when the user enters the same character
	 * three or more times in a row.
	 * @param message String contains the error message
	 */
	public InvalidSequenceException(String message) {
		super(message);
	}
}
