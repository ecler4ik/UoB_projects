package Ex2;

/**
 * In the following we have to create the class StarRating with method interpret,
 * that aims to translate the cartoon below into a program
 * 
 *@author Valeriya Yashina, ID 1603690
 *@version 26.10.2016
 */

/**
 * In the following class there is the interpretation of rating according to
 * obtained average grade
 */

public class StarRating {

	/**
	 * Simple class StarRating contains method that interprets rating to Strings
	 * according to obtained grade
	 */

	/**
	 * The following method interprets the averaged rating. E.g. if the rating
	 * is between 0 and 4(excl), then the method returns "CRAP" and etc.
	 * 
	 * @param rating - average rating over several individual ratings
	 * @return result as type String
	 */
	public static String interpret(double rating) {

		if (0 <= rating && rating < 4.0) {
			return "CRAP"; // for rating between 0(incl) and 4(excl)
		} else if (4.0 <= rating && rating < 4.5) {
			return "OK"; // for rating between 4(incl) and 4.5(excl)
		} else if (4.5 <= rating && rating < 5) {
			return "EXCELLENT"; // for rating between 4.5(incl) and 5(excl)
		} else if (rating >= 5) {
			return "[HAS ONLY ONE REVIEW]"; // for rating equals to 5 or more
		} else {
			return "not rated"; // for the rest of rating
		}
	}
}

