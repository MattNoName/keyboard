/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import keyboardmappings.MusicTheoryKeyboard;

/**
 *
 * @author mattroberts
 */
public class KeyboardViewModel {
    
    private AbstractKeyOfModel keyModel;

    public KeyboardViewModel() {
        this.keyModel = new PianoKeyModel();
    }

    public AbstractKeyOfModel getKeyModel() {
        return keyModel;
    }
    
    void updateKeyboard(KeyEvent keyEvent){
        KeyCode kc=keyEvent.getCode();
        switch(kc){
            case M:
                keyModel=new MusicTheoryKeyModel(keyModel);
                return;
            case N:
                keyModel=new PianoKeyModel(keyModel);            
        }
    }
    
}
