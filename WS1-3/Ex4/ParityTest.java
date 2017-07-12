package Ex4;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * These are own tests for Ex4
 * @author Valeriya Yashina, ID 1603690
 *
 */
public class ParityTest {
	/**
	 * Tests 1 - 5 dedicated to check if the methods addParity and checkParity work properly 
	 */
	@Test
	public void test1() {
		  int[][] test1 = {{1,1,1,1},
                           {1,0,0,0},
                           {0,1,0,1}};
		  
		 
		  //expected array after adding parity bits
		  int [][] expected = {{1,1,1,1,0},
                  			   {1,0,0,0,1},
                  			   {0,1,0,1,0},
                  			   {0,0,1,0,1}};
		  
		  int [][] actual = Parity.addParity(test1);
		  assertArrayEquals(expected, actual);
	}

	
	@Test
	public void test2() {
		  int[][] test1 = {{0,0,1,1,0},
                                   {1,1,0,0,1},
                                   {0,0,1,0,1}};
		  
		assertFalse(Parity.checkParity(test1));
	}


	@Test
	public void test3() {
		  int[][] test1 = {{1,1,1,1,0},
                                   {1,1,1,0,1},
                                   {1,0,0,0,0}};
		  
		  assertTrue(Parity.checkParity(Parity.addParity(test1)));
	}


	@Test
	public void test4() {

		  int[][] test4 = {{0,0,1,0,0},
	                           {0,0,0,0,0},
	                           {1,0,1,0,0}};
		  
		  //expected array after adding parity bits
		  int [][] expected = {{0,0,1,0,0,1},
		                       {0,0,0,0,0,0},
		                       {1,0,1,0,0,0},
		                       {1,0,0,0,0,1}};
		  
		
		 int  [][] actual = Parity.addParity(test4);
		 assertArrayEquals(expected, actual);
	}

	
	@Test
	public void test5() {

		  int[][] test4 = {{1,1,1,1,1,0,1,0,1,1},
	                       {1,1,0,0,1,0,0,0,0,0},
	                       {1,1,1,1,0,0,0,0,0,1}};
		  
		 assertTrue( Parity.checkParity(Parity.addParity(test4)));
	
	}
}
