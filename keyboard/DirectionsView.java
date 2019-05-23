/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author mattroberts
 */
public class DirectionsView extends BorderPane {
    
    /*
    title--keyboard
    directions in uneditable text area
    */
    private VBox topVBox=new VBox();
    //private Label titleLabel=new Label("Keyboard");
    private VBox centerVBox=new VBox();
    private TextArea teachingTextArea=new TextArea();

    //private Label directionsLabel=new Label("Press some keys until you know how to use it.");

    public DirectionsView() {
        //topVBox.getChildren().addAll(titleLabel);
        topVBox.setAlignment(Pos.CENTER);
        topVBox.setSpacing(20);
        teachingTextArea.setFocusTraversable(false);
        teachingTextArea.setEditable(false);
        teachingTextArea.setWrapText(true);
        teachingTextArea.setMaxWidth(500);
        teachingTextArea.setMaxHeight(500);
        centerVBox.getChildren().addAll(teachingTextArea);
        centerVBox.setAlignment(Pos.CENTER);
        centerVBox.setSpacing(20);
        setTop(topVBox);
        setCenter(teachingTextArea);
    }
    
    void setTeachingText(String text){
        teachingTextArea.setText(text);
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
