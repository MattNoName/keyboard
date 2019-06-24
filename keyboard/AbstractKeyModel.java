/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import java.util.HashMap;
import javafx.scene.input.KeyCode;

/**
 *
 * @author mattroberts
 */
public class AbstractKeyModel {
    
    protected int octave = 0;

    protected int key = 0;
    
    private HashMap<Integer, HashMap<KeyCode, Key>> keysHashMap=new HashMap<>();
}
