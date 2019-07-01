/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview;

import keyboard.keyboardview.keys.KeyboardKey;
import keyboard.keyboardview.keys.KeyType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import keyboard.keyboardview.keys.AbstractKey;
import keyboard.keyboardview.keys.KeyLabels;

/**
 *
 * @author mattroberts
 */
public class KeyboardView extends VBox{
    
    private int NUM_TOP_KEYS=12;
    private int NUM_BOTTOM_KEYS=11;
    private int NUM_KEYS=12;
    
    static final int VIEW_WIDTH=840;
    static final int VIEW_HEIGHT=540;
    
    VBox [] changeKeys=new VBox[NUM_KEYS];
    VBox [] topKeys=new VBox[NUM_TOP_KEYS];
    VBox [] bottomKeys=new VBox[NUM_BOTTOM_KEYS];
    
    Label currentKeyLabel=new Label("Key of C");
    Label octaveLabel=new Label("Octave: Middle C");
    KeyLabels keyLabels=new KeyLabels();
    
    KeyboardView(){
        
        VBox changeKeysVBox=new VBox();
        changeKeysVBox.setAlignment(Pos.TOP_CENTER);
        Label changeKeysLabel=new Label("Change Keys:");
        FlowPane changeKeysFP=new FlowPane();
        changeKeysFP.setAlignment(Pos.TOP_CENTER);
        createChangeKeys();
        changeKeysFP.getChildren().addAll(changeKeys);
        changeKeysVBox.getChildren().addAll(changeKeysLabel, changeKeysFP);
        
        StackPane keysStackPane=new StackPane();
        FlowPane bottomKeysFP=new FlowPane();
        FlowPane topKeysFP=new FlowPane();
        topKeysFP.setHgap(20);
        bottomKeysFP.setAlignment(Pos.TOP_CENTER);
        topKeysFP.setAlignment(Pos.TOP_CENTER);
        createBottomKeys();
        createTopKeys();
        topKeysFP.getChildren().addAll(topKeys);
        bottomKeysFP.getChildren().addAll(bottomKeys);
        keysStackPane.getChildren().addAll(bottomKeysFP,topKeysFP);
        
        HBox labelsHBox=new HBox();
        labelsHBox.getChildren().addAll(currentKeyLabel, octaveLabel);
        labelsHBox.setAlignment(Pos.CENTER);
        labelsHBox.setSpacing(30);
        
        this.getChildren().addAll(changeKeysVBox, keysStackPane, labelsHBox);
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
        
    }
    
    private void createTopKeys(){
        for (int i=0; i<NUM_TOP_KEYS; i++){
            topKeys[i]=new VBox();
            topKeys[i].setMinSize(40, 200);
            topKeys[i].setMaxSize(40, 200);
            topKeys[i].getStyleClass().add("brown-keys");
            topKeys[i].setAlignment(Pos.BOTTOM_CENTER);
            Label keyLabel=new Label(String.valueOf(keyLabels.getTopKeys()[i]));
            keyLabel.getStyleClass().add("yellow-label");
            topKeys[i].getChildren().add(keyLabel);
        }
    }
    
    private void createBottomKeys(){
        for (int i=0; i<NUM_BOTTOM_KEYS; i++){
            bottomKeys[i]=new VBox();
            bottomKeys[i].setMinSize(60, 280);
            bottomKeys[i].setMaxSize(60, 280);
            bottomKeys[i].getStyleClass().add("yellow-keys");
            bottomKeys[i].setAlignment(Pos.BOTTOM_CENTER);
            Label keyLabel=new Label(String.valueOf(keyLabels.getBottomKeys()[i]));
            keyLabel.getStyleClass().add("brown-label");
            bottomKeys[i].getChildren().add(keyLabel);
            
        }
    }
    
    private void createChangeKeys(){
        for (int i=0; i<NUM_KEYS; i++){
            changeKeys[i]=new VBox();
            changeKeys[i].setMinSize(60, 60);
            changeKeys[i].setMaxSize(60, 60);
            changeKeys[i].getStyleClass().add("yellow-keys");
            changeKeys[i].setAlignment(Pos.BOTTOM_CENTER);
            Label keyLabel=new Label(keyLabels.getKeyStrings()[i]);
            keyLabel.getStyleClass().add("brown-label");
            Label changeKeyLabel=new Label(String.valueOf(keyLabels.getChangeKeys()[i]));
            keyLabel.getStyleClass().add("brown-label");
            changeKeys[i].getChildren().addAll(keyLabel, changeKeyLabel);
            
        }
    }
    
    private void hideTopKeys(){
        for (VBox rect: topKeys){
            rect.setVisible(false);
        }
    }
    
    void setKeys(AbstractKey indices){
        hideTopKeys();
        for (Integer index : indices){
            showTopKey(index);
        }
    }
    
    void setKeyLabel(String key){
        currentKeyLabel.setText("Key of "+key);
    }
    
    private void showKey(KeyboardKey key){
        getKeyRect(key).setVisible(true);
    }
    
    private void showTopKey(Integer index){
        topKeys[index].setVisible(true);
    }
    
    private void showBottomKey(Integer index){
        topKeys[index].setVisible(true);
    }
    
    private VBox getKeyRect(KeyboardKey key){
        if (key.getKeyType()==KeyType.BOTTOM_KEY){
            return bottomKeys[key.getIndex()];
        }
        else{
            return topKeys[key.getIndex()];
        }
    }
    
    public void keyDown(KeyboardKey key){
        if (key.getKeyType()==KeyType.BOTTOM_KEY){
            bottomKeys[key.getIndex()].setBackground(new Background(new BackgroundFill(Paint.valueOf("#ffcc00"), CornerRadii.EMPTY, Insets.EMPTY)));
        }
        else{
            topKeys[key.getIndex()].setBackground(new Background(new BackgroundFill(Paint.valueOf("#cc9900"), CornerRadii.EMPTY, Insets.EMPTY)));
                    
        }
    }
    
    public void keyUp(KeyboardKey key){
        if (key.getKeyType()==KeyType.BOTTOM_KEY){
            bottomKeys[key.getIndex()].setBackground(new Background(new BackgroundFill(Paint.valueOf("rgb(255, 230, 0)"), CornerRadii.EMPTY, Insets.EMPTY)));
                    
        }
        else{
            topKeys[key.getIndex()].setBackground(new Background(new BackgroundFill(Paint.valueOf("rgb(189, 135, 34)"), CornerRadii.EMPTY, Insets.EMPTY)));

        }
    }
    
    
    
}
