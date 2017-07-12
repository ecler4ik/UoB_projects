import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Valeriya Yashina, ID 1603690 This class contains the solution for
 *         Worksheet1
 */

public class Worksheet2 implements Worksheet2Interface {

	/**
	 * Ex1. The following method returns a new tree containing all the elements of
	 * the initial tree with negated sign. All positives become negative, all 
	 * negatives become positives
	 * 
	 * @param t - the initial Tree
	 * @return the result of type Tree, that is new Tree with negated sign
	 */
	public static Tree negateAll(Tree t) {
		if (t.isEmpty()) {
			return new Tree();
		} else if (t.getLeft().isEmpty() && t.getRight().isEmpty()) {
			return new Tree(-1 * t.getValue());
		} else {
			return new Tree(-1 * t.getValue(), negateAll(t.getLeft()), negateAll(t.getRight()));
		}
	}

	/**
	 * Ex2. The following method constructs and returns the mirror image of the initial tree.
	 * 
	 * 
	 * 				 5									   5
	 * 			  /     \							    /     \
	 * 			/         \							  /         \
	 * 		 3				 8						8			  3
	 * 		/ \				/ \					   / \			 / \
	 *    /     \         /     \				 /    \         /   \
	 * 	 3		 4		 2		 1			   1	   2	   4	  3
	 *  / \     / \    /   \   /  \   		  / \     / \    /   \   /  \
	 * 6   9   0   7   1   3   4   5         5   4   3   1  7     0 9    6
	 * 
	 * @param t - the initial tree to be mirrored
	 * @return the result of the type Tree - mirrored tree
	 */
	public static Tree mirror(Tree t) {
		if (t.isEmpty()) {
			return new Tree();
		} else   {
			return new Tree(t.getValue(), mirror(t.getRight()),mirror(t.getLeft()));
		}
	}

	/**
	 * Ex3. The following method returns a list containing the values of 
	 * the initial tree by traversing the nodes in postorder. The order is following:
	 * left sub tree, right sub tree, root
	 * for more information: https://www.tutorialspoint.com/data_structures_algorithms/tree_traversal.html
	 * 
	 *  			 7									   
	 * 			  /     \							    
	 * 			/         \							
	 * 		 3				 6						
	 * 		/ \				/ \					  
	 *    /     \         /     \				
	 * 	 1		 2		 4		 5			  
	 * 
	 * @param t - given tree to be traversed to the List
	 * @return result of the type List, which is traversed tree
	 */
	public static List postorder(Tree t) {
		if (t.isEmpty()){
			return List.empty();
			} else {
				return ListOps.addToEnd(ListOps.append(postorder(t.getLeft()), postorder(t.getRight())), t.getValue());
			}
	}

	
	/**
	 * Ex4. The following method returns a boolean value indicating whether
	 * all nodes are >=0 
	 * 
	 * @param a - the Tree to be checked
	 * @return the result of the type boolean
	 */
	public static boolean allPositive(Tree a) {
		if (a.isEmpty()) {
			return true;
		} else if (a.getValue() < 0) {
			return false;
		} else if (!a.getLeft().isEmpty()) {
			return allPositive(a.getLeft());
		} else if (!a.getRight().isEmpty()) {
			return allPositive(a.getRight());
		}else{
			return true;
		}
	}

	/**
	 * Ex5. The following method returns result of the type boolean indicating
	 * whether the tree is a binary search tree
	 * 
	 * @param a - the given tree to be checked
	 * @return the result of the type boolean, true if the tree is binary search tree
	 */
	public static boolean isSearchTree(Tree a) {
		if (a.isEmpty() ){
			return true;
		} else {
		return sorted(inorder(a));
	}
	}
	
	/**
	 * Additional method for Ex5. The following method collects elements of the Tree into List
	 * @param t - given tree
	 * @return - result of the type List, e.g. given tree in the following order (left, root, right)
	 */
	static List inorder (Tree t){
		if (t.isEmpty()){
			return List.empty();
			} else {
				return ListOps.append(inorder(t.getLeft()), List.cons(t.getValue(),inorder(t.getRight())));
			}
	}
	
	/**
	 * Additional method for Ex5. Checks if List is sorted in ascending order (WITHOUT duplicates)
	 * @param a - given List
	 * @return - result of the type boolean, true - if it's sorted
	 */
	public static boolean sorted(List a) {
		if (a.isEmpty()) {
			return true;
		} else if (a.getTail().isEmpty()) {
			return true;
		} else {
			return (a.getHead() < a.getTail().getHead() ? sorted(a.getTail()) : false);
		}
	}
	
	/**
	 * Ex6. The following method prints the values stored in the tree in descending order.
	 * @param a - given tree
	 */
	public static void printDescending(Tree a) {
		if (a.isEmpty()){
			return ;
		} else {
			printDescending(a.getRight());
			System.out.print(a.getValue());
			printDescending(a.getLeft());
		} 	
	}

