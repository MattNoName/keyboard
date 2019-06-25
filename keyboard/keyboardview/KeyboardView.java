/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author mattroberts
 */
public class KeyboardView extends VBox{
    
    private int NUM_TOP_KEYS=12;
    private int NUM_BOTTOM_KEYS=11;
    
    static final int VIEW_WIDTH=840;
    static final int VIEW_HEIGHT=360;
    
    Rectangle []topKeys=new Rectangle[NUM_TOP_KEYS];
    Rectangle []bottomKeys=new Rectangle[11];
    
    KeyboardView(){
        StackPane keysStackPane=new StackPane();
        FlowPane bottomKeysFP=new FlowPane();
        FlowPane topKeysFP=new FlowPane();
        //topKeysFP.setTranslateX(60);
        topKeysFP.setHgap(20);
        //bottomKeysFP.setTranslateX(80);
        createBottomKeys();
        createTopKeys();
        bottomKeysFP.setAlignment(Pos.TOP_CENTER);
        topKeysFP.setAlignment(Pos.TOP_CENTER);
        
        topKeysFP.getChildren().addAll(topKeys);
        bottomKeysFP.getChildren().addAll(bottomKeys);
        keysStackPane.getChildren().addAll(bottomKeysFP,topKeysFP);
        HBox labelsHBox=new HBox();
        Label keyLabel=new Label("Key of C");
        Label octaveLabel=new Label("Octave: Middle C");
        labelsHBox.getChildren().addAll(keyLabel, octaveLabel);
        labelsHBox.setAlignment(Pos.CENTER);
        labelsHBox.setSpacing(30);
        this.getChildren().addAll(keysStackPane, labelsHBox);
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
        
    }
    
    private void createTopKeys(){
        for (int i=0; i<NUM_TOP_KEYS; i++){
            topKeys[i]=new Rectangle(40, 200);
            topKeys[i].getStyleClass().add("brown-keys");
        }
    }
    
    private void createBottomKeys(){
        for (int i=0; i<NUM_BOTTOM_KEYS; i++){
            bottomKeys[i]=new Rectangle(60, 280);
            bottomKeys[i].getStyleClass().add("yellow-keys");
        }
    }
    
}
