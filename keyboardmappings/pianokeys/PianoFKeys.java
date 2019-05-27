/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardmappings.pianokeys;

import java.util.HashMap;
import javafx.scene.input.KeyCode;

/**
 *
 * @author mattroberts
 */

public class PianoFKeys extends HashMap<KeyCode, Integer>{

    public PianoFKeys() {
        put(KeyCode.A, 5);//F
        put(KeyCode.W, 6);//F#
        put(KeyCode.S, 7);//G
        put(KeyCode.E, 8);//G#
        put(KeyCode.D, 9);//A
        put(KeyCode.R, 10);//A#
        put(KeyCode.F, 11);//B
        put(KeyCode.G, 12);//C
        put(KeyCode.Y, 13);//C#
        put(KeyCode.H, 14);//D
        put(KeyCode.U, 15);//D#
        put(KeyCode.J, 16);//E
        put(KeyCode.K, 17);//F
        put(KeyCode.O, 18);//F#
        put(KeyCode.L, 19);//G
        put(KeyCode.P, 20);//G#
        put(KeyCode.SEMICOLON, 21);//A
        put(KeyCode.OPEN_BRACKET, 22);//A#
        put(KeyCode.QUOTE, 23);//B
        put(KeyCode.OPEN_BRACKET, 24);//C
    }
    
    
    
}