	/**
	 * Ex7. The following method finds and returns the maximum value in the given Binary Search tree. 
	 * @param a - given tree
	 * @return result of the type int, that is maximum
	 */
	public static int max(Tree a) {
		if (a.isEmpty()) {
			throw new IllegalStateException("list is empty");
		} else if (a.getRight().isEmpty()) {
			return a.getValue();
		} else {
			return max(a.getRight());
		}
	}
	
	/**
	 * Ex8. The following method returns new Binary Search tree without the element 
	 * that must be deleted.
	 * @param x - given BS tree
	 * @param a - value that should be deleted
	 * @return - result of the type Tree, which is new BS tree
	 */
	public static Tree delete(int x, Tree a) {

		if (a.isEmpty()) {
			return new Tree();
		} else if (x < a.getValue()) {
			return new Tree(a.getValue(), delete(x, a.getLeft()), a.getRight());
		} else if (x > a.getValue()) {
			return new Tree(a.getValue(), a.getLeft(), delete(x, a.getRight()));
		} else {
			/**
			 * Case 1: when the node doesn't have neither left nor right sub trees
			 */
			if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
				return new Tree();
			/**
			 * Case 2.1: when the node has only right sub tree
			 */
			} else if (a.getLeft().isEmpty() && a.getRight().isEmpty() == false) {
				return new Tree(a.getRight().getValue(), a.getRight().getLeft(), a.getRight().getRight());
			/**
			 * Case 2.2: when the node has only left sub tree
			 */
			} else if (a.getLeft().isEmpty() == false && a.getRight().isEmpty()) {
				return new Tree(a.getLeft().getValue(), a.getLeft().getLeft(), a.getLeft().getRight());
			/**
			 * Case 3: when the node has both left and right sub trees
			 */
			} else if (a.getLeft().getLeft().isEmpty()){
				return new Tree(max(a.getLeft()),a.getLeft().getLeft(), a.getRight());
			} else {
				return new Tree(max(a.getLeft()), new Tree(a.getLeft().getValue(), a.getLeft().getLeft(), new Tree()), a.getRight());
			}
		}
	}

	/**
	 * Ex9. The following method checks if the BS tree is height balanced tree
	 * @param a - given BS tree
	 * @return - result of the type boolean: true - of the BS tree is height balanced, otherwise - false
	 */
	public static boolean isHeightBalanced(Tree a) {
		if (a.isEmpty()){
			return true;
		} else if (Math.abs(a.getLeft().getHeight() - a.getRight().getHeight()) <= 1 && isHeightBalanced(a.getLeft()) && isHeightBalanced(a.getRight())){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Ex10. The following method should insert the new value to the AVL tree
	 * maintaining the height-balanced property
	 * 
	 * @param x - the value, that should be inserted to the AVL tree
	 * @param a - given AVL tree
	 * @return - result of type Tree, that is a new AVL tree
	 */
	public static Tree insertHB(int x, Tree a) {
		Tree t;
		if (a.isEmpty()) {
			return new Tree(x);
		} else if (x < a.getValue()) {
			t = new Tree(a.getValue(), insertHB(x, a.getLeft()), a.getRight());
		} else if (x > a.getValue()) {
			t = new Tree(a.getValue(), a.getLeft(), insertHB(x, a.getRight()));
		} else {
			return a; // if x equals to the value of the existing node
		}
		/**
		 * Since we have inserted new element, we rotate necessary elements of the tree
		 * if the height-balance is violated
		 */
		return rotate (x, t );
		
	}
	
	/**
	 * Additional method to check the balance of the tree
	 * @param a - tree to be check in accordance to height balance
	 * @return - result of type integer indicating what rotation to do next to improve 
	 * height balance
	 */
	static int getBalance(Tree a) {
		if (a.isEmpty()) {
			return 0;
		} else {
			return a.getLeft().getHeight() - a.getRight().getHeight();
		}
	}
	
	/**
	 * Additional method that performs right rotation of the nodes
	 * @param t - given tree to be rotated
	 * @return - rotated tree
	 */
	static Tree rightRotate(Tree t) {
		return new Tree(t.getLeft().getValue(), t.getLeft().getLeft(),
				new Tree(t.getValue(), t.getLeft().getRight(), t.getRight()));
	}

	/**
	 * Additional method that performs left rotation of the nodes
	  * @param t - given tree to be rotated
	 * @return - rotated tree
	 */
	static Tree leftRotate(Tree t) {
		return new Tree(t.getRight().getValue(), new Tree(t.getValue(), t.getLeft(), t.getRight().getLeft()),
				t.getRight().getRight());
	}

	/**
	 * Additional method that rotates tree in accordance to one of the possible 4 cases
	 * @param x - integer to be inserted
	 * @param t - tree to be rotated
	 * @return - rotated tree
	 */
	static Tree rotate(int x, Tree t) {
		/**
		 * Right rotation
		 */
		if (getBalance(t) > 1 && x < t.getLeft().getValue())
			return rightRotate(t);
		/**
		 * Left rotation
		 */
		else if (getBalance(t) < -1 && x > t.getRight().getValue())
			return leftRotate(t);
		/**
		 * Left right rotation
		 */
		else if (getBalance(t) > 1 && x > t.getLeft().getValue()) {
			return rightRotate(new Tree(t.getValue(), leftRotate(t.getLeft()), t.getRight()));
		/**
		 * Right Left Rotation
		 */
		} else if (getBalance(t) < -1 && x < t.getRight().getValue()) {
			return leftRotate(new Tree(t.getValue(), t.getLeft(), rightRotate(t.getRight())));
		/**
		 * in case the tree is unchanged
		 */
		} else {
			return t;
		}
	}
	
	/**
	 * Ex10. The following method should delete the given value from the AVL tree 
	 * maintaining the height-balanced property
	 * @param x - the value should be deleted
	 * @param a - given tree
	 * @return - result of type Tree, that is a new AVL tree
	 */
	public static Tree deleteHB(int x, Tree a) {
		Tree t;
		if (a.isEmpty()) {
			return new Tree();
		} else if (x < a.getValue()) {
			t =  new Tree(a.getValue(), deleteHB(x, a.getLeft()), a.getRight());
		} else if (x > a.getValue()) {
			t = new Tree(a.getValue(), a.getLeft(), deleteHB(x, a.getRight()));
		} else 
			/**
			 * Case 1: when the node doesn't have neither left nor right sub trees
			 */
			if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
				return new Tree();
			/**
			 * Case 2.1: when the node has only right sub tree
			 */
			} else if (a.getLeft().isEmpty() && a.getRight().isEmpty() == false) {
				t=new Tree(a.getRight().getValue(), deleteHB(x,a.getLeft()), new Tree());
			/**
			 * Case 2.2: when the node has only left sub tree
			 */
			} else if (a.getLeft().isEmpty() == false && a.getRight().isEmpty()) {
				t = new Tree(a.getLeft().getValue(), new Tree(), a.getRight());
			/**
			 * Case 3: when the node has both left and right sub trees
			 */		
			} else if (a.getLeft().getLeft().isEmpty()){
				return new Tree(max(a.getLeft()),a.getLeft().getLeft(), a.getRight());
			} else {
				t = new Tree(max(a.getLeft()), deleteHB(x,new Tree(a.getLeft().getValue(), a.getLeft().getLeft(), new Tree())), a.getRight());
			}
		return rotateDel(x, t);	
	}

	/**
	 * Additional method for 'delete' method that rotates tree in accordance to one of the possible 4 cases
	 * @param x -  the value should be deleted
	 * @param t - given tree
	 * @return result of type Tree, that is a new AVL tree
	 */
	static Tree rotateDel(int x, Tree t) {	
	while (isHeightBalanced(t)==false){
		if( getBalance(t) >1 && getBalance(t.getLeft())>=0){
			return rightRotate(t);
		} else if (getBalance(t)>1 && getBalance(t.getLeft())<0){
			return rightRotate(new Tree(t.getValue(), leftRotate(t.getLeft()), t.getRight()));
		} else if (getBalance(t) < -1 && getBalance(t.getRight())<0){
			return leftRotate(t);
		} else if (getBalance(t) < -1 && getBalance(t.getRight())>=0){
			return leftRotate(new Tree(t.getValue(), t.getLeft(), rightRotate(t.getRight())));
		} else {
			return t;
		}	
	}
	return t;
	}
	
	/**
	 * Main method contains examples to test 'printDescending' method
	 */
	public static void main(String[] args) {
		Tree leftBSSubTree = new Tree(8, new Tree(5, new Tree(2, new Tree(1), new Tree(3)), new Tree(7, new Tree(6), new Tree())), new Tree());
		Tree rightBSSubTree = new Tree(3, new Tree(), new Tree(11, new Tree(6, new Tree(4), new Tree(8)), new Tree(16, new Tree(15), new Tree())));
		Tree bsTree = new Tree(20, new Tree(10, new Tree(5, new Tree(2), new Tree(8)), new Tree(17, new Tree(14), new Tree(19))),
				new Tree(32, new Tree(24, new Tree(), new Tree(28)),
				new Tree(44, new Tree(37, new Tree(34), new Tree()), new Tree())));
		Tree initial = new Tree(7, new Tree(4, new Tree(2), new Tree(5)), new Tree(15, new Tree(8), new Tree(20)));
		
		System.out.println("Example 1");
		printDescending(leftBSSubTree);
		System.out.println();
		System.out.println("Example 2");
		printDescending(rightBSSubTree);
		System.out.println();
		System.out.println("Example 3");
		printDescending(bsTree);
		System.out.println();
		System.out.println("Example 4");
		printDescending(initial);
		
	}
}
