

/**
 * In the following we create superclass Car that realizes getters and setters
 * for maxSpeed and maxPassengers and, also, method toString
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version Date 06/11/2016
 *
 */
public class Vehicle {

	/**
	 * Class Vehicle is the superclass
	 */
	private double maxSpeed;
	private int maxPassengers;

	/**
	 * Constructor for the class Vehicle
	 * 
	 * @param maxSpeed stands for max speed of the Car
	 * @param maxPassengers stands for passenger capacity of the Car
	 */
	public Vehicle(double maxSpeed, int maxPassengers) {
		this.maxSpeed = maxSpeed;
		this.maxPassengers = maxPassengers;
	}

	/**
	 * Getter for maxSpeed
	 * 
	 * @return maxSpeed of the type double
	 */
	public double getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * Setter for maxSpeed
	 * 
	 * @param maxSpeed sets new value for the variable
	 */
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/**
	 * Getter for maxPassenger
	 * 
	 * @return maxPassengers of the type int represents the number of passengers
	 */
	public int getMaxPassengers() {
		return maxPassengers;
	}

	/**
	 * Setter for maxPassengers
	 * 
	 * @param maxPassengers sets new value for the variable
	 */
	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}

	/**
	 * toString method defines how to print out the result
	 */
	public String toString() {
		String passengers;
		if (maxPassengers == 1) {
			passengers = "passenger";
		} else {
			passengers = "passengers";
		}
		return "The vehicle has a maximal speed of " + maxSpeed + " km/h. It carries " + maxPassengers + " "
				+ passengers + ".";
	}

}
