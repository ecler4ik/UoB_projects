package predictive;

/**
 * The following class contains main method for calling overriden method 'signatureToWords' from command - line
 *
 * @author Yashina Valeriya, ID 1603690
 * @version 02/01/2017.
 *          <p>
 *          To test how the command-line suggested dictionary is used (name of the file "words.txt").
 *          <p>
 *          MacBook-Pro-Valeria:WS2-3 valeria$ java -cp ./out/production/WS2-3 predictive.Sigs2WordsList 63
 *          63: [md, me, mf, nd, ne, nf, od, oe, of]
 */
public class Sigs2WordsList {
    public static void main(String[] args) {
        ListDictionary ld = new ListDictionary("words.txt");
        for (int i = 0; i < args.length; i++) {
            String str = ld.signatureToWords(args[i]).toString();
            System.out.println(args[i] + ": " + str);
        }
    }
}
/**
 * The time comparision of the first two prototypes. Large dictionary is used ('word'.txt)
 * <p>
 * MacBook-Pro-Valeria:WS2-3 valeria$ time java -cp ./out/production/WS2-3/ predictive.Sigs2WordsList 653
 * 49828 8492 7429 74829 74829 4782 428 1983 73918 7319 472 4782 742 592 7194 7249 52410 74928 74289 1324356
 * 7429 7592 4279 63
 * 653: [mld, mlf, nlf, oke, old, ole]
 * 49828: []
 * 8492: [tiza]
 * 7429: [shaw, shay]
 * 74829: []
 * 74829: []
 * 4782: [grub]
 * 428: [gat, gau, gav, gbt, gct, hat, hau, hav, iau, ict]
 * 1983: []
 * 73918: []
 * 7319: []
 * 472: [gpc, gra, grb, gsa, gsc, hsb, hsc, ipa, ipc, ira, irc, isa, isc]
 * 4782: [grub]
 * 742: [pga, pha, phc, pia, pic, qic, rgb, rha, rhb, rhc, ria, rib, ric, sha, sia, sib, sic]
 * 592: [kwa, lyc]
 * 7194: []
 * 7249: [sagy]
 * 52410: []
 * 74928: []
 * 74289: []
 * 1324356: []
 * 7429: [shaw, shay]
 * 7592: []
 * 4279: [gapy, gary, harz]
 * 63: [md, me, mf, nd, ne, nf, od, oe, of]
 * <p>
 * real	0m3.494s
 * <p>
 * MacBook-Pro-Valeria:WS2-3 valeria$ time java -cp ./out/production/WS2-3/ predictive.Sigs2WordsProto 653
 * 49828 8492 7429 74829 74829 4782 428 1983 73918 7319 472 4782 742 592 7194 7249 52410 74928 74289 1324356
 * 7429 7592 4279 63
 * <p>
 * Output was the same
 * real	0m16.232s
 * <p>
 * The speed of the second prototype is 4,645 times higher in comparison with the first one.
 * This difference is explained by the fact that in the first prototype the method needs to read the dictionary
 * from the very beginning for every input, whereas the dictionary in the second prototype is stored in Java program
 */