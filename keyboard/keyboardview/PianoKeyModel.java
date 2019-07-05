
package keyboard.keyboardview;

import java.util.HashMap;
import keyboard.keyboardview.keys.AbstractKey;
import keyboard.keyboardview.keys.KeyOfA;
import keyboard.keyboardview.keys.KeyOfASharp;
import keyboard.keyboardview.keys.KeyOfB;
import keyboard.keyboardview.keys.KeyOfC;
import keyboard.keyboardview.keys.KeyOfCSharp;
import keyboard.keyboardview.keys.KeyOfD;
import keyboard.keyboardview.keys.KeyOfDSharp;
import keyboard.keyboardview.keys.KeyOfE;
import keyboard.keyboardview.keys.KeyOfF;
import keyboard.keyboardview.keys.KeyOfFSharp;
import keyboard.keyboardview.keys.KeyOfG;
import keyboard.keyboardview.keys.KeyOfGSharp;

/**
 *
 * @author mattroberts
 */
public class PianoKeyModel extends AbstractKeyModel{
    
    private HashMap<Integer, AbstractKey> hashMapOfKeysHashMap=new HashMap<>();
    
    public PianoKeyModel(){
        setUpKeyboard();
    }
    
    public PianoKeyModel(AbstractKeyModel abkm) {
        super(abkm);
        setUpKeyboard();
    }
    
    @Override
    protected void setKey(int key){
        this.key=key;
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
        hashMapOfKeysHashMap.put(8, new KeyOfGSharp());
        hashMapOfKeysHashMap.put(9, new KeyOfA());
        hashMapOfKeysHashMap.put(10, new KeyOfASharp());
        hashMapOfKeysHashMap.put(11, new KeyOfB());
    }
    
    private void setUpKeyboard(){
        name="Piano Keyboard";
        putKeyHashMaps();
        setKey(0);
    }
    
    
}
