package predictive;

/**
 * The following class contains main method for calling overriden method 'signatureToWords' from command - line
 *
 * @author Yashina Valeriya, ID 1603690
 * @version 06/01/2017
 *          <p>
 *          To test how the command-line suggested dictionary is used (name of the file "words.txt").
 *
 *          MacBook-Pro-Valeria:WS2-3 valeria$ java -cp ./out/production/WS2-3/ predictive.Sigs2WordsTree 5427
 *          5427: [[jhar, jibs, khap, khar, khas, kias, kibs, lhar, lhas, liar, lias, libr, libs]
 *
 *          MacBook-Pro-Valeria:WS2-3 valeria$ time java -cp ./out/production/WS2-3 predictive.Sigs2WordsTree 4663
 *          4663: [gnof, gome, gond, gone, good, gooe, goof, home, hond, hone, honf, hood, hooe, hoof, imme, inme,
 *          inne, inod, ione, ioof
 */
public class Sigs2WordsTree {
    public static void main(String[] args) {
        TreeDictionary tree = new TreeDictionary("words.txt");
        for (int i = 0; i < args.length; i++) {
            String str = tree.signatureToWords(args[i]).toString();
            System.out.println(args[i] + ": " + str);
        }
    }
}
    /**
     * Comparing data structure we can notice that the Map implementation is more than twice faster than Tree one.
     * Time consumed for MapDictionary - 0m1.990s
     * Time consumed for TreeDictionary - real	0m4.318s
     * The observed time difference can be explained the fact that in tree implementation we also return prefixes, that means
     * we go through set again adding prefixes of possible matching words.
     *
     * MacBook-Pro-Valeria:WS2-3 valeria$ time java -cp ./out/production/WS2-3/ predictive.Sigs2WordsTree 63127 62783
     * 782 361 4627 137 1357 631 6428 6313 8539 123 3332 2746 6428 1783 7429 7492 42 317 21 6372 4782 212 31 42  1 32
     * 328 429 31 34 45 139 7384
     * No match for the signature
     * 63127: []
     * 62783: [marte, marve, maste, mastf, mcque, obste, ocque]
     * 782: [pta, pua, pub, puc, pva, pvc, qta, qtc, qua, qub, rta, rtc, rua, rub, ruc, sta, stb, stc, sua, sub, suc, sva, svc]
     * No match for the signature
     * 361: []
     * 4627: [gnar, gnas, goar, goas, gobs, hmas, hoar, hoas, hobs, imap, imar, imas, imbr, inap, inar, inbr, incr, iocs]
     * No match for the signature
     * 137: []
     * No match for the signature
     * 1357: []
     * No match for the signature
     * 631: []
     * 6428: [miau, niat, nicu, ogat, ogbu, ohau]
     * No match for the signature
     * 6313: []
     * 8539: [ulex]
     * No match for the signature
     * 123: []
     * 3332: [deda, deea, defa, edda, edea, efec, effa, feda, feeb]
     * 2746: [apho, apin, apio, argo, arhn, arim, arin, ario, asgm, ashm, asho, asim, asin, asio, brim, brin, brio,
     * bsgm, bsin, cpio, crim, crin]
     * 6428: [miau, niat, nicu, ogat, ogbu, ohau]
     * No match for the signature
     * 1783: []
     * 7429: [phay, piaz, ribw, shaw, shay, shaz, siby, sicy]
     * 7492: [piza, qiya, riya, riza, shwa, siwa, siza]
     * 42: [ga, gb, gc, ha, hb, hc, ia, ib, ic]
     No match for the signature
     317: []
     No match for the signature
     21: []
     6372: [mepa, mera, merc, mesa, mesc, nepa, nera, nerc, nesa, nesb, nesc, nfpa, odra]
     4782: [grub]
     No match for the signature
     212: []
     No match for the signature
     31: []
     42: [ga, gb, gc, ha, hb, hc, ia, ib, ic]
     No match for the signature
     1: []
     32: [da, db, dc, ea, eb, ec, fa, fb, fc]
     328: [dat, dau, dav, dbv, dct, dcv, eat, eau, eav, ebu, ect, ecu, ecv, fat, fau, fav, fbv, fct]
     429: [gaw, gay, gaz, gbz, haw, hax, hay, haz, icy]
     No match for the signature
     31: []
     34: [dg, dh, di, eg, eh, ei, fg, fh, fi]
     45: [gk, gl, hj, hk, hl, ij, ik, il]
     No match for the signature
     139: []
     7384: [peth, peti, peug, peuh, pfui, reth, reti, reui, revi, seth, seti, seug, sevi]

     real	0m3.156s
     user	0m6.049s
     sys	0m0.538s
     MacBook-Pro-Valeria:WS2-3 valeria$ time java -cp ./out/production/WS2-3/ predictive.Sigs2WordsMap 63127 62783 782 361 4627 137 1357 631 6428 6313 8539 123 3332 2746 6428 1783 7429 7492 42 317 21 6372 4782 212 31 42  1 32 328 429 31 34 45 139 7384
     63127: []
     62783: [marve, marte, ocque]
     782: [rtc, stb, qtc, ruc, sta, sub, svc, stc, pva, pta, pub, pvc, qua, pua, rta, rub, puc, rua]
     361: []
     4627: [imap, incr, hmas, imas, iocs, gnar, hoar, hobs, goar, gobs, goas]
     137: []
     1357: []
     631: []
     6428: []
     6313: []
     8539: [ulex]
     123: []
     3332: [deda, edda, feeb, edea]
     2746: [argo, asio, apio, brio, ario, brim, crin, arin, brin, cpio, crim]
     6428: []
     1783: []
     7429: [shay, shaw]
     7492: [shwa, riza]
     42: [ia, ha, ib, ga, hb, ic, gb, hc, gc]
     317: []
     21: []
     6372: [mera, nesc, mesa, odra, mepa, merc, nfpa, nepa, nerc]
     4782: [grub]
     212: []
     31: []
     42: [ia, ha, ib, ga, hb, ic, gb, hc, gc]
     1: []
     32: [fa, ea, fb, da, eb, fc, db, ec, dc]
     328: [dct, dat, ecu, fct, ect, dav, eau, fat, dau, dbv, eat, ecv, fbv]
     429: [gaz, hay, gaw, gay, gbz, hax, icy, haw]
     31: []
     34: [fg, eg, dg, eh, fi, dh, ei, di]
     45: [ij, hj, ik, hk, il, gk, hl, gl]
     139: []
     7384: [seti, seth, peti, pfui]

     real	0m1.990s
     user	0m3.376s
     sys	0m0.450s
     */


