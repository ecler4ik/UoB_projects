package predictive;

/**
 * TThe following line contains main for calling method 'signatureToWords' from command - line
 *
 * @author Yashina Valeriya, ID 1603690
 * @version 31/01/2017.
 *          <p>
 *          To test how the command-line the own dictionary is used (name of the file "dictTest.txt").
 *          The output is the following:
 *          <p>
 *          MacBook-Pro-Valeria:WS2-3 valeria$ java -cp ./out/production/WS2-3/ predictive.Sigs2WordsProto 63
 *          63: [of, me]
 *          <p>
 *          MacBook-Pro-Valeria:WS2-3 valeria$ java -cp ./out/production/WS2-3/ predictive.Sigs2WordsProto 4663 329
 *          4663: [hood, good, hone, hoof, gone, home]
 *          329: [dax, fax, daz, day, faz, fay]
 */
public class Sigs2WordsProto {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String str = PredictivePrototype.signatureToWords(args[i]).toString();
            System.out.println(args[i] + ": " + str);
        }
    }
}