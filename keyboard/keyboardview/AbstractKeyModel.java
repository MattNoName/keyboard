/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview;

import keyboard.keyboardview.keys.KeyboardKey;
import keyboard.keyboardview.keys.KeyType;
import java.util.HashMap;
import javafx.scene.input.KeyCode;
import keyboard.keyboardview.keys.AbstractKey;
import keyboard.keyboardview.keys.BottomKeys;
import keyboard.keyboardview.keys.TopKeys;
import keyboardmaps.UnusedKeyCodeException;

/**
 *
 * @author mattroberts
 */
public abstract class AbstractKeyModel {
    
    protected String name;
    
    protected int key=0;
    
    protected int octave=0;
    
    protected AbstractKey topKeyIndices;
    
    protected HashMap<KeyCode, Integer> bottomKeyMap=new BottomKeys();
    protected HashMap<KeyCode, Integer> topKeyMap=new TopKeys();
    
    protected String [] octaves={"-2", "-1", "", "+1", "+2"};

    public AbstractKeyModel() {
        
    }
    
    public AbstractKeyModel(AbstractKeyModel abkm) {
        key=abkm.getKey();
    }
    
    public final KeyboardKey getKeyFromKeyCode(KeyCode kc) throws UnusedKeyCodeException {
        
        Integer foundKey=bottomKeyMap.get(kc);
        if (foundKey!=null){
            return new KeyboardKey(KeyType.BOTTOM_KEY, foundKey);
        }
        foundKey=topKeyMap.get(kc);
        if (foundKey!=null){
            return new KeyboardKey(KeyType.TOP_KEY, foundKey);
        }
        throw new UnusedKeyCodeException();
    }
    
    AbstractKey getKeyIndicies(){
        return topKeyIndices;
    }
    
    abstract protected void setKey(int index);
    
    protected void setOctave(int octave){
        this.octave=octave-3;
    }
    
    public String getOctaveString(){
        return octaves[this.octave];
    }
    
    protected void setKeyboard(int octave){
        this.octave=octave-3;
    }

    public int getKey() {
        return key;
    }
    
    String getKeyOfString(){
        return topKeyIndices.getKeyOfString();
    }

    public String getName() {
        return name;
    }
    
    
    
}
