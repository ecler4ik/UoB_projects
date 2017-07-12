 package Ex5;

/**
 * In following we have to write a method correctMatrix that takes a
 * two-dimensional array (with parity bits) that may contain up to one incorrect
 * bit and returns a corrected two- dimensional array (with parity bits) that
 * does not contain any incorrect bits.
 * 
 * Secondly, we have to write a method findRow that finds a row which is not
 * formed according to the rules and method findColumn that finds a column which
 * is not formed according to the rules (each returning -1 if everything is
 * formed according to the rules).
 * 
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version 30/10/2016
 *
 */
public class ParityCorrection {

	/**
	 * The following method uses the methods findRow and findColumn to find the
	 * element to fix with "if" statement, 
	 * the incorrect value of element changes to the opposite
	 * 
	 * @param a is for two-dimensional array that have to be corrected
	 * @return result as type of int 
	 */
	public static int[][] correctMatrix(int[][] a) {

		int incorrectRow = findRow(a);
		int incorrectColumn = findColumn(a);

		if (incorrectRow != -1 || incorrectColumn != -1) {
			if (a[incorrectRow][incorrectColumn] == 0) {
				a[incorrectRow][incorrectColumn] = 1;
			} else {
				a[incorrectRow][incorrectColumn] = 0;
			}
		}
		return a;
	}

	/**
	 * The following method finds the incorrect row in the two-dimensional array. 
	 * 1.Sum all elements except last one in the row. 
	 * 2.Compare the value of the last element with the remainder of division sumOnRow by 2 
	 * 3.If they don't match, it returns number of the row, if it's ok then returns -1
	 *
	 * @param a is for array to be checked in order to find incorrect row
	 * @return result of type int
	 */
	public static int findRow(int[][] a) {
		int sumOnRows = 0;

		for (int i = 0; i < a.length - 1; i++) {
			sumOnRows = 0;
			for (int j = 0; j < a[0].length - 1; j++) {

				sumOnRows = sumOnRows + a[i][j];

				if (j == a[0].length - 2) {
					if (a[i][a[0].length - 1] == 0 && sumOnRows % 2 != 0
							|| a[i][a[0].length - 1] == 1 && sumOnRows % 2 != 1) {
						return i;
					}
				}
			}
		}

		return -1;
	}

	/**
	 * The following method finds the incorrect column in the two-dimensional array. 
	 * 1.Sum all elements except last one in the column 
	 * 2.Compare the value of the last element with the remainder of division sumOnColumn by 2
	 * 3.If the they don't match, it returns number of the column, if it's ok then returns -1
	 * 
	 * @param a is for array to be checked in order to find incorrect row
	 * @return result of type int 
	 */
	public static int findColumn(int[][] a) {
		int sumOnColumns = 0;
		for (int j = 0; j < a[0].length - 1; j++) {
			sumOnColumns = 0;
			for (int i = 0; i < a.length - 1; i++) {

				sumOnColumns = sumOnColumns + a[i][j];

				if (i == a.length - 2) {

					if (a[a.length - 1][j] == 0 && sumOnColumns % 2 != 0
							|| a[a.length - 1][j] == 1 && sumOnColumns % 2 != 1) {
						return j;
					}
				}
			}
		}
		return -1;
	}
}

