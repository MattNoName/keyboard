/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview;

import java.util.Collection;
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
    
    protected HashMap<KeyCode, KeyboardKey> keysHashMap=new HashMap<>();
    
    public final KeyboardKey getKeyFromKeyCode(KeyCode kc) throws UnusedKeyCodeException {
        
        KeyboardKey foundKey=keysHashMap.get(kc);
        if (foundKey!=null){
            return foundKey;
        }
        throw new UnusedKeyCodeException();
    }
    
    Collection<KeyboardKey> getSetOfKeys(){
        return keysHashMap.values();
    }
}
