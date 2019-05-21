/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import java.util.ArrayList;
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

    private final HashMap<Integer, Boolean> keyDown = new HashMap<>();
    private final HashMap<Integer, Boolean> sustenatoNotes = new HashMap<>();

    private KeyboardInterface keyboard;

    private boolean sustaining = false;

    private final short NOTE_TRANSLATION_CONSTANT = 60;

    public KeyboardModel() {
        for (int i = -100; i < 100; i++) {
            keyDown.put(i, Boolean.FALSE);
        }
        /*
        KeyCode [] keyCodes=KeyCode.values();
        for (KeyCode kc: keyCodes){
            keyDown.put(kc.getName(), Boolean.FALSE);
        }
         */
        keyboard = new TraditionalKeyboard();
    }

    public void setKeyboard(KeyboardType kt) {
        System.out.println("Setting keyboard");
        if (kt == KeyboardType.TRADITIONAL) {
            keyboard = new TraditionalKeyboard();
            System.out.println("Traditional");
        } else {
            keyboard = new MusicTheoryKeyboard();
            System.out.println("Music Theory");
        }

    }

    /*
    private boolean isKeyPressed(KeyCode kc){
            return keyDown.get(kc.getName());
    }
    
    private void updateKeyPressed(KeyCode kc, boolean yes){
            keyDown.put(kc.getName(), yes);
    }

    private int getNoteCode(int input) {
        return input + 60;
    }
     */
    private ShortMessage getNoteOnMessage(int noteCode)
            throws InvalidMidiDataException, MidiUnavailableException {
        ShortMessage noteMessage = new ShortMessage();
        noteMessage.setMessage(ShortMessage.NOTE_ON, 4,
                noteCode + NOTE_TRANSLATION_CONSTANT, 70);
        return noteMessage;
    }

    private ShortMessage getNoteOffMessage(int noteCode)
            throws InvalidMidiDataException, MidiUnavailableException {
        ShortMessage noteMessage = new ShortMessage();
        noteMessage.setMessage(ShortMessage.NOTE_OFF, 4,
                noteCode + NOTE_TRANSLATION_CONSTANT, 0);
        return noteMessage;
    }

    public ArrayList<ShortMessage> respondToPedalsDown(KeyEvent keyEvent) throws
            InvalidMidiDataException, MidiUnavailableException {
        KeyCode kc = keyEvent.getCode();
        switch (kc) {
            case CAPS:
                if (!sustaining) {
                    sustaining = true;
                    return null;
                } else {
                    sustaining = false;
                    ArrayList<ShortMessage> notesOffArrayList = new ArrayList<>();
                    for (Integer i : sustenatoNotes.keySet()) {
                        if (!keyDown.get(i)) {
                            sustenatoNotes.put(i, false);
                            notesOffArrayList.add(getNoteOffMessage(i));
                        }
                    }
                    return notesOffArrayList;
                }
               
        }
        return null;
    }

    public void respondToPedalUp(KeyEvent keyEvent) {
        KeyCode kc = keyEvent.getCode();
    }

    public ShortMessage respondToKeyPressed(KeyEvent keyEvent) throws UnusedKeyCodeException,
            InvalidMidiDataException, MidiUnavailableException {
        int noteCode = keyboard.getIntFromKey(keyEvent.getCode());
        //KeyCode kc=keyEvent.getCode();
        if (keyDown.get(noteCode)) {
            //updateKeyPressed(kc, true);
            //keyDown.put(noteCode, true);
            return null;
        } else {
            //updateKeyPressed(kc, true);
            keyDown.put(noteCode, true);
            sustenatoNotes.put(noteCode, true);
            return getNoteOnMessage(noteCode);
        }
    }

    public ShortMessage respondToKeyReleased(KeyEvent keyEvent) throws UnusedKeyCodeException,
            InvalidMidiDataException, MidiUnavailableException {
        //KeyCode kc=keyEvent.getCode();
        int noteCode = keyboard.getIntFromKey(keyEvent.getCode());
        //updateKeyPressed(kc, false);
        keyDown.put(noteCode, false);
        if (sustaining) {
            throw new UnusedKeyCodeException();
        }
        return getNoteOffMessage(noteCode);

    }
}
