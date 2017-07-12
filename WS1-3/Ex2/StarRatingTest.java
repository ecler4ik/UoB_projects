package Ex2;

import static org.junit.Assert.*;

import org.junit.Test;

public class StarRatingTest {

/**
 * The following tests are used to check if method "interpret" works right 	
 */
	/**
	 * Test 1 and Test 2 are to check if the rating is within the interval from 0(incl) to 4(excl)
	 */
	@Test
	public void test1() {
		assertEquals("CRAP", StarRating.interpret(0));
	}

	@Test
	public void test2() {
		assertEquals("CRAP", StarRating.interpret(1.3));
	}

	/**
	 * Test 3 and Test 4 are to check if the rating is within the interval from 4(incl) to 4.5(excl)
	 */
	@Test
	public void test3() {
		assertEquals("OK", StarRating.interpret(4));
	}

	@Test
	public void test4() {
		assertEquals("OK", StarRating.interpret(4.3));
	}

	/**
	 * Test 5 is to check if the rating is within the interval from 4,5(incl) to 5(excl)
	 */
	@Test
	public void test5() {
		assertEquals("EXCELLENT", StarRating.interpret(4.5));
	}

	/**
	 * Test 6 and Test 7 are to check if the rating is more then 5(incl)
	 */
	@Test
	public void test6() {
		assertEquals("[HAS ONLY ONE REVIEW]", StarRating.interpret(5));
	}

	@Test
	public void test7() {
		assertEquals("[HAS ONLY ONE REVIEW]", StarRating.interpret(5.98));
	}

	/**
	 *Test 8 is to check if the rating is negative 
	 */
	@Test
	public void test8() {
		assertEquals("not rated", StarRating.interpret(-1));
	}
}
