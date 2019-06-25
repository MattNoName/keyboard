/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview;

import java.util.HashMap;
import javafx.scene.input.KeyCode;
import keyboardmappings.UnusedKeyCodeException;

/**
 *
 * @author mattroberts
 */
public class AbstractKeyModel {
    
    protected int octave = 0;

    protected int key = 0;
    
    protected HashMap<KeyCode, Key> keysHashMap=new HashMap<>();
    
    public final Key getKeyFromKeyCode(KeyCode kc) throws UnusedKeyCodeException {
        
        Key foundKey=keysHashMap.get(kc);
        if (foundKey!=null){
            return foundKey;
        }
        throw new UnusedKeyCodeException();
    }
}
