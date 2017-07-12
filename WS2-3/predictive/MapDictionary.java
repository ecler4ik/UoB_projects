package predictive;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static predictive.PredictivePrototype.wordToSignature;

/**
 * The following class presents the improved implementation of the Dictionary using a Map data structure.
 * The data should be stored in a "multi-valued map", data structure that maps each signature to set of words.
 *
 * Explanation of how maps work and justification of choice.
 * Map collection allows map keys to values. A map cannot contain duplicate keys and at the same time each key
 * cann't map more than one value. To implement Map interface Hash-map was chosen.
 * Some Hashmap properties that describes its nature and justifies why it was reasonable to be implemented in this case.
 *
 * 1. HashMap allows one null key and any number of null values to be stored.
 * 2 .HashMap is unsynchronised (multiple threads should not modify a HashMap concurrently)
 *
 * @author Yashina Valeriya, ID 1603690
 * @version 06/02/2017.
 */
public class MapDictionary implements Dictionary {

    private final String path;
    private Map<String, Set<String>> maps = new HashMap<>();

    /**
     * Constructor of the MapDictionary class.
     *
     * @param path - represents path (name) of the dictionary that is read
     */
    public MapDictionary(String path) {
        this.path = path;
        createMap();
    }

    /**
     * The following method reads the dictionary from the file and store the result as a map,
     * where signature is a key, and set of words (Set<String>) - matched words
     */
    public void createMap() {
        File file = new File(this.path);
        String line;
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                if (PredictivePrototype.isValidWord(line)) {
                    addToMap(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Incorrect input, can't find the file");
        }
    }

    /**
     * The following method converts the signature to words. It looks for the signature among keys
     * and returns related set of matched words
     *
     * @param signature - numeric signature of the word
     * @return result of type Set<String> which contains all matched words
     */
    @Override
    public Set<String> signatureToWords(String signature) {
        if (maps.get(signature) == null) {
            return new TreeSet<>();
        }
        return maps.get(signature);
    }

    /**
     * Additional method that takes word, converts the word to the signature and depending on if
     * this signature already exist adds new word to the set or create new set.
     *
     * @param string - word
     * @return result of type Set<String> that matched particular signature
     */
    public Set<String> addToMap(String string) {
        Set<String> words = new HashSet<>();
        if (maps.containsKey(wordToSignature(string.toLowerCase()))) {
            maps.get(wordToSignature(string.toLowerCase())).add(string.toLowerCase());
        } else {
            String sign = wordToSignature(string.toLowerCase());
            words.add(string.toLowerCase());
            maps.put(sign, words);
        }
        return words;
    }
}
