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

public class PianoBKeys extends HashMap<KeyCode, Integer>{

    public PianoBKeys() {
        put(KeyCode.A, 11);//B
        put(KeyCode.S, 12);//C
        put(KeyCode.E, 13);//C#
        put(KeyCode.D, 14);//D
        put(KeyCode.R, 15);//D#
        put(KeyCode.F, 16);//E
        put(KeyCode.G, 17);//F
        put(KeyCode.Y, 18);//F#
        put(KeyCode.H, 19);//G
        put(KeyCode.U, 20);//G#
        put(KeyCode.J, 21);//A
        put(KeyCode.I, 22);//A#
        put(KeyCode.K, 23);//B
        put(KeyCode.L, 24);//C
        put(KeyCode.P, 25);//C#
        put(KeyCode.SEMICOLON, 26);//D
        put(KeyCode.OPEN_BRACKET, 27);//D#
        put(KeyCode.QUOTE, 28);//E
    }
    
    
    
}