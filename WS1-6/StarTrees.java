import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.security.SecureRandom;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The following class is a subclass of the class Trees. The aim of this class
 * is to draw a star tree at its top. The star is characterised by the number of
 * vertices and the number of steps to come to the next vertex.
 * 
 * @author Valeriya, Yashina, ID 1603690
 * @version Date 03/01/2017
 *
 */

public class StarTrees extends Trees {

	private static int numberOfVertices;
	private int steps;

	/**
	 * Constructor for the class StarTrees. Variables xTrees, yTrees, scaleTrees
	 * are inherited from the superclass Trees.
	 * 
	 * @param xTrees - x-coordinates for Christmas trees
	 * @param yTrees - y-coordinates for Christmas trees
	 * @param scaleTrees - array of scaling factors
	 * @param numberOfVertices - number of vertices in a star
	 * @param steps - number of steps to come to the next vertex
	 */
	public StarTrees(int[] xTrees, int[] yTrees, int[] scaleTrees, int numberOfVertices, int steps) {
		super(xTrees, yTrees, scaleTrees);
		this.numberOfVertices = numberOfVertices;
		this.steps = steps;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		/**
		 * 1.Cast g to Graphics2D. 2.Use General Path to build the star shape.
		 */
		Graphics2D g2d = (Graphics2D) g;
		GeneralPath star = new GeneralPath();

		/**
		 * Formula to calculate the angle between 2 vertices
		 */
		
		double angle = 2 * Math.PI / numberOfVertices;

		/**
		 * The following 'for' loop is used to draw star at the top of the tree
		 * according to scaling factor
		 */
		for (int i = 0; i < getScaleTrees().length; i++) {

			/**
			 * xInitial and yInitial are variables that store the value of the first point
			 * from which the star will be drawn. r - external radius of the
			 * star. The size of radius is chosen arbitrarily ("/4"), but it
			 * changes in accordance with the tree's size
			 */
			int xInitial = getxTrees()[1] * getScaleTrees()[i] + 50 * i * getScaleTrees()[i];
			int yInitial = getyTrees()[1] * getScaleTrees()[i] + 50 * getScaleTrees()[i];
			double r = (getyTrees()[0] - getyTrees()[1]) * getScaleTrees()[i] / 4;

			/**
			 * Calculate x and y coordinates of points and store them in arrays
			 * xCoord, yCoord
			 */
			double[] xCoord = calculateXCoord(xInitial, r, angle, numberOfVertices);
			double[] yCoord = calculateYCoord(yInitial, r, angle, numberOfVertices);

			/**
			 * set the initial coordinates of the General Path
			 */
			star.moveTo(xInitial, yInitial + r);

			/**
			 * The following for loop creates a star, this doesn't draw the
			 * star. 'If' statement defines if the number of vertices and steps
			 * are coprime integers or not
			 */
			int count = 0; // We count divisible number
			for (int t = 2; t <= numberOfVertices; t++) {
				if (steps % t == 0 && numberOfVertices % t == 0) {
					count++;
				}
			}
			if (count == 0) { // if there is no divisible numbers, the integers are coprime

				for (int j = 0; j <= numberOfVertices * steps - steps; j = j + steps) {
					if (j % numberOfVertices == 0) {
						star.lineTo(xCoord[j], yCoord[j]);
					} else {
						star.lineTo(xCoord[j % numberOfVertices], yCoord[j % numberOfVertices]);
					}
				}

				/**
				 * close the shape
				 */
				star.closePath();
				
				/**
				 * Set black colour and draw a star
				 */
				g2d.setColor(Color.BLACK);
				g2d.draw(star);

			} else {
				System.out.println("Not Prime"); // The integers are not coprime
			}
		}
	}

	/**
	 * The following method calculates the values of the xCoord array
	 * 
	 * @param xInitial - the x coordinate of the starting point
	 * @param r - external radius of the star
	 * @param angle - angle between two vertices
	 * @return the result as one dimensional array of type double
	 */
	public static double[] calculateXCoord(int xInitial, double r, double angle, int numberOfVertices) {
		/**
		 * xCoord is an arrays that stores x-coordinates of the star's vertices
		 */
		double[] xCoord = new double[numberOfVertices];
		for (int z = 0; z < numberOfVertices; z++) {
			xCoord[z] = xInitial + r * Math.sin(z * angle);
		}
		return xCoord;
	}

	/**
	 * The following method calculates the values of the yCoord array
	 * 
	 * @param yInitial - the y coordinate of the starting point
	 * @param r - external radius of the star
	 * @param angle - angle between two vertices
	 * @return the result as one dimensional array of type double
	 */
	public static double[] calculateYCoord(int yInitial, double r, double angle, int numberOfVertices) {
		/**
		 * yCoord is an arrays that stores y-coordinates of the star's vertices
		 */
		double[] yCoord = new double[numberOfVertices];
		for (int z = 0; z < numberOfVertices; z++) {
			yCoord[z] = yInitial + r * Math.cos(z * angle);
		}
		return yCoord;
	}

	/**
	 * Main method that displays the result as an example
	 *
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("StarTrees");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int[] x = { 10, 40, 70, 35, 45, 45, 35 };
		int[] y = { 60, 0, 60, 60, 60, 80, 80 };
		int[] s = {1,2,5,3,4};
		int numberOfVertices = 11;
		int steps = 4;

		//Example 2
//		int numberOfVertices = 15;
//		int steps = 2;
		
		//Example 3
//		 int numberOfVertices = 5;
//		 int steps = 2;

		StarTrees panel = new StarTrees(x, y, s, numberOfVertices, steps);
		frame.add(panel);
		frame.setBackground(Color.WHITE);
		frame.setSize(1500, 1000);
		frame.setVisible(true);

	}

}
