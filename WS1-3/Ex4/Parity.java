package Ex4;

/**
 * In the following we have to write method addParity that takes a two-dimensional array 
 * (consisting of 0s and 1s) of size [rows][columns] and returns an array of size [rows+1]×[columns+1] 
 * with the parity bits added. 
 * 
 * Moreover, we have to write a method checkParity that returns true if in an extended matrix 
 * with parity bits the parity bits follow the rules and false otherwise
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version 28.10.2016
 */

public class Parity {

	/**
	 * The following method is used to return two-dimensional array of the size [rows+1][columns+1]
	 * with the parity bits added
	 * @param a is for two-dimensional array of the type int
	 * @return return result of the type int [][]
	 */
	public static int[][] addParity(int[][] a) {

		int sumOnRows; // variable that is used to calculate sum in each row
		int sumOnColumns = 0; // variable that is used to calculate sum in each column
		/**
		 * 1.create a new two-dimensional array of the [rows+1] [columns+1]
		 * 2.copy the values of the given array to newly created array
		 */
		int arrayNew[][] = new int[a.length + 1][a[0].length + 1];
		copyArray(a, arrayNew);

		/**
		 * This loop is used to calculate sum on each row, then the sum will be divided by 2
		 * if the reminder equals to 0, then new element with the value 0 will be created
		 * otherwise, if the reminder equals 1, then new element with the value 1 will be created 
		 */
		for (int i = 0; i < arrayNew.length; i++) {
			sumOnRows = 0;

			for (int j = 0; j < arrayNew[0].length; j++) {

				sumOnRows = sumOnRows + arrayNew[i][j];

				if (j == arrayNew[0].length - 1) { //this if statement is used to make the loop summing all elements on the row

					if (sumOnRows % 2 == 0) {
						arrayNew[i][j] = 0;
					} else {
						arrayNew[i][j] = 1;
					}
				}
			}
		}

		/**
		 * This loop is used to calculate sum on each column, then the sum will be divided by 2
		 * if the reminder equals to 0, then new element of the value 0 will be created
		 * otherwise, if the reminder equals 1, then new element of the value 1 will be created 
		 */
		for (int j = 0; j < arrayNew[0].length; j++) {
			sumOnColumns = 0;
			for (int i = 0; i < arrayNew.length; i++) {

				sumOnColumns = sumOnColumns + arrayNew[i][j];

				if (i == arrayNew.length - 1) { //this if statement is used to make the loop summing all elements on the column

					if (sumOnColumns % 2 == 0) {
						arrayNew[i][j] = 0;
					} else {
						arrayNew[i][j] = 1;
					}
				}
			}
		}
		return arrayNew;
	}

	/**
	 * This method copies the values of the given array to newly created array
	 * @param from is for given array of the size [rows][columns]
	 * @param to is for new array of the size [rows+1][columns+1]
	 */
	private static void copyArray(int[][] from, int[][] to) {
		for (int i = 0; i < from.length; i++) {
			for (int j = 0; j < from[0].length; j++) {
				to[i][j] = from[i][j];
			}
		}
	}

	/**
	 * This method returns true if in an extended matrix with parity bits 
	 * the parity bits follow the rules and false otherwise
	 * @param a is for array to check
	 * @return the result of the type boolean
	 */
	public static boolean checkParity(int[][] a) {

		int sumOnRows = 0;
		int sumOnColumns = 0;

		/**
		 * 1.calculate the sum in each row until last but one element, divide it by 2
		 * 2.compare the last element in each rows with the remainder from the division the sumOnRows by 2
		 * 3.if the value of last element in the row doesn't match the remainder then return false
		 * 4. otherwise, return true
		 */
		for (int i = 0; i < a.length - 1; i++) {
			sumOnRows = 0;
			for (int j = 0; j < a[0].length - 1; j++) {

				sumOnRows = sumOnRows + a[i][j];

				if (j == a[0].length - 2) {
					if (a[i][a[0].length - 1] == 0 && sumOnRows % 2 != 0
							|| a[i][a[0].length - 1] == 1 && sumOnRows % 2 != 1) {
						return false;
					}
				}
			}
		}

		/**
		 * 1.calculate the sum in each column until last but one element, divide it by 2
		 * 2.compare the last element in each column with the remainder from the division the sumOnColumns by 2
		 * 3.if the value of last element in the column doesn't match the remainder then return false
		 * 4. otherwise, return true
		 */
		for (int j = 0; j < a[0].length - 1; j++) {
			sumOnColumns = 0;
			for (int i = 0; i < a.length - 1; i++) {

				sumOnColumns = sumOnColumns + a[i][j];

				if (i == a.length - 2) {

					if (a[a.length - 1][j] == 0 && sumOnColumns % 2 != 0
							|| a[a.length - 1][j] == 1 && sumOnColumns % 2 != 1) {
						return false;

					}
				}
			}
		}
		return true;
	}
}
