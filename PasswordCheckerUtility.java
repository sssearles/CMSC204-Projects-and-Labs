import java.util.regex.*;
import java.util.ArrayList;

/** This utility class contains methods to check
 * a password entered by a user for validity and
 * for strength.
 * 
 * @author SusanSearles
 *
 */

public class PasswordCheckerUtility {

	// No-arg constructor for PasswordCheckerUtility
	
	public PasswordCheckerUtility() {}
	
	/** This method tests whether a password is valid or not, 
	 * making sure it has a length greater than 6, an uppercase
	 * letter, a lowercase letter, a digit, a special character,
	 * and no more than two of the same character in succession.
	 * 
	 * @param pwd The password parameter passed in by the user
	 * @return boolean value as to whether the password is valid
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException	 * 
	 */

	public static boolean isValidPassword(String pwd) 
		throws LengthException, NoUpperAlphaException, NoLowerAlphaException,
		InvalidSequenceException, NoDigitException, NoSpecialCharacterException {
			
		// Check password length


				if (pwd.length() < 6)
		
				throw new LengthException("The password must be at least 6 "
						+ "characters long.");
			
		// Check for an uppercase alpha character
			
			Pattern pattern = Pattern.compile("[A-Z]+");
			Matcher matcher = pattern.matcher(pwd);
			
			if (!matcher.find())
			
				throw new NoUpperAlphaException ("The password must contain "
						+ "at least one uppercase alphabetic character.");
				
		// Check for a lowercase alpha character

			pattern = Pattern.compile("[a-z]");
			matcher = pattern.matcher(pwd);
			if (!matcher.find())
				
				throw new NoLowerAlphaException ("The password must contain "
						+ "at least one lowercase alphabetic character.");
		
		// Check for a digit

			pattern =  Pattern.compile("[\\d]");
			matcher = pattern.matcher(pwd);
			
			if(!matcher.find())
				throw new NoDigitException("The password must contain at "
						+ "least one digit.");

		// Check for a special character

			pattern = Pattern.compile("[\\W]");
			matcher = pattern.matcher(pwd);
			
			if(!matcher.find())
			 	throw new NoSpecialCharacterException ("The password must contain " 
						+ "at least one special character.");
		
		// Check for invalid sequence 
			
			pattern = Pattern.compile("(.)\\1{2}");
			matcher = pattern.matcher(pwd);
			
			if (matcher.find())
				throw new InvalidSequenceException("The password cannot contain "
				+ "more than two of the same character in sequence.");

			return true;
	}
	public static boolean isWeakPassword (String pwd)
		throws WeakPasswordException {
		
		// Check for password length between 6 and 9.
			
			if (pwd.length() > 5 && pwd.length() < 10) {
				
	//			throw new WeakPasswordException("The password is OK but weak --"
	//				+ " It contains fewer than 10 characters.");
				return true;

	}
		return false;
		
	}
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		
		// Check array of passwords and assemble an array list of those that are invalid.
		// Then, return an array list of the invalid passwords.
		
		// Create a loop that checks each password in the Array List for
		// validity and puts it in a new array list if it is NOT a valid 
		// password. 
		
		ArrayList<String> invalidPasswords = new ArrayList<String>();
			String 	pwd;
			
			for (int index = 0; index < passwords.size(); index++) {
				pwd = passwords.get(index);
				
				try {
					
					if (!isValidPassword(pwd)) {
						
					}
				}
				catch (Exception e) {
					
					invalidPasswords.add(pwd + " " + e.getMessage());
				}
			}
			return invalidPasswords;
	}
				

}

