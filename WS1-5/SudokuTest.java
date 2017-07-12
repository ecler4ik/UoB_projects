import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * Own tests for Exercise 1 to check how methods toString and isFilled work
 * @author Valeriya Yashina, ID 1603690
 *
 */

public class SudokuTest {

	//Two arrays to check methods, 1st one is filled, 2nd one is not 
	
	int[][] arrayTest = { { 8, 3, 5, 4, 1, 6, 9, 2, 7 }, 
			{ 2, 9, 6, 8, 5, 7, 4, 3, 1 }, 
			{ 4, 1, 7, 2, 9, 3, 6, 5, 8 },
			{ 5, 6, 9, 1, 3, 4, 7, 8, 2 }, 
			{ 1, 2, 3, 6, 7, 8, 5, 4, 9 }, 
			{ 7, 4, 8, 5, 2, 9, 1, 6, 3 },
			{ 6, 5, 2, 7, 8, 1, 3, 9, 4 }, 
			{ 9, 8, 1, 3, 4, 5, 2, 7, 6 }, 
			{ 3, 7, 4, 9, 6, 2, 8, 1, 5 } };

	int[][] arrayTest2 = { { 0, 3, 4, 6, 7, 8, 9, 1, 2 }, 
			{ 6, 7, 2, 1, 9, 5, 0, 4, 8 }, 
			{ 1, 9, 8, 3, 4, 2, 5, 6, 0 },
			{ 0, 5, 9, 7, 0, 1, 4, 2, 3 }, 
			{ 4, 2, 6, 8, 5, 3, 7, 9, 1 }, 
			{ 7, 1, 3, 9, 0, 4, 8, 5, 6 },
			{ 9, 6, 1, 5, 0, 7, 2, 8, 0 }, 
			{ 2, 8, 0, 4, 1, 9, 6, 0, 5 }, 
			{ 3, 4, 5, 2, 8, 6, 1, 0, 0 } };

	//test to check toString method when sudoku is filled
	@Test
	public void testToSTring1() {
		String expected = "++===+===+===++===+===+===++===+===+===++\n" + 
							"|| 8 | 3 | 5 || 4 | 1 | 6 || 9 | 2 | 7 ||\n"+ 
							"++---+---+---++---+---+---++---+---+---++\n" + 
							"|| 2 | 9 | 6 || 8 | 5 | 7 || 4 | 3 | 1 ||\n"+ 
							"++---+---+---++---+---+---++---+---+---++\n" + 
							"|| 4 | 1 | 7 || 2 | 9 | 3 || 6 | 5 | 8 ||\n"+ 
							"++===+===+===++===+===+===++===+===+===++\n" + 
							"|| 5 | 6 | 9 || 1 | 3 | 4 || 7 | 8 | 2 ||\n"+ 
							"++---+---+---++---+---+---++---+---+---++\n" + 
							"|| 1 | 2 | 3 || 6 | 7 | 8 || 5 | 4 | 9 ||\n"+ 
							"++---+---+---++---+---+---++---+---+---++\n" + 
							"|| 7 | 4 | 8 || 5 | 2 | 9 || 1 | 6 | 3 ||\n"+ 
							"++===+===+===++===+===+===++===+===+===++\n" + 
							"|| 6 | 5 | 2 || 7 | 8 | 1 || 3 | 9 | 4 ||\n"+ 
							"++---+---+---++---+---+---++---+---+---++\n" + 
							"|| 9 | 8 | 1 || 3 | 4 | 5 || 2 | 7 | 6 ||\n"+ 
							"++---+---+---++---+---+---++---+---+---++\n" + 
							"|| 3 | 7 | 4 || 9 | 6 | 2 || 8 | 1 | 5 ||\n"+ 
							"++===+===+===++===+===+===++===+===+===++";

		Sudoku sudokuTest = new Sudoku(arrayTest);
		Assert.assertEquals(expected, sudokuTest.toString());
	}

	// test to check method isFilled that in this case must return true
	@Test
	public void testIsFilled() {
		Sudoku sudokuFilled = new Sudoku(arrayTest);
		Assert.assertEquals(true, sudokuFilled.isFilled());

	}

	// test to check method isFilled that in this case must return true
	@Test
	public void testIsFilled2() {
		Sudoku sudokuFilled = new Sudoku(arrayTest2);
		Assert.assertNotEquals(true, sudokuFilled.isFilled());
	}

	// test to check method isFilled that in this case must return false
	@Test
	public void testIsFilled3() {
		Sudoku sudokuFilled = new Sudoku(arrayTest2);
		Assert.assertEquals(false, sudokuFilled.isFilled());
	}

	// test for toString method where there are empty elements
	@Test
	public void testToSTring2() {

		String expected = "++===+===+===++===+===+===++===+===+===++\n" + 
						"||   | 3 | 4 || 6 | 7 | 8 || 9 | 1 | 2 ||\n"+ 
						"++---+---+---++---+---+---++---+---+---++\n" + 
						"|| 6 | 7 | 2 || 1 | 9 | 5 ||   | 4 | 8 ||\n"+ 
						"++---+---+---++---+---+---++---+---+---++\n" + 
						"|| 1 | 9 | 8 || 3 | 4 | 2 || 5 | 6 |   ||\n"+ 
						"++===+===+===++===+===+===++===+===+===++\n" + 
						"||   | 5 | 9 || 7 |   | 1 || 4 | 2 | 3 ||\n"+ 
						"++---+---+---++---+---+---++---+---+---++\n" + 
						"|| 4 | 2 | 6 || 8 | 5 | 3 || 7 | 9 | 1 ||\n"+ 
						"++---+---+---++---+---+---++---+---+---++\n" + 
						"|| 7 | 1 | 3 || 9 |   | 4 || 8 | 5 | 6 ||\n"+ 
						"++===+===+===++===+===+===++===+===+===++\n" + 
						"|| 9 | 6 | 1 || 5 |   | 7 || 2 | 8 |   ||\n"+ 
						"++---+---+---++---+---+---++---+---+---++\n" + 
						"|| 2 | 8 |   || 4 | 1 | 9 || 6 |   | 5 ||\n"+ 
						"++---+---+---++---+---+---++---+---+---++\n" + 
						"|| 3 | 4 | 5 || 2 | 8 | 6 || 1 |   |   ||\n"+ 
						"++===+===+===++===+===+===++===+===+===++";
		
		Sudoku sudokuTest = new Sudoku(arrayTest2);
		Assert.assertEquals(expected, sudokuTest.toString());
	}
}
