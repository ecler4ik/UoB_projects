import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;
/**
 * @author Valeriya Yashina, ID 1603690.
 * This class contains the test cases for Worksheet2 solutions
 * 
 */

public class Worksheet2Test {
	
		Tree emptyTree = new Tree();
		Tree treeOneNode = new Tree(7, new Tree(), new Tree());
		Tree bsTree = new Tree (20, new Tree(10, new Tree(5, new Tree (2), new Tree (8)), new Tree(17, new Tree(14), new Tree(19))), new Tree(32, new Tree(24, new Tree(), new Tree(28)), new Tree(44, new Tree(37, new Tree(34), new Tree()), new Tree())));
		Tree avlTree = new Tree (20, new Tree(10, new Tree(5, new Tree (2), new Tree (8)), new Tree(17, new Tree(14), new Tree(19))), new Tree(32, new Tree(24, new Tree(), new Tree(28)), new Tree(44, new Tree(37, new Tree(34), new Tree()), new Tree(50))));
		Tree leftBSSubTree = new Tree (8, new Tree(5, new Tree(2, new Tree(1), new Tree(3)), new Tree(7, new Tree(6), new Tree())), new Tree());
		Tree rightBSSubTree = new Tree (3, new Tree(), new Tree(11, new Tree(6, new Tree(4), new Tree(8)), new Tree(16, new Tree(15), new Tree())));
	
		@Rule
	    public ExpectedException exception = ExpectedException.none();
		
		@Test
		/**
		 * to check method 'negateAll' when all elements are positive
		 */
		public void TestEx1_1 (){
			Tree t =new Tree(7, new Tree( 5, new Tree(5), new Tree(2)), new Tree (8, new Tree(2), new Tree (6))); 
			Tree expectedTree = new Tree(-7, new Tree(-5, new Tree(-5), new Tree(-2)), new Tree (-8, new Tree(-2), new Tree (-6)));
			
			Tree actualTree = Worksheet2.negateAll(t);
			assertEquals(expectedTree, actualTree);
		}
		
		@Test
		/**
		 * to check method 'negateAll' when there is only one node
		 */
		public void TestEx1_2 (){
			Tree expected = new Tree(-7, new Tree(), new Tree());
			assertEquals(expected, Worksheet2.negateAll(treeOneNode));
		}
		
		@Test
		/**
		 * to check method 'negateAll' when all elements are negative
		 */
		public void TestEx1_3 (){
			Tree t = new Tree(-6, new Tree( -3, new Tree(-7), new Tree(-8)), new Tree (-65, new Tree(-32), new Tree (-1)));
			Tree expected = new Tree(6, new Tree( 3, new Tree(7), new Tree(8)), new Tree (65, new Tree(32), new Tree (1)));
			assertEquals(expected, Worksheet2.negateAll(t));
		}
		
		@Test
		/**
		 * to check method 'negateAll' when all values in the nodes are of different sign
		 */ 
		public void TestEx1_4 (){
			Tree е = new Tree(-6, new Tree( 0, new Tree(7), new Tree(0)), new Tree (5, new Tree(-32), new Tree (-1)));	
			Tree expected = new Tree(6, new Tree( 0, new Tree(-7), new Tree(0)), new Tree (-5, new Tree(32), new Tree (1)));
			assertEquals(expected, Worksheet2.negateAll(е));
		}
		
		@Test
		/**
		 * to check method 'negateAll' when there is only left subtree
		 */
		public void TestEx1_5 (){
			Tree expected= new Tree (-8, new Tree(-5, new Tree(-2, new Tree(-1), new Tree(-3)), new Tree(-7, new Tree(-6), new Tree())), new Tree());
			assertEquals(expected, Worksheet2.negateAll(leftBSSubTree));
		}
		
		@Test
		/**
		 * to check method 'negateAll' when there is only right subtree
		 */
		public void TestEx1_6 (){
			Tree expected = new Tree (-3, new Tree(), new Tree(-11, new Tree(-6, new Tree(-4), new Tree(-8)), new Tree(-16, new Tree(-15), new Tree())));
			assertEquals(expected, Worksheet2.negateAll(rightBSSubTree));
		}
		
