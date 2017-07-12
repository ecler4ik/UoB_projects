package Ex3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
/**
 * These tests are used to check if method "allIntegersWithout" returns an ArrayList without particular digit
 * @author Valeriya Yashina, ID 1603690
 *
 */
public class OmitTest {

	@Test
	public void test1() {

		ArrayList<Integer> expected = new ArrayList<Integer>
		(Arrays.asList(66,68,69,80));
		ArrayList<Integer> actual = Omit.allIntegersWithout(66, 80, 7);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void test2() {

		ArrayList<Integer> expected = new ArrayList<Integer>
		(Arrays.asList(43,44,46,47,48,49));
		ArrayList<Integer> actual = Omit.allIntegersWithout(43, 55, 5);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void test3() {

		ArrayList<Integer> expected = new ArrayList<Integer>
		(Arrays.asList(99));
		ArrayList<Integer> actual = Omit.allIntegersWithout(99, 121, 1);
		
		assertEquals(expected, actual);
		
	}

	@Test
	public void test4() {

		ArrayList<Integer> expected = new ArrayList<Integer>
		(Arrays.asList(18,19,20,21,22,24,25,26,27,28,29));
		ArrayList<Integer> actual = Omit.allIntegersWithout(18, 34, 3);
		
		assertEquals(expected, actual);
		
	}
}
