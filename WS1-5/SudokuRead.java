
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * The following method of the Class SudokuRead aims to read in a potentially
 * only partially filled Sudoku from a file. This method should throw exceptions
 * if file is not accessible, if the input is not a number between 1 and 9 or an
 * empty space, of if input is incomplete.
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version Date 22/11/2016
 *
 */
public class SudokuRead {
	/**
	 * The following class is a simple class that reads sudoku from a file. As
	 * the size of sudoku is predefined (9x9) there is final variable SIZE of
	 * the value 9
	 */
	final static int SIZE = 9;
	static int[] temp = new int[SIZE];

	/**
	 * The following method reads sudoku from the file In the following method
	 * the BufferedReader is used to read in from the file.
	 * 
	 * @param fileName parameter that stores pathway to the file
	 * @return result of the type Sudoku
	 * @throws IllegalArgumentException if argument is illegal, that is numbers 
	 * are not between 1 and 9 (incl)
	 * @throws IOException if input is not correct or file doesn't exist
	 *
	 */
	public static Sudoku readSudoku(String fileName) throws IllegalArgumentException, IOException {

		int[][] integerArray = new int[SIZE][SIZE];

		BufferedReader textReader = new BufferedReader(new FileReader(fileName));
		String line;
		int linesCounter = 0;

		line = textReader.readLine();

		while ((line != null && linesCounter < SIZE)) {

			integerArray[linesCounter] = lineToInteger(line);

			line = textReader.readLine();
			linesCounter++;
		}
		textReader.close();
		
		return new Sudoku(integerArray);

	}

	/**
	 * The following additional method is for converting chars to integers. In
	 * case there is space, it converts it to zero
	 * 
	 * @param line parameter that represents one line that was read from the file
	 * @return result of the type [] int
	 */
	public static int[] lineToInteger(String line) {
		int[] temp = new int[SIZE];

		if (line.length() < SIZE) {
			for (int j = line.length(); j < SIZE; j++) {
				temp[j] = 0;
			}

		} else {
			for (int i = 0; i < SIZE; i++) {
				char ch = line.charAt(i);
				if (Character.isWhitespace(ch)) {
					temp[i] = 0;
				} else if (Character.isDigit(ch)) {
					temp[i] = Integer.parseInt(String.valueOf(ch));
				} else {
					throw new IllegalArgumentException("illegal character ");
				}
			}
		}
		return temp;
	}

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		System.out.println(readSudoku("/Users/valeria/Downloads/WS5-examples/sudoku-full.txt"));

	}

}
