/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardmaps.keys;

import java.util.HashMap;
import javafx.scene.input.KeyCode;

/**
 *
 * @author mattroberts
 */

public class PianoEKeys extends HashMap<KeyCode, Integer>{

    public PianoEKeys() {
        put(KeyCode.A, 4);//E
        put(KeyCode.S, 5);//F
        put(KeyCode.E, 6);//F#
        put(KeyCode.D, 7);//G
        put(KeyCode.R, 8);//G#
        put(KeyCode.F, 9);//A
        put(KeyCode.T, 10);//A#
        put(KeyCode.G, 11);//B
        put(KeyCode.H, 12);//C
        put(KeyCode.U, 13);//C#
        put(KeyCode.J, 14);//D
        put(KeyCode.I, 15);//D#
        put(KeyCode.K, 16);//E
        put(KeyCode.L, 17);//F
        put(KeyCode.P, 18);//F#
        put(KeyCode.SEMICOLON, 19);//G
        put(KeyCode.OPEN_BRACKET, 20);//G#
        put(KeyCode.QUOTE, 21);//A
        put(KeyCode.CLOSE_BRACKET, 22);//A#
    }
    
    
    
}