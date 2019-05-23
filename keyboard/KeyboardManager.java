/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import java.util.ArrayList;
import keyboardmappings.UnusedKeyCodeException;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
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
    Stage primaryStage;
    Scene scene;
    DirectionsView directionsView = new DirectionsView();
    DirectionsModel directionsModel = new DirectionsModel();
    KeyPressedHandler keyPressedHandler=new KeyPressedHandler();
    KeyReleasedHandler keyReleasedHandler=new KeyReleasedHandler();

    /*
    Once note is gotten, pass to sendToSynethesizer function
    to get list of all soundbank's instruments, use sounbank getAllInstruments
    load instrument with synthesizer
     */
    public KeyboardManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
        model = new KeyboardModel();

        try {
            sound = new KeyboardSound();
        } catch (MidiUnavailableException e) {
            AlertsManager.showAlert(e);
            return;
        }
        setUpScene();
        primaryStage.show();
    }

    private void setUpScene() {
        setUpDirectionsScene();
        setUpKeyboardInput(scene);
    }

    private void setUpDirectionsScene() {
        directionsView.setTeachingText(directionsModel.getTeachingText());
        directionsView.setUpKeyPressedInput(keyPressedHandler);
        directionsView.setUpKeyReleasedInput(keyReleasedHandler);
        scene = new Scene(directionsView, 375, 450);

        primaryStage.setTitle("Keyboard");
        primaryStage.setScene(scene);
    }

    private void setUpKeyboardInput(Scene scene) {

        scene.setOnKeyPressed(keyPressedHandler);
        scene.setOnKeyReleased(keyReleasedHandler);

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
