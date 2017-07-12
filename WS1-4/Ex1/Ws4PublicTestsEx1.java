
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
/**
 * Public tests for Worksheet 4, Exercise 1. They test the
 * getMeasure() methods for invoices and patients. Furthermore the
 * mean and standard deviation for ArrayList of type Measurable.
 *
 * @author David McDonald
 *
 */
public class Ws4PublicTestsEx1 {

	@Test
	public void ex1PublicTest1() {
		Invoice invoice = new Invoice("14525489", "77-95-62", 1000);
		
		double expected = 1000;
		double actual = invoice.getMeasure();
		double tolerance = 1e-8;
		
		assertEquals(expected, actual, tolerance);
	}

	@Test
	public void ex1PublicTest2() {
		Patient patient = new Patient("John Doe", 35, 85.5);
		
		double expected = 85.5;
		double actual = patient.getMeasure();
		double tolerance = 1e-8;
		
		assertEquals(expected, actual, tolerance);
	}
	
	@Test
	public void ex1PublicTest3() {
		
		ArrayList<Measurable> invoices = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++){
			invoices.add(new Invoice("14525489", "77-95-62", i*1000));
		}
		
		double expected = 5500;
		double actual = Statistics.mean(invoices);
		double tolerance = 1e-8;
		
		assertEquals(expected, actual, tolerance);
	}
	
	@Test
	public void ex1PublicTest4() {
		
		ArrayList<Measurable> patients = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++){
			patients.add(new Patient("John Doe", 35, i*20));
		}
		
		double expected = 57.445626465380286;
		double actual = Statistics.standardDeviation(patients);
		double tolerance = 1e-8;
		
		assertEquals(expected, actual, tolerance);
	}
}
