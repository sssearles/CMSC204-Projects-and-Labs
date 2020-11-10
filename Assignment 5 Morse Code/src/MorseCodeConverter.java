import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class contains a static MorseCodeTree object and constructs the MorseCodeTree.
 * The class has two static methods convertToEnglish to convert a string and a file from 
 * Morse Code to English. There is also a static printTree method that is used for testing
 * to make sure the tree was built properly. 
 * 
 * Author: Susan Searles
 * CMSC204 with Professor Alexander
 * Assignment 5, Morse Code due Wednesday, November 11, 2020
 */
public class MorseCodeConverter {


	/**
	 * Instantiate a tree
	 */
	private static MorseCodeTree tree = new MorseCodeTree();

	// No-arg constructor
	//	public MorseCodeConverter() {
	//		
	//	}

	/**
	 * Converts a file of Morse code into English. Each letter is delimited by a space.
	 * @param codeFile  File of Morse code to convert
	 * @return  String of English 
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		Scanner input = new Scanner(codeFile);
		String phrase = "";
		while (input.hasNextLine())  {
			phrase += input.nextLine();
		}
		return convertToEnglish(phrase);
	}

	/**
	 * Converts a string of Morse code into English
	 * @param code
	 * @return String of English
	 */
	public static String convertToEnglish(String code)  {
		String phrase = "";
		String[] morseCode = code.split("/");
		String[][] codeWords = new String[morseCode.length][];

		// Put the morse code string into arrays for each word
		for (int i = 0; i < codeWords.length; i++)  {
			codeWords[i] = morseCode[i].split(" ");
		}

		// Convert each word from Morse code to English
		for (int i = 0; i < codeWords.length; i++) {
			for (int j = 0; j < codeWords[i].length; j++) {
				codeWords[i][j] = tree.fetch(codeWords[i][j]);
				phrase += codeWords[i][j];
			}
			if (i == codeWords.length -1) {
				phrase += "";
			} else phrase += " ";
		}
	return phrase;
}

/**
 * Returns a string with all the data in the tree in LNR order
 * with a space in between them.
 * @return String of all the nodes in the tree
 */
public static String printTree() {
	String treeString = "";
	for (String e : tree.toArrayList()) {
		treeString += e + " ";
	}
	return treeString;
}
}
