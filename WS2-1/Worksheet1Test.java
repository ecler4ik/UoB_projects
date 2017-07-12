import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author <Valeriya Yashina, ID 1603690> This class contains the test cases for
 *         Worksheet1 solutions. <WRITE YOUR TEST CASES BELOW>
 */

public class Worksheet1Test {

	@Rule
    public ExpectedException exception = ExpectedException.none();
	
  
	@Test
	/**
	 * to check method power using the case when we raise to the power 0 (boundary case)
	 */
	public void TestEx1_1() {
		int expected = 1;
		int actual = Worksheet1.power(3, 0);

		assertEquals(expected, actual);
	}

	@Test
	/**
	 * to check method power using the case when we raise 0 to some non-negative power (boundary case)
	 */
	public void TestEx1_2() {
		int expected = 0;
		int actual = Worksheet1.power(0, 3);

		assertEquals(expected, actual);
	} 
	
	@Test
	/**
	 * to check method power
	 */
	public void TestEx1_3() {
		int expected = 32;
		int actual = Worksheet1.power(2, 5);

		assertEquals(expected, actual);
	}

	@Test
	/**
	 * to check method fastPower using the case when we raise to the power 0 (boundary case)
	 */
	public void TestEx1_4() {
		int expected = 1;
		int actual = Worksheet1.fastPower(3, 0);

		assertEquals(expected, actual);
	}

	@Test
	/**
	 * to check method power using the case when we raise 0 to some non-negative power (boundary case)
	 */
	public void TestEx1_5() {
		int expected = 0;
		int actual = Worksheet1.fastPower(0, 3);

		assertEquals(expected, actual);
	}
	
	@Test
	/**
	 * to check method fastPower
	 */
	public void TestEx1_6() {
		int expected = 256;
		int actual = Worksheet1.fastPower(2, 8);

		assertEquals(expected, actual);
	}

	@Test
	/**
	 * to compare if methods 'power' and 'fastPower' produce the same result
	 */
	public void TestEx1_7() {
		int power = Worksheet1.power(2, 8);
		int fastPower = Worksheet1.fastPower(2, 8);

		assertEquals(power, fastPower);
	}

	@Test
	/**
	 * to check if the method 'negateAll' works properly
	 */
	public void TestEx2_1() {
		List list = new List(-2, List.cons(5, List.cons(-8, List.cons(0, List.empty()))));
		List expected = new List(2, List.cons(-5, List.cons(8, List.cons(0, List.empty()))));
		assertEquals(expected, Worksheet1.negateAll(list));

	}

	@Test
	/**
	 * to check if the method 'negateAll' works properly
	 */
	public void TestEx2_2() {
		List list = new List(-8, List.cons(-1, List.cons(0, List.cons(1, List.empty()))));
		List expected = new List(8, List.cons(1, List.cons(0, List.cons(-1, List.empty()))));
		assertEquals(expected, Worksheet1.negateAll(list));

	}

	@Test
	/**
	 * to check if method 'find' works properly. find -8 that occupies 0
	 * position
	 */
	public void TestEx3_1() {
		List list = new List(-8, List.cons(-1, List.cons(0, List.cons(1, List.empty()))));
		int expected = 0;
		assertEquals(expected, Worksheet1.find(-8, list));
	}

	@Test
	/**
	 * to check if method 'find' works properly. find number 1 that FIRSTLY
	 * occurs at the 3d position
	 */
	public void TestEx3_2() {
		List list = new List(-8, List.cons(-1, List.cons(0, List.cons(1, List.cons(1, List.empty())))));
		int expected = 3;
		assertEquals(expected, Worksheet1.find(1, list));
	}

	
    @Test
    /**
     * find - boundary case for exception (not in list)
     */
    public void TestEx3_3() {
        exception.expect(IllegalStateException.class);
        exception.expectMessage("list does not have any elements or element was not found");

        List list1 = List.cons(7, List.cons(5, List.cons(3, List.cons(8, List.empty()))));
        int actual = Worksheet1.find(2, list1);

    }
    
	@Test
	/**
	 * to check if the list contains only positive numbers
	 */
	public void TestEx4_1() {
		List list = new List(-8, List.cons(-1, List.cons(0, List.cons(1, List.cons(1, List.empty())))));
		assertEquals(false, Worksheet1.allPositive(list));
	}

	@Test
	/**
	 * to check if the list contains only positive numbers
	 */
	public void TestEx4_2() {
		List list = new List(8, List.cons(1, List.cons(0, List.cons(1, List.cons(10, List.empty())))));
		assertEquals(true, Worksheet1.allPositive(list));
	}

	@Test
	/**
	 * to check the exception in case when the list is empty
	 */
	public void TestEx4_3() {
		exception.expect(IllegalStateException.class);
		exception.expectMessage("list is empty");

		boolean actual = Worksheet1.allPositive(List.empty());
	}
	
