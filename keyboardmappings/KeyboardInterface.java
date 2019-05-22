/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardmappings;

import javafx.scene.input.KeyCode;

/**
 *
 * @author mattroberts
 */
public interface KeyboardInterface {
    
    public int getIntFromKey(KeyCode key) throws UnusedKeyCodeException;
    
}
