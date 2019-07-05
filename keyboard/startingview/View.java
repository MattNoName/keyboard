/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.startingview;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 *
 * @author matt roberts
 */
public class View extends VBox {
    
    private Label instructionsLabel=new Label("Instructions");
    private Button viewKeyboardButton=new Button("See Full View");
    private TextArea teachingTextArea=new TextArea();

    View() {
        teachingTextArea.setFocusTraversable(false);
        teachingTextArea.setEditable(false);
        teachingTextArea.setWrapText(true);
        teachingTextArea.setMaxWidth(500);
        teachingTextArea.setMaxHeight(500);
        HBox btnHBox=new HBox();
        btnHBox.getChildren().add(viewKeyboardButton);
        btnHBox.setAlignment(Pos.CENTER);
        btnHBox.setSpacing(20);
        viewKeyboardButton.setFocusTraversable(false);
        getChildren().addAll(instructionsLabel, teachingTextArea, btnHBox);
        setAlignment(Pos.CENTER);
        setSpacing(5);
        VBox.setVgrow(teachingTextArea, Priority.ALWAYS);
    }
    
    void setTeachingText(String writtenText, String spokenText){
        teachingTextArea.setText(writtenText);
        teachingTextArea.setAccessibleText(spokenText);
    }
    
    void setUpKeyPressedHandler(EventHandler<KeyEvent> kph){
        teachingTextArea.setOnKeyPressed(kph);

    }
    
    void setUpKeyReleasedHandler(EventHandler<KeyEvent> krh){
        teachingTextArea.setOnKeyReleased(krh);
    }
    
    void setShowKeyboardHandler(EventHandler<ActionEvent> event){
        viewKeyboardButton.setOnAction(event);
    }
    
}
