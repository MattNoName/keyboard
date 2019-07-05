/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.startingview;

import keyboard.keyboardview.KeyboardViewManager;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author mattroberts
 */
public class ViewManager {
    
    private Stage primaryStage;
    private Scene scene;
    private View directionsView = new View();
    private ViewModel directionsModel = new ViewModel();
    private KeyboardViewManager keyboardViewManager;

    public ViewManager(Stage primaryStage, 
            EventHandler<KeyEvent> keyPressedHandler, 
            EventHandler<KeyEvent> keyReleasedHandler) {
        this.primaryStage = primaryStage;
        setUpScene();
        setUpWindow();
        setUpKeyboardInput(keyPressedHandler, keyReleasedHandler);
        keyboardViewManager=new KeyboardViewManager(keyPressedHandler,keyReleasedHandler);
        directionsView.setShowKeyboardHandler(new showKeyboardViewHandler());
    }

    private void setUpScene() {
        directionsView.setTeachingText(directionsModel.getTeachingText(false), directionsModel.getTeachingText(true));
        
        scene = new Scene(directionsView, 375, 400);
        scene.getStylesheets().add("keyboard/view-style.css");
        primaryStage.setScene(scene);
    }
    
    private void setUpKeyboardInput(EventHandler<KeyEvent> kph, EventHandler<KeyEvent> krh){
        directionsView.setUpKeyPressedHandler(kph);
        directionsView.setUpKeyReleasedHandler(krh);
        scene.setOnKeyPressed(kph);
        scene.setOnKeyReleased(krh);
    }
    
    private void setUpWindow(){
        primaryStage.setTitle("Keyboard");
    }
    
    public void showWindow(){
        primaryStage.show();
    }
    
    class showKeyboardViewHandler implements EventHandler{

        @Override
        public void handle(Event event) {
            keyboardViewManager.showWindow();
        }
        
    }

    public KeyboardViewManager getKeyboardViewManager() {
        return keyboardViewManager;
    }

}
