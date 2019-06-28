/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview.keys;

import java.util.HashMap;
import javafx.scene.input.KeyCode;
import keyboard.keyboardview.KeyType;
import keyboard.keyboardview.KeyboardKey;

/**
 *
 * @author mattroberts
 */
public abstract class AbstractKeyOf extends HashMap<KeyCode, KeyboardKey>{
    
    protected String keyOfString="";
    
    public AbstractKeyOf(){
        put(KeyCode.A, new KeyboardKey(KeyType.BOTTOM_KEY,0));//C
        put(KeyCode.S, new KeyboardKey(KeyType.BOTTOM_KEY,1));//D
        put(KeyCode.D, new KeyboardKey(KeyType.BOTTOM_KEY,2));//E
        put(KeyCode.F, new KeyboardKey(KeyType.BOTTOM_KEY,3));//F
        put(KeyCode.G, new KeyboardKey(KeyType.BOTTOM_KEY,4));//G
        put(KeyCode.H, new KeyboardKey(KeyType.BOTTOM_KEY,5));//A
        put(KeyCode.J, new KeyboardKey(KeyType.BOTTOM_KEY,6));//B
        put(KeyCode.K, new KeyboardKey(KeyType.BOTTOM_KEY,7));//C
        put(KeyCode.L, new KeyboardKey(KeyType.BOTTOM_KEY,8));//D
        put(KeyCode.SEMICOLON, new KeyboardKey(KeyType.BOTTOM_KEY,9));//E
        put(KeyCode.QUOTE, new KeyboardKey(KeyType.BOTTOM_KEY,10));//F
    }

    public String getKeyOfString() {
        return keyOfString;
    }
    
    
}
