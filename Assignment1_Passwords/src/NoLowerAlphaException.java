/** This specialized exception is invoked when a password
 * does not contain a lowercase alpha character.
 * 
 * @author SusanSearles
 *
 */
public class NoLowerAlphaException extends Exception{

	/** No-arg constructor for the exception message that
	 * is displayed when the user enters a password that 
	 * does not contain a lowercase alpha character.
	 */
	
	public NoLowerAlphaException() {}
	
	/**
	 * Constructor for the exception that occurs when
	 * there is no lowercase letter in the password.
	 * @param message string for message displayed when
	 * the user does not have a lowercase letter in the
	 * password
	 */
	public NoLowerAlphaException(String message) {
		super(message);
	}
}

