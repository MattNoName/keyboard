
package keyboard.keyboardview;

import java.util.HashMap;
import javafx.scene.input.KeyCode;
import keyboard.keyboardview.keys.AbstractKeyOf;
import keyboard.keyboardview.keys.KeyOfC;
import keyboard.keyboardview.keys.KeyOfCSharp;
import keyboard.keyboardview.keys.KeyOfD;
import keyboard.keyboardview.keys.KeyOfDSharp;

/**
 *
 * @author mattroberts
 */
public class PianoKeyModel extends AbstractKeyOfModel{
    
    private HashMap<Integer, AbstractKeyOf> hashMapOfKeysHashMap=new HashMap<>();
    
    public PianoKeyModel(){
        setUpKeyHashMaps();
    }
    
    @Override
    protected void setKey(int key){
        keysHashMap=hashMapOfKeysHashMap.get(key);
    }
    
    private void putKeyHashMaps(){
        hashMapOfKeysHashMap.put(0, new KeyOfC());
        hashMapOfKeysHashMap.put(1, new KeyOfCSharp());
        hashMapOfKeysHashMap.put(2, new KeyOfD());
        hashMapOfKeysHashMap.put(3, new KeyOfDSharp());
    }
    
    private void setUpKeyHashMaps(){
        putKeyHashMaps();
        setKey(0);
    }
    
}
