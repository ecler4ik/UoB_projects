import java.util.Arrays;

/**
 * The following class contains method solve that allow to solve sudoku easily.
 * The technique is used is based on the assumption that every number may occur
 * only once in a row, column or square. If there is only one possibility then we
 * put this value to this cell. Secondly, for particular number check whether there
 * is only one place to go, if yes, then the solver enters the value to this cell
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version Date 30/11/2016
 *
 */
public class SudokuSolve extends Sudoku {
	/**
	 * Class SudokuSolve is the sub class of the class Sudoku 
	 * Constructor of the class SudokuSolve
	 * 
	 * @param array
	 */
	public SudokuSolve(int[][] array) {
		super(array);
	}

	/**
	 * The following method allows to solve sudoku easily
	 */
	public void solve() {
		/**
		 * we start from the beginning by checking each square. 
		 * var sSolve is used to check how many squares are solves 
		 * var stop is used to check whether we carry on solving sudoku. 
		 * If it's true, we can't solve the sudoku because there some 
		 * other techniques should be used
		 * 
		 */

		while (true) {
			int sSolve = 0;
			boolean stop = false;

			/**
			 * use for loop to check each square, we start from 1 because it's easier
			 */
			for (int s = 1; s <= 9; s++) {
				/**
				 * int [] cell position contains the row and value of the cell.
				 * we use findCell to put value to it
				 */
				int[] cellPosition = findCell(s, (int) 1);
				int row = cellPosition[1];
				int col = cellPosition[0];

				/**
				 * the following array let us check if the solver has found
				 * possible solution for the cell and what square contains this
				 * sell. False - this square doesn't contain solution,
				 */
				boolean[] possibleSolution = new boolean[] { true, true, true, true, true, true, true, true, true };

				/**
				 * the following for loop fulfils the array boolean. 
				 * If the square contains possible cell to fulfil, then true
				 */
				for (int i = 1; i <= 9; i++) {
					int[] cell = findCell(s, i);

					if (getArray()[cell[1]][cell[0]] != 0) {
						possibleSolution[i - 1] = false;
					}
				}

				/**
				 * 1.the following for loop is used to check the second
				 * assumption whether the particular number contains in the
				 * square. It checks numbers from 1 to 9 one after another 
				 * 
				 * 2. "If" statement is used to check if the square contains already the
				 * particular number. If "no", the solver tries to solve it
				 */
				for (int checkingNumber = 1; checkingNumber <= 9; checkingNumber++) {
					if (checkIfThereIsNumberInSquare(s, checkingNumber) == false) {
						boolean[] possibleSolution2 = Arrays.copyOf(possibleSolution, possibleSolution.length);
						/**
						 * the following "if" checks whether there is this
						 * particular number in a row or in the column depending
						 * on in what square we are now. 
						 * 
						 * it compares with the value of the array of the type boolean the same for the rest
						 * 
						 * e.g. square 1  | * | * | * ---> 
						 * 				  | * | * | * ---> 
						 * 				  v * v * v * --->
						 */

						if (checkIfThereIsNumberInRow(row, checkingNumber) == true)// 1 row
																					
						{
							possibleSolution2[0] = false;
							possibleSolution2[1] = false;
							possibleSolution2[2] = false;
						}

						if (checkIfThereIsNumberInRow((int) (row + 1), checkingNumber) == true)// 2row
																								
						{
							possibleSolution2[3] = false;
							possibleSolution2[4] = false;
							possibleSolution2[5] = false;
						}

						if (checkIfThereIsNumberInRow((int) (row + 2), checkingNumber) == true)// 3 row
																								
						{
							possibleSolution2[6] = false;
							possibleSolution2[7] = false;
							possibleSolution2[8] = false;
						}

						if (checkIfThereIsNumberInColumn(col, checkingNumber) == true)// 1 column
																						
						{
							possibleSolution2[0] = false;
							possibleSolution2[3] = false;
							possibleSolution2[6] = false;
						}

						if (checkIfThereIsNumberInColumn((int) (col + 1), checkingNumber) == true)// 2 column
																									
						{
							possibleSolution2[1] = false;
							possibleSolution2[4] = false;
							possibleSolution2[7] = false;
						}

						if (checkIfThereIsNumberInColumn((int) (col + 2), checkingNumber) == true)// 3 column
																									
						{
							possibleSolution2[2] = false;
							possibleSolution2[5] = false;
							possibleSolution2[8] = false;
						}

						/**
						 * the following for loop is to check whether we found place for that particular number. 
						 * If yes, the value will be passed to array and be assigned to related cell. 
						 * To assign value to the particular cell the if statement is used
						 */

						int counter = 0;
						int k = 0;
						for (int j = 0; j <= 8; j++) {
							if (possibleSolution2[j] == true) {
								counter++;
								k = j;
							}
						}

						if (counter == 1) {
							int[] cell2 = findCell(s, (int) (k + 1));
							getArray()[cell2[1]][cell2[0]] = checkingNumber;
							stop = true;
							sSolve++;
						}
					}
				}
			}

			/**
			 * in case during the for loop iteration the solver doesn't solve
			 * any cell, that means it can't solve it. We break the for loop, otherwise it would be infinite
			 */
			if (stop == false) {
				break;
			}
		}
	}

