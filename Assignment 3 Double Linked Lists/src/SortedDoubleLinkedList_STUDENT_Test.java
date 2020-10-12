import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SortedDoubleLinkedList_STUDENT_Test {

	SortedDoubleLinkedList<String> sortedLinkedString;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	SortedDoubleLinkedList<Art> sortedLinkedArt;
	StringComparator comparator;
	DoubleComparator comparatorD;
	ArtComparator comparatorArt;
	
	public Art a=new Art("Van Gogh", "Sunflowers", 1888);
	public Art b=new Art("Kandinsky", "Composition VII", 1913);
	public Art c=new Art("Picasso", "Weeping Woman", 1937);
	public Art d=new Art("Da Vinci", "Portrait of Ginevra Benci", 1478);
	public Art e=new Art("Monet", "Water Lilies", 1916);
	public Art f=new Art("Munch", "The Scream", 1893);
	// Sorted alphabetic order: d b e f c a
	
	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
		
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		
		comparatorArt = new ArtComparator();
		sortedLinkedArt = new SortedDoubleLinkedList<Art>(comparatorArt);
		
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		comparatorD = null;
		comparatorArt = null;
		sortedLinkedString = null;
		sortedLinkedDouble = null;
		sortedLinkedArt = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Good morning");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("Good morning");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() {
		sortedLinkedArt.add(a);
		sortedLinkedArt.add(b);
		sortedLinkedArt.add(c);
		sortedLinkedArt.add(d);
		ListIterator<Art> iterator = sortedLinkedArt.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(d, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulStringPrevious() {
		sortedLinkedString.add("And a");
		sortedLinkedString.add("To you");
		sortedLinkedString.add("Good morning");
		sortedLinkedString.add("Viet Nam");
		sortedLinkedString.display();
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("And a", iterator.next());
		assertEquals("Good morning", iterator.next());
		assertEquals("To you", iterator.next());
		assertEquals("Viet Nam", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Viet Nam", iterator.previous());
		assertEquals("To you", iterator.previous());
		assertEquals("Good morning", iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulArtPrevious() {
		sortedLinkedArt.add(e);
		sortedLinkedArt.add(c);
		sortedLinkedArt.add(b);
		sortedLinkedArt.add(d);
		//ArrayList<Art> artList = sortedLinkedArt.toArrayList();
		//alphabetic order: d b e f c a
		ListIterator<Art> iterator = sortedLinkedArt.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(d, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(e, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(c, iterator.previous());
		assertEquals(e, iterator.previous());
		assertEquals(b, iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(6));
		sortedLinkedDouble.add(new Double(1));
		sortedLinkedDouble.add(new Double(2));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(1), iterator.next());
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(6), iterator.next());
		assertEquals(true, iterator.hasNext());	}
	
	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(10));
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(2));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(new Double(8), iterator.next());
		assertEquals(true, iterator.hasPrevious());
		//assertEquals(new Double(10), iterator.previous());
		assertEquals(new Double(8), iterator.previous());
		assertEquals(true, iterator.hasPrevious());
	}
	
	@Test
	public void testIteratorNoSuchElementException() {
		sortedLinkedArt.add(e);
		sortedLinkedArt.add(c);
		sortedLinkedArt.add(b);
		sortedLinkedArt.add(d);
		//ArrayList<Art> artList = sortedLinkedArt.toArrayList();
		//alphabetic order: d b e f c a
		ListIterator<Art> iterator = sortedLinkedArt.iterator();
		
		assertEquals(true, iterator.hasNext());
		assertEquals(d, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(e, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(c, iterator.next());
		try{
			//no more elements in list
			iterator.next();
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
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedArt.add(e);
		sortedLinkedArt.add(c);
		sortedLinkedArt.add(b);
		sortedLinkedArt.add(d);
		//ArrayList<Art> artList = sortedLinkedArt.toArrayList();
		//alphabetic order: d b e f c a
		ListIterator<Art> iterator = sortedLinkedArt.iterator();
		
		try{
			//remove is not supported for the iterator
			iterator.remove();
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
	public void testAddArt() {
		//alphabetic order: d b e f c a
		sortedLinkedArt.add(a);
		sortedLinkedArt.add(b);
		sortedLinkedArt.add(c);
		
		assertEquals(b, sortedLinkedArt.getFirst());
		assertEquals(a, sortedLinkedArt.getLast());
		sortedLinkedArt.add(d);
		sortedLinkedArt.add(e);
		assertEquals(d, sortedLinkedArt.getFirst());
		assertEquals(a, sortedLinkedArt.getLast());
		//deletes Van Gogh from linked list
		assertEquals(a,sortedLinkedArt.retrieveLastElement());
		assertEquals(c, sortedLinkedArt.getLast());
	}

	@Test
	public void testRemoveFirstArt() {
		//alphabetic order: d b e f c a
		sortedLinkedArt.add(e);
		sortedLinkedArt.add(c);
		assertEquals(e, sortedLinkedArt.getFirst());
		assertEquals(c, sortedLinkedArt.getLast());
		sortedLinkedArt.add(d);
		assertEquals(d, sortedLinkedArt.getFirst());
		// remove the first
		sortedLinkedArt.remove(d, comparatorArt);
		assertEquals(e, sortedLinkedArt.getFirst());
	}
	
	@Test
	public void testRemoveEndArt() {
		//alphabetic order: d b e f c a
		sortedLinkedArt.add(b);
		sortedLinkedArt.add(f);
		assertEquals(b, sortedLinkedArt.getFirst());
		assertEquals(f, sortedLinkedArt.getLast());
		sortedLinkedArt.add(d);
		assertEquals(f, sortedLinkedArt.getLast());
		//remove from the end of the list
		sortedLinkedArt.remove(f, comparatorArt);
		assertEquals(b, sortedLinkedArt.getLast());
	}

	@Test
	public void testRemoveMiddleArt() {
		//alphabetic order: d b e f c a
		sortedLinkedArt.add(a);
		sortedLinkedArt.add(b);
		assertEquals(b, sortedLinkedArt.getFirst());
		assertEquals(a, sortedLinkedArt.getLast());
		sortedLinkedArt.add(f);
		assertEquals(b, sortedLinkedArt.getFirst());
		assertEquals(a, sortedLinkedArt.getLast());
		assertEquals(3,sortedLinkedArt.getSize());
		//remove from middle of list
		sortedLinkedArt.remove(a, comparatorArt);
		assertEquals(b, sortedLinkedArt.getFirst());
		assertEquals(f, sortedLinkedArt.getLast());
		sortedLinkedArt.display();
		assertEquals(2,sortedLinkedArt.getSize());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class ArtComparator implements Comparator<Art>
	{

		@Override
		public int compare(Art arg0, Art arg1) {
			// Just put arts in alphabetic order by artist
			return arg0.getArtist().compareTo(arg1.getArtist());
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