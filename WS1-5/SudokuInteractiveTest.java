import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class SudokuInteractiveTest {
/**
 * Own tests for Ex 4
 * @throws IllegalArgumentException if the argument is invalid 
 * @throws IOException if the inout is invalid
 */
	@Test
	public void Test1() throws IllegalArgumentException, IOException {
		String sudInt ="     1   2   3    4   5   6    7   8   9   \n"
				+ "  ++===+===+===++===+===+===++===+===+===++\n"
				+ "a ||   |   |   ||   |*9*|   ||*2*|   |*8*||\n"
				+ "  ++---+---+---++---+---+---++---+---+---++\n"
				+ "b ||   |*4*|*2*||*8*|   |*1*||*7*|   |   ||\n"
				+ "  ++---+---+---++---+---+---++---+---+---++\n"
				+ "c ||*8*|   |   ||   |*4*|   ||   |   |*2*||\n"
				+ "  ++===+===+===++===+===+===++===+===+===++\n"
				+ "d ||*4*|*9*|   ||   |   |*5*||   |*3*|*8*||\n"
				+ "  ++---+---+---++---+---+---++---+---+---++\n"
				+ "e ||   |*1*|   ||*7*|*9*|   ||   |*6*|   ||\n"
				+ "  ++---+---+---++---+---+---++---+---+---++\n"
				+ "f ||*3*|*6*|   ||   |   |   ||   |*7*|*9*||\n"
				+ "  ++===+===+===++===+===+===++===+===+===++\n"
				+ "g ||*1*|   |   ||   |*7*|   ||*8*|   |*6*||\n"
				+ "  ++---+---+---++---+---+---++---+---+---++\n"
				+ "h ||   |*8*|*6*||*2*|   |*4*||*3*|   |   ||\n"
				+ "  ++---+---+---++---+---+---++---+---+---++\n"
				+ "i ||   |   |*3*||*5*|   |*6*||   |   |   ||\n"
				+ "  ++===+===+===++===+===+===++===+===+===++";
		String file = "sudoku-ex1.txt";
		SudokuInteractive sudoku = new SudokuInteractive(SudokuRead.readSudoku(file).getArray());
		String actual = sudoku.toString();
		String expected = sudInt;
			
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void Test2() throws IllegalArgumentException, IOException {
		String sudInt =  "     1   2   3    4   5   6    7   8   9   \n"
				+ "  ++===+===+===++===+===+===++===+===+===++\n"
				+ "a ||   |   |*4*||   |*8*|*5*||   |*1*|   ||\n"
				+ "  ++---+---+---++---+---+---++---+---+---++\n"
				+ "b ||   |*2*|   ||*6*|   |*9*||*8*|   |*3*||\n"
				+ "  ++---+---+---++---+---+---++---+---+---++\n"
				+ "c ||*3*|   |*8*||   |   |   ||   |   |   ||\n"
				+ "  ++===+===+===++===+===+===++===+===+===++\n"
				+ "d ||   |*5*|   ||*2*|*6*|   ||   |   |*9*||\n"
				+ "  ++---+---+---++---+---+---++---+---+---++\n"
				+ "e ||   |*7*|   ||   |   |   ||*3*|*2*|   ||\n"
				+ "  ++---+---+---++---+---+---++---+---+---++\n"
				+ "f ||*9*|   |   ||   |*4*|*3*||   |*5*|   ||\n"
				+ "  ++===+===+===++===+===+===++===+===+===++\n"
				+ "g ||   |*3*|   ||   |   |   ||   |   |*6*||\n"
				+ "  ++---+---+---++---+---+---++---+---+---++\n"
				+ "h ||*8*|   |*9*||   |   |*1*||   |*3*|   ||\n"
				+ "  ++---+---+---++---+---+---++---+---+---++\n"
				+ "i ||   |*4*|   ||*9*|   |   ||*2*|*7*|   ||\n"
				+ "  ++===+===+===++===+===+===++===+===+===++";
		String file = "sudoku-ex2.txt";
		SudokuInteractive sudoku = new SudokuInteractive(SudokuRead.readSudoku(file).getArray());
		String actual = sudoku.toString();
		String expected = sudInt;
			
		assertEquals(expected, actual);
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void Test3() throws IllegalArgumentException, IOException {
		
		String file = "sudoku-illegal1.txt";
		SudokuInteractive sudoku = new SudokuInteractive(SudokuRead.readSudoku(file).getArray());
		String actual = sudoku.toString();
		String expected = "Invalid file!";
			
		assertEquals(expected, actual);
		
	}

}


