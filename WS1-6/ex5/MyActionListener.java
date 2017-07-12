package ex5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JOptionPane;

/**
 * The following class contains ActionListener which handles the button' actions
 * 
 * @author Valeriya Yashina, ID 1603690
 *
 */
public class MyActionListener implements ActionListener {

	GuiHtmlRead gui;
	
	public MyActionListener(GuiHtmlRead gui) {
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		String url = gui.getUrl();
		String filename = gui.getFilename();
		
		String actionCommand = event.getActionCommand();
		/**
		 * If statement is used to give appropriate feedback whether the
		 * file was properly download.
		 */
		if (GuiHtmlRead.isValidURL(url)) {
			try {
				GuiHtmlRead.saveUrl(url, filename);
				System.out.println(url);
				File f = new File("/Users/valeria/Documents/workspace/WS1-6/" + filename);

				if (f.isFile() && f.canRead()) {

					actionCommand = "File successfully saved!";

				} else {
					actionCommand = "Something went wront, try again!";
				}
				JOptionPane.showMessageDialog(null, actionCommand);
			} catch (MalformedURLException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		} else {
			System.out.println("Ooops, the url is invalid!");
		}
	}

}
