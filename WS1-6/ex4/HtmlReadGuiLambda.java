package ex4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ex3.HtmlReadGuiInner;

/**
 * The following class allows user to download a HTML file of their choice to
 * the local file of their choice
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version Date 05/01/2017
 *
 */
public class HtmlReadGuiLambda extends JPanel  {
	/**
	 * Class HtmlReadGuiInner extends JPanel to draw an interface windows that
	 * allows the user to interact with program
	 */
	private final JTextField field1;
	private final JTextField field2;
	private final JButton button;

	/**
	 * The following method is used to save HTML file to local directory.
	 * 
	 * @param fileName - preferred file name
	 * @param urlString - copy of HTML page that is needed to be saved
	 * @throws MalformedURLException - string form of the URL is wrong. 
	 * Either no legal protocol could be found in a specification string 
	 * or the string could not be parsed.
	 * @throws IOException - incorrect input/ output
	 */
	public void saveUrl(String fileName, String urlString) throws MalformedURLException, IOException {

		/**
		 * BufferedInputStream is used to read the data as one input operation
		 * into a memory buffer FileOutputStream is used to write a stream of
		 * characters
		 */
		BufferedInputStream in = null;
		FileOutputStream fout = null;
		try {
			in = new BufferedInputStream(new URL(fileName).openStream());
			fout = new FileOutputStream(urlString);

			final byte data[] = new byte[1024];
			int count;
			while ((count = in.read(data, 0, 1024)) != -1) {
				fout.write(data, 0, count);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (fout != null) {
				fout.close();
			}
		}
	}

	/**
	 * HTML constructor adds two fields and one button to JFrame
	 */
	public HtmlReadGuiLambda() {
		super();
		setLayout(new FlowLayout());

		/**
		 * Construct text fields which prompt the user. Set up their size, make
		 * them editable in order to clear the field later. Add field to JFrame
		 */
		field1 = new JTextField("Please enter URL");
		field1.setEditable(true);
		field1.setPreferredSize(new Dimension(300, 130)); // set up size
		add(field1);

		field2 = new JTextField("Please enter filename");
		field2.setEditable(true);
		field2.setPreferredSize(new Dimension(300, 130));// set up size
		add(field2);

		/**
		 * Construct button which prompts the user. Set up its size, colour,
		 * alignment and font. Add button to JFrame.
		 */
		button = new JButton("DOWNLOAD");
		button.setPreferredSize(new Dimension(300, 130));
		button.setBackground(Color.GRAY);
		button.setHorizontalAlignment(SwingConstants.CENTER);
		button.setFont(new Font("Serif", Font.BOLD, 16));
		add(button);
		
		/**
		 * Using lambda expressions to handle with action
		 */
		button.addActionListener(event -> {
				if (isValidURL(field1.getText()))	{
				try {
						saveUrl(field1.getText(), field2.getText());
						System.out.println(field1.getText());
						File f = new File("/Users/valeria/Documents/workspace/WS1-6/" + field2.getText());
						String string = "";
						if (f.isFile() && f.canRead()) {
							string = "File succefully saved!";
							System.out.println(string);
						} else {
							string = "Something went wront, try again!";
							System.out.println(string);
						}
						JOptionPane.showMessageDialog(null, string);
					} catch (MalformedURLException e) {

						e.printStackTrace();
					} catch (IOException e) {

						e.printStackTrace();
					}
				} else {
					System.out.println("Ooops, the url is invalid!");
				}
				});
			}


	/**
	 * The following method is to check whether the url is correct
	 * @param url - string of url
	 * @return true or false
	 */
	public static boolean isValidURL(String url) {
		Pattern pattern = Pattern
				.compile("^http(s{0,1})://[a-zA-Z0-9_/\\-\\.]+\\.([A-Za-z/]{2,5})[a-zA-Z0-9_/\\&\\?\\=\\-\\.\\~\\%]*");
		Matcher matcher = pattern.matcher(url);
		return matcher.matches();
	}	
	
	/**
	 * * The following main method is used to activate GUI interface.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Read HTML file");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HtmlReadGuiLambda gui = new HtmlReadGuiLambda();

		frame.add(gui);
		frame.setSize(300, 400);
		frame.setVisible(true);
	}

}
