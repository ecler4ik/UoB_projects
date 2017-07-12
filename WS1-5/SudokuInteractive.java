import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The following class allows users to play sudoku interactively . The user
 * inputs from keyboard the cell and the value, after each step the sudoku will
 * be updated. The user also can reset or exit from the game
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version Date 28/11/2016
 *
 */
public class SudokuInteractive extends Sudoku {
	/**
	 * Class SudokuInterective is the sub class of the super class Sudoku
	 */
	final static int SIZE = 9;
	private final boolean[][] initial;

	/**
	 * Constructor for the class SudokuInteractive with parameter array that is
	 * inherited from the super class. Moreover contains array initial of the
	 * type boolean, 'true' if cell contains digit, otherwise 'false'
	 * 
	 * @param array represents sudoku
	 */
	public SudokuInteractive(int[][] array) {
		super(array);
		this.initial = new boolean[SIZE][SIZE];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				this.initial[i][j] = (array[i][j] != 0);
			}
		}
	}

	/**
	 * The following method allows users to play sudoku interactively
	 * 
	 * @param file - pathway of the file where the sudoku is stored.
	 * @throws IllegalArgumentException - if argument is illegal, that is 
	 * numbers are not between 1 and 9 (incl)
	 * @throws IOException if input is not correct or file doesn't exist
	 * 
	 *             The algorithm will be explained step-by-step
	 */
	public static void play(String file) throws IllegalArgumentException, IOException {
		
		/**
		 * create object of the class SUdokuInteractive 
		 * read sudoku from the file using the previous method
		 */
		Sudoku sudokuInitial = SudokuRead.readSudoku(file);
		SudokuInteractive sudokuI = new SudokuInteractive(SudokuRead.readSudoku(file).getArray());
		
		/**
		 * variable cell is for cell where to write down number. 
		 * variable number if for value to to be stored into the cell.
		 * variables rowNumber and colNumber are used in order to convert 
		 * String designation of the cell like a3, g6 to integer values to 
		 * output the initial sudoku
		 */
		String cell;
		int number = 0;
		int rowNumber = 0;
		int colNumber = 0;
		System.out.println(sudokuI.toString());

		/**
		 * 1. to use while loop in order to carry on playing sudoku until it
		 * will be solved
		 */
		while (isSolved(sudokuI.getArray()) == false) {

			/**
			 * 1. to create Scanner object to let user input cell and value 
			 * 2. It's also possible to reset or exit the game. 
			 * 3. If user resets the game, we asked to read sudoku from the file 
			 * again in order to get initial values of sudoku 
			 * 4. If user types "exit" then the game is over. Exit.
			 */
			Scanner s = new Scanner(System.in);
			System.out.println("Enter the chosen 'cell':'value' (a3:1), or reset, or exit: ");
			cell = s.next();
			if (cell.equals("reset")) {
				sudokuI = new SudokuInteractive(SudokuRead.readSudoku(file).getArray());
				System.out.println(sudokuI.toString());

			} else if (cell.equals("exit")) {
				System.out.println("Game over");
				System.exit(0);
			} else if (isCommandValid(cell)==true){
				/**
				 * 5. If user types cell, then he is asked what value he would like to put 
				 * 6. To covert the cell of type String to integer type in order to know 
				 * the location of the cell in the array
				 */
				String[] parts = cell.split(":");
				String p1 = parts[0]; // a4
				String p2 = parts[1]; // 1

				number = Integer.parseInt(p2);

				rowNumber = convertRow(p1);
				colNumber = Integer.parseInt(String.valueOf(p1.charAt(1)));

				/**
				 * 6. If the cell is not occupied then we assign this value to
				 * this cell. 
				 * 7. We made the condition that user can't can't the
				 * initial value, but it's possible to change his own previous
				 * values 
				 * 8. After each step the sudoku is updated and displays
				 * on the console 
				 * 9. When the Sudoku will be completely filled
				 * (and the sudoku must be filled correctly), the game will finish
				 */
				if (sudokuInitial.getArray()[rowNumber - 1][colNumber - 1] == 0) {
					sudokuI.getArray()[rowNumber - 1][colNumber - 1] = number;
					Sudoku sud = new Sudoku(sudokuI.getArray());
					if (isSolved(sudokuI.getArray()) == true && Boolean.TRUE.equals(SudokuCheck.check(sud))) {
						System.out.println("Finished! Congradulations!");
						s.close();
						System.exit(0);
					}
					System.out.println(sudokuI.toString());
				} else {
					System.out.println("This cell is occupaid");
				}
			}
		}
	}

	/**
	 * The following method is to check whether sudoku is solved. It's not
	 * solved if there is at least one element that equals to 0
	 * 
	 * @param array is for array to check whether it's solved
	 * @return result of type boolean
	 */

	public static boolean isSolved(int[][] array) throws IllegalArgumentException, IOException {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (array[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * The following method is used to check if the input matches the pattern ignoring the exit and reset
	 * @param cell
	 * @return
	 */
	static boolean isCommandValid(String cell) {
	    return (cell.equalsIgnoreCase("exit") || cell.equalsIgnoreCase("reset") || cell.matches("[a-i]{1}\\d{1}:\\d{1}"));
	}
	/**
	 * the following method converts the cell of the type String to number that
	 * represents row of the array
	 * 
	 * @param s - cell that user input
	 * @return result of the type integer throws IllegalArgumentException in
	 *         case the cell is not valid
	 */
	public static int convertRow(String s) {
		// The following is to convert from cell to element of array
		char[] rowLetters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' };
		int[] correspNum = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int rowNumber = 0;

		if (s.length() != 2) {
			throw new IllegalArgumentException("Invalid cell");
		} else {
			char ch = s.charAt(0);
			/**
			 * take 0 element (which is letter) and assign to var ch search for
			 * the position of the ch in array
			 */
			int position = Arrays.binarySearch(rowLetters, ch);
			return rowNumber = correspNum[position];

		}
	}

	/**
	 * the following method overrides toString method from super class according
	 * to the pattern provided
	 */
	@Override
	public String toString() {
		String arrayToPrint = new String();
		String[] rowLetters = { "a", "b", "c", "d", "e", "f", "g", "h", "i" };
		arrayToPrint = "     1   2   3    4   5   6    7   8   9   " + "\n";
		for (int row = 0; row < SIZE; row++) {
			if (row == 0 || row % 3 == 0) {
				arrayToPrint = arrayToPrint + "  ++===+===+===++===+===+===++===+===+===++" + "\n";
			} else {
				arrayToPrint = arrayToPrint + "  ++---+---+---++---+---+---++---+---+---++" + "\n";
			}
			for (int column = 0; column < SIZE; column++) {
				if (getCell(row, column) != null) {
					if (column == 0) {
						arrayToPrint = arrayToPrint + rowLetters[row] + " ||" + getCell(row, column);

					} else if (column % 3 == 0) {
						arrayToPrint = arrayToPrint + "||" + getCell(row, column);
						;
					} else {
						arrayToPrint = arrayToPrint + "|" + getCell(row, column);
					}
				} else {

					if (column == 0) {

						arrayToPrint = arrayToPrint + "||  ";
					} else if (column % 3 == 0) {
						arrayToPrint = arrayToPrint + " ||  ";
					} else {
						arrayToPrint = arrayToPrint + " |  ";
					}
				}
			}
			arrayToPrint = arrayToPrint + "||\n";
		}
		arrayToPrint = arrayToPrint + "  ++===+===+===++===+===+===++===+===+===++";
		return arrayToPrint;
	}

	/**
	 * The following method is used to get cell from the array and then it will
	 * be used in toString method
	 */
	String getCell(int i, int j) {

		if (initial[i][j] == true) {

			if (getArray()[i][j] == 0) {
				return "   ";
			} else {
				return "*" + String.valueOf(getArray()[i][j]) + "*";
			}
		} else {
			return super.getCell(i, j);
		}
	}

	public static void main(String[] args) {
		try {
			play("/Users/valeria/Downloads/WS5-examples/sudoku-ex2.txt");
		} catch (IOException e) {
			System.out.println("The input is not correct");
		}
	}
}
