/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import keymappings.UnusedKeyCodeException;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;
import keymappings.KeyboardType;

/**
 *
 * @author mattroberts
 */
public class KeyboardManager {
    
    KeyboardModel model;
    KeyboardSound sound;
    Stage primaryStage;
    Scene scene;
    ChoiceView choiceView=new ChoiceView();
    
    /*
    Once note is gotten, pass to sendToSynethesizer function
    to get list of all soundbank's instruments, use sounbank getAllInstruments
    load instrument with synthesizer
    */
    
    
    public KeyboardManager(Stage primaryStage){
        this.primaryStage=primaryStage;
        model=new KeyboardModel();
        
        try{
            sound=new KeyboardSound();
        }
        catch(MidiUnavailableException e){
            AlertsManager.showAlert(e);
            return;
        }
        setUpScene();
        primaryStage.show();
    }
    
    private void setUpScene(){
        setUpChoiceScene();
        setUpKeyboardInput(scene);
    }
    
    private void setUpChoiceScene(){
        scene = new Scene(choiceView, 300, 250);
        EventHandler<ActionEvent> traditionalHandler=new EventHandler(){
            @Override
            public void handle(Event event) {
                model.setKeyboard(KeyboardType.TRADITIONAL);
            }
            
        };
        choiceView.getTraditionalBtn().setOnAction(traditionalHandler);
        EventHandler<ActionEvent> musicTheoryHandler=new EventHandler(){
            @Override
            public void handle(Event event) {
                model.setKeyboard(KeyboardType.MUSIC_THEORY);
            }
            
        };
        choiceView.getMusicTheoryBtn().setOnAction(musicTheoryHandler);
        primaryStage.setTitle("Keyboard");
        primaryStage.setScene(scene);
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
            try{
                respondToKeyReleased(keyEvent);
            }
            catch(Exception e){
                AlertsManager.showAlert(e);
            }
        };
        
        scene.setOnKeyPressed(keyPressed);
        scene.setOnKeyReleased(keyReleased);
        
    }
    
    public void respondToKeyPressed(KeyEvent keyEvent) throws
            InvalidMidiDataException, MidiUnavailableException{
        try{
            ArrayList<ShortMessage> notesOffArrayList=model.respondToPedalsDown(keyEvent);
            if (notesOffArrayList!=null){
                sound.sendToSynethesizer(notesOffArrayList);
            }
            ShortMessage noteMessage=model.respondToKeyPressed(keyEvent);
            if (noteMessage!=null){
                sound.sendToSynethesizer(noteMessage);
            }
        }
        catch(UnusedKeyCodeException e){
            //do nothing
        }
    }
    
    public void respondToKeyReleased(KeyEvent keyEvent) throws
            InvalidMidiDataException, MidiUnavailableException{
        try{
            System.out.println("key released");
            ArrayList<ShortMessage> notesOffArrayList=model.respondToPedalUp(keyEvent);
            if (notesOffArrayList!=null){
                sound.sendToSynethesizer(notesOffArrayList);
            }
            ShortMessage noteMessage=model.respondToKeyReleased(keyEvent);
            if (noteMessage!=null){
                sound.sendToSynethesizer(noteMessage);
            }
        }
        catch(UnusedKeyCodeException e){
            //do nothing
        }
    }
    
}
