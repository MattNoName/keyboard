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
 * @author mattroberts
 */
public class View extends VBox {
    
    /*
    title--keyboard
    directions in uneditable text area
    */
    private Label instructionsLabel=new Label("Instructions");
    private TextArea thankYouTextArea=new TextArea();
    private Button viewKeyboardButton=new Button("See View");
    private Button pictureDirectionsButton=new Button("See Picture Directions");
    private Label acknowledgementsLabel=new Label("Acknowledgements");
    private TextArea teachingTextArea=new TextArea();
    


    View() {
        teachingTextArea.setFocusTraversable(false);
        teachingTextArea.setEditable(false);
        teachingTextArea.setWrapText(true);
        teachingTextArea.setMaxWidth(500);
        teachingTextArea.setMaxHeight(500);
        HBox btnHBox=new HBox();
        btnHBox.getChildren().addAll(viewKeyboardButton,pictureDirectionsButton);
        btnHBox.setAlignment(Pos.CENTER);
        btnHBox.setSpacing(20);
        viewKeyboardButton.setFocusTraversable(false);
        thankYouTextArea.setFocusTraversable(false);
        thankYouTextArea.setEditable(false);
        thankYouTextArea.setWrapText(true);
        thankYouTextArea.setMaxWidth(500);
        thankYouTextArea.setMaxHeight(135);
        getChildren().addAll(instructionsLabel, teachingTextArea, btnHBox, acknowledgementsLabel,thankYouTextArea);
        setAlignment(Pos.CENTER);
        setSpacing(5);
        VBox.setVgrow(thankYouTextArea, Priority.ALWAYS);
        VBox.setVgrow(teachingTextArea, Priority.ALWAYS);
    }
    
    void setThankYouText(String text){
        thankYouTextArea.setText(text);
    }
    
    void setTeachingText(String writtenText, String spokenText){
        teachingTextArea.setText(writtenText);
        teachingTextArea.setAccessibleText(spokenText);
    }
    
    void setUpKeyPressedInput(EventHandler<KeyEvent> kph){
        teachingTextArea.setOnKeyPressed(kph);

    }
    
    void setUpKeyReleasedInput(EventHandler<KeyEvent> krh){
        teachingTextArea.setOnKeyReleased(krh);
    }
    
    void setShowKeyboardHandler(EventHandler<ActionEvent> event){
        viewKeyboardButton.setOnAction(event);
    }
    

    
}
