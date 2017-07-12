

/**
 * In the following we create class Patient and implement interface Measurable
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version Date 06/11/2016
 *
 */
public class Patient implements Measurable {

	/**
	 * Class Patient is the simple class that implements interface Measurable
	 */
	private String name;
	private int age;
	private double weight;

	/**
	 * Constructor for the class Patient with parameters name, age, weight
	 * 
	 * @param name stands for the name of the patient
	 * @param age - age of the Patient
	 * @param weight - weight of the Patient
	 */
	public Patient(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	/**
	 * method getMeasure that was implemented through interface Measurable
	 * 
	 * @return result as the type double
	 */
	public double getMeasure() {
		return weight;

	}
}
