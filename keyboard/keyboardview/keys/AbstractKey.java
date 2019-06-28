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
public class AbstractKey extends HashMap<KeyCode, KeyboardKey>{
    
    AbstractKey(){
        put(KeyCode.A, new KeyboardKey(KeyType.BOTTOM_KEY,0,'A'));//C
        put(KeyCode.S, new KeyboardKey(KeyType.BOTTOM_KEY,1,'S'));//D
        put(KeyCode.D, new KeyboardKey(KeyType.BOTTOM_KEY,2,'D'));//E
        put(KeyCode.F, new KeyboardKey(KeyType.BOTTOM_KEY,3,'F'));//F
        put(KeyCode.G, new KeyboardKey(KeyType.BOTTOM_KEY,4,'G'));//G
        put(KeyCode.H, new KeyboardKey(KeyType.BOTTOM_KEY,5,'H'));//A
        put(KeyCode.J, new KeyboardKey(KeyType.BOTTOM_KEY,6,'J'));//B
        put(KeyCode.K, new KeyboardKey(KeyType.BOTTOM_KEY,7,'K'));//C
        put(KeyCode.L, new KeyboardKey(KeyType.BOTTOM_KEY,8,'L'));//D
        put(KeyCode.SEMICOLON, new KeyboardKey(KeyType.BOTTOM_KEY,9,';'));//E
        put(KeyCode.QUOTE, new KeyboardKey(KeyType.BOTTOM_KEY,10,'\''));//F
    }
}
