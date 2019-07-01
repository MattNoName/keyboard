/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview.keys;

import java.util.HashMap;
import javafx.scene.input.KeyCode;

/**
 *
 * @author mattroberts
 */
public class TopKeys extends HashMap<KeyCode, Integer>{
    
    public TopKeys(){
        put(KeyCode.Q, 0);
        put(KeyCode.W, 1);
        put(KeyCode.E, 2);
        put(KeyCode.R, 3);
        put(KeyCode.T, 4);
        put(KeyCode.Y, 5);
        put(KeyCode.U, 6);
        put(KeyCode.I, 7);
        put(KeyCode.O, 8);
        put(KeyCode.P, 9);
        put(KeyCode.OPEN_BRACKET, 10);
        put(KeyCode.CLOSE_BRACKET, 11);
    }
}