		@Test
		/**
		 * to check method 'negateAll' when the Tree is empty
		 */
		public void TestEx1_7 (){
			Tree expected = new Tree();
			assertEquals(expected,Worksheet2.negateAll(emptyTree));
		}
		
		@Test 
		/**
		 * to check that method 'mirror' returns empty tree
		 */
		public void TestEx2_1(){
			Tree expectedTree = new Tree();
			Tree actualTree = Worksheet2.mirror(emptyTree);
			assertEquals (expectedTree, actualTree);
		}
		
		@Test 
		/**
		 * to check that method 'mirror' returns tree with only one node
		 */
		public void TestEx2_2(){
			Tree expectedTree = new Tree(7, new Tree(), new Tree());
			Tree actualTree = Worksheet2.mirror(treeOneNode);
			assertEquals (expectedTree, actualTree);
		}
		
		@Test 
		/**
		 * to check that method mirrors the left subtree correctly
		 */
		public void TestEx2_3(){
			Tree expectedTree = new Tree(8, new Tree(), new Tree(5, new Tree(7, new Tree(), new Tree(6)), new Tree(2, new Tree(3), new Tree(1))));
			Tree actualTree = Worksheet2.mirror(leftBSSubTree);
			assertEquals (expectedTree, actualTree);
		}
		
		@Test 
		/**
		 * to check that method mirrors the right subtree correctly
		 */
		public void TestEx2_4(){
			Tree expectedTree = new Tree(3, new Tree(11, new Tree(16, new Tree(), new Tree(15)), new Tree(6, new Tree(8), new Tree(4))),new Tree());
			Tree actualTree = Worksheet2.mirror(rightBSSubTree);
			assertEquals (expectedTree, actualTree);
		}
		
		@Test 
		/**
		 * to check that method mirrors the full binary search tree correctly
		 */
		public void TestEx2_5(){
			Tree expectedTree = new Tree(20, new Tree(32, new Tree(44, new Tree(), new Tree(37, new Tree(), new Tree(34))), new Tree(24, new Tree(28), new Tree())), new Tree(10, new Tree(17, new Tree(19), new Tree(14)), new Tree(5, new Tree(8), new Tree(2))));
			Tree actualTree = Worksheet2.mirror(bsTree);
			assertEquals (expectedTree, actualTree);
		}
		
		@Test
		/**
		 * to check the method 'postorder' on the full tree
		 */
		public void TestEx3_1(){
			Tree tree = new Tree(7, new Tree( 5, new Tree(5), new Tree(2)), new Tree (8, new Tree(2), new Tree (6)));
			List expList = new List (5, List.cons(2, List.cons(5, List.cons(2, List.cons(6, List.cons(8, List.cons(7,List.empty())))))));
			assertEquals(expList,Worksheet2.postorder(tree));
		}
		
		@Test
		/**
		 * to check the method 'postorder' on the empty tree
		 */
		public void TestEx3_2(){
			Tree tree = new Tree();
			List expList = new List();
			assertEquals(expList,Worksheet2.postorder(tree));
		}
		
		@Test
		/**
		 * to check the method 'postorder' on the left sub tree
		 */
		public void TestEx3_3(){
			List expList = new List (1, List.cons(3, List.cons(2, List.cons(6, List.cons(7, List.cons(5, List.cons(8,List.empty())))))));
			assertEquals(expList,Worksheet2.postorder(leftBSSubTree));
		}
		
		@Test
		/**
		 * to check the method 'postorder' on the right sub tree
		 */
		public void TestEx3_4(){
			List expList = new List (4, List.cons(8, List.cons(6, List.cons(15, List.cons(16, List.cons(11, List.cons(3,List.empty())))))));
			assertEquals(expList,Worksheet2.postorder(rightBSSubTree));
		}
		
		@Test 
		/**
		 * to check if the method 'allPositive' returns true if the initial tree is empty 
		 */
		public void TestEx4_1(){
			assertEquals(true, Worksheet2.allPositive(emptyTree));
		}
		
		@Test
		/**
		 * to check if the method 'allPositives' return true in case the tree contains all positives nodes
		 */
		public void TestEx4_2(){
			assertEquals(true, Worksheet2.allPositive(bsTree));
		}
		
