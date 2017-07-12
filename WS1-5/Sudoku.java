import java.util.Arrays;



/**
 * In the following we create class Sudoku. Sudoku represents two-dimensional
 * array where in case it's filled the values are between 0 and 9, if some
 * fields are empty, they should be represented by 0
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version Date 19/11/2016
 *
 */
public class Sudoku {
	/**
	 * Class Sudoku is a simple class that represents sudoku as two-dimensional
	 * array array is the field variable of this Class. As sudoku has fixed size
	 * 9x9, the length of array will be fixed, final variable SIZE is created
	 * for this purpose
	 */
	private int[][] array;
	private static final int SIZE = 9;

	/**
	 * Constructor of the class Sudoku
	 * 
	 * @param array contains the array that is passed to this Class
	 */
	public Sudoku(int[][] array) {
		this.array = array;
	}

	/**
	 * Getter for the array[][]
	 * 
	 * @return result of the type int [][] array
	 */
	public int[][] getArray() {
		return array;
	}
/**
 * Setter for the array [][]
 * @param array represents array
 * @return 
 */
	public void setArray(int [][]array){
		this.array=array;
	}
	/**
	 * This method defines how to print out sudoku. As we were indicated about
	 * the especial format to print out we have to override existing toString
	 * method.
	 * 
	 * 1. First for loop displays lines such as ++===+===+=== and ++---+---+---
	 * according to given pattern 
	 * 2. Second for loop displays the value of fields according whether it's 
	 * empty (represented by 0), or it's the digit
	 */
	@Override
	public String toString() {
		String arrayToPrint = new String();

		for (int row = 0; row < SIZE; row++) {
			if (row == 0 || row % 3 == 0) {
				arrayToPrint = arrayToPrint + "++===+===+===++===+===+===++===+===+===++" + "\n";
			} else {
				arrayToPrint = arrayToPrint + "++---+---+---++---+---+---++---+---+---++" + "\n";
			}
			for (int column = 0; column < SIZE; column++) {
				if (array[row][column] != 0) {
					if (column == 0) {
						arrayToPrint = arrayToPrint + "|| " + Integer.toString(array[row][column]);
					} else if (column % 3 == 0) {
						arrayToPrint = arrayToPrint + " || " + Integer.toString(array[row][column]);
					} else {
						arrayToPrint = arrayToPrint + " | " + Integer.toString(array[row][column]);
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
			arrayToPrint = arrayToPrint + " ||\n";
		}
		arrayToPrint = arrayToPrint + "++===+===+===++===+===+===++===+===+===++";
		return arrayToPrint;
	}

	/**
	 * The following method checks whether all elements are filled in a sudoku
	 * 
	 * @return result of type boolean
	 */
	public boolean isFilled() {
		for (int rows = 0; rows <= array.length - 1; rows++) {
			for (int columns = 0; columns <= array.length - 1; columns++) {
				if (array[rows][columns] == 0)
					return false;
			}
		}
		return true;
	}
/**
 * The following method is created for the 4th Ex in order to get the value of the particular cell
 * @param i row number
 * @param j column number
 * @return the result of the type String
 */
	String getCell(int i, int j) {
        if (array[i][j] == 0) {
            return "   ";
        } else {
            return " " + String.valueOf(array[i][j]) + " ";
        }
    }
	
	/**
	 * We override method equals of the class Object in order to compare two objects
	 * this method will be used later in Junit tests
	 */
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sudoku sudoku = (Sudoku) o;

        return Arrays.deepEquals(getArray(), sudoku.getArray());

    }

    
	//Method main also checks whether toString and isFilled work properly
	public static void main(String[] args) {

		int[][] array = { { 0, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 0, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 0 },

				{ 0, 5, 9, 7, 0, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 0, 4, 8, 5, 6 },

				{ 9, 6, 1, 5, 0, 7, 2, 8, 0 }, { 2, 8, 0, 4, 1, 9, 6, 0, 5 }, { 3, 4, 5, 2, 8, 6, 1, 0, 0 } };

		Sudoku sudoku = new Sudoku(array);

		System.out.println((sudoku.toString()));
		System.out.println(sudoku.isFilled());
	}
}
