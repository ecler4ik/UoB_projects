

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Public tests for Worksheet 4, Exercise 2. Four tests to check the toString()
 * method for the Vehicle and Car classes.
 * @author David McDonald
 *
 */
public class Ws4PublicTestsEx2 {
	
	private Vehicle vehicle;

	@Test
	public void ex2PublicTest1() {
		vehicle = new Vehicle(120.0, 5);
		
		String expected = "The vehicle has a maximal speed of 120.0 km/h. " +
				"It carries 5 passengers.";
		String actual = vehicle.toString();
		
		assertEquals(expected, actual);
	}

	@Test
	public void ex2PublicTest2() {
		vehicle = new Vehicle(65.0, 1);
		
		String expected = "The vehicle has a maximal speed of 65.0 km/h. " +
				"It carries 1 passenger.";
		String actual = vehicle.toString();
		
		assertEquals(expected, actual);
	}

	@Test
	public void ex2PublicTest3() {
		vehicle = new Car(120.0, 5, 6.3);
		
		String expected = "The vehicle has a maximal speed of 120.0 km/h. " +
				"It carries 5 passengers. " +
				"Its fuel consumption is 6.3 l/100km.";
		String actual = vehicle.toString();
		
		assertEquals(expected, actual);
	}

	@Test
	public void ex2PublicTest4() {
		vehicle = new Car(65.0, 1, 7.5);
		
		String expected = "The vehicle has a maximal speed of 65.0 km/h. " +
				"It carries 1 passenger. " +
				"Its fuel consumption is 7.5 l/100km.";
		String actual = vehicle.toString();
		
		assertEquals(expected, actual);
	}
}

