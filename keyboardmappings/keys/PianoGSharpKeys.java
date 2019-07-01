/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardmappings.keys;

import java.util.HashMap;
import javafx.scene.input.KeyCode;

/**
 *
 * @author mattroberts
 */

public class PianoGSharpKeys extends HashMap<KeyCode, Integer>{

    public PianoGSharpKeys() {
        put(KeyCode.W, 8);//G#
        put(KeyCode.S, 9);//A
        put(KeyCode.E, 10);//A#
        put(KeyCode.D, 11);//B
        put(KeyCode.F, 12);//C
        put(KeyCode.T, 13);//C#
        put(KeyCode.G, 14);//D
        put(KeyCode.Y, 15);//D#
        put(KeyCode.H, 16);//E
        put(KeyCode.J, 17);//F
        put(KeyCode.I, 18);//F#
        put(KeyCode.K, 19);//G
        put(KeyCode.O, 20);//G#
        put(KeyCode.L, 19);//A
        put(KeyCode.P, 20);//A#
        put(KeyCode.SEMICOLON, 21);//B
        put(KeyCode.QUOTE, 22);//C
        put(KeyCode.CLOSE_BRACKET, 23);//C#
        put(KeyCode.QUOTE, 24);//D
    }
    
    
    
}