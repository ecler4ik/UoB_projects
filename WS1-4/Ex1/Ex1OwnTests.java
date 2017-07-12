

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class Ex1OwnTests {
/**
 * Own junit tests to check if how the method getMesure works in classes Invoice and Patient.
 * Moreover, check if the methods mean and standardDevition work properly
 * 
 * @author Valeriya Yashina
 */
    public static final double TOLERANCE = 1e-5;

    @Test
    public void invoiceMean1() {
        Invoice invoice = new Invoice("", "", 10);
        ArrayList<Measurable> arrayList = new ArrayList<Measurable>(1);
        arrayList.add(invoice);
        Assert.assertEquals(10, Statistics.mean(arrayList), TOLERANCE);
    }

    @Test
    public void invoiceStandardDeviation1() {
        Invoice invoice = new Invoice("", "", 10);
        ArrayList<Measurable> arrayList = new ArrayList<Measurable>(1);
        arrayList.add(invoice);
        Assert.assertEquals(0, Statistics.standardDeviation(arrayList), TOLERANCE);
    }

    @Test
    public void patientMean1() {
        Patient patient = new Patient("", 12, -10);
        ArrayList<Measurable> arrayList = new ArrayList<Measurable>(1);
        arrayList.add(patient);
        Assert.assertEquals(-10, Statistics.mean(arrayList), TOLERANCE);
    }

    @Test
    public void patientStandardDeviation1() {
        Patient patient = new Patient("", 12, -10);
        ArrayList<Measurable> arrayList = new ArrayList<Measurable>(1);
        arrayList.add(patient);
        Assert.assertEquals(0, Statistics.standardDeviation(arrayList), TOLERANCE);
    }

    @Test
    public void invoiceMeanTest() {
        ArrayList<Measurable> arrayList = new ArrayList<Measurable>(17);
        for (int i = -8; i < 9; i++) {
            arrayList.add(new Invoice("", "", i));
        }
        double meanExpected = 0.0;
        Assert.assertEquals(meanExpected, Statistics.mean(arrayList), TOLERANCE);
    }

    @Test
    public void invoiceStardardDeviationTest() {
        ArrayList<Measurable> arrayList = new ArrayList<Measurable>(17);
        for (int i = -8; i < 9; i++) {
            arrayList.add(new Invoice("", "", i));
        }
        double standardDeviationExpected = 4.89898;
        Assert.assertEquals(standardDeviationExpected, Statistics.standardDeviation(arrayList), TOLERANCE);
    }

    @Test
    public void patientMeanTest() {
        ArrayList<Measurable> arrayList = new ArrayList<Measurable>(10);
        for (int i = 0; i < 10; i++) {
            arrayList.add(new Patient("", 12, i*10));
        }
        double meanExpected = 45.0;
        Assert.assertEquals(meanExpected, Statistics.mean(arrayList), TOLERANCE);
    }

    @Test
    public void patientStandartDeviationTest() {
        ArrayList<Measurable> arrayList = new ArrayList<Measurable>(10);
        for (int i = 0; i < 10; i++) {
            arrayList.add(new Patient("", 12, i*10));
        }
        double standardDeviationExpected = 28.72281;
        Assert.assertEquals(standardDeviationExpected, Statistics.standardDeviation(arrayList), TOLERANCE);
    }
    
  
    @Test
	public void invoiceTest() {
		Invoice invoice = new Invoice("565643", "LF-95", 4500);
		
		assertEquals(4500, invoice.getMeasure(), 1e-8);
	}

	@Test
	public void patientTest() {
		Patient patient = new Patient("Mary Stuart", 65, 60.8);
	
		assertEquals(60.8, patient.getMeasure(), 1e-8);
	}
}
