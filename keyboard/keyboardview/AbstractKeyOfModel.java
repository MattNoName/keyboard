/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.input.KeyCode;
import keyboard.keyboardview.keys.AbstractKeyOf;
import keyboard.keyboardview.keys.BottomKeys;
import keyboard.keyboardview.keys.TopKeys;
import keyboardmappings.UnusedKeyCodeException;

/**
 *
 * @author mattroberts
 */
public abstract class AbstractKeyOfModel {
    
    protected AbstractKeyOf topKeyIndices;
    
    protected HashMap<KeyCode, Integer> bottomKeyMap=new BottomKeys();
    protected HashMap<KeyCode, Integer> topKeyMap=new TopKeys();
    
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
    
    AbstractKeyOf getKeyIndicies(){
        System.out.println("Getting top key indices");
        return topKeyIndices;
    }
    
    abstract protected void setKey(int index);
    
    String getKeyOfString(){
        return topKeyIndices.getKeyOfString();
    }
    
}
