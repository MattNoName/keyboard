
package keyboardmappings;

/**
 *
 * @author mattroberts
 */
public class UnusedKeyCodeException extends Exception{

    public UnusedKeyCodeException() {
    }

    public UnusedKeyCodeException(String message) {
        super(message);
    }
    
}
