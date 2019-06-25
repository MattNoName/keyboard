
package keyboard.keyboardview;

import java.util.HashMap;
import javafx.scene.input.KeyCode;
import keyboard.keyboardview.keymodels.CKeyModel;

/**
 *
 * @author mattroberts
 */
public class PianoKeyModel extends AbstractKeyModel{
    
    private HashMap<Integer, HashMap<KeyCode, Key>> hashMapOfKeysHashMap=new HashMap<>();
    
    private void setKey(int key){
        keysHashMap=hashMapOfKeysHashMap.get(key);
    }
    
    protected void putKeyHashMaps(){
        hashMapOfKeysHashMap.put(0, new CKeyModel());
    }
}
