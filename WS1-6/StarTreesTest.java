import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
* Own JUnit tests to check if the x- and y- of coordinates of points are calculated correctly
* 
* @author Valeriya Yashina, ID 1603690
*/
public class StarTreesTest {

	

	@Test
	public void test() {
		int[] x = { 10, 40, 70, 35, 45, 45, 35 };
		int[] y = { 60, 0, 60, 60, 60, 80, 80 };
		int[] s = {1};
		
		int numberOfVertices = 11;
		
		double [] xExpected ={40.0, 48.1096, 53.6444, 54.8473, 51.3362, 44.226, 35.774, 28.6637, 25.1527, 26.3555, 31.8904};
		double [] xActual = StarTrees.calculateXCoord(40, 15, 0.5712,11);	
		assertArrayEquals(xExpected, xActual,0.001);

		
	}
	
	@Test
	public void test1() {
		int[] x = { 10, 40, 70, 35, 45, 45, 35 };
		int[] y = { 60, 0, 60, 60, 60, 80, 80 };
		int[] s = {1};
		
		int numberOfVertices = 11;

		double [] yExpected = {65.0, 62.6188, 56.2312, 47.8653, 40.1771, 35.6076, 35.6076, 40.1771, 47.8653, 56.2312, 62.6188};
		double [] yActual = StarTrees.calculateYCoord(50, 15, 0.5712, 11);	
		assertArrayEquals(yExpected, yActual, 0.001);
		
	}

	
}
