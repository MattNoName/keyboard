/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
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
    //private VBox topVBox=new VBox();
    private Label instructionsLabel=new Label("Instructions");
    private TextArea thankYouTextArea=new TextArea();
    private Label acknowledgementsLabel=new Label("Acknowledgements");
    private TextArea teachingTextArea=new TextArea();
    

    //private Label directionsLabel=new Label("Press some keys until you know how to use it.");

    View() {
        //topVBox.getChildren().addAll(titleLabel);
        //topVBox.setAlignment(Pos.CENTER);
        //topVBox.setSpacing(20);
        thankYouTextArea.setFocusTraversable(false);
        thankYouTextArea.setEditable(false);
        thankYouTextArea.setWrapText(true);
        thankYouTextArea.setMaxWidth(500);
        thankYouTextArea.setMaxHeight(135);
        teachingTextArea.setFocusTraversable(false);
        teachingTextArea.setEditable(false);
        teachingTextArea.setWrapText(true);
        teachingTextArea.setMaxWidth(500);
        teachingTextArea.setMaxHeight(500);
        getChildren().addAll(instructionsLabel, teachingTextArea, acknowledgementsLabel,thankYouTextArea);
        setAlignment(Pos.CENTER);
        setSpacing(5);
        VBox.setVgrow(thankYouTextArea, Priority.ALWAYS);
        VBox.setVgrow(teachingTextArea, Priority.ALWAYS);
        //setTop(topVBox);
        //setCenter(teachingTextArea);
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
    
    /*
    vbox
     */

    
}
