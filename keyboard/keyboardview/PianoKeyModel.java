
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
    
    public PianoKeyModel(){
        setUpKeyHashMaps();
    }
    
    private void setKey(int key){
        keysHashMap=hashMapOfKeysHashMap.get(key);
    }
    
    private void putKeyHashMaps(){
        hashMapOfKeysHashMap.put(0, new CKeyModel());
    }
    
    private void setUpKeyHashMaps(){
        putKeyHashMaps();
        setKey(0);
    }
}
