/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alerts;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

/**
 *
 * @author mattroberts
 */
public class AlertModel {
    
    protected String title;
    protected String description;

    public AlertModel() {
        
    }
    
    

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
    
    public AlertModel(Exception exception){
            title="Exception";
            //description="An unkown error occurred.  Keyboard will quit now.";
            description=exception.toString();
    }
    
}
