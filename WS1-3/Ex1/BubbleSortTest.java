//package Ex1;

import static org.junit.Assert.*;



import org.junit.Test;

/**
 * Own tests for Ex1.
 * @author Valeriya Yashina
 *
 */
public class BubbleSortTest {
	/**
	 * All tests contain different arrays to check if method bubbleSort works properly
	 */
	
	@Test
	public void test1() {
		int[] arrayForTest1 = { 8, 90, 876, 0, 63, 4, 3, 2, 1 };
		int[] a1 = BubbleSort.bubbleSort(arrayForTest1);

		int[] arrayExpected1 = { 0, 1, 2, 3, 4, 8, 63, 90, 876 };
		assertArrayEquals(arrayExpected1, a1);
	}

	@Test
	public void test2() {
		int[] arrayForTest2 = { -700, -907, -1098, -98, -1235 };
		int[] a2 = BubbleSort.bubbleSort(arrayForTest2);
	
		int[] arrayExpected2 = { -1235, -1098, -907, -700, -98 };
		assertArrayEquals(arrayExpected2, a2);
	}

	@Test
	public void test3() {
		int[] arrayForTest = { 1, 7865, 907, 90, 8765 };
		int[] a3 = BubbleSort.bubbleSort(arrayForTest);
		int[] arrayExpected = { 1, 90, 907, 7865, 8765 };
		assertArrayEquals(arrayExpected, a3);
	}

	@Test
	public void test4() {
		int[] arrayForTest = { 1, 0, 1, 0 };
		int[] a = BubbleSort.bubbleSort(arrayForTest);
		int[] arrayExpected = { 0, 0, 1, 1 };
		assertArrayEquals(arrayExpected, a);
	}

	@Test
	public void test5() {
		int[] arrayForTest = { 1, 700, -700, -1, 0, -5678, 5678 };
		int[] a = BubbleSort.bubbleSort(arrayForTest);
		int[] arrayExpected = { -5678, -700, -1, 0, 1, 700, 5678 };
		assertArrayEquals(arrayExpected, a);
	}

}
