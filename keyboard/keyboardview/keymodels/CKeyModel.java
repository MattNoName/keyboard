/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview.keymodels;

import java.util.HashMap;
import javafx.scene.input.KeyCode;
import keyboard.keyboardview.Key;
import keyboard.keyboardview.KeyType;

/**
 *
 * @author mattroberts
 */
public class CKeyModel extends HashMap<KeyCode, Key>{
    
    public CKeyModel() {
        put(KeyCode.A, new Key(KeyType.BOTTOM_KEY,0,'A'));//C
        put(KeyCode.W, new Key(KeyType.TOP_KEY,1,'W'));//C#
        put(KeyCode.S, new Key(KeyType.BOTTOM_KEY,1,'S'));//D
        put(KeyCode.E, new Key(KeyType.TOP_KEY,2,'E'));//D#
        put(KeyCode.D, new Key(KeyType.BOTTOM_KEY,2,'D'));//E
        put(KeyCode.F, new Key(KeyType.BOTTOM_KEY,3,'F'));//F
        put(KeyCode.T, new Key(KeyType.TOP_KEY,4,'T'));//F#
        put(KeyCode.G, new Key(KeyType.BOTTOM_KEY,4,'G'));//G
        put(KeyCode.Y, new Key(KeyType.TOP_KEY,5,'Y'));//G#
        put(KeyCode.H, new Key(KeyType.BOTTOM_KEY,5,'H'));//A
        put(KeyCode.U, new Key(KeyType.TOP_KEY,6,'U'));//A#
        put(KeyCode.J, new Key(KeyType.BOTTOM_KEY,6,'J'));//B
        put(KeyCode.K, new Key(KeyType.BOTTOM_KEY,7,'K'));//C
        put(KeyCode.O, new Key(KeyType.TOP_KEY,8,'O'));//C#
        put(KeyCode.L, new Key(KeyType.BOTTOM_KEY,8,'L'));//D
        put(KeyCode.P, new Key(KeyType.TOP_KEY,9,'P'));//D#
        put(KeyCode.SEMICOLON, new Key(KeyType.BOTTOM_KEY,9,';'));//E
        put(KeyCode.QUOTE, new Key(KeyType.BOTTOM_KEY,10,'\''));//F
        put(KeyCode.CLOSE_BRACKET, new Key(KeyType.TOP_KEY,11,']'));//F#
    }
    
}
