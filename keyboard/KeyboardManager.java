package keyboard;

import java.util.ArrayList;
import keyboardmappings.UnusedKeyCodeException;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;

/**
 *
 * @author mattroberts
 */
class KeyboardManager {

    KeyboardModel model;
    KeyboardSound sound;
    KeyPressedHandler keyPressedHandler = new KeyPressedHandler();
    KeyReleasedHandler keyReleasedHandler = new KeyReleasedHandler();
    ViewManager viewManager;

    /*
    Once note is gotten, pass to sendToSynethesizer function
    to get list of all soundbank's instruments, use sounbank getAllInstruments
    load instrument with synthesizer
     */
    KeyboardManager(Stage primaryStage) {
        model = new KeyboardModel();

        try {
            sound = new KeyboardSound();
        } catch (MidiUnavailableException e) {
            AlertsManager.showAlert(e);
            return;
        }
        viewManager = new ViewManager(primaryStage, keyPressedHandler, keyReleasedHandler);
        viewManager.showWindow();
    }

    private class KeyPressedHandler implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent event) {
            try {
                //System.out.println(keyEvent.getCode());
                ShortMessage noteMessage = null;
                try {
                    noteMessage = model.respondToKeyPressed(event);
                } catch (UnusedKeyCodeException e) {
                    //do nothing
                }
                if (noteMessage != null) {
                    System.out.println(noteMessage.toString());
                    sound.sendToSynethesizer(noteMessage);
                } else if (!model.updateOctaveAndKey(event)) {

                    ArrayList<ShortMessage> notesOffArrayList = model.respondToPedalsDown(event);
                    if (notesOffArrayList != null) {
                        sound.sendToSynethesizer(notesOffArrayList);
                    }
                    model.updateKeyboard(event);
                }
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
                ShortMessage noteMessage = null;
                try {
                    //System.out.println("key released");
                    noteMessage = model.respondToKeyReleased(event);
                } catch (UnusedKeyCodeException e) {
                    //do nothing
                }
                if (noteMessage != null) {
                    sound.sendToSynethesizer(noteMessage);
                } else {
                    ArrayList<ShortMessage> notesOffArrayList = model.respondToPedalUp(event);
                    if (notesOffArrayList != null) {
                        sound.sendToSynethesizer(notesOffArrayList);
                    }
                }
            } catch (Exception e) {
                AlertsManager.showAlert(e);
            }
        }
    };

}
