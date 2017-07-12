import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * Own tests for Exercise 2 to check if the method check works properly
 * @author Valeriya Yashina, ID 1603690
 *
 */
public class SudokuReadTest {
/**
 * the following tests check whether method readSudoku works properly
 * @throws IOException if the input is incorrect
 */
	

		
	@Test
	public void testReadSudoku() throws IllegalArgumentException, IOException {
		int [][]array=new int[][]{
			{1,2,3,4,5,6,7,8,9},
			{4,5,6,7,8,9,1,2,3},
			{7,8,9,1,2,3,4,5,6},
			{2,3,4,5,6,7,8,9,1},
			{5,6,7,8,9,1,2,3,4},
			{8,9,1,2,3,4,5,6,7},
			{3,4,5,6,7,8,9,1,2},
			{6,7,8,9,1,2,3,4,5},
			{9,1,2,3,4,5,6,7,8}};
			
		Sudoku sudoku = SudokuRead.readSudoku("sudoku-full.txt");
		Assert.assertArrayEquals(array, sudoku.getArray());
	}

	@Test
	public void testReadSudoku2() throws IOException {
		int [][]array1 = {{0, 0, 0, 0, 9, 0, 2, 0, 8},
	             {0, 4, 2, 8, 0, 1, 7, 0, 0},
	             {8, 0, 0, 0, 4, 0, 0, 0, 2},
	             {4, 9, 0, 0, 0, 5, 0, 3, 8},
	             {0, 1, 0, 7, 9, 0, 0, 6, 0},
	             {3, 6, 0, 0, 0, 0, 0, 7, 9},
	             {1, 0, 0, 0, 7, 0, 8, 0, 6},
	             {0, 8, 6, 2, 0, 4, 3, 0, 0},
	             {0, 0, 3, 5, 0, 6, 0, 0, 0}};
		
		
		Sudoku sudoku1 = SudokuRead.readSudoku("sudoku-ex1.txt");
		Assert.assertArrayEquals(array1, sudoku1.getArray());
		
}
	@Test
	public void testReadSudoku3() throws IOException {
		Sudoku sudokuExpected = new Sudoku(new int[][]{
			 {0, 0, 4, 0, 8, 5, 0, 1, 0},
             {0, 2, 0, 6, 0, 9, 8, 0, 3},
             {3, 0, 8, 0, 0, 0, 0, 0, 0},
             {0, 5, 0, 2, 6, 0, 0, 0, 9},
             {0, 7, 0, 0, 0, 0, 3, 2, 0},
             {9, 0, 0, 0, 4, 3, 0, 5, 0},
             {0, 3, 0, 0, 0, 0, 0, 0, 6},
             {8, 0, 9, 0, 0, 1, 0, 3, 0},
             {0, 4, 0, 9, 0, 0, 2, 7, 0}
    });

    SudokuRead read = new SudokuRead();

    Assert.assertEquals(sudokuExpected, read.readSudoku("sudoku-ex2.txt"));
}

	
	@Test(expected = IllegalArgumentException.class)
    public void readSudokuIllegal1() throws Exception {

        SudokuRead read = new SudokuRead();
        Sudoku sudoku = read.readSudoku("sudoku-illegal1.txt");
    }

    //Malformed input file (a letter in the second line)
    @Test(expected = IllegalArgumentException.class)
    public void readSudokuIllegal2() throws Exception {

        SudokuRead read = new SudokuRead();
        Sudoku sudoku = read.readSudoku("sudoku-illegal2.txt");
    }


}
