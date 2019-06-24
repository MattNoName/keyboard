/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

/**
 *
 * @author mattroberts
 */
public class Key {
    
    private KeyType keyType;
    
    private short index;

    public Key(KeyType keyType, short index) {
        this.keyType = keyType;
        this.index = index;
    }

    public KeyType getKeyType() {
        return keyType;
    }

    public short getIndex() {
        return index;
    }
    
    
}