		@Test
		/**
		 * to check if the method 'allPositives' return false in case the tree contains all positives nodes
		 */
		public void TestEx4_3(){
			Tree negTree = new Tree(8, new Tree(-8, new Tree(8), new Tree(-2)), new Tree(7, new Tree(-6), new Tree(0)));
			assertEquals(false, Worksheet2.allPositive(negTree));
		}
		
		@Test
		/**
		 * to check if the tree is the binary search tree (in case it's empty)
		 */
		public void TestEx5_1(){
		assertEquals(true, Worksheet2.isSearchTree(emptyTree));
		}
		
		@Test
		/**
		 * to check if the tree is the binary search tree (in case there is one node)
		 */
		public void TestEx5_2(){
		assertEquals(true, Worksheet2.isSearchTree(treeOneNode));
		}
		
		@Test
		/**
		 * to check if the tree is the binary search tree (BS tree is given)
		 */
		public void TestEx5_3(){
		assertEquals(true, Worksheet2.isSearchTree(bsTree));
		}
		
		@Test
		/**
		 * to check if the tree is the binary search tree (BS tree is given)
		 */
		public void TestEx5_4(){
		Tree simpleTree = new Tree (8, new Tree(9, new Tree (2), new Tree(1)), new Tree(1, new Tree (16), new Tree(3)));
		assertEquals(false, Worksheet2.isSearchTree(simpleTree));
		}
		
		@Test
		/**
		 * to check if the tree is the binary search tree (in case there are duplicate elements)
		 */
		public void TestEx5_5(){
		Tree treeWithDuplic =  new Tree (3, new Tree(), new Tree(11, new Tree(6, new Tree(4), new Tree(8)), new Tree(16, new Tree(15), new Tree(16))));
		assertEquals(false, Worksheet2.isSearchTree(treeWithDuplic));
		}
		
		@Test
		/**
		 * to check if method 'max' can find maximum in the BS tree. In case it's empty, there should me error
		 */
		public void TestEx7_1(){
			exception.expect(IllegalStateException.class);
			exception.expectMessage("list is empty");

			int actual = Worksheet2.max(new Tree());	
		}
		
		@Test
		/**
		 * to check if method 'max' can find maximum in the BS tree (left subTree)
		 */
		public void TestEx7_2(){
			assertEquals(8, Worksheet2.max(leftBSSubTree));
		}
		
		@Test
		/**
		 * to check if method 'max' can find maximum in the BS tree.
		 */
		public void TestEx7_3(){
			assertEquals(44, Worksheet2.max(bsTree));
		}
		
		@Test
		/**
		 * to check if the method 'delete' works properly. Case 1: when the node doesn't have neither left sub tree, nor right sub tree
		 */
		public void TestEx8_1(){
			Tree initial = new Tree (7, new Tree(4, new Tree(2), new Tree(5)), new Tree(15, new Tree(8), new Tree(20)));
			Tree expected = new Tree (7, new Tree(4, new Tree(2), new Tree(5)), new Tree(15, new Tree(), new Tree(20)));
			assertEquals(expected, Worksheet2.delete(8,initial));
		}
		
		@Test
		/**
		 * to check if the method 'delete' works properly. Case 2.1: when the node has only right sub tree
		 */
		public void TestEx8_2(){
			Tree initial = new Tree (7, new Tree(4, new Tree(2), new Tree(5)), new Tree(15, new Tree(), new Tree(20)));
			Tree expected = new Tree (7, new Tree(4, new Tree(2), new Tree(5)), new Tree(20, new Tree(), new Tree()));
			assertEquals(expected, Worksheet2.delete(15,initial));
		}
		
		@Test
		/**
		 * to check if the method 'delete' works properly. Case 2.2: when the node has only left sub tree
		 */
		public void TestEx8_3(){
			Tree initial = new Tree (7, new Tree(4, new Tree(2), new Tree(5)), new Tree(15, new Tree(8), new Tree()));
			Tree expected = new Tree (7, new Tree(4, new Tree(2), new Tree(5)), new Tree(8, new Tree(), new Tree()));
			assertEquals(expected, Worksheet2.delete(15,initial));
		}
		
