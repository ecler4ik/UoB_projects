
import java.util.*;

/**
 * In the following we create class Statistics that realizes method mean and
 * method standardDeviation
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version Date 06/11/2016
 *
 */

public class Statistics {

	/**
	 * Class Statistics is the simple class with two methods
	 */

	/**
	 * Method mean is used in order to calculate the mean value. 
	 * 
	 * 1. declare and initialise temporary local variable sum that stores sum 
	 * of all elements of ArrayList 
	 * 2. use for loop to calculate the sum of all elements 
	 * 3. divide sum by number of elements in the ArrayList and return this result
	 * 
	 * @param list - ArrayList of type Measurable, represents an ArrayList based
	 * on which we calculate mean value
	 * @return result of type double
	 */
	public static double mean(ArrayList<Measurable> list) {
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum = sum + list.get(i).getMeasure();
		}
		return sum / list.size();
	}

	/**
	 * Method standardDeaviation is used for calculating the Standard Deviation
	 * 
	 * 1.declare and initialise temporary local variable sum that stores sum of
	 * all elements of ArrayList 
	 * 2.use Math.pow to raise into the power of two the result of the subtraction 
	 * between the value of particular element and mean value 
	 * 3.use for loop to calculate the sum of results raised into the power of two 
	 * 4.use Math.sqrt to obtain the square root of the result of
	 * dividing sum by number of elements
	 * 
	 * @param list - ArrayList of type Measurable, represents an ArrayList based
	 * on which we calculate standard deviation
	 * @return result of type double
	 */
	public static double standardDeviation(ArrayList<Measurable> list) {
		double sum = 0;

		for (int i = 0; i < list.size(); i++) {
			sum = sum + Math.pow((list.get(i).getMeasure() - mean(list)), 2);
		}
		return Math.sqrt(sum / list.size());
	}

}
