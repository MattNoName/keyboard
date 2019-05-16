/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard;

import javafx.scene.control.Alert;
import javax.sound.midi.MidiUnavailableException;

/**
 *
 * @author mattroberts
 */
public class AlertModel {
    
    private String title;
    private String description;

    public AlertModel(String title, String description) {
        this.title = title;
        this.description = description;
    }
    
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    
    public static AlertModel makeAlertData(Exception exception){
        String title;
        String description;
        if (exception instanceof MidiUnavailableException){
            title="Sound Resource Unavailable";
            description="A necessary sound resource was not avilable.  Keyboard will quit now.";
        }
        else{
            title="Unknown Error";
            description="An unkown error occurred.  Keyboard will quit now.";
        }
        return new AlertModel(title, description);
    }
    
}
