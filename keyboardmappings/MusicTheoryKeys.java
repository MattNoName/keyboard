/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardmappings;

import java.util.HashMap;
import javafx.scene.input.KeyCode;

/**
 *
 * @author mattroberts
 */
public class MusicTheoryKeys extends HashMap<KeyCode, Integer> {

    public MusicTheoryKeys(){
        put(KeyCode.TAB, -12);
        put(KeyCode.Q, -11);
        put(KeyCode.A, -10);
        put(KeyCode.W, -9);
        put(KeyCode.S, -8);
        put(KeyCode.E, -7);
        put(KeyCode.D, -6);
        put(KeyCode.R, -5);
        put(KeyCode.F, -4);
        put(KeyCode.T, -3);
        put(KeyCode.G, -2);
        put(KeyCode.Y, -1);
        put(KeyCode.H, 0);
        put(KeyCode.U, 1);
        put(KeyCode.J, 2);
        put(KeyCode.I, 3);
        put(KeyCode.K, 4);
        put(KeyCode.O, 5);
        put(KeyCode.L, 6);
        put(KeyCode.P, 7);
        put(KeyCode.SEMICOLON, 8);
        put(KeyCode.OPEN_BRACKET, 9);
        put(KeyCode.QUOTE, 10);
        put(KeyCode.CLOSE_BRACKET, 11);
        put(KeyCode.BACK_SLASH, 12);
    }
}
