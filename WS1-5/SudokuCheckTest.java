import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Own tests for Exercise 3 to check if the method check works properly
 * @author Valeriya Yashina, ID 1603690
 *
 */
public class SudokuCheckTest {

	

	
	/**
	 * The sudoku is correctly filled, the values of each elements after passing the method check must be true
	 */
	@Test
	public void testCheck() {
		
		int[][] array = {{5,3,4,6,7,8,9,1,2},
	            {6,7,2,1,9,5,3,4,8},
	            {1,9,8,3,4,2,5,6,7},
	            {8,5,9,7,6,1,4,2,3},
	            {4,2,6,8,5,3,7,9,1},
	            {7,1,3,9,2,4,8,5,6},
	            {9,6,1,5,3,7,2,8,4},
	            {2,8,7,4,1,9,6,3,5},
	            {3,4,5,2,8,6,1,7,9}};
		
		boolean[][] arrayExpected = {{true,true,true,true,true, true,true,true, true},
				{true,true,true,true,true, true,true,true, true},
				{true,true,true,true,true, true,true,true, true}};
	
	Sudoku sudoku = new Sudoku (array);
	SudokuCheck.setResult(arrayExpected);
	Assert.assertArrayEquals(arrayExpected, SudokuCheck.check(sudoku));
}
	
	@Test
	public void testCheck2() {
		/**
		 * the wrong element is in row:1, column:5, square:2
		 */
		int[][] arrayToCheck = {{5,3,4,6,6,8,9,1,2},
	            {6,7,2,1,9,5,3,4,8},
	            {1,9,8,3,4,2,5,6,7},
	            {8,5,9,7,6,1,4,2,3},
	            {4,2,6,8,5,3,7,9,1},
	            {7,1,3,9,2,4,8,5,6},
	            {9,6,1,5,3,7,2,8,4},
	            {2,8,7,4,1,9,6,3,5},
	            {3,4,5,2,8,6,1,7,9}};
		
		boolean[][] arrayExpected = {{false, true, true, true, true, true, true, true, true},
				{true,true,true,true,false, true,true,true, true},
				{true,false,true,true,true, true,true,true, true}};
		SudokuCheck.setResult(arrayExpected);
	Sudoku sudoku = new Sudoku (arrayToCheck);
	System.out.println(Arrays.deepToString(SudokuCheck.check(sudoku)));
	Assert.assertTrue(Arrays.deepEquals(arrayExpected, SudokuCheck.check(sudoku)));

}
	
	@Test
	public void testCheck3() {
		/**
		 * the wrong element is in row:2, column:4, square:2
		 */
		int[][] arrayToCheck2 = {{5,3,4,6,7,8,9,1,2},
	            {6,7,2,3,9,5,3,4,8},
	            {1,9,8,3,4,2,5,6,7},
	            {8,5,9,7,6,1,4,2,3},
	            {4,2,6,8,5,3,7,9,1},
	            {7,1,3,9,2,4,8,5,6},
	            {9,6,1,5,3,7,2,8,4},
	            {2,8,7,4,1,9,6,3,5},
	            {3,4,5,2,8,6,1,7,9}};
		
		boolean[][] arrayExpected = {{true, false, true, true, true, true, true, true, true},
				{true,true,true,false,true, true,true,true, true},
				{true,false,true,true,true, true,true,true, true}};
	
	Sudoku sudoku1 = new Sudoku (arrayToCheck2);
	SudokuCheck.setResult(arrayExpected);
	Assert.assertArrayEquals(arrayExpected, SudokuCheck.check(sudoku1));
}
	
}