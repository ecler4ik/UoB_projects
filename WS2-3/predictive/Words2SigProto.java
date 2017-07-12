package predictive;
/**
 * The following line contains main for calling method 'wordsToSignature' from command - line
 *
 * @author Yashina Valeriya, ID 1603690
 * @version 31/01/2017.
 */

/**
 * To test how the command-line the own dictionary is used (name of the file "dictTest.txt")
 * The output is the following:
 * <p>
 * MacBook-Pro-Valeria:WS2-3 valeria$ java -cp ./out/production/WS2-3 predictive.Words2SigProto car
 * car: 227
 * <p>
 * MacBook-Pro-Valeria:WS2-3 valeria$ java -cp ./out/production/WS2-3 predictive.Words2SigProto vocabularly
 * vocabularly: 86222852759
 */
public class Words2SigProto {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String str = PredictivePrototype.wordToSignature(args[i]).toString();
            System.out.println(args[i] + ": " + str);
        }
    }
}
/**
 * Output that has been obtained by testing 'Words2SigProto'
 * MacBook-Pro-Valeria:WS2-3 valeria$ java -cp ./out/production/WS2-3 predictive.Words2SigProto
 * "Java is a general-purpose computer programming language that is concurrent, class-based, object-oriented,
 * and specifically designed to have as few implementation dependencies as possible. It is intended to let
 * application developers "write once, run anywhere" (WORA),meaning that compiled Java code can run on all
 * platforms that support Java without the need for recompilation.Java applications are typically compiled to
 * bytecode that can run on any Java virtual machine (JVM) regardless of computer architecture. As of 2016, Java
 * is one of the most popular programming languages in use,particularly for client-server web applications, with
 * a reported 9 million developers.Java was originally developed by James Gosling at Sun Microsystems (which has
 * since been acquired by Oracle Corporation) and released in 1995 as a core component of Sun Microsystems' Java
 * platform. The language derives much of its syntax from C and C++, but it has fewer low-level facilities than
 * either of them."
 * Java is a general-purpose computer programming language that is concurrent, class-based, object-oriented,
 * and specifically designed to have as few implementation dependencies as possible. It is intended to let application
 * developers write:  282 47 2 4363725 7877673 26678837 77647266464 52648243 8428 47 2662877368  25277 22733  625328
 * 67436833  263 773243422559 33744633 86 4283 27 339 46753636828466 337363362437 27 76774253   8 47 46836333 86 538
 * 27754228466 3383567377 97483
 * once,: 6623
 * run: 786
 * anywhere (WORA),meaning that compiled Java code can run on all platforms that support Java without the need for
 * recompilation.Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM)
 * regardless of computer architecture. As of 2016, Java is one of the most popular programming languages in use,
 * particularly for client-server web applications, with a reported 9 million developers.Java was originally developed
 * by James Gosling at Sun Microsystems (which has since been acquired by Oracle Corporation) and released in 1995 as
 * a core component of Sun Microsystems' Java platform. The language derives much of its syntax from C and C++, but it
 * has fewer low-level facilities than either of them.: 26994373        6326464 8428 26674533  282 2633 226 786 66 255
 * 752836767 8428 7877678  282 9484688 843 6333 367 7326674528466  282 277542284667 273 897422559 26674533 86 29832633
 * 8428 226 786 66 269  282 8478825 6224463       7342735377 63 26678837 272448328873   7 63        282 47 663 63 843
 * 6678 7678527 77647266464 526482437 46 873 727842852759 367 254368 737837 932 277542284667  9484 2 73767833
 * 6455466 3383567377  282 927 6744462559 338356733 29  2637  675464 28  86  42767978367  94424 427 74623 2336 22784733
 * 29  72253  6776728466  263 73532733 46      27 2 2673 266766368 63  86  42767978367   282 75283676   43 52648243
 * 3374837 6824 63 487 796829 3766   263      288 48 427 33937 569 53835 3224548437 8426 348437 63 8436
 */
