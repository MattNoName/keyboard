/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author mattroberts
 */
public class ChoiceView extends VBox {

    private Label directionsLabel=new Label("Press some keys until you know how to use it.");
    private Button traditionalBtn = new Button("Use Traidtional Keyboard");
    private Button musicTheoryBtn = new Button("Use Music Theory Keyboard");

    public ChoiceView() {
        this.getChildren().addAll(directionsLabel, traditionalBtn, musicTheoryBtn);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        traditionalBtn.setFocusTraversable(false);
        musicTheoryBtn.setFocusTraversable(false);
    }
    
    

    /*
    vbox
     */

    public Button getTraditionalBtn() {
        return traditionalBtn;
    }

    public Button getMusicTheoryBtn() {
        return musicTheoryBtn;
    }
}
