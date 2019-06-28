/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview;

import javafx.event.EventHandler;
import keyboard.keyboardview.KeyboardView;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author mattroberts
 */
public class KeyboardViewManager {
    
    private static KeyboardViewManager kvManager=null;
    private KeyboardViewModel kvModel=new KeyboardViewModel();
    private KeyboardView kvView=new KeyboardView();
    private Scene scene=new Scene(kvView, 
                    KeyboardView.VIEW_HEIGHT, KeyboardView.VIEW_WIDTH);
    
    private Stage window=null;
    
    private KeyboardViewManager(EventHandler<KeyEvent> kph, EventHandler<KeyEvent> krh){
        setUpScene(kph, krh);
        setUpWindow();
        setKeysInView();
    }
    
    private void setKeysInView(){
        kvView.setKeys(kvModel.getKeyModel().getSetOfKeys());
    }
    
    public static KeyboardViewManager getInstance(EventHandler<KeyEvent> kph, EventHandler<KeyEvent> krh) 
    { 
        if (kvManager == null) {
            kvManager=new KeyboardViewManager(kph, krh);
        }
        return kvManager;
    }
    
    private void setUpScene(EventHandler<KeyEvent> kph, EventHandler<KeyEvent> krh){
        scene.setOnKeyPressed(kph);
        scene.setOnKeyReleased(krh);
    }
    
    private void setUpWindow(){
        if (window == null) {
            window=new Stage();
            window.setTitle("Keyboard View");
            scene.getStylesheets().add("keyboard/view-style.css");
            window.setScene(scene);
        }
    }
    
    public void showWindow(){
        window.show();
        window.setMinHeight(KeyboardView.VIEW_HEIGHT);
        window.setMinWidth(KeyboardView.VIEW_WIDTH);
        window.setHeight(KeyboardView.VIEW_HEIGHT);
        window.setWidth(KeyboardView.VIEW_WIDTH);
        window.centerOnScreen();
        window.toFront();
    }
    
    
}
