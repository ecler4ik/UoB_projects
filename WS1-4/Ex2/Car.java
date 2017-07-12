
/**
 * In the following we create subclass Car that realizes method
 * getFuelComsumption, method setFuelConsumption and method toString that
 * overrides the superclass method toString
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version Date 06/11/2016
 *
 */
public class Car extends Vehicle {

	/**
	 * Class Car is the subclass of the superclass Vehicle
	 */
	private double fuelConsumption;

	/**
	 * Constructor for the subclass Car with parameters maxSpeed, maxPassengers
	 * that are inherited from the superclass Vehicle and one new variable
	 * fuelConsumption
	 * 
	 * @param maxSpeed stands for max speed of the Car
	 * @param maxPassengers stands for passenger capacity of the car
	 * @param fuelConsumption stands for fuel consumption of the Car
	 */
	public Car(double maxSpeed, int maxPassengers, double fuelConsumption) {
		super(maxSpeed, maxPassengers);
		this.fuelConsumption = fuelConsumption;
	}

	/**
	 * 
	 * Getter for the fuelConsumption
	 * 
	 * @return fuelConsumption of the type double
	 */
	public double getFuelConsumption() {
		return fuelConsumption;
	}

	/**
	 * Setter for the fuelConsumption
	 * 
	 * @param fuelConsumption
	 *            is for the new value of fuelConsumption
	 */
	public void setFuelComsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	@Override // this method overrides the superclass method
	/**
	 * toString method defines how to print out the result
	 */
	public String toString() {
		return super.toString() + " Its fuel consumption is " + fuelConsumption + " l/100km.";
	}

}
