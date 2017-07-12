import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * In the following we create class Trees that draws Christmas trees with some
 * variations. The shape of tree should be green triangle (12 units at the
 * bottom, 12 units - height) plus brown rectangle (2x4 units). Trees can be
 * resized by a scaling factor of type int.
 * 
 * @author Valeriya, Yashina, ID 1603690
 * @version Date 02/01/2017
 * 
 */

public class Trees extends JPanel {
	/**
	 * Class Trees is a simple class that draws simple Christmas trees using
	 * scaling factor to modify the tree.
	 */
	private int[] xTrees;
	private int[] yTrees;
	private int[] scaleTrees;

	/**
	 * Constructor of the class Threes.
	 * 
	 * @param xTrees stands for the array of x-coordinates
	 * @param yTrees stands for the array of y-coordinates
	 * @param scaleTrees - scaling factor
	 */
	public Trees(int[] xTrees, int[] yTrees, int[] scaleTrees) {
		this.setxTrees(xTrees);
		this.setyTrees(yTrees);
		this.setScaleTrees(scaleTrees);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);

		/**
		 * the following for loop is used to draw grey grid with the length
		 * between lines 50
		 */
		g.setColor(Color.GRAY);
		for (int i = 0; i <= 1500; i += 25) {
			for (int j = 0; j <= 1200; j += 25) {
				g.drawLine(i, j, i, 1200);
				g.drawLine(i, j, 1500, j);
			}
		}
		
			/**the following for loop is used to create trees of different scale
			 * 
			 */
			for (int i = 0; i < getScaleTrees().length; i++) {
			//Arrays.sort(scaleTrees); //this method can be used in order to allocate the trees in increasing order
			
			/**
			 * Create two new arrays for x- and y- values to draw a triangle.
			 * Copy the necessary value from initial xTrees and yTrees arrays to new
			 * ones.
			 */
			int[] xTriangle = new int[3];
			int[] yTriangle = new int[3];

			for (int j = 0; j < 3; j++) {
				xTriangle[j] = getxTrees()[j] * getScaleTrees()[i] + 50 * i * getScaleTrees()[i];	
				yTriangle[j] = getyTrees()[j] * getScaleTrees()[i] + 50 * getScaleTrees()[i];
			}
			
					 
			/**
			 * Create two new arrays for x- and y- values to draw a trunk.
			 * Copy the necessary values from initial xTrees and yTrees arrays to new ones.
			 */
			int[] xTrunk = new int[4];
			System.arraycopy(getxTrees(), 3, xTrunk, 0, 4);

			int[] yTrunk = new int[4];
			System.arraycopy(getyTrees(), 3, yTrunk, 0, 4);

			for (int j = 0; j < 4; j++) {
				xTrunk[j] = xTrunk[j] * getScaleTrees()[i] + 50 * i * getScaleTrees()[i];
				yTrunk[j] = yTrunk[j] * getScaleTrees()[i] + 50 * getScaleTrees()[i];
			}
			
			
			/**
			 * create green and brown colours using RGB values
			 */
			Color green = new Color(0, 102, 0);
			Color brown = new Color(102, 51, 0);
			
			/**
			 * 1.Set up colours for the triangle and the trunk respectively.
			 * 2.Draw trees using fillPolygon method 
			 */
			g.setColor(green);
			g.fillPolygon(xTriangle, yTriangle, 3);

			g.setColor(brown);
			g.fillPolygon(xTrunk, yTrunk, 4);

		}
	}


	
	/**
	 * The following main method is used to show how Christmas trees are allocated.
	 * Another example is contained in the class TreesMain
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Cristmas trees");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int[] x = { 10, 40, 70, 35, 45, 45, 35 };
		int[] y = { 60, 0, 60, 60, 60, 80, 80 };
		int[] s = { 3, 4, 5, 1, 2 };

		Trees panel = new Trees(x, y, s);

		frame.add(panel);
		frame.setSize(1500, 1200);
		frame.setVisible(true);
	}

	/**
	 * the following getters are used in the next ex. 
	 */
	
	/**
	 * getter for the array xTrees, which stands for x coordinates
	 * @return array of x coordinates
	 */
	public int[] getxTrees() {
		return xTrees;
	}

	/**
	 * setter to change the values of the array xTrees
	 * @param xTrees array
	 */
	public void setxTrees(int[] xTrees) {
		this.xTrees = xTrees;
	}

	/**
	 * getter for the array yTrees, which stands for y coordinates
	 * @return array of y cooedinates
	 */
	public int[] getyTrees() {
		return yTrees;
	}

	/**
	 * setter to change the values of the array yTrees
	 * @param yTrees array
	 */
	public void setyTrees(int[] yTrees) {
		this.yTrees = yTrees;
	}

	/** 
	 * getter for the array scaleTrees, which stands for scaling factor
	 * @return array of scale
	 */
	public int[] getScaleTrees() {
		return scaleTrees;
	}

	/**
	 * setter to change the values of the array scaleTrees
	 * @param scaleTrees array
	 */
	public void setScaleTrees(int[] scaleTrees) {
		this.scaleTrees = scaleTrees;
	}
}
