/** This specialized exception is invoked when a password
 * does not include at least one special character
 * 
 * @author SusanSearles
 *
 */
public class NoSpecialCharacterException extends Exception{

	/** No-arg constructor for the exception message that
	 * is displayed when the user enters password that
	 * does not include at least one special character.
	 */
	public NoSpecialCharacterException() {}
	
	/**
	 * Constructor for this exception that accepts a message
	 * string describing the reason for the exception.
	 */
	public NoSpecialCharacterException(String message) {
		super(message);
	}
}
