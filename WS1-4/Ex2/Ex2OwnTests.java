

import org.junit.Test;

import static org.junit.Assert.*;

public class Ex2OwnTests {

	/**
	 * Own junit tests to check if the method toString works properly within the
	 * classes Vehicle and Car
	 * @author Valeriya Yashina
	 */
	@Test
	public void vehicleTest1() {
		Vehicle vehicle = new Vehicle(240.0, 2);

		String expected = "The vehicle has a maximal speed of 240.0 km/h. It carries 2 passengers.";
		String actual = vehicle.toString();

		assertEquals(expected, actual);
	}

	@Test
	public void vehicleTest2() {
		Vehicle vehicle = new Vehicle(5.05, 8);

		String expected = "The vehicle has a maximal speed of 5.05 km/h. It carries 8 passengers.";
		String actual = vehicle.toString();

		assertEquals(expected, actual);
	}

	@Test
	public void carTest3() {
		Car car = new Car(40.0, 2, 4.555);

		String expected = "The vehicle has a maximal speed of 40.0 km/h. It carries 2 passengers."
				+ " Its fuel consumption is 4.555 l/100km.";
		String actual = car.toString();

		assertEquals(expected, actual);
	}

	@Test
	public void carTest4() {
		Vehicle car = new Car(100.0, 50, 0.5);

		String expected = "The vehicle has a maximal speed of 100.0 km/h. It carries 50 passengers."
				+ " Its fuel consumption is 0.5 l/100km.";
		String actual = car.toString();

		assertEquals(expected, actual);
	}

	@Test
	public void carTest5() {
		Vehicle car = new Car(100.0, 1, 0.5);

		String expected = "The vehicle has a maximal speed of 100.0 km/h. It carries 1 passenger."
				+ " Its fuel consumption is 0.5 l/100km.";
		String actual = car.toString();

		assertEquals(expected, actual);
	}

}
