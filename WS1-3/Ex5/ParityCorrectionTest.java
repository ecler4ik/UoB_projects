package Ex5;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * These tests are created to check if the methods "correctMatrix", "findRow", "findColumn" work properly 
 * @author Valeriya Yashina, ID 1603690
 *
 */
public class ParityCorrectionTest {

	@Test
	public void test1() {
		
		/**
		 * this matrix is correct. Test should return result -1.
		 * Used for testing methods "findRow", "findColumn"
		 */
		int[][] test1 = {{1,0,1,0},
						{1,1,1,1},
						{0,0,1,1},
						{0,1,1,0}};
		
		  assertEquals(-1,ParityCorrection.findRow(test1));
		  assertEquals(-1,ParityCorrection.findColumn(test1));
		  
	}

	
	@Test
	public void test2() {
		  /**
		   * In tests 2 and 3 matrixes are incorrect. The wrong element is [1][1] in 2nd test, and [2][1] in the 3d test
		   * We have to compare results of the methods "correctMatrix", "findRow", "findColumn"
		   * with the expected results
		   */
        int[][] test2 = {{1,0,1,0},
        				{0,1,0,0},
        				{1,0,1,0}};
        		
        		  
		  assertEquals(1,ParityCorrection.findRow(test2));
		  assertEquals(1,ParityCorrection.findColumn(test2));
		  
		  int [][] correctedArray = {{1,0,1,0},
  									{0, 0,0,0},
  									{1,0,1,0}};

assertArrayEquals(correctedArray, ParityCorrection.correctMatrix(test2));
          
	}

	@Test
	public void test3() {
		  
        int[][] test3 = {{1,1,1,0,0,1},
        				 {0,0,0,0,1,1},
        				 {1,0,0,0,0,0},
        				 {0,0,1,0,1,0}};
   
		  assertEquals(2,ParityCorrection.findRow(test3));
		  assertEquals(1,ParityCorrection.findColumn(test3));
		  
		  int [][] correctedArray = {{1,1,1,0,0,1},
					 				 {0,0,0,0,1,1},
						 				 {1,1,0,0,0,0},
						 				 {0,0,1,0,1,0}};
		 
		  assertArrayEquals(correctedArray, ParityCorrection.correctMatrix(test3));
        
        
	}

}
