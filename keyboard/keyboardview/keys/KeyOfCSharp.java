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
public class KeyOfCSharp extends AbstractKeyOf{

     public KeyOfCSharp() {
        keyOfString="C Sharp";
        put(KeyCode.Q, new KeyboardKey(KeyType.TOP_KEY,0));//C#
        put(KeyCode.W, new KeyboardKey(KeyType.TOP_KEY,1));//D#
        put(KeyCode.R, new KeyboardKey(KeyType.TOP_KEY,3));//F#
        put(KeyCode.T, new KeyboardKey(KeyType.TOP_KEY,4));//G#
        put(KeyCode.Y, new KeyboardKey(KeyType.TOP_KEY,5));//A#
        put(KeyCode.I, new KeyboardKey(KeyType.TOP_KEY,6));//C#
        put(KeyCode.O, new KeyboardKey(KeyType.TOP_KEY,7));//D#
        put(KeyCode.P, new KeyboardKey(KeyType.TOP_KEY,9));//F#
        put(KeyCode.OPEN_BRACKET, new KeyboardKey(KeyType.TOP_KEY,10));//G#
        
    }

}
