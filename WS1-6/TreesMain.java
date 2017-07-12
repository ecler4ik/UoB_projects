import javax.swing.JFrame;

/**
 * The following class contain only main method, that is needed to show how the
 * trees are allocated.
 * 
 * @author Valeriya Yashina, ID 1603690
 * @versionDate 02/01/2017
 *
 */
public class TreesMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Cristmas trees");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int[] x = { 10, 25, 40, 20, 30, 30, 20 };
		int[] y = { 60, 30, 60, 60, 60, 70, 70 };
		int[] s = { 3, 4, 5, 1, 2 };

		Trees panel = new Trees(x, y, s);

		frame.add(panel);
		frame.setSize(1500, 1200);
		frame.setVisible(true);
	}
}
