/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview.keys;

import keyboard.keyboardview.KeyboardKey;
import keyboard.keyboardview.KeyType;
import javafx.scene.input.KeyCode;

/**
 *
 * @author mattroberts
 */
public class KeyOfC extends AbstractKeyOf{
    
    
    public KeyOfC() {
        keyOfString="C";
        put(KeyCode.W, new KeyboardKey(KeyType.TOP_KEY,1));//C#
        put(KeyCode.E, new KeyboardKey(KeyType.TOP_KEY,2));//D#
        put(KeyCode.T, new KeyboardKey(KeyType.TOP_KEY,4));//F#
        put(KeyCode.Y, new KeyboardKey(KeyType.TOP_KEY,5));//G#
        put(KeyCode.U, new KeyboardKey(KeyType.TOP_KEY,6));//A#
        put(KeyCode.O, new KeyboardKey(KeyType.TOP_KEY,8));//C#
        put(KeyCode.P, new KeyboardKey(KeyType.TOP_KEY,9));//D#
        put(KeyCode.CLOSE_BRACKET, new KeyboardKey(KeyType.TOP_KEY,11));//F#
    }
    
}
