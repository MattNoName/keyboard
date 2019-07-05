/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview;

import keyboard.keyboardview.keys.MusicTheoryKeys;

/**
 *
 * @author mattroberts
 */
public class MusicTheoryKeyModel extends AbstractKeyModel{

    public MusicTheoryKeyModel() {
        setUpKeyboard();
    }
    
    public MusicTheoryKeyModel(AbstractKeyModel abkm) {
        super(abkm);
        setUpKeyboard();
    }
    
    private void setUpKeyboard(){
        name="Music Theory Keyboard";
        topKeyIndices=new MusicTheoryKeys();
    }
    
    @Override
    protected void setKey(int index) {
        this.key=index;
        ((MusicTheoryKeys)topKeyIndices).setKey(index);
    }

}
