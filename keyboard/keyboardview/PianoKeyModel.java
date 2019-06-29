
package keyboard.keyboardview;

import java.util.HashMap;
import keyboard.keyboardview.keys.AbstractKeyOf;
import keyboard.keyboardview.keys.KeyOfC;
import keyboard.keyboardview.keys.KeyOfCSharp;
import keyboard.keyboardview.keys.KeyOfD;
import keyboard.keyboardview.keys.KeyOfDSharp;
import keyboard.keyboardview.keys.KeyOfE;
import keyboard.keyboardview.keys.KeyOfF;
import keyboard.keyboardview.keys.KeyOfFSharp;
import keyboard.keyboardview.keys.KeyOfG;

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
        topKeyIndices=hashMapOfKeysHashMap.get(key);
    }
    
    private void putKeyHashMaps(){
        hashMapOfKeysHashMap.put(0, new KeyOfC());
        hashMapOfKeysHashMap.put(1, new KeyOfCSharp());
        hashMapOfKeysHashMap.put(2, new KeyOfD());
        hashMapOfKeysHashMap.put(3, new KeyOfDSharp());
        hashMapOfKeysHashMap.put(4, new KeyOfE());
        hashMapOfKeysHashMap.put(5, new KeyOfF());
        hashMapOfKeysHashMap.put(6, new KeyOfFSharp());
        hashMapOfKeysHashMap.put(7, new KeyOfG());
    }
    
    private void setUpKeyHashMaps(){
        putKeyHashMaps();
        setKey(0);
    }
    
    
}
