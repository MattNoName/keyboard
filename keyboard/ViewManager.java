/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author mattroberts
 */
class ViewManager {
    
    private Stage primaryStage;
    private Scene scene;
    private View directionsView = new View();
    private ViewModel directionsModel = new ViewModel();

    ViewManager(Stage primaryStage, 
            EventHandler<KeyEvent> keyPressedHandler, 
            EventHandler<KeyEvent> keyReleasedHandler) {
        this.primaryStage = primaryStage;
        setUpDirectionsScene();
        setUpWindow();
        setUpKeyboardInput(keyPressedHandler, keyReleasedHandler);
        directionsView.setShowKeyboardHandler(new showKeyboardViewHandler());
    }

    private void setUpDirectionsScene() {
        directionsView.setThankYouText(directionsModel.getThankYouText());
        directionsView.setTeachingText(directionsModel.getTeachingText(false), directionsModel.getTeachingText(true));
        
        scene = new Scene(directionsView, 375, 600);
        scene.getStylesheets().add("keyboard/view-style.css");
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
    
    class showKeyboardViewHandler implements EventHandler{

        @Override
        public void handle(Event event) {
            KeyboardViewManager.getInstance().showView();
        }
        
    }
    
    
    
}
