
package keyboard;

import alerts.AlertModel;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

/**
 *
 * @author mattroberts
 */
public class AppAlertModel extends AlertModel{

    public AppAlertModel(String title, String description) {
        super(title, description);
    }
    
    public AppAlertModel(Exception exception){
        if (exception instanceof MidiUnavailableException){
            title="Sound Resource Unavailable";
            description="A necessary sound resource was not avilable.  Keyboard will quit now.";
        }
        else if(exception instanceof InvalidMidiDataException){
            title="Invalid Midi Data";
            description="Data sent to synthesizer was invalid.";
        }
        else if(exception instanceof InstrumentUnavailableException){
            title="Required Instrument Unavailable";
            description="The required instrument was unavailable.  Keyboard will quit now.";
        }
        else{
            title="Exception";
            //description="An unkown error occurred.  Keyboard will quit now.";
            description=exception.toString();
        }
    }
    
}
