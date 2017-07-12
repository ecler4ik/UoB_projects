package Ex3;
/**
 * 
 *In the following we have to write method that returns array of integers without particular digit
 *@author Valeriya Yashina, ID 1603690
 *@version 29.10.2016
 *
 */
import java.util.ArrayList;

public class Omit {
		/**
		 * 
		 * @param from - the first number in arrayList
		 * @param to - the last number in arrayList
		 * @param omittedDigit - the digit that we have to omit from arrayList
		 * @return result as type of ArrayList<Integer> 
		 */
	public static ArrayList<Integer> allIntegersWithout(int from, int to, int omittedDigit) {

		/**
		 * 1.calculate the length of array and initialise the ArrayList
		 * 2.convert omittedDigit to type String
		 * 3.use loop "for" to check each element of ArrayList: if it contains omittedDigit
		 * 4.while executing the loop each element of ArrayList is converting to type String in order to be checked
		 * 5.use the if statement to sort elements without omittedDigit
		 * 6.return the ArrayList without omittedDigit
		 */
		int length = to-from;
		ArrayList<Integer> allIntegers = new ArrayList<Integer>(length); 
		
		String str = Integer.toString(omittedDigit);
		for (int i=from; i <= to; i++)
		{ 
			String ii = Integer.toString(i);
			if (!ii.contains(str)){
				allIntegers.add(i); //if element doesn't contain omittedDigit, then add it to ArrayList
			}
		}
		return allIntegers;
	}
}




