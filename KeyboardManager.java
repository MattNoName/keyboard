/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.sound.midi.Instrument;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

/**
 *
 * @author mattroberts
 */
public class KeyboardManager {
    
    /*
    Once note is gotten, pass to playNote function
    to get list of all soundbank's instruments, use sounbank getAllInstruments
    load instrument with synthesizer
    */
    
    public KeyboardManager(Scene scene){
        try{
            setUpSound();
        }
        catch(MidiUnavailableException e){
            AlertsManager.showAlert(e);
            return;
        }
        setUpKeyboardInput(scene);
    }
    
    private void setUpSound() throws MidiUnavailableException {
        Synthesizer synthesizer=MidiSystem.getSynthesizer();
        Instrument [] availableInstruments=synthesizer.getAvailableInstruments();
        for (Instrument instrument : availableInstruments)
            System.out.println(instrument.getName());
    }
    
    private void setUpKeyboardInput(Scene scene){
        EventHandler<KeyEvent> keyPressed=(final KeyEvent keyEvent) -> {
            getNoteFromKey(keyEvent.getCode());
        };
        
        EventHandler<KeyEvent> keyReleased=(final KeyEvent keyEvent) -> {
            getNoteFromKey(keyEvent.getCode());
        };
        
        scene.setOnKeyPressed(keyPressed);
        scene.setOnKeyReleased(keyReleased);
    }
    
    /**
     * 
     * @param key the key
     */
    static void getNoteFromKey(KeyCode key){
            switch (key){
                case A:
                    System.out.println("A pressed");
                    break;
                case W:
                    System.out.println("W pressed");
                    break;
                case S:
                    break;
                case E:
                    break;
                case D:
                    break;
                case R:
                    break;
                case F:
                    break;
                case G:
                    break;
                case Y:
                    break;
                case H:
                    break;
                case U:
                    break;
                case J:
                    break;
                case K:
                    break;
                case O:
                    break;
                case L:
                    break;
                case P:
                    break;
                case SEMICOLON:
                    break;
                case BRACELEFT:
                    break;
                case QUOTE:
                    break;
                case BRACERIGHT:
                    break;
            }
    }
    
}
