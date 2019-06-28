/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview;

import java.util.Collection;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
    
    VBox [] topKeys=new VBox[NUM_TOP_KEYS];
    VBox [] bottomKeys=new VBox[NUM_BOTTOM_KEYS];
    
    Label keyLabel=new Label("Key of C");
    Label octaveLabel=new Label("Octave: Middle C");
    
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
        labelsHBox.getChildren().addAll(keyLabel, octaveLabel);
        labelsHBox.setAlignment(Pos.CENTER);
        labelsHBox.setSpacing(30);
        this.getChildren().addAll(keysStackPane, labelsHBox);
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
        
    }
    
    private void createTopKeys(){
        for (int i=0; i<NUM_TOP_KEYS; i++){
            topKeys[i]=new VBox(40, 200);
            topKeys[i].getStyleClass().add("brown-keys");
        }
    }
    
    private void createBottomKeys(){
        for (int i=0; i<NUM_BOTTOM_KEYS; i++){
            bottomKeys[i]=new VBox(60, 280);
            bottomKeys[i].getStyleClass().add("yellow-keys");
        }
    }
    
    private void hideKeys(){
        for (Rectangle rect: topKeys){
            rect.setVisible(false);
        }
        for (Rectangle rect: bottomKeys){
            rect.setVisible(false);
        }
    }
    
    void setKeys(Collection<KeyboardKey> keys){
        hideKeys();
        for (KeyboardKey key : keys){
            showKey(key);
        }
    }
    
    void setKeyLabel(String key){
        keyLabel.setText("Key of "+key);
    }
    
    private void showKey(KeyboardKey key){
        getKeyRect(key).setVisible(true);
    }
    
    private Rectangle getKeyRect(KeyboardKey key){
        if (key.getKeyType()==KeyType.BOTTOM_KEY){
            return bottomKeys[key.getIndex()];
        }
        else{
            return topKeys[key.getIndex()];
        }
    }
    
    public void keyDown(KeyboardKey key){
        if (key.getKeyType()==KeyType.BOTTOM_KEY){
            bottomKeys[key.getIndex()].setFill(Color.web("#ffcc00"));
        }
        else{
            topKeys[key.getIndex()].setFill(Color.web("#cc9900"));
        }
    }
    
    public void keyUp(KeyboardKey key){
        if (key.getKeyType()==KeyType.BOTTOM_KEY){
            bottomKeys[key.getIndex()].setFill(Color.web("rgb(255, 230, 0)"));
        }
        else{
            topKeys[key.getIndex()].setFill(Color.web("rgb(189, 135, 34)"));
        }
    }
    
    
    
}
