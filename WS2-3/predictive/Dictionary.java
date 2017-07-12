package predictive;
import java.util.Set;

/**
 * Interface to be implemented in the classes containing higher fidelity prototype
 *
 * @author Yashina Valeriya, ID 1603690
 * @version 31/01/2017.
 */
public interface Dictionary {
    public Set<String> signatureToWords(String signature);
}
