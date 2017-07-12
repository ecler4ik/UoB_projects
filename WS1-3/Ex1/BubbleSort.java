package Ex1;

/**
 * In the following we create class BubbleSort and implement method bubbleSort
 * using loops
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version Date 26/10/2016
 *
 *          Class BubbleSort is class that sort the array of integers in precise
 *          order
 */
public class BubbleSort {

	/**
	 * variable swapOccurred is used as flag to show that swap occurred between
	 * adjacent elements
	 */
	static boolean swapOccurred = true;

	/**
	 * @param numbers - array of integers to sort
	 * @return the value as array of integers
	 */
	public static int[] bubbleSort(int[] numbers) {
		int swap = 0;
		/**
		 * In the following first "for statement" we count the number of "outside" loops. 
		 * First "inside" loop is when the greatest value is moved
		 * from the left (starting position) to the right(till the end) e.g. 
		 * 1st loop     2nd loop 
		 * 4,3,2,1 		2,3,1,4 
		 * 3,4,2,1 		2,1,3,4 
		 * 3,2,4,1  	the second greatest value 3 reached its position and etc. 
		 * 3,2,1,4 the greatest value 4 reached its position
		 */
		for (int j = 0; j < numbers.length - 1; j++) {
			swapOccurred = false;
			/**
			 * the following loop is used to swap adjacent elements within 1 loop
			 */
			for (int i = 0; i < numbers.length - 1; i++) {

				/**
				 * the following if statement is used to swap adjacent numbers.
				 * New variable swap is created for temporary storage of the value. 
				 * Value of the current number is assigned for temporary variable swap. 
				 * Value of the next (adjacent) number is moved to current number's position. 
				 * The next number is assigned by the value of swap variable
				 */
				if (numbers[i] > numbers[i + 1]) {
					swap = numbers[i]; // temporary storage for current
										// value
					numbers[i] = numbers[i + 1]; // next value moves to the
													// place of current
													// value
					numbers[i + 1] = swap; // swap occurred
					swapOccurred = true;
				}
			}
		}
		return numbers;
	}
}



