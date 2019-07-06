
package keyboardmaps;

import javafx.scene.input.KeyCode;

/**
 *
 * @author mattroberts
 */
public interface KeyboardInterface {
    
    public int getIntFromKey(KeyCode key) throws UnusedKeyCodeException;
    
}
