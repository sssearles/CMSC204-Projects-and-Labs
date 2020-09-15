
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author SusanSearles
 * 
 * This test class checks each password requirement method in the
 * PasswordCheckerUtility with two test cases--one that passes and
 * another that fails. The file entered for the getInvalidPasswords 
 * contains at least one invalid and one valid case of each password
 * requirement.
 */

/**
 * Student test for the PasswordCheckerUtiltity methods
 * @author Susan Searles
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String>	passwordList;
	String				pwd1;
	String				pwd2;
	
	@Before
	public void setUp() throws Exception {
		String[] passwords = {"2Sho!", "Not2Short!", "noupperalpha2!", "UpperAlpha2!",
					"NOLCALPHA2!", "LCAlphaOK1?", "NoDigitPwd!", "IHaveADigit1!", "NoSCPwd123",
						"Reeepeater1!", "SequenceOK2*", "WeakPwd2*", "NotWeakPwd2*"};
		passwordList = new ArrayList<String>();
		passwordList.addAll(Arrays.asList(passwords));		// Adds test pwds into ArrayList
		}
	

	@After
	public void tearDown() throws Exception {
		passwordList = null;
	
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Not2Short!"));
			PasswordCheckerUtility.isValidPassword("2Sho!");
			assertTrue("Did not throw lengthException", false);
		}
		
		catch (LengthException e)
		{
			assertTrue("Successfully threw a lengthException", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException", false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("UpperAlpha2!"));
			PasswordCheckerUtility.isValidPassword("noupperalpha2!");
			assertTrue("Did not throw NoUpperAlphaException", false);
		}
		
		catch (NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaException", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException", false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("NOLCALPHA2!"));
			PasswordCheckerUtility.isValidPassword("LCAlphaOK1?");
			assertTrue("Did not throw NoLowerAlphaException", false);
		}
		
		catch (NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaException", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException", false);
		}
	}

	@Test
	/**
	 * Test if the password is weak
	 * This test should throw a WeakPasswordException for the second case
	 */
	public void testIsWeakPassword()
	{
		try {
			assertEquals(true,PasswordCheckerUtility.isValidPassword("NotWeakPwd2*"));
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("WeakPwd2*");
			assertTrue(weakPwd);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw an incorrect exception", false);
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("SequenceOK2*"));
			PasswordCheckerUtility.isValidPassword("Reeepeater1!");
			assertTrue("Did not throw an InvalidSequenceException", false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceException", true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw another exception besides an InvalidSequenceException", false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * The second test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("IHaveADigit1!"));
			PasswordCheckerUtility.isValidPassword("NoDigitPwd!");
			assertTrue("Did not throw a NoDigitException", false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw another exception besides a NoDigitException", false);
		}
		
	}
	
	/**
	 * Test if the password has at least one special character
	 * The second test should throw a NoSpecialCharacterException
	 */
	@Test
	public void testIsValidPasswordNoSpecialCharacter()
	{
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("IHaveAnSC1!"));
			PasswordCheckerUtility.isValidPassword("NoSCPwd123");
			assertTrue("Did not throw a NoSpecialCharacterException", false);
		}
		catch(NoSpecialCharacterException e)
		{
			assertTrue("Successfully threw a NoSpecialCharacterException",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw another exception besides a NoSpecialCharacterException", false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("ValidPwd2!"));
			PasswordCheckerUtility.isValidPassword("YesValidPwd2!");
//			assertTrue("Threw an exception", false);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw any exception at all", false);
		}
	}
	
	/**
	 * Test the getInvalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testGetInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwordList);
		
		// Check the password in the array that is too short.
		// Instantiate the Scanner object
		Scanner scan = new Scanner(results.get(0));
		assertEquals(scan.next(), "2Sho!");
		
		// Instantiate nextResults
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("6 characters"));
		
		// Check the password in the array that has no uppercase character.
		scan = new Scanner(results.get(1));
		assertEquals(scan.next(), "noupperalpha2!");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));		

		// Check the password in the array that has no lowercase character.
		scan = new Scanner(results.get(2));
		assertEquals(scan.next(), "NOLCALPHA2!");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));

		// Check the password in the array that has no digit.
		scan = new Scanner(results.get(3));
		assertEquals(scan.next(), "NoDigitPwd!");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
		
		// Check the password in the array that has no special character.
		scan = new Scanner(results.get(4));
		assertEquals(scan.next(), "NoSCPwd123");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("special"));
		
	}
	
}