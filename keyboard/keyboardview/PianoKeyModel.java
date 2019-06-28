
package keyboard.keyboardview;

import java.util.HashMap;
import javafx.scene.input.KeyCode;
import keyboard.keyboardview.keys.CKey;

/**
 *
 * @author mattroberts
 */
public class PianoKeyModel extends AbstractKeyModel{
    
    private HashMap<Integer, HashMap<KeyCode, KeyboardKey>> hashMapOfKeysHashMap=new HashMap<>();
    
    public PianoKeyModel(){
        setUpKeyHashMaps();
    }
    
    private void setKey(int key){
        keysHashMap=hashMapOfKeysHashMap.get(key);
    }
    
    private void putKeyHashMaps(){
        hashMapOfKeysHashMap.put(0, new CKey());
    }
    
    private void setUpKeyHashMaps(){
        putKeyHashMaps();
        setKey(0);
    }
}
