/** This specialized exception is invoked from the GUI
 * when the user enters a "Re-typed" Password that is
 * different from the initial Password. The passwords
 * are unmatched.
 * 
 * @author SusanSearles
 *
 */
public class UnmatchedException extends Exception{

	/** No-arg constructor for the exception message that
	 * is displayed when the user enters passwords that 
	 * do not match.
	 */
	
	public UnmatchedException() {
		super("The passwords do not match.");
	}
}
