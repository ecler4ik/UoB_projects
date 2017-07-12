package predictive;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static predictive.PredictivePrototype.isValidWord;
import static predictive.PredictivePrototype.wordToSignature;

/**
 * The following class provides reading dictionary and storing it in the memory as a list of pairs.
 * Where each pair consists of signature and the word. Method 'wordToSignature' can be re-used, whereas
 * method 'signatureToWord' should be overriden as an instance method.
 *
 * @author Yashina Valeriya, ID 1603690
 * @version 31/01/2017.
 */
public class ListDictionary implements Dictionary {

    private String path;
    private ArrayList<WordSig> pairs = new ArrayList<>();

    /**
     * Constructor for the class ListDictionary.
     * Constructor reads the dictonary and stores it in the ArrayList<String>
     *
     * @param path - represents path (name) of the dictionary that is read
     */
    public ListDictionary(String path) {
        this.path = path;
        readDictionary();
    }

    /**
     * The following method looks for the signature in the stored ArrayList</String> and returns
     * all matched words.
     * BinarySearch is used to find the signature
     *
     * @param signature - numeric signature of the word
     * @return result of type Set<String> which contains all matched words
     */
    @Override
    public Set<String> signatureToWords(String signature) {
        Set<String> matched = new TreeSet<>();
        WordSig ws = new WordSig(signature, "");
        int keyIndex = Collections.binarySearch(this.pairs, ws);
        int keyIndex1 = keyIndex - 1;
        /**
         * look for possible word on the right
         */
        while (isMatched(ws, keyIndex)) {
            matched.add(pairs.get(keyIndex).getWords());
            keyIndex++;
        }

        /**
         * look for possible words on the left
         */
        while (isMatched(ws, keyIndex1)) {
            matched.add(pairs.get(keyIndex1).getWords());
            keyIndex1--;
        }
        return matched;
    }

    /**
     * Additional method to check that given signature matches to the signature of the object
     * of the ArrayList<WordSig> pairs, also checks that the looking index should be within the borders
     *
     * @param ws       - object of the ArrayList<WordSig>, that is pair of the word and its signature
     * @param keyIndex - index of the element which signature matches to the looking signature
     * @return result of type boolean, true in case it matches
     */
    private boolean isMatched(WordSig ws, int keyIndex) {
        return keyIndex >= 0 && keyIndex < pairs.size() && pairs.get(keyIndex).getSignature().equals(ws.getSignature());
    }

    /**
     * The following method reads the dictionary from file and store the result in ArrayList<WordSig>.
     * Each element of the ArrayList is an object that consists of the signature and the word.
     */
    public void readDictionary() {
        File file = new File(this.path);
        String line;
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                if (isValidWord(line)) {
                    this.pairs.add(new WordSig(wordToSignature(line.toLowerCase()), line.toLowerCase()));
                }
            }
            sc.close();
            Collections.sort(this.pairs);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Incorrect input, can't find the file");
        }
    }

    /**
     * The following method specify how to print the objects of the ArrayList.
     *
     * @return result of the type String
     */
    @Override
    public String toString() {
        return "" + pairs;
    }
}
