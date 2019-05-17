/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import java.util.HashMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;

/**
 *
 * @author mattroberts
 */
public class KeyboardModel {
    
    private HashMap<String, Boolean> keyDown=new HashMap<>();

    public KeyboardModel() {
        KeyCode [] keyCodes=KeyCode.values();
        for (KeyCode kc: keyCodes){
            keyDown.put(kc.getName(), Boolean.FALSE);
        }
    }
    
    
    
    private boolean isKeyPressed(KeyCode kc){
            return keyDown.get(kc.getName());
    }
    
    private void updateKeyPressed(KeyCode kc, boolean yes){
            keyDown.put(kc.getName(), yes);
    }

    /**
     *
     * @param key the key
     */
    private int getEMajorIntFromKey(KeyCode key) throws UnusedKeyCodeException {
        switch (key) {
            case A:
                return -8;
            case S:
                return -7;
            case E:
                return -6;
            case D:
                return -5;
            case R:
                return -3;
            case F:
                return -2;
            case G:
                return -1;
            case H:
                return 0;
            case U:
                return 1;
            case J:
                return 2;
            case I:
                return 3;
            case K:
                return 4;
            case L:
                return 5;
            case P:
                return 6;
            case SEMICOLON:
                return 7;
            case BRACELEFT:
                return 8;
            case QUOTE:
                return 9;
            case BRACERIGHT:
                return 10;
        }
        throw new UnusedKeyCodeException();
    }
    
    private int getCMajorIntFromKey(KeyCode key) throws UnusedKeyCodeException {
        switch (key) {
            case A:
                return 0;
            case W:
                return 1;
            case S:
                return 2;
            case E:
                return 3;
            case D:
                return 4;
            case F:
                return 5;
            case T:
                return 6;
            case G:
                return 7;
            case Y:
                return 8;
            case H:
                return 9;
            case U:
                return 10;
            case J:
                return 11;
            case K:
                return 12;
            case O:
                return 13;
            case L:
                return 14;
            case P:
                return 15;
            case SEMICOLON:
                return 16;
            case QUOTE:
                return 17;
            case CLOSE_BRACKET:
                return 18;
        }
        
        throw new UnusedKeyCodeException();
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
    
    public ShortMessage respondToKeyPressed(KeyEvent keyEvent)throws UnusedKeyCodeException, 
            InvalidMidiDataException, MidiUnavailableException{
        KeyCode kc=keyEvent.getCode();
        if (isKeyPressed(kc)){
            updateKeyPressed(kc, true);
            return null;
        }else{
            updateKeyPressed(kc, true);
            return getNoteMessage(getNoteCode(getCMajorIntFromKey(keyEvent.getCode())));
        }
    }
    
    public void respondToKeyReleased(KeyEvent keyEvent){
        KeyCode kc=keyEvent.getCode();
        updateKeyPressed(kc, false);
        
    }
}
