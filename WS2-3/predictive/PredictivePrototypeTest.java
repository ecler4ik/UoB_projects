package predictive;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Yashina Valeriya, ID 1603690
 * @version 05/02/2017
 */
public class PredictivePrototypeTest {

    @Test
    public void wordToSignature1(){
        Assert.assertEquals("4663", PredictivePrototype.wordToSignature("home"));
    }

    @Test
    public void wordToSignature2(){
        Assert.assertEquals("4 63", PredictivePrototype.wordToSignature("h-me"));
    }

    @Test
    public void wordToSignature3(){
        Assert.assertEquals("43556", PredictivePrototype.wordToSignature("hello"));
    }

    @Test
    public void wordToSignature4(){
        Assert.assertEquals("    ", PredictivePrototype.wordToSignature("!@£$"));
    }

    @Test
    public void signatureToWords1() {
        Set<String> results = new HashSet<>(8);
        results.add("hood");
        results.add("good");
        results.add("hone");
        results.add("hoof");
        results.add("gone");
        results.add("home");
        Assert.assertEquals(results, PredictivePrototype.signatureToWords("4663"));
    }

    @Test
    public void signatureToWords2() {
        Set<String> results = new HashSet<>(16);
        results.add("dax");
        results.add("fax");
        results.add("daz");
        results.add("day");
        results.add("faz");
        results.add("fay");
        Assert.assertEquals(results, PredictivePrototype.signatureToWords("329"));
    }

    @Test
    public void signatureToWords3() {
        Set<String> results = new HashSet<>(2);
        results.add("of");
        results.add("me");
        Assert.assertEquals(results, PredictivePrototype.signatureToWords("63"));
    }

    @Test
    public void isValid1(){
        Assert.assertTrue(PredictivePrototype.isValidWord("vocabluraly"));
    }

    @Test
    public void isValid2(){
        Assert.assertFalse(PredictivePrototype.isValidWord("-hoho"));
    }

    @Test
    public void isValid3(){
        Assert.assertFalse(PredictivePrototype.isValidWord(" "));
    }

    /**
     * To test "wordToSignature" method for Linkedlist implementation
     */
    @Test
    public void signatureToWords2_1() {
        ListDictionary dictionary = new ListDictionary("dictTest.txt");
        Set<String> results = new HashSet<>(8);
        results.add("hood");
        results.add("good");
        results.add("hone");
        results.add("hoof");
        results.add("gone");
        results.add("home");
        Assert.assertEquals(results, dictionary.signatureToWords("4663"));
    }

    /**
     * To test "wordToSignature" method for Linkedlist implementation
     */
    @Test
    public void signatureToWords2_2() {
        ListDictionary dictionary = new ListDictionary("dictTest.txt");
        Set<String> results = new HashSet<>(16);
        results.add("dax");
        results.add("fax");
        results.add("daz");
        results.add("day");
        results.add("faz");
        results.add("fay");
        Assert.assertEquals(results, dictionary.signatureToWords("329"));
    }

    /**
     * To test "wordToSignature" method for Linkedlist implementation
     */
    @Test
    public void signatureToWords2_3() {
        ListDictionary dictionary = new ListDictionary("dictTest.txt");
        Set<String> results = new HashSet<>(2);
        results.add("of");
        results.add("me");
        Assert.assertEquals(results, dictionary.signatureToWords("63"));
    }

    /**
     * To test "wordToSignature" method for HashMap implementation
     */
    @Test
    public void signatureToWords3_1() {
        MapDictionary mapDictionary = new MapDictionary("dictTest.txt");
        Set<String> results = new HashSet<>(2);
        results.add("of");
        results.add("me");
        Assert.assertEquals(results, mapDictionary.signatureToWords("63"));
    }

    /**
     * To test "wordToSignature" method for HashMap implementation
     */
    @Test
    public void signatureToWords3_2() {
        MapDictionary mapDictionary = new MapDictionary("dictTest.txt");
        Set<String> results = new HashSet<>(16);
        results.add("dax");
        results.add("fax");
        results.add("daz");
        results.add("day");
        results.add("faz");
        results.add("fay");
        Assert.assertEquals(results, mapDictionary.signatureToWords("329"));
    }

    /**
     * To test "wordToSignature" method for Tree implementation
     */
    @Test
    public void signatureToWords4_1(){
        TreeDictionary treeDictionary = new TreeDictionary("words.txt");
        Set<String> results = new HashSet<>();
        results.add("gnof");
        results.add("gome");
        results.add("gond");
        results.add("gone");
        results.add("good");
        results.add("gooe");
        results.add("goof");
        results.add("home");
        results.add("hond");
        results.add("hone");
        results.add("honf");
        results.add("hood");
        results.add("hooe");
        results.add("hoof");
        results.add("imme");
        results.add("inme");
        results.add("inne");
        results.add("inod");
        results.add("ione");
        results.add("ioof");
        results.add("gonf");
        results.add("home");
        results.add("inoe");
        results.add("inof");
        Assert.assertEquals(results, treeDictionary.signatureToWords("4663"));
    }

    /**
     * To test "wordToSignature" method for Tree implementation
     */
    @Test
    public void signatureToWords4_2(){
        TreeDictionary treeDict = new TreeDictionary("words.txt");
        Set<String> results = new HashSet<>();
        results.add("jhar");
        results.add("jibs");
        results.add("khap");
        results.add("khar");
        results.add("khas");
        results.add("kias");
        results.add("kibs");
        results.add("lhar");
        results.add("lhas");
        results.add("liar");
        results.add("lias");
        results.add("libr");
        results.add("libs");
        Assert.assertEquals(results, treeDict.signatureToWords("5427"));
    }
}