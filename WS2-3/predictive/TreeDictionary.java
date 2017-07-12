

package predictive;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * The following class creates improved version of the Dictionary interface. Own tree data structure is used.
 * At each node of the tree, we must store a collection of all the words that can possible match  the partial signature
 * along the path.
 *
 * @author Yashina Valeriya, ID 1603690
 * @version 09/02/2017.
 */
public class TreeDictionary implements Dictionary {

    private Set<String> words;
    private TreeDictionary[] nodes;

    /**
     * Constructor for a new child node
     */
    public TreeDictionary() {
        this.words = new TreeSet<>();
        this.nodes = new TreeDictionary[8];
    }

    /**
     * Constructor for an existing node
     *
     * @param words represents set of words
     * @param nodes path to the node where the words are stored,
     */
    public TreeDictionary(Set<String> words, TreeDictionary[] nodes) {

        this.words = words;
        this.nodes = nodes;
    }

    /**
     * Top level construstor to read the dictionary and store it as a tree
     *
     * @param path - file path where the dictionary is stored
     */
    public TreeDictionary(String path) {
        this.words = new TreeSet<>();
        this.nodes = new TreeDictionary[8];
        File file = new File(path);
        String line, signature;
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                line = sc.nextLine().toLowerCase();
                if (PredictivePrototype.isValidWord(line)) {
                    signature = PredictivePrototype.wordToSignature(line);
                    this.addWord(line, signature);
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Incorrect input, can't find the file");
        }
    }

    /**
     * Getter for the words
     *
     * @return result of tyoe Set<String>
     */
    public Set<String> getWords() {
        return this.words;
    }

    /**
     * Getter for the nodes
     *
     * @return result if type TreeDictionary
     */
    public TreeDictionary[] getNodes() {
        return this.nodes;
    }

    /**
     * The following methos returns a Set<String>, the mathcing words and prefixes of the words for given signature.
     * The character length of each of returned words or prefixes must be the same as the input signature.
     *
     * @param signature - numeric signature of the word
     * @return result of type Set<String> which contains all matched words
     */

    @Override
    public Set<String> signatureToWords(String signature) {
        try {
            return findWords(signature, signature.length());
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("No match for the signature");
        }
        return new TreeSet<String>();
    }

    /**
     * The followng returns matched words in the set<String>
     * @param signature - numeric signature of the word
     * @param length - length of the signature
     * @return - result of type Set<String></String>
     */
    public Set<String> findWords(String signature, int length) {

        if(signature.length() == 0){
            Set<String> currentNodeWords = new TreeSet<String>();

            for (Iterator<String> it = this.getWords().iterator(); it.hasNext();) {
                String f = it.next();
                currentNodeWords.add(f.substring(0, length));
            }
            return currentNodeWords;
        } else {
            int position = Integer.parseInt(signature.substring(0, 1)) - 2;
            TreeDictionary underTree = this.getNodes()[position];
            return underTree.findWords(signature.substring(1), length);
        }
    }

    /**
     * Additional method to add a new read word to the tree
     *
     * @param word      word from the dictionary to be added to the tree
     * @param signature - numeric signature of the word
     * @return TreeDictionary object
     */
    private TreeDictionary addWord(String word, String signature) {
        if (signature.length() == 0) {
            Set<String> words1 = this.getWords();
            words1.add(word);
            return new TreeDictionary(words1, this.getNodes());
        } else {
            int position = Integer.parseInt(signature.substring(0, 1)) - 2;
            TreeDictionary[] nodeReplace = this.getNodes();
            if (nodeReplace[position] == null) {
                nodeReplace[position] = new TreeDictionary();
            }
            Set<String> set = this.getWords();
            set.add(word);
            nodes[position].addWord(word, signature.substring(1));
            return new TreeDictionary(set, nodes);
        }
    }

    public static void main(String[] args) {
        TreeDictionary tr = new TreeDictionary("words.txt");
        System.out.println(tr.signatureToWords("5427").toString());

    }
}
