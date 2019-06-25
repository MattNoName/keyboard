/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview;

/**
 *
 * @author mattroberts
 */
public class Key {
    
    private KeyType keyType;
    
    private int index;
    
    private char character;

    public Key(KeyType keyType, int index, char character) {
        this.keyType = keyType;
        this.index = index;
        this.character=character;
    }

    public KeyType getKeyType() {
        return keyType;
    }

    public int getIndex() {
        return index;
    }
    
    public char getCharacter() {
        return character;
    }
    
    
}
