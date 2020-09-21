import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
	
	GradeBook 	book1, book2;
	@Before
	public void setUp() throws Exception {
		book1 = new GradeBook(5);
		book1.addScore(95.0);
		book1.addScore(89.6);
		book1.addScore(94.6);
		book2 = new GradeBook(5);
		book2.addScore(85.9);
		book2.addScore(97.8);
	}
	
	@After
	public void tearDown() throws Exception {
		book1 = book2 = null;
	}
	
	@Test
	public void testAddScore() {
		assertEquals(3.0, book1.getScoreSize(), 0.01);
		assertEquals(book1.toString(), "95.0 89.6 94.6 ");
		assertEquals(2.0, book2.getScoreSize(), 0.01);
		assertEquals(book2.toString(), "85.9 97.8 ");
	}
	
	@Test
	public void testSum()  {
		assertEquals(279.2, book1.sum(), 0.0001);
		assertEquals(183.7, book2.sum(), 0.0001);
	}

	@Test
	public void testMinimum() {
		assertEquals(89.6, book1.minimum(), 0.001);
		assertEquals(85.9, book2.minimum(), 0.001);
	}
	
	@Test
	public void testFinalScore()  {
		assertEquals(189.6, book1.finalScore(), 0.0001);
		assertEquals(97.8, book2.finalScore(), 0.0001);
	}
}
