
package keyboard;

import java.util.ArrayList;
import keyboardmappings.UnusedKeyCodeException;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;

/**
 *
 * @author mattroberts
 */
public class KeyboardManager {

    KeyboardModel model;
    KeyboardSound sound;
    KeyPressedHandler keyPressedHandler=new KeyPressedHandler();
    KeyReleasedHandler keyReleasedHandler=new KeyReleasedHandler();
    ViewManager viewManager;

    /*
    Once note is gotten, pass to sendToSynethesizer function
    to get list of all soundbank's instruments, use sounbank getAllInstruments
    load instrument with synthesizer
     */
    public KeyboardManager(Stage primaryStage) {
        model = new KeyboardModel();

        try {
            sound = new KeyboardSound();
        } catch (MidiUnavailableException e) {
            AlertsManager.showAlert(e);
            return;
        }
        viewManager=new ViewManager(primaryStage,keyPressedHandler,keyReleasedHandler);
        viewManager.showWindow();
    }

    public void respondToKeyPressed(KeyEvent keyEvent) throws
            InvalidMidiDataException, MidiUnavailableException {
        ShortMessage noteMessage = null;
        try {
            noteMessage = model.respondToKeyPressed(keyEvent);
        } catch (UnusedKeyCodeException e) {
            //do nothing
        }
        if (noteMessage != null) {
            sound.sendToSynethesizer(noteMessage);
        } else if (!model.updateOctaveAndKey(keyEvent)) {

            ArrayList<ShortMessage> notesOffArrayList = model.respondToPedalsDown(keyEvent);
            if (notesOffArrayList != null) {
                sound.sendToSynethesizer(notesOffArrayList);
            }
            model.updateKeyboard(keyEvent);
        }
    }

    public void respondToKeyReleased(KeyEvent keyEvent) throws
            InvalidMidiDataException, MidiUnavailableException {
        ShortMessage noteMessage = null;
        try {
            //System.out.println("key released");
            noteMessage = model.respondToKeyReleased(keyEvent);
        } catch (UnusedKeyCodeException e) {
            //do nothing
        }
        if (noteMessage != null) {
            sound.sendToSynethesizer(noteMessage);
        } else {
            ArrayList<ShortMessage> notesOffArrayList = model.respondToPedalUp(keyEvent);
            if (notesOffArrayList != null) {
                sound.sendToSynethesizer(notesOffArrayList);
            }
        }
    }

    private class KeyPressedHandler implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent event) {
            try {
                //System.out.println(keyEvent.getCode());
                respondToKeyPressed(event);
            } catch (Exception e) {
                AlertsManager.showAlert(e);
            }
        }
    };
    
    private class KeyReleasedHandler implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent event) {
            try {
                //System.out.println(keyEvent.getCode());
                respondToKeyReleased(event);
            } catch (Exception e) {
                AlertsManager.showAlert(e);
            }
        }
    };

}
