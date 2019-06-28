/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview;

import keyboard.keyboardview.KeyType;

/**
 *
 * @author mattroberts
 */
public class KeyboardKey {
    
    private KeyType keyType;
    
    private int index;

    public KeyboardKey(KeyType keyType, int index) {
        this.keyType = keyType;
        this.index = index;
    }

    public KeyType getKeyType() {
        return keyType;
    }

    public int getIndex() {
        return index;
    }
    
}
