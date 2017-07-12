/**
 * @author Valeriya Yashina, ID 1603690 
 * This class contains the solution for Worksheet1
 */

public class Worksheet1 {

	/**
	 * Ex1. The following method raises the integer m to the power of the
	 * integer n.
	 * The preconditions are the following: n and m >= 0,so we don't have to test them later
	 * 
	 * @param m - base, an integer that will be raised to the power of n
	 * @param n - power
	 * @return result of the type int
	 */
	public static int power(int m, int n) {
		if  (n == 0) {
			return 1;
		} else {
			return m * power(m, n - 1);
		}
	}

	/**
	 * Ex1. The following method raises the integer m to the power of the
	 * integer n. If the power (n) is even, then (m^(n/2)^2), otherwise if n is
	 * odd - m*m^(n-1)
	 * The preconditions are the following: n and m > 0, so we don't have to test them later
	 * 
	 * @param m - base, an integer that will be raised to the power of n
	 * @param n - power
	 * @return result of the type int
	 */
	public static int fastPower(int m, int n) {
		if  (n == 0) {
			return 1;
		} else if (n % 2 == 0) {
			int x = power(m, n / 2);
			return x * x;
		} else {
			int x = power(m, (n - 1) / 2);
			return m * x * x;
		}
	}

	/**
	 * Ex2. The following method returns a new list with all the elements of a
	 * with sign negated.
	 * 
	 * @param a - initial list
	 * @return result of the type List
	 */
	public static List negateAll(List a) {
		if (a.isEmpty()) {
			return a;
		} else {
			return List.cons(a.getHead() * -1, negateAll(a.getTail()));
		}
	}

	/**
	 * Ex3. The following method returns the position of the first occurrence of
	 * x in a list
	 * 
	 * @param x - required value
	 * @param a - given list
	 * @return result of type int which represents the position of x in the list a
	 */
	public static int find(int x, List a) throws IllegalStateException {

		if ((a.isEmpty())) {
			throw new IllegalStateException("list does not have any elements or element was not found");
		} else if (a.getHead() == x) {
			return 0;
		} else {
			return 1 + find(x, a.getTail());
		}
	}

	/**
	 * Ex4. The following method returns a boolean value indicating whether all
	 * elements of the list are positive or not.
	 * 
	 * @param a - list to be check
	 * @return result of type boolean
	 */
	public static boolean allPositive(List a) {

		if (a.isEmpty()) {
			throw new IllegalStateException ("list is empty");
		} else if (a.getHead() < 0) {
			return false;
		} else if (a.getTail().isEmpty()== false ){
			return allPositive(a.getTail());
		} else { // list is of the size of 1 element which is positive
			return true;
		}
	}

	/**
	 * Ex5. The following method returns a new list which contains all the
	 * positive values of the given list
	 * 
	 * @param a - given list of integers
	 * @return result as a list with only positive values
	 */
	public static List positives(List a) {
		if (a.isEmpty()) {
			return a;
		} else if (a.getHead() >= 0) {
			return List.cons(a.getHead(), positives(a.getTail()));
		} else {
			return positives(a.getTail());
		}
	}

	/**
	 * Ex6. The following method returns a boolean value indicating whether a is
	 * sorted in increasing order.
	 * 
	 * @param a - given list
	 * @return result of the type boolean
	 */
	public static boolean sorted(List a) {
		if (a.isEmpty()) {
			return true;
		} else if (a.getTail().isEmpty()) {
			return true;
		} else {
			return (a.getHead() <= a.getTail().getHead() ? sorted(a.getTail()) : false);
		}
	}

	/**
	 * Ex7. The following method returns new sorted list that contains all the
	 * elements of two initial sorted lists. Any duplicate copies of elements
	 * are retained.
	 * 
	 * @param a - initial SORTED list
	 * @param b - another initial SORTED list
	 * @return result of type List that is new sorted list
	 */
	public static List merge(List a, List b) {
		if (b.isEmpty()) {
			return a;
		} else if (a.isEmpty()) {
			return b;
		} else if (b.getTail().isEmpty()) {
			return (a.getHead() >= b.getHead() ? List.cons(b.getHead(), a)
					: List.cons(a.getHead(), merge(a.getTail(), b)));
		} else {
			return (a.getHead() >= b.getHead() ? List.cons(b.getHead(), merge(a, b.getTail()))
					: List.cons(a.getHead(), merge(a.getTail(), b)));
		}
	}

	/**
	 * Ex8. The following method returns a new sorted list without duplicated
	 * elements
	 * 
	 * @param a - initial SORTED list
	 * @return result of type List that is list without duplicated copies
	 */
	static List removeDuplicates(List a) {
		if (a.isEmpty()) {
			return List.empty();
		} else if (a.getTail().isEmpty()) {
			return a;
		} else {
			return (a.getHead() == a.getTail().getHead()
					? removeDuplicates(List.cons(a.getHead(), a.getTail().getTail()))
					: List.cons(a.getHead(), removeDuplicates(a.getTail())));
		}
	}
}
