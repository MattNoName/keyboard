/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview.keys;

import javafx.scene.input.KeyCode;
import keyboard.keyboardview.KeyType;
import keyboard.keyboardview.KeyboardKey;

/**
 *
 * @author mattroberts
 */
public class KeyOfD extends AbstractKeyOf{
    
    public KeyOfD() {
        keyOfString="D";
        put(KeyCode.W, new KeyboardKey(KeyType.TOP_KEY,1));//D#
        put(KeyCode.R, new KeyboardKey(KeyType.TOP_KEY,3));//G#
        put(KeyCode.T, new KeyboardKey(KeyType.TOP_KEY,4));//A#
        put(KeyCode.Y, new KeyboardKey(KeyType.TOP_KEY,5));//C#
        put(KeyCode.I, new KeyboardKey(KeyType.TOP_KEY,7));//D#
        put(KeyCode.O, new KeyboardKey(KeyType.TOP_KEY,8));//F#
        put(KeyCode.OPEN_BRACKET, new KeyboardKey(KeyType.TOP_KEY,10));//G#
        put(KeyCode.CLOSE_BRACKET, new KeyboardKey(KeyType.TOP_KEY,11));//A#
        
    }
}
