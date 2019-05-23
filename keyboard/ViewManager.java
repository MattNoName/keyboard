/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

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
    private DirectionsView directionsView = new DirectionsView();
    private DirectionsModel directionsModel = new DirectionsModel();

    ViewManager(Stage primaryStage, 
            EventHandler<KeyEvent> keyPressedHandler, 
            EventHandler<KeyEvent> keyReleasedHandler) {
        this.primaryStage = primaryStage;
        setUpDirectionsScene();
        setUpWindow();
        setUpKeyboardInput(keyPressedHandler, keyReleasedHandler);
    }

    private void setUpDirectionsScene() {
        directionsView.setTeachingText(directionsModel.getTeachingText());
        
        scene = new Scene(directionsView, 375, 450);
        primaryStage.setScene(scene);
    }
    
    private void setUpKeyboardInput(EventHandler<KeyEvent> keyPressedHandler, EventHandler<KeyEvent> keyReleasedHandler){
        directionsView.setUpKeyPressedInput(keyPressedHandler);
        directionsView.setUpKeyReleasedInput(keyReleasedHandler);
        scene.setOnKeyPressed(keyPressedHandler);
        scene.setOnKeyReleased(keyReleasedHandler);
    }
    
    private void setUpWindow(){
        primaryStage.setTitle("Keyboard");
    }
    
    void showWindow(){
        primaryStage.show();
    }
    
    
    
}