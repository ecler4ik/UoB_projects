package Ex2;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author David Mcdonald
 * 8 tests to check the StarRating.interpret.
 */

public class Ws3PublicTestsEx2 {

	@Test
	public void test1() {
		
		double rating = 4.0;
		
		String expected = "OK";
		String actual = StarRating.interpret(rating);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		
		double rating = 5.0;
		
		String expected = "[HAS ONLY ONE REVIEW]";
		String actual = StarRating.interpret(rating);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		
		double rating = 1.5;
		
		String expected = "CRAP";
		String actual = StarRating.interpret(rating);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() {
		
		double rating = 4.5;
		
		String expected = "EXCELLENT";
		String actual = StarRating.interpret(rating);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test5() {
		
		double rating = 2.5;
		
		String expected = "CRAP";
		String actual = StarRating.interpret(rating);
		
		assertEquals(expected, actual);
	}

	@Test
	public void test6() {
		
		double rating = 100;
		
		String expected = "[HAS ONLY ONE REVIEW]";
		String actual = StarRating.interpret(rating);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test7() {
		
		double rating = 3.0;
		
		String expected = "CRAP";
		String actual = StarRating.interpret(rating);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test8() {
		
		double rating = -5.5;
		
		String expected = "not rated";
		String actual = StarRating.interpret(rating);
		
		assertEquals(expected, actual);
	}
}
