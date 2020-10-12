//package _solution;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * This is a student-created JUnit test for the 
 * BasicDoubleLinkedList class
 * @author Susan Searles
 * CMSC 204 with Professor Alexander
 * Due October 14, 2020
 */
public class BasicDoubleLinkedList_STUDENT_Test {

	BasicDoubleLinkedList<String> linkString;
	BasicDoubleLinkedList<Integer> linkInteger;
	BasicDoubleLinkedList<Art> linkArt;
	StringComparator comparator;
	IntegerComparator comparatorI;
	ArtComparator comparatorArt;
	
	public Art a=new Art("Van Gogh", "Sunflowers", 1888);
	public Art b=new Art("Kandinsky", "Composition VII", 1913);
	public Art c=new Art("Picasso", "Weeping Woman", 1937);
	public Art d=new Art("Da Vinci", "Portrait of Ginevra Benci", 1478);
	public Art e=new Art("Monet", "Water Lilies", 1916);
	public Art f=new Art("Munch", "The Scream", 1893);

	public ArrayList<Art> fill = new ArrayList<Art>();
	

	@Before
	public void setUp() throws Exception {
		linkString = new BasicDoubleLinkedList<String>();
		linkString.addToEnd("Good Morning");
		linkString.addToEnd("Viet Nam");
		comparator = new StringComparator();
		
		linkInteger = new BasicDoubleLinkedList<Integer>();
		linkInteger.addToEnd(77);
		linkInteger.addToEnd(20);
		comparatorI= new IntegerComparator();
		
		linkArt= new BasicDoubleLinkedList<Art>();
		linkArt.addToEnd(b);
		linkArt.addToEnd(c);
		comparatorArt = new ArtComparator();
	}

