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
        put(KeyCode.Q, 8);//G#
        put(KeyCode.A, 9);//A
        put(KeyCode.W, 10);//A#
        put(KeyCode.S, 11);//B
        put(KeyCode.D, 12);//C
        put(KeyCode.R, 13);//C#
        put(KeyCode.F, 14);//D
        put(KeyCode.T, 15);//D#
        put(KeyCode.G, 16);//E
        put(KeyCode.H, 17);//F
        put(KeyCode.U, 18);//F#
        put(KeyCode.J, 19);//G
        put(KeyCode.I, 20);//G#
        put(KeyCode.K, 21);//A
        put(KeyCode.O, 22);//A#
        put(KeyCode.L, 23);//B
        put(KeyCode.SEMICOLON, 24);//C
        put(KeyCode.OPEN_BRACKET, 25);//C#
        put(KeyCode.QUOTE, 26);//D
        put(KeyCode.CLOSE_BRACKET, 27);//E#
    }
    
    
    
}