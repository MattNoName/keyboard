
package keyboard;

import java.util.ArrayList;
import keyboardmappings.KeyboardType;
import keyboardmappings.UnusedKeyCodeException;
import java.util.HashSet;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;
import keyboardmappings.AbstractKeyboard;
import keyboardmappings.MusicTheoryKeyboard;
import keyboardmappings.ClassicKeyboard;
import musictheory.MusicalKey;

/**
 *
 * @author mattroberts
 */
class KeyboardModel {

    private final HashSet<Integer> keyDown = new HashSet<>();
    
    /*
    As long as the sustaining key was "on" when these were played, 
    these were't dampened.  They are dampened when the sustaining key is pressed again.
    */
    private final HashSet<Integer> sustainingNotes = new HashSet<>();
    /*
    As long as these were down when the sostenato key was pressed, these are held
    until it is lifted.
    */
    private final HashSet<Integer> sostenatoNotes = new HashSet<>();

    private AbstractKeyboard keyboard;

    private boolean sustaining = false;
    
    private boolean sostenato = false;

    //private final short NOTE_TRANSLATION_CONSTANT = 60;

    KeyboardModel() {
        keyboard = new MusicTheoryKeyboard(60,MusicalKey.C);
    }

    void setKeyboard(KeyboardType kt) {
        System.out.println("Setting keyboard");
        if (kt == KeyboardType.TRADITIONAL) {
            keyboard = new ClassicKeyboard(keyboard);
            System.out.println("Traditional");
        } else {
            keyboard = new MusicTheoryKeyboard(keyboard);
            System.out.println("Music Theory");
        }

    }

    /*
    private boolean isKeyPressed(KeyCode kc){
            return keyDown.get(kc.getName());
    }
     */
    
    private ShortMessage getNoteOnMessage(int noteCode)
            throws InvalidMidiDataException, MidiUnavailableException {
        ShortMessage noteMessage = new ShortMessage();
        //System.out.println(noteCode);
        noteMessage.setMessage(ShortMessage.NOTE_ON, 4,
                noteCode + keyboard.getOctaveKeyTranslation(), 70);
        return noteMessage;
    }

    private ShortMessage getNoteOffMessage(int noteCode)
            throws InvalidMidiDataException, MidiUnavailableException {
        ShortMessage noteMessage = new ShortMessage();
        noteMessage.setMessage(ShortMessage.NOTE_OFF, 4,
                noteCode + keyboard.getOctaveKeyTranslation(), 0);
        return noteMessage;
    }

    ArrayList<ShortMessage> respondToPedalsDown(KeyEvent keyEvent) throws
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
                    for (Integer i : sustainingNotes) {
                        if (!keyDown.contains(i)) {
                            notesOffArrayList.add(getNoteOffMessage(i));
                        }
                    }
                    sustainingNotes.clear();
                    return notesOffArrayList;
                }
            case SPACE:
                if (!sostenato){
                    sostenato=true;
                    for (Integer i : keyDown) {
                        sostenatoNotes.add(i);
                    }
                }
                return null;
               
        }
        return null;
    }

    ArrayList<ShortMessage> respondToPedalUp(KeyEvent keyEvent) throws
            InvalidMidiDataException, MidiUnavailableException{
        KeyCode kc = keyEvent.getCode();
        switch (kc){
            case SPACE:
                if (sostenato){
                    ArrayList<ShortMessage> notesOffArrayList=new ArrayList<>();
                    sostenato=false;
                    for (Integer i : sostenatoNotes) {
                        notesOffArrayList.add(getNoteOffMessage(i));
                    }
                    sostenatoNotes.clear();
                    return notesOffArrayList;
                }
            return null;
        }
        return null;
    }

    ShortMessage respondToKeyPressed(KeyEvent keyEvent) throws UnusedKeyCodeException,
            InvalidMidiDataException, MidiUnavailableException {
        int noteCode = keyboard.getIntFromKey(keyEvent.getCode());
        //KeyCode kc=keyEvent.getCode();
        if (keyDown.contains(noteCode)) {
            //updateKeyPressed(kc, true);
            //keyDown.put(noteCode, true);
            return null;
        } else {
            //updateKeyPressed(kc, true);
            keyDown.add(noteCode);
            if(sustaining){
                sustainingNotes.add(noteCode);
            }
            return getNoteOnMessage(noteCode);
        }
    }

    public ShortMessage respondToKeyReleased(KeyEvent keyEvent) throws UnusedKeyCodeException,
            InvalidMidiDataException, MidiUnavailableException {
        //KeyCode kc=keyEvent.getCode();
        int noteCode = keyboard.getIntFromKey(keyEvent.getCode());
        //updateKeyPressed(kc, false);
        keyDown.remove(noteCode);
        if (sustaining||sostenatoNotes.contains(noteCode)) {
            throw new UnusedKeyCodeException();
        }   
        return getNoteOffMessage(noteCode);

    }
    
    void updateKeyboard(KeyEvent keyEvent){
        KeyCode kc=keyEvent.getCode();
        switch(kc){
            case M:
                keyboard=new MusicTheoryKeyboard(keyboard);
                return;
            case N:
                keyboard=new ClassicKeyboard(keyboard);
                return;              
        }
    }
    
    boolean updateOctaveAndKey(KeyEvent ke){
        return keyboard.updateOctaveAndKey(ke);
    }
    
}
