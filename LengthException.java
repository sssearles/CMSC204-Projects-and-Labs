/** This specialized exception is invoked when a password
 * is not at least 6 characters long.
 * 
 * @author SusanSearles
 *
 */
public class LengthException extends Exception{

	/** No-arg constructor for the exception message that
	 * is displayed when the user enters a password that
	 * is too short (less than 6 characters).
	 */
	
	public LengthException() {}
	
	/**
	 * Constructor for the length exception
	 * @param message String that contains the error
	 * message that the password is too short.
	 */
	public LengthException(String message) {
		super(message);
	}
}

