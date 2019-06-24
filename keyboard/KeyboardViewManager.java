/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mattroberts
 */
public class KeyboardViewManager {
    
    private static KeyboardViewManager keyboardViewManager=null;
    
    private Stage window=null;
    
    
    private KeyboardViewManager(){
        setUpWindow();
    }
    
    static KeyboardViewManager getInstance() 
    { 
        if (keyboardViewManager == null) {
            keyboardViewManager=new KeyboardViewManager();
        }
        return keyboardViewManager;
    }
    
    private void setUpWindow(){
        if (window == null) {
            window=new Stage();
            window.setTitle("Keyboard View");
            Scene scene=new Scene(new KeyboardView(), 
                    KeyboardView.VIEW_HEIGHT, KeyboardView.VIEW_WIDTH);
            scene.getStylesheets().add("keyboard/view-style.css");
            window.setScene(scene);
        }
    }
    
    void showView(){
        window.show();
        window.setMaxHeight(KeyboardView.VIEW_HEIGHT);
        window.setMinHeight(KeyboardView.VIEW_HEIGHT);
        window.setMaxWidth(KeyboardView.VIEW_WIDTH);
        window.setMinWidth(KeyboardView.VIEW_WIDTH);
        window.centerOnScreen();
    }
    
    
}
