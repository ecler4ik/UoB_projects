package Ex5;

import static org.junit.Assert.*;
import org.junit.Test;
/**
 * @author Alexandros Evangelidis
 * 3 tests to test each the ParityCorrection.findRow,
 * ParityCorrection.findColumn, and ParityCorrection.correctMatrix 
 * methods.
 */


public class Ws3PublicTestsEx5 {

	@Test
	public void test1() {
		
		//correct matrix
		int[][] test1 = {{0,1,1,1,0,1},
                                 {1,0,0,0,1,0},
                                 {1,0,1,0,1,1},
                                 {0,1,0,1,0,0}};
		 
		 //expected incorrect rows and columns
		  int expected_rows = -1;
		  int expected_cols = -1;
		  
		  int actual_rows = ParityCorrection.findRow(test1);
		  int actual_cols = ParityCorrection.findColumn(test1);
		  assertEquals(expected_rows,actual_rows);
		  assertEquals(expected_cols,actual_cols);
		  
		  int [][] expected_corrected_matrix = {{0,1,1,1,0,1},
	                                                {1,0,0,0,1,0},
	                                                {1,0,1,0,1,1},
	                                                {0,1,0,1,0,0}};
		  
		  int [][] actual_corrected_matrix = ParityCorrection.correctMatrix(test1);
		 
		  assertArrayEquals(expected_corrected_matrix, actual_corrected_matrix);
	
	}

	
	@Test
	public void test2() {
		  /* incorrect in row 2, column 3 */
        int[][] test2 = {{0,1,1,1,0,1},
                         {1,0,0,0,1,0},
                         {1,0,1,1,1,1},
                         {0,1,0,1,0,0}};
	
          //expected incorrect rows and columns
		  int expected_rows = 2;
		  int expected_cols = 3;
		  
		  int actual_rows = ParityCorrection.findRow(test2);
		  int actual_cols = ParityCorrection.findColumn(test2);
		  assertEquals(expected_rows,actual_rows);
		  assertEquals(expected_cols,actual_cols);
		  
		  int [][] expected_corrected_matrix = {{0, 1, 1, 1, 0, 1},
		                                        {1, 0, 0, 0, 1, 0},
		                                        {1, 0, 1, 0, 1, 1},
		                                        {0, 1, 0, 1, 0, 0}};
		  
		  int [][] actual_corrected_matrix = ParityCorrection.correctMatrix(test2);
		 
		  assertArrayEquals(expected_corrected_matrix, actual_corrected_matrix);
        
        
	}

	@Test
	public void test3() {
		  /* incorrect in row 1, column 2 */
        int[][] test3 = {{0, 1, 1, 1, 0, 1},
        		 {1 ,0 ,1 ,0 ,1 ,0},
        		 {1 ,0 ,1 ,0 ,1 ,1},
        		 {0 ,1 ,0 ,1 ,0 ,0}};
	
         //expected incorrect rows and columns
		  int expected_rows = 1;
		  int expected_cols = 2;
		  
		  int actual_rows = ParityCorrection.findRow(test3);
		  int actual_cols = ParityCorrection.findColumn(test3);
		  assertEquals(expected_rows,actual_rows);
		  assertEquals(expected_cols,actual_cols);
		  
		  int [][] expected_corrected_matrix = {{0, 1, 1, 1, 0, 1},
		                                        {1, 0, 0, 0, 1, 0},
		                                        {1, 0, 1, 0, 1, 1},
		                                        {0, 1, 0, 1, 0, 0}};
		  
		  int [][] actual_corrected_matrix = ParityCorrection.correctMatrix(test3);
		 
		  assertArrayEquals(expected_corrected_matrix, actual_corrected_matrix);
        
        
	}


	
}