	@Test
	/**
	 * to return list with only positive integers
	 */
	public void TestEx5_1() {
		List list = new List(-8, List.cons(1, List.cons(0, List.cons(-1, List.cons(10, List.empty())))));
		List expected = new List(1, List.cons(0, List.cons(10, List.empty())));
		assertEquals(expected, Worksheet1.positives(list));
	}

	@Test
	/**
	 * to return list with only positive integers. In this case there are not
	 * positive integers
	 */
	public void TestEx5_2() {
		List list = new List(-8, List.cons(-1, List.cons(-8, List.cons(-1, List.cons(-10, List.empty())))));
		List expected = new List();
		assertEquals(expected, Worksheet1.positives(list));
	}
	
	@Test
	/**
	 * to return empty list in case the initial list is empty
	 */
	public void TestEx5_() {
	
		assertEquals(new List(), Worksheet1.positives(new List()));
	}

	@Test
	/**
	 * to check if list is sorted
	 */
	public void TestEx6_1() {
		List list = new List(-8, List.cons(-1, List.cons(-8, List.cons(-1, List.cons(-10, List.empty())))));
		assertEquals(false, Worksheet1.sorted(list));
	}

	@Test
	/**
	 * to check if list is sorted
	 */
	public void TestEx6_2() {
		List list = new List(-8, List.cons(-5, List.cons(-1, List.cons(0, List.cons(10, List.empty())))));
		assertEquals(true, Worksheet1.sorted(list));
	}

	@Test
	/**
	 * to check if the list is sorted in case when there are duplicate numbers
	 */
	public void TestEx6_3() {
	    List list = new List(0, List.cons(1, List.cons(2, List.cons(2, List.cons(3, List.empty())))));
	    assertEquals(true, Worksheet1.sorted(list));
	}
	
	@Test
	/**
	 * to receive the result as the merged list of two SORTED lists. Both lists
	 * are not empty
	 */
	public void TestEx7_1() {
		List list1 = new List(-8, List.cons(-5, List.cons(-1, List.cons(0, List.cons(10, List.empty())))));
		List list2 = new List(-8, List.cons(-3, List.cons(1, List.cons(5, List.cons(16, List.empty())))));
		List expected = new List(-8, List.cons(-8, List.cons(-5, List.cons(-3,
				List.cons(-1, List.cons(0, List.cons(1, List.cons(5, List.cons(10, List.cons(16, List.empty()))))))))));

		assertEquals(expected, Worksheet1.merge(list1, list2));
	}

	@Test
	/**
	 * to receive the result as the merged list of two SORTED lists. First list
	 * is empty
	 */
	public void TestEx7_2() {
		List list1 = new List();
		List list2 = new List(-8, List.cons(-3, List.cons(1, List.cons(5, List.cons(16, List.empty())))));
		List expected = new List(-8, List.cons(-3, List.cons(1, List.cons(5, List.cons(16, List.empty())))));

		assertEquals(expected, Worksheet1.merge(list1, list2));
	}

	@Test
	/**
	 * to receive the result as the merged list of two SORTED lists. Second list
	 * is empty
	 */
	public void TestEx7_3() {
		List list1 = new List(-9, List.cons(-3, List.cons(5, List.cons(15, List.cons(26, List.empty())))));
		List list2 = new List();
		List expected = new List(-9, List.cons(-3, List.cons(5, List.cons(15, List.cons(26, List.empty())))));

		assertEquals(expected, Worksheet1.merge(list1, list2));
	}

	@Test
	/**
	 * to receive list without duplicate elements.
	 */
	public void TestEx8_1() {
		List list = new List(-2, List.cons(-2,
				List.cons(8, List.cons(15, List.cons(15, List.cons(20, List.cons(20, List.cons(21, List.empty()))))))));

		List expected = new List(-2, List.cons(8, List.cons(15, List.cons(20, List.cons(21, List.empty())))));

		assertEquals(expected, Worksheet1.removeDuplicates(list));
	}

	@Test
	/** to receive list without duplicate elements. Number 1 occurs 3 times
	 * in a row.
	 */

	public void TestEx8_2() {
		List list = new List(-1, List.cons(-3,
				List.cons(-3, List.cons(0, List.cons(1, List.cons(1, List.cons(1, List.cons(6, List.empty()))))))));
		List expected = new List(-1, List.cons(-3, List.cons(0, List.cons(1, List.cons(6, List.empty())))));

		assertEquals(expected, Worksheet1.removeDuplicates(list));
	}
	
	@Test
	/**
	 * to check that method should return the empty lust in case when the initial list is empty
	 */
	public void TestEx8_3() {

		assertEquals(new List(), Worksheet1.removeDuplicates(new List ()));
	}

}
