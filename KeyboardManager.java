/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
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
    
    /*
    Once note is gotten, pass to playNote function
    to get list of all soundbank's instruments, use sounbank getAllInstruments
    load instrument with synthesizer
    */
    
    
    public KeyboardManager(Scene scene){
        model=new KeyboardModel();
        
        try{
            sound=new KeyboardSound();
        }
        catch(MidiUnavailableException e){
            AlertsManager.showAlert(e);
            return;
        }
        setUpKeyboardInput(scene);
    }
    
    private void setUpKeyboardInput(Scene scene){
        EventHandler<KeyEvent> keyPressed=(final KeyEvent keyEvent) -> {
            try{
                respondToKeyPressed(keyEvent);
            }
            catch(Exception e){
                AlertsManager.showAlert(e);
            }
        };
        
        EventHandler<KeyEvent> keyReleased=(final KeyEvent keyEvent) -> {
            model.respondToKeyReleased(keyEvent);
        };
        
        scene.setOnKeyPressed(keyPressed);
        scene.setOnKeyReleased(keyReleased);
        
    }
    
    public void respondToKeyPressed(KeyEvent keyEvent) throws
            InvalidMidiDataException, MidiUnavailableException{
        try{
            ShortMessage noteMessage=model.respondToKeyPressed(keyEvent);
            if (noteMessage!=null){
                sound.playNote(noteMessage);
            }
        }
        catch(UnusedKeyCodeException e){
            //do nothing
        }
    }
    
}