		@Test
		/**
		 * to check if the method 'delete' works properly. 
		 */
		public void TestEx8_4(){
		
			Tree expected = new Tree (20, new Tree(8, new Tree(5, new Tree (2), new Tree ()), new Tree(17, new Tree(14), new Tree(19))), new Tree(32, new Tree(24, new Tree(), new Tree(28)), new Tree(44, new Tree(37, new Tree(34), new Tree()), new Tree())));
			assertEquals(expected, Worksheet2.delete(10,bsTree));
		}
	
		@Test
		public void TestEx8_5() {

			    Tree tree = new Tree (8, new Tree(5, new Tree(2, new Tree(1), new Tree(3)), new Tree(7, new Tree(6), new Tree())), new Tree());
			    Tree treeExpected = new Tree (8, new Tree(3, new Tree(2, new Tree(1), new Tree()), new Tree(7, new Tree(6), new Tree())), new Tree());
			    assertEquals(treeExpected, Worksheet2.delete(5, tree));
		}
		
		@Test
		/**
		 * to check if the BS tree is height balanced
		 */
		public void TestEx9_1(){
			assertEquals(false, Worksheet2.isHeightBalanced(bsTree));
		}
		
		@Test
		/**
		 * to check if the BS tree is height balanced
		 */
		public void TestEx9_2(){
			Tree t = new Tree(7, new Tree(6, new Tree(), new Tree()), new Tree(15, new Tree(10, new Tree(9), new Tree()), new Tree(17)));
			assertEquals(false, Worksheet2.isHeightBalanced(t));
		}
		
		@Test
		/**
		 * to check if the BS tree is height balanced
		 */
		public void TestEx9_3(){
			Tree t = new Tree(10, new Tree(5, new Tree(), new Tree(7, new Tree(), new Tree(9))), new Tree());
			assertEquals(false, Worksheet2.isHeightBalanced(t));
		}
		
		@Test
		/**
		 * to check if the BS tree is height balanced
		 */
		public void TestEx9_4(){
			assertEquals(true, Worksheet2.isHeightBalanced(avlTree));
		}
		
		@Test
		public void TestEx10_1() {
			/**
			 * to check the method 'insert' on the left sub tree
			 */
			Tree leftTree = new Tree(12, new Tree(6), new Tree());
			Tree expected = new Tree(6, new Tree(2), new Tree(12));
			assertEquals(expected, Worksheet2.insertHB(2, leftTree));
		}

		@Test
		public void TestEx10_2(){
			/**
			 * to check if the method 'insert' on the right sub tree
			 */
			  Tree rightTree =new Tree(4, new Tree(), new Tree(13));
			  Tree expected = new Tree(13, new Tree(4), new Tree(17));
			  assertEquals( expected, Worksheet2.insertHB(17, rightTree));
		    }

		 @Test
		public void TestEx10_3() {
			 /**
			  * to check left right rotation ('insert' method)
			  */
			 Tree leftTree = new Tree(12, new Tree(6), new Tree());
			 Tree expected = new Tree(8, new Tree(6), new Tree(12));
			 assertEquals( expected, Worksheet2.insertHB(8, leftTree));
		    }
		 

		    
		  @Test
		    public void TestEx10_4() {
			  /**
			   * to check 'insert' method - left tree empty, right left rotation
			   */
			  Tree rightTree =new Tree(4, new Tree(), new Tree(13));
			  Tree expected = new Tree (7, new Tree(4), new Tree(13));
			  assertEquals( expected, Worksheet2.insertHB(7, rightTree));
		    }
		  
	/**
	 * insertHB - edge case, right rotation with subtree
	 */
	@Test
	public void TestEx10_5() {
		Tree t = new Tree(9, new Tree(4, new Tree(2, new Tree(), new Tree()), new Tree(5, new Tree(), new Tree())),
				new Tree(14));
		Tree expected = new Tree(4, new Tree(2, new Tree(1, new Tree(), new Tree()), new Tree()),
				new Tree(9, new Tree(5), new Tree(14)));
		assertEquals(expected, Worksheet2.insertHB(1, t));
	}

