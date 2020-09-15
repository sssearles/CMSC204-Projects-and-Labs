/** This specialized exception is invoked when a password
 * does not contain a uppercase alpha character.
 * 
 * @author SusanSearles
 *
 */
public class NoUpperAlphaException extends Exception{

	/** No-arg constructor for the exception message that
	 * is displayed when the user enters a password that 
	 * does not contain a uppercase alpha character.
	 */
	
	public NoUpperAlphaException() {}
	
	/** Constructor for the exception message that 
	 * is displayed when the user enters a password
	 * that does not contain an uppercase alpha character.
	 * @param message String that contains the error 
	 * message for not having an uppercase alphabetic
	 * character in the password.
	 */
	public NoUpperAlphaException(String message) {
		super(message);
	}
}
