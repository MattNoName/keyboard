/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview.keys;

import keyboard.keyboardview.KeyboardKey;
import keyboard.keyboardview.KeyType;
import java.util.HashMap;
import javafx.scene.input.KeyCode;

/**
 *
 * @author mattroberts
 */
public class CKey extends AbstractKey{
    
    public CKey() {
        put(KeyCode.W, new KeyboardKey(KeyType.TOP_KEY,1,'W'));//C#
        put(KeyCode.E, new KeyboardKey(KeyType.TOP_KEY,2,'E'));//D#
        put(KeyCode.T, new KeyboardKey(KeyType.TOP_KEY,4,'T'));//F#
        put(KeyCode.Y, new KeyboardKey(KeyType.TOP_KEY,5,'Y'));//G#
        put(KeyCode.U, new KeyboardKey(KeyType.TOP_KEY,6,'U'));//A#
        put(KeyCode.O, new KeyboardKey(KeyType.TOP_KEY,8,'O'));//C#
        put(KeyCode.P, new KeyboardKey(KeyType.TOP_KEY,9,'P'));//D#
        put(KeyCode.CLOSE_BRACKET, new KeyboardKey(KeyType.TOP_KEY,11,']'));//F#
    }
    
}
