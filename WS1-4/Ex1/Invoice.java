
/**
 * In the following we create class Invoice and implement interface Measurable
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version Date 06/11/2016
 *
 */
public class Invoice implements Measurable {
	/**
	 * Class Invoice is the simple class that implements interface Measurable
	 */
	private String accountNumber;
	private String sortCode;
	private double amount;

	/**
	 * Constructor for the class Invoice with parameters accountNumber,
	 * sortCode, amount
	 * 
	 * @param accountNumber - account number of the account owner
	 * @param sortCode identifies both the bank and the branch where the account is held
	 * @param amount - amount of money that owner has
	 *
	 */
	public Invoice(String accountNumber, String sortCode, double amount) {
		this.accountNumber = accountNumber;
		this.sortCode = sortCode;
		this.amount = amount;
	}

	/**
	 * method getMeasure that was implemented through interface Measurable
	 * 
	 * @return result as the type double
	 */
	public double getMeasure() {
		return amount;
	}
}
