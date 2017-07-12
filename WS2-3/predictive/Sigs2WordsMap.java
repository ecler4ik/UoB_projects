package predictive;

/**
 * The following class contains main method for calling overriden method 'signatureToWords' from command - line
 *
 * @author Yashina Valeriya, ID 1603690
 * @version 06/01/2017
 *          <p>
 *          To test how the command-line suggested dictionary is used (name of the file "words.txt").
 *          <p>
 *          MacBook-Pro-Valeria:WS2-3 valeria$ java -cp ./out/production/WS2-3/ predictive.Sigs2WordsMap 63
 *          63: [od, nd, oe, md, ne, of, me, nf, mf]
 *          <p>
 *          MacBook-Pro-Valeria:WS2-3 valeria$ java -cp ./out/production/WS2-3/ predictive.Sigs2WordsMap 5427
 *          5427: [jibs, kias, khar, liar, libs, lias, libr]
 */
public class Sigs2WordsMap {
    public static void main(String[] args) {
        MapDictionary map = new MapDictionary("words.txt");
        for (int i = 0; i < args.length; i++) {
            String str = map.signatureToWords(args[i]).toString();
            System.out.println(args[i] + ": " + str);
        }
    }
}
