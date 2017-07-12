import java.util.Arrays;
/**
 * The following Class SudokuCheck contains method that aims to check  whether a given Sudoku of size 9x9 satisfies the conditions.
 * It's needed to check whether each row, each column and each square  contains numbers from 1 to 9 only once.
 * @author Valeriya Yashina, ID 1603690
 * @versison Date 23/11/2016
 *
 */
public class SudokuCheck {
/**
 * Class SudokuCheck is simple class that contains method check
 */
	static boolean[][] result = new boolean[3][9];//declare and initialise the variable result

	public static void setResult(boolean[][] r)
	{
		result = r;
	}
	/**
 * The following method checks whether each row, column and square contains numbers from 1 to 9 only once.
 * @param sudoku represents sudoku
 * @return result of the type boolean
 */
	public static boolean[][] check(Sudoku sudoku) {

		
		int[][] sudArray = sudoku.getArray();
		int[] temp = new int[9];
/** 
 * 1. create an array that contains only correct numbers, they are located in increasing order
 * First for loop checks whether each rows contains the numbers from 1 to 9 only once.
 * 2. take each row and store it to temp array.
 * 3. sort the elements of the temp array in the increasing order
 * 4. compare the sorted array temp to the correct one if yes, then true will be passed to related element of the array result.
 * 5. Note result[0] 0 this row to store results of the type boolean after checking each row
 */
		int[] correctNumbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				temp[j] = sudArray[i][j];
			}
			Arrays.sort(temp);
			boolean a = true;
			if (Arrays.equals(correctNumbers, temp) == a) {
				result[0][i] = a;
			}
		}

	/**
	 * Second for loop states to check columns. Algorithm of checking is the same as for rows.
	 * Results of the type boolean are stored in result[1]
	 */
		for (int j = 0; j < temp.length; j++) {
			for (int i = 0; i < temp.length; i++) {
				temp[i] = sudArray[i][j];
			}
			Arrays.sort(temp);
			boolean a = true;
			if (Arrays.equals(correctNumbers, temp) == a) {
				result[1][j] = a;
			}
		}
		
	/**
	 * The tird for loop is to check whether in each square numbers from 1 to 9 occur only once
	 * 
	 * [(i/3)*3+j/3] Explanation below
	 * i/3 gives us ((0,1,2)->0), ((3,4,5)->1), ((6,7,8)->2)
	 * multiplication by 3 let us jump to necessary square from 1 to 3 in row
	 * j/3 let us move in column
	 * 
	 * [i * 3 % 9 + j % 3] Explanation below
	 * i*3%9 gives us ((0,3,6->0), ((1,4,7)->1), ((2,5,8)->2) and i is for moving vertically
	 * j%3 is for moving horizontally
	 */

		for (int i=0; i<9; i++){
			for (int j=0; j<9;j++){
			temp [j]=sudArray[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
			}
			Arrays.sort(temp);
			boolean a = true;
			if (Arrays.equals(correctNumbers, temp) == a) {
				result[2][i] = a;	
			}		
		}
		return result;	
	}

	public static void main(String[] args) {
		int[][] array = {{5,3,4,6,6,8,9,1,2},
	            {6,7,2,1,9,5,3,4,8},
	            {1,9,8,3,4,2,5,6,7},
	            {8,5,9,7,6,1,4,2,3},
	            {4,2,6,8,5,3,7,9,1},
	            {7,1,3,9,2,4,8,5,6},
	            {9,6,1,5,3,7,2,8,4},
	            {2,8,7,4,1,9,6,3,5},
	            {3,4,5,2,8,6,1,7,9}};

		Sudoku sudoku = new Sudoku(array);
		System.out.println(Arrays.deepToString(check(sudoku)));
	}
}