	@After
	public void tearDown() throws Exception {
		linkString = null;
		linkInteger = null;
		linkArt = null;
		comparatorI = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkString.getSize());
		assertEquals(2,linkInteger.getSize());
		assertEquals(2,linkArt.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("Viet Nam", linkString.getLast());
		linkString.addToEnd("Tail");
		assertEquals("Tail", linkString.getLast());
		
		assertEquals(c,linkArt.getLast());
		linkArt.addToEnd(d);
		assertEquals(d,linkArt.getLast());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("Good Morning", linkString.getFirst());
		linkString.addToFront("Head");
		assertEquals("Head", linkString.getFirst());
		
		assertEquals(b,linkArt.getFirst());
		linkArt.addToFront(a);
		assertEquals(a,linkArt.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("Good Morning", linkString.getFirst());
		linkString.addToFront("New");
		assertEquals("New", linkString.getFirst());
		
		assertEquals(b,linkArt.getFirst());
		linkArt.addToFront(a);
		assertEquals(a,linkArt.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("Viet Nam", linkString.getLast());
		linkString.addToEnd("New");
		assertEquals("New", linkString.getLast());
		
		assertEquals(c,linkArt.getLast());
		linkArt.addToEnd(d);
		assertEquals(d,linkArt.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<Art> list;
		linkArt.addToFront(a);
		linkArt.addToEnd(d);
		list = linkArt.toArrayList();
		assertEquals(a,list.get(0));
		assertEquals(b,list.get(1));
		assertEquals(c,list.get(2));
		assertEquals(d,list.get(3));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkString.addToFront("Begin");
		linkString.addToEnd("End");
		ListIterator<String> iterator = linkString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Good Morning", iterator.next());
		assertEquals("Viet Nam", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
		
		linkArt.addToFront(a);
		linkArt.addToEnd(d);
		ListIterator<Art> iteratorArt = linkArt.iterator();
		assertEquals(true, iteratorArt.hasNext());
		assertEquals(a, iteratorArt.next());
		assertEquals(b, iteratorArt.next());
		assertEquals(c, iteratorArt.next());
		assertEquals(true, iteratorArt.hasNext());
		assertEquals(d, iteratorArt.next());
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkArt.addToFront(a);
		linkArt.addToEnd(d);
		ListIterator<Art> iteratorArt = linkArt.iterator();
		assertEquals(true, iteratorArt.hasNext());
		assertEquals(a, iteratorArt.next());
		assertEquals(b, iteratorArt.next());
		assertEquals(c, iteratorArt.next());
		assertEquals(d, iteratorArt.next());
		assertEquals(true, iteratorArt.hasPrevious());
		assertEquals(d, iteratorArt.previous());
		assertEquals(c, iteratorArt.previous());
		assertEquals(b, iteratorArt.previous());
		assertEquals(a, iteratorArt.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkArt.addToFront(a);
		linkArt.addToEnd(d);
		ListIterator<Art> iteratorArt = linkArt.iterator();		
		assertEquals(true, iteratorArt.hasNext());
		assertEquals(a, iteratorArt.next());
		assertEquals(b, iteratorArt.next());
		assertEquals(c, iteratorArt.next());
		assertEquals(true, iteratorArt.hasNext());
		assertEquals(d, iteratorArt.next());
		
		try{
			//no more elements in list
			iteratorArt.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkArt.addToFront(a);
		linkArt.addToEnd(d);
		ListIterator<Art> iteratorArt = linkArt.iterator();		
		assertEquals(true, iteratorArt.hasNext());
		assertEquals(a, iteratorArt.next());
		assertEquals(b, iteratorArt.next());
		assertEquals(c, iteratorArt.next());
		assertEquals(d, iteratorArt.next());
		assertEquals(true, iteratorArt.hasPrevious());
		assertEquals(d, iteratorArt.previous());
		assertEquals(c, iteratorArt.previous());
		assertEquals(b, iteratorArt.previous());
		assertEquals(a, iteratorArt.previous());
		
		try{
			//no more elements in list
			iteratorArt.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		linkArt.addToFront(a);
		linkArt.addToEnd(d);
		ListIterator<Art> iteratorArt = linkArt.iterator();		
		assertEquals(true, iteratorArt.hasNext());
		assertEquals(a, iteratorArt.next());
		assertEquals(b, iteratorArt.next());
		assertEquals(c, iteratorArt.next());
		assertEquals(true, iteratorArt.hasNext());
		assertEquals(d, iteratorArt.next());
		
		try{
			//remove is not supported for the iterator
			iteratorArt.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
	
	@Test
	public void testRemove() {
		// remove the first
		assertEquals(b, linkArt.getFirst());
		assertEquals(c, linkArt.getLast());
		linkArt.addToFront(a);
		assertEquals(a, linkArt.getFirst());
		linkArt.remove(a, comparatorArt);
		assertEquals(b, linkArt.getFirst());
		//remove from the end of the list
		linkArt.addToEnd(d);
		assertEquals(d, linkArt.getLast());
		linkArt.remove(d, comparatorArt);
		assertEquals(c, linkArt.getLast());
		//remove from middle of list
		linkArt.addToFront(a);
		assertEquals(a, linkArt.getFirst());
		assertEquals(c, linkArt.getLast());
		linkArt.remove(b, comparatorArt);
		assertEquals(a, linkArt.getFirst());
		assertEquals(c, linkArt.getLast());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals(b, linkArt.getFirst());
		linkArt.addToFront(a);
		assertEquals(a, linkArt.getFirst());
		assertEquals(a, linkArt.retrieveFirstElement());
		assertEquals(b,linkArt.getFirst());
		assertEquals(b, linkArt.retrieveFirstElement());
		assertEquals(c,linkArt.getFirst());
		
		assertEquals("Good Morning", linkString.getFirst());
		linkString.addToFront("New");
		assertEquals("New", linkString.getFirst());
		assertEquals("New", linkString.retrieveFirstElement());
		assertEquals("Good Morning",linkString.getFirst());
		assertEquals("Good Morning", linkString.retrieveFirstElement());
		assertEquals("Viet Nam",linkString.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals(c, linkArt.getLast());
		linkArt.addToEnd(d);
		assertEquals(d, linkArt.getLast());
		assertEquals(d, linkArt.retrieveLastElement());
		assertEquals(c,linkArt.getLast());
		
		assertEquals("Viet Nam", linkString.getLast());
		linkString.addToEnd("New");
		assertEquals("New", linkString.getLast());
		assertEquals("New", linkString.retrieveLastElement());
		assertEquals("Viet Nam",linkString.getLast());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class IntegerComparator implements Comparator<Integer>
	{

		@Override
		public int compare(Integer arg0, Integer arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class ArtComparator implements Comparator<Art>
	{

		@Override
		public int compare(Art arg0, Art arg1) {
			// Just put art in alphabetic order by artist
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}
	
	private class Art{
		String artist;
		String title;
		int year;
		
		public Art(String artist, String title, int year){
			this.artist = artist;
			this.title = title;
			this.year = year;
		}
		
		public String getArtist(){
			return artist;
		}
		public String getTitle(){
			return title;
		}
		public int getYear(){
			return year;
		}
		
		public String toString() {
			return (getArtist()+" "+getTitle()+" "+getYear());
		}
	}
}