	/**
	 * the following method allows to find the possible square where the solver
	 * can fulfil the cell array squareRange. It shows what square it is (from row
	 * to row, from column to column)
	 * 
	 * @param squareNumber  - number of the square from 1 to 9 from left to the right,
	 *  		from the top to the bottom
	 * @param i - number of the square
	 * @return result of the type int [][] array
	 */
	private int[] findCell(int squareNumber, int i) {
		int[] rangeForSquare = null;
		/**
		 * with the range the solver finds the possible square,9 cases because 9 squares. 
		 * Then using var 'i'. It looks for the position of the cell, 9 cases because 9 elements 
		 * there are in the square
		 */
		switch (squareNumber) {
		case 1:
			rangeForSquare = new int[] { 0, 0 };
			break;
		case 2:
			rangeForSquare = new int[] { 3, 0 };
			break;
		case 3:
			rangeForSquare = new int[] { 6, 0 };
			break;
		case 4:
			rangeForSquare = new int[] { 0, 3 };
			break;
		case 5:
			rangeForSquare = new int[] { 3, 3 };
			break;
		case 6:
			rangeForSquare = new int[] { 6, 3 };
			break;
		case 7:
			rangeForSquare = new int[] { 0, 6 };
			break;
		case 8:
			rangeForSquare = new int[] { 3, 6 };
			break;
		case 9:
			rangeForSquare = new int[] { 6, 6 };
			break;
		}

		int[] positionOfCell = null;
		/**
		 * we check square from the left to the right from the top to the bottom
		 */
		switch (i) {
		case 1:
			positionOfCell = new int[] { rangeForSquare[0], rangeForSquare[1] };
			break;
		case 2:
			positionOfCell = new int[] { (int) (rangeForSquare[0] + 1), rangeForSquare[1] };
			break;
		case 3:
			positionOfCell = new int[] { (int) (rangeForSquare[0] + 2), rangeForSquare[1] };
			break;
		case 4:
			positionOfCell = new int[] { rangeForSquare[0], (int) (rangeForSquare[1] + 1) };
			break;
		case 5:
			positionOfCell = new int[] { (int) (rangeForSquare[0] + 1), (int) (rangeForSquare[1] + 1) };
			break;
		case 6:
			positionOfCell = new int[] { (int) (rangeForSquare[0] + 2), (int) (rangeForSquare[1] + 1) };
			break;
		case 7:
			positionOfCell = new int[] { rangeForSquare[0], (int) (rangeForSquare[1] + 2) };
			break;
		case 8:
			positionOfCell = new int[] { (int) (rangeForSquare[0] + 1), (int) (rangeForSquare[1] + 2) };
			break;
		case 9:
			positionOfCell = new int[] { (int) (rangeForSquare[0] + 2), (int) (rangeForSquare[1] + 2) };
			break;
		}

		return positionOfCell;
	}

	/**
	 * The following method checks whether there is particular number in the
	 * particular square
	 * 
	 * @param s- number of the square
	 * @param checkingNumber - particular number to be checked
	 * @return result of the type boolean
	 */
	private boolean checkIfThereIsNumberInSquare(int s, int checkingNumber) {
		for (int i = 1; i <= 9; i++) {
			int[] cellPosition = findCell(s, i);

			if (getArray()[cellPosition[1]][cellPosition[0]] == checkingNumber) {
				return true;
			}
		}

		return false;
	}

	/**
	 * The following method checks whether there is particular number in the
	 * particular row
	 * 
	 * @param row - number of the row
	 * @param checkingNumber - particular number to be checked
	 * @return result of the type boolean
	 */
	private boolean checkIfThereIsNumberInRow(int row, int checkingNumber) {
		for (int col = 0; col <= 8; col++) {
			if (getArray()[row][col] == checkingNumber) {
				return true;
			}
		}

		return false;
	}

	/**
	 * The following method checks whether there is particular number in the
	 * particular column
	 * 
	 * @param col number of the column
	 * @param checkingNumber- particular number to be checked
	 * @return result of the type boolean
	 */
	private boolean checkIfThereIsNumberInColumn(int col, int checkingNumber) {
		for (int row = 0; row <= 8; row++) {
			if (getArray()[row][col] == checkingNumber) {
				return true;
			}
		}
		return false;
	}
}