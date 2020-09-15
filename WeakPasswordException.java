/** This specialized exception is invoked when a password
 * is valid but only contains 6 to 9 characters.
 * 
 * @author SusanSearles
 *
 */
public class WeakPasswordException extends Exception{

	/** No-arg constructor for the exception message that
	 * is displayed when the user enters password that
	 * is valid but only contains 6 to 9 characters.
	 */
	
	public WeakPasswordException() {}
	
	/**
	 * Constructor for the exception message displayed
	 * when a user enters a password that is only 6-9
	 * characters long.
	 * @param message String message displayed to user
	 */
	public WeakPasswordException(String message) {
		super(message);
	}
}

