

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a student test for the CourseDBStructure
 * which is implemented from the CourseDBManagerInterface
 * @author Susan Serales
 */
public class CourseDBStructure_STUDENT_Test {
	CourseDBStructure cds, testStructure;
	
	// Set up the test
	@Before
	public void setUp() throws Exception {
		cds = new CourseDBStructure(15);
		testStructure = new CourseDBStructure("TestStructure", 15);
	}

	// Tear down the test
	@After
	public void tearDown() throws Exception {
		cds = testStructure = null;
	}
	
	/**
	 * Test the tableSize for CourseDBStructures constructed
	 * with each constructor
	 */
	@Test
	public void testGetTableSize()
	{
		assertEquals(15, cds.getTableSize());
		assertEquals(15, testStructure.getTableSize());		
	}
	
	/**
	 * Test the hashTable for CourseDBStructures constructed
	 * with each constructor
	 */
	@Test
	public void testHashTable()
	{

		assertEquals(15, cds.hashTable.length);
		CourseDBElement cde = new CourseDBElement("BIOL222", 35127, 4, "REMOTE", "Peter Vos"); 
		cds.add(cde);
		LinkedList<CourseDBElement> list = cds.hashTable[cde.hashCode()%cds.getTableSize()];
		assertEquals(35127, list.get(0).getCRN());
		
		cds = new CourseDBStructure("TestStructure",15);
		assertEquals(15, cds.hashTable.length);	
		cds.add(cde);
		list = cds.hashTable[cde.hashCode()%15];
		assertEquals(35127, list.get(0).getCRN());
	}
}