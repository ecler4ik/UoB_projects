package predictive;

import java.io.File;
import java.util.*;

/**
 * The following class deals with a first version of the prototype for the predictive text problem.
 *
 * @author Yashina Valeriya, ID 1603690
 * @version 31/01/2017.
 */
public class PredictivePrototype {

    /**
     * The following method takes a parameter of the type String and returns result as integer.
     * For our first low-fidelity prototype that means that we take a word and convert it to the numeric signature.
     * For example, 'home' --> 4663
     * <p>
     * String is preferably used when immutable structure is appropriate. In case we need to alter its value,
     * another object created whereas StringBuffer is used because it's mutable, that means it can change its value.
     *
     * @param word represents the word that should be converted
     * @return result of type int, numeric signature
     */
    public static String wordToSignature(String word) {

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);
            if (ch == 'a' || ch == 'b' || ch == 'c') {
                stringBuffer.append(2);
            } else if (ch == 'd' || ch == 'e' || ch == 'f') {
                stringBuffer.append(3);
            } else if (ch == 'g' || ch == 'h' || ch == 'i') {
                stringBuffer.append(4);
            } else if (ch == 'j' || ch == 'k' || ch == 'l') {
                stringBuffer.append(5);
            } else if (ch == 'm' || ch == 'n' || ch == 'o') {
                stringBuffer.append(6);
            } else if (ch == 'p' || ch == 'q' || ch == 'r' || ch == 's') {
                stringBuffer.append(7);
            } else if (ch == 't' || ch == 'u' || ch == 'v') {
                stringBuffer.append(8);
            } else if (ch == 'w' || ch == 'x' || ch == 'y' || ch == 'z') {
                stringBuffer.append(9);
            } else {
                stringBuffer.append(' ');
            }
        }
        return stringBuffer.toString();
    }

    /**
     * The following method takes numeric signature and returns a set of possible
     * matching words from the dictionary. Each word should be in lower-case.
     * <p>
     * This implementation can be inefficient because each time we look fot particilar signature,
     * we need to read Dictionary from the very beginning. It takes more time and less efficient then
     * storing file in a program.
     *
     * @param signature represents numeric signature of the word
     * @return result of type Set<String> containing the matched words
     */
    public static Set<String> signatureToWords(String signature) {
        Set<String> matched = new HashSet<>();
        File file = new File("dictTest.txt");
        String line;
        try {
            /**
             * We use Scanner to read the dictionary line by line. We assume that
             * there is only one word per line
             */
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                if (isValidWord(line)) {
                    if (wordToSignature(line.toLowerCase()).equals(signature)) {
                        matched.add(line.toLowerCase());
                    }
                }
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matched;
    }

    /**
     * The following method checks if the word is valid, it ignores lines with non-alphabetic characters
     *
     * @param word to be checked
     * @return result of type boolean, true in case word matches partucular pattern
     */
    public static boolean isValidWord(String word) {

        return word.matches("[A-Za-z]+");
    }
}
