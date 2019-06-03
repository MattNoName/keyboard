
package keyboard;

import java.util.ArrayList;
import javax.sound.midi.Instrument;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;

/**
 *
 * @author mattroberts
 */
class KeyboardSound {
    
    private Synthesizer synthesizer;
    
    private Receiver receiver;
    
    private Instrument electricPiano;
    
    //private String MAC_ELECTRIC_PIANO_2="Electric Piano 2";
    
    //private String PC_E_PIANO_2="E. Piano 2   ";
    private short ELECTRIC_PIANO_NUM=6;

    KeyboardSound() throws MidiUnavailableException{
        synthesizer=MidiSystem.getSynthesizer();
        Instrument [] availableInstruments=synthesizer.getAvailableInstruments();
        electricPiano=availableInstruments[6];
        /*
        for (Instrument instrument : availableInstruments){
            System.out.println(instrument.getName());
            if (instrument.getName().equals(ELECTRIC_PIANO)){
                electricPiano=instrument;
            }
        }
*/
        synthesizer.loadInstrument(electricPiano);
        receiver = MidiSystem.getReceiver();
    }
    
    void sendToSynethesizer(ShortMessage noteMessage){
        receiver.send(noteMessage, -1);
    }
    
    void sendToSynethesizer(ArrayList<ShortMessage> noteMessageArrayList){
        for (ShortMessage noteMessage : noteMessageArrayList)
        receiver.send(noteMessage, -1);
    }
    
    
}