	@Test
	/**
	 * to check insert method
	 */
	public void TestEx10_6() {
		Tree t = new Tree(9, new Tree(4, new Tree(2, new Tree(), new Tree()), new Tree(5, new Tree(), new Tree())),
				new Tree(14));
		Tree expected = new Tree(5, new Tree(4, new Tree(2), new Tree()), new Tree(9, new Tree(6), new Tree(14)));
		assertEquals(expected, Worksheet2.insertHB(6, t));
	}

	@Test
	/**
	 * to check insert method
	 */
	public void TestEx10_7() {
		Tree t = new Tree(9, new Tree(4), new Tree(14, new Tree(12), new Tree(19)));
		Tree expected = new Tree(12, new Tree(9, new Tree(4), new Tree(10)), new Tree(14, new Tree(), new Tree(19)));
		assertEquals(expected, Worksheet2.insertHB(10, t));
	}

	@Test
	public void TestEx10_8() {
		/**
		 * to check insert method
		 */
		Tree t = new Tree(9, new Tree(4, new Tree(2), new Tree(6)), new Tree(14, new Tree(12), new Tree(19)));
		Tree expected = new Tree(9, new Tree(4, new Tree(2), new Tree(6)),
				new Tree(14, new Tree(11, new Tree(10), new Tree(12)), new Tree(19)));
		Tree a = Worksheet2.insertHB(11, t);
		assertEquals(expected, Worksheet2.insertHB(10, a));
	}
   
	@Test
	public void TestEx10_9() {
		/**
		 * to check 'insert' method in case the tree is empty
		 */
		Tree expected = new Tree(15);
		assertEquals(expected, Worksheet2.insertHB(15, emptyTree));
	}
	
	   /**
     * deleteHB1 - edge case, right-left rotation with subtree
     */
    @Test
    public void TestEx10_10() {
    	/**
    	 * to check 'delete' method (left right rotation)
    	 */
    	Tree t = new Tree(9, new Tree(4),new Tree(14,new Tree(12), new Tree(19)));
    	Tree expected = new Tree(12, new Tree(9), new Tree(14, new Tree(),new Tree(19)));
    	assertEquals(expected, Worksheet2.deleteHB(4, t));

    }

    @Test
    public void TestEx10_11() {
    	/**
    	 * to check 'delete' method (in case tree is empty)
    	 */
        Tree expected = new Tree();
        assertEquals(expected,  Worksheet2.deleteHB(1, emptyTree));
    }


  
	@Test
	/**
	 * to check 'delete' method (left-right rotation)
	 */
	public void TestEx10_12() {
		Tree t = new Tree(9, new Tree(4, new Tree(2), new Tree(7, new Tree(5), new Tree(8))),
				new Tree(14, new Tree(11), new Tree()));
		Tree expected = new Tree(7, new Tree(4, new Tree(2), new Tree(5)), new Tree(9, new Tree(8), new Tree(14)));
		assertEquals(expected, Worksheet2.deleteHB(11, t));
	}
    
    
    @Test
    /**
     * to check 'delete' method (right-left rotation )
     */
    public void TestEx10_13() {      
        Tree t = new Tree(9, new Tree(4,new Tree(2), new Tree(7, new Tree(5), new Tree(8))),new Tree(14,new Tree(11), new Tree()));
        Tree expected =  new Tree(9,new Tree(2,new Tree(), new Tree(7, new Tree(5),new Tree(8))), new Tree(14,new Tree(11),new Tree()));       
        assertEquals(expected,Worksheet2.deleteHB(4, t));
    }

    @Test
    /**
     * to check 'delete' method (right rotation )
     */
    public void TestEx10_14(){
        Tree temp =  new Tree(9, new Tree(4, new Tree(2, new Tree(1), new Tree()), new Tree(7)), new Tree(14, new Tree(11),new Tree()));
        Tree expected = new Tree(7, new Tree(2, new Tree(1), new Tree(4)), new Tree(14, new Tree(11),  new Tree()));    
        assertEquals(expected, Worksheet2.deleteHB(9, temp));
    }
    
}