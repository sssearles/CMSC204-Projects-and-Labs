import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a student JUnit test writte to test the MorseCodeConverter
 * class. There are two text files needed: philippians.txt and
 * philippians2.txt.
 * @author Susan Searles
 * CMSC 204 with Professor Alexander
 * Due: Wednesday, November 11, 2020
 *
 */
public class MorseCodeConverter_STUDENT_Test {
	File inputFile;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvertToEnglishString() {	
		String converttest1 = MorseCodeConverter.convertToEnglish("-. .. -.-. . / - --- / -- . . - / -.-- --- ..- ");
		assertEquals("nice to meet you",converttest1);
		
		String test2="merry christmas";		
		String converttest2 = MorseCodeConverter.convertToEnglish("-- . .-. .-. -.-- / -.-. .... .-. .. ... - -- .- ... ");
		assertEquals(test2, converttest2);
	}

	@Test
	public void testConvertToEnglishFile() throws FileNotFoundException {
		String test1="i can do all things";		
		getFile("philippians.txt");
		String converttest1 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test1,converttest1);
		
		String test2="through him who gives me strength";		
		getFile("philippians2.txt");
		String converttest2 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test2,converttest2);

	}
	
	public void getFile(String in) throws FileNotFoundException {		
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select Input File - " + in);
		status = chooser.showOpenDialog(null);

		if(status == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				inputFile = chooser.getSelectedFile();
				// readFile();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}