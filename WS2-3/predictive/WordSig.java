package predictive;

import java.math.BigInteger;

/**
 * The following class pairs words and signatures.
 *
 * @author Yashina Valeriya, ID 1603690
 * @version 02/02/2017.
 */
public class WordSig implements Comparable<WordSig> {

    private String words;
    private String signature;

    /**
     * Constructor for the class WordSig
     *
     * @param signature represents numeric value of the word
     * @param words     represents word
     */
    public WordSig(String signature, String words) {
        this.words = words;
        this.signature = signature;
    }

    /**
     * Getter for words
     *
     * @return words
     */
    public String getWords() {
        return this.words;
    }

    /**
     * Getter for signatire
     *
     * @return signature
     */
    public String getSignature() {
        return this.signature;
    }

    /**
     * The following method specifies how to print objects of WordSig
     *
     * @return result of type String
     */
    @Override
    public String toString() {
        return "WordSig{" + words +
                "-" + signature;
    }

    /**
     * The following method compares two objects according their signatures in ascending order
     * BigInteger is used as the method handles with big integers
     *
     * @param ws - object that is pair of the word and signature
     * @return 1 - if 1st object is greater than 2nd, 0 - if they are equal, -1 - if 1st object os less than 2nd one.
     */
    public int compareTo(WordSig ws) {
        BigInteger n1 = new BigInteger(this.signature);
        BigInteger n2 = new BigInteger(ws.getSignature());
        return n1.compareTo(n2);
    }
}
