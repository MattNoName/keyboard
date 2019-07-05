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
public class BottomKeys extends HashMap<KeyCode, Integer>{
    
    public BottomKeys(){
        put(KeyCode.A, 0);
        put(KeyCode.S, 1);
        put(KeyCode.D, 2);
        put(KeyCode.F, 3);
        put(KeyCode.G, 4);
        put(KeyCode.H, 5);
        put(KeyCode.J, 6);
        put(KeyCode.K, 7);
        put(KeyCode.L, 8);
        put(KeyCode.SEMICOLON, 9);
        put(KeyCode.QUOTE, 10);
    }
    
}
