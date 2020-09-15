/** This specialized exception is invoked when a password
 * does not contain a numeric character.
 * 
 * @author SusanSearles
 *
 */
public class NoDigitException extends Exception{

	/** No-arg constructor for the exception message that
	 * is displayed when the user enters a password that 
	 * does not contain a numeric character.
	 */
	
	public NoDigitException() {}
	
	/**
	 * Constructor for the NoDigitException
	 * @param message contains the string describing the
	 * error that there is no digit in the password
	 */
	public NoDigitException(String message) {
		super(message);
	}
}