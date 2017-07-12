package Ex3;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

/**
 * @author David Mcdonald
 * 4 tests to check the Omit.allIntegersWithout method.
 */
public class Ws3PublicTestsEx3 {

	@Test
	public void test1() {

		ArrayList<Integer> expected = new ArrayList<Integer>
		(Arrays.asList(20, 21, 22, 24, 25, 26, 27, 28, 29, 40, 41, 42, 44, 45));
		ArrayList<Integer> actual = Omit.allIntegersWithout(20, 45, 3);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void test2() {

		ArrayList<Integer> expected = new ArrayList<Integer>
		(Arrays.asList(2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14));
		ArrayList<Integer> actual = Omit.allIntegersWithout(2, 15, 5);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void test3() {

		ArrayList<Integer> expected = new ArrayList<Integer>
		(Arrays.asList(20, 22, 23, 24, 25, 26, 27, 28, 29, 30, 32, 33, 34, 35, 36, 37, 38));
		ArrayList<Integer> actual = Omit.allIntegersWithout(16, 38, 1);
		
		assertEquals(expected, actual);
		
	}

	@Test
	public void test4() {

		ArrayList<Integer> expected = new ArrayList<Integer>
		(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));
		ArrayList<Integer> actual = Omit.allIntegersWithout(1, 15, 1);
		
		assertEquals(expected, actual);
		
	}
}
