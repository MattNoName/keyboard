/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import keymappings.KeyboardType;
import keymappings.UnusedKeyCodeException;
import java.util.HashMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;
import keymappings.KeyboardInterface;
import keymappings.MusicTheoryKeyboard;
import keymappings.TraditionalKeyboard;

/**
 *
 * @author mattroberts
 */
public class KeyboardModel {
    
    private HashMap<String, Boolean> keyDown=new HashMap<>();
    
    private KeyboardInterface keyboard;

    public KeyboardModel() {
        KeyCode [] keyCodes=KeyCode.values();
        for (KeyCode kc: keyCodes){
            keyDown.put(kc.getName(), Boolean.FALSE);
        }
        keyboard=new TraditionalKeyboard();
    }
    
    public void setKeyboard(KeyboardType kt){
        if (kt==KeyboardType.TRADITIONAL){
            keyboard=new TraditionalKeyboard();
        }
        else{
            keyboard=new MusicTheoryKeyboard();
        }
        
    }
    
    
    
    
    
    private boolean isKeyPressed(KeyCode kc){
            return keyDown.get(kc.getName());
    }
    
    private void updateKeyPressed(KeyCode kc, boolean yes){
            keyDown.put(kc.getName(), yes);
    }

    
    
    

    private int getNoteCode(int input) {
        return input + 60;
    }

    private ShortMessage getNoteMessage(int noteCode)
            throws InvalidMidiDataException, MidiUnavailableException {
        ShortMessage noteMessage = new ShortMessage();
        noteMessage.setMessage(ShortMessage.NOTE_ON, 4, noteCode, 70);
        return noteMessage;
    }
    
    public ShortMessage respondToKeyPressed(KeyEvent keyEvent) throws UnusedKeyCodeException, 
            InvalidMidiDataException, MidiUnavailableException{
        KeyCode kc=keyEvent.getCode();
        if (isKeyPressed(kc)){
            updateKeyPressed(kc, true);
            return null;
        }else{
            updateKeyPressed(kc, true);
            return getNoteMessage(getNoteCode(keyboard.getIntFromKey(keyEvent.getCode())));
        }
    }
    
    public void respondToKeyReleased(KeyEvent keyEvent){
        KeyCode kc=keyEvent.getCode();
        updateKeyPressed(kc, false);
        
    }
}
