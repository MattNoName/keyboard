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
public class MusicTheoryKeyModel extends AbstractKeyOfModel{

    public MusicTheoryKeyModel() {
        setUpKeys();
    }
    
    public MusicTheoryKeyModel(AbstractKeyOfModel abkm) {
        super(abkm);
        setUpKeys();
    }
    
    private void setUpKeys(){
        topKeyIndices=new MusicTheoryKeys();
    }
    
    @Override
    protected void setKey(int index) {
        this.key=index;
        ((MusicTheoryKeys)topKeyIndices).setKey(index);
    }

}
