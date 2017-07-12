

import java.util.*;
import java.io.*;
import java.net.URL;

/**
 * In the following we create class WebCrawler aims to start with particular
 * web page and then collect all web pages.
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version Date 10/11/2016
 *
 */
public class WebCrawler {

	/**
	 * This method is used to split stream of data by lines, extract urls and gather them together 
	 * 1.use BufferedReader to read text from a character-input stream, buffering characters 
	 * so as to provide for the efficient reading of characters, arrays, and lines.
	 * 2. then add these lines into ArrayList of the type String 
	 * 3. check if line contains <a href=\" (after sequence of these chars the url starts) 
	 * 4. we use for loop in order to check if the line contains required sequence of chars 
	 * 5.if yes, then we pass this line to the method buildUrl (the content of this method will
	 * be explained below) 
	 * 6.the outcome of this method is added to ArrayList urlS that after filling will be returned
	 * 
	 * @param urlString - url that is passed to method collectUrls
	 * @return result of the type ArrayList<String>
	 */
	public static ArrayList<String> collectUrls(String urlString) {
		String readString; //temporary stores line
		ArrayList<String> urlS = new ArrayList<String>();//stores url after they have been split 
		ArrayList<String> list = new ArrayList<String>();//stores all lines after they were passed through BafferedReader
		try {
			URL url = new URL(urlString);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((readString = in.readLine()) != null) {
				list.add(readString);
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).contains("<a href=\"")) {
					urlS.add(buildUrl(list.get(i)));
				}
			}
			in.close();
		} catch (IOException e) {//go through exception if something wrong with url
			System.out.println("no access to URL: " + urlString);
		}
		return urlS;
	}

	/**
	 * This method is used to split url from the string
	 * 1.takes the string and than first time splits it by dividing it between "<a href=", 
	 * this consequence of char removes
	 * 2.use for loop in order to check for "\"" as the starting sequence of chars
	 * 3.if yes, then it splits this line second time between "\">"",
	 * 4.take the first part after split and split it third time between "\""
	 * 
	 * @param text - argument of the method
	 * @return result as the type of String
	 */
	public static String buildUrl(String text) {

		String[] firstSplit = text.split("<a href=");// first split
		String url = null;
		for (int i = 0; i < firstSplit.length; i++) {//sort out all elements after first split
			if (firstSplit[i].startsWith("\"")) {
				String[] secondSplit = firstSplit[i].split("\">");//second split (cut the unnecessary ending of url
				String[] thirdSplit = secondSplit[0].split("\"");//third split (cut the left quote)
				url = thirdSplit[1];//assigns cropped url to variable url
			}
		}
		return url;
	}
}
