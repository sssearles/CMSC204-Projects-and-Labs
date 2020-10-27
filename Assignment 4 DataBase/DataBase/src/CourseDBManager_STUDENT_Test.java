

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the STUDENT test for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 * @author Susan Searles
 *
 */
public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface cdm = new CourseDBManager();

	/**
	 * Create an instance of the CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		cdm = new CourseDBManager();
	}

	/**
	 * Set the cdm to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		cdm = null;
	}

	/**
	 * Test the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			cdm.add("BIOL222",35127,4,"REMOTE","Peter Vos");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test the showAll method
	 */
	@Test
	public void testShowAll() {
		cdm.add("BIOL222",35127,4,"REMOTE","Peter Vos");
		cdm.add("BIOL106",35079,4,"BS124","Kiersten Newtoff");
		cdm.add("CHEM204",33851,4,"BS138","Susan Bontems");
		ArrayList<String> list = cdm.showAll();
		
		assertEquals(list.get(0),"\nCourse:CHEM204 CRN:33851 Credits:4 Instructor:Susan Bontems Room:BS138");
		assertEquals(list.get(1),"\nCourse:BIOL106 CRN:35079 Credits:4 Instructor:Kiersten Newtoff Room:BS124");
		assertEquals(list.get(2),"\nCourse:BIOL222 CRN:35127 Credits:4 Instructor:Peter Vos Room:REMOTE");
			}
	/**
	 * Test the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("BIOL222 35127 4 REMOTE Peter Vos");
			inFile.print("CHEM204 33851 4 BS138 Susan Bontems");
			
			inFile.close();
			cdm.readFile(inputFile);
			//System.out.println(cdm.showAll());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}