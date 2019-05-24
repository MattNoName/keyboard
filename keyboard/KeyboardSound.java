
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
    
    private String ELECTRIC_PIANO="Electric Piano 2";

    KeyboardSound() throws MidiUnavailableException{
        synthesizer=MidiSystem.getSynthesizer();
        Instrument [] availableInstruments=synthesizer.getAvailableInstruments();
        for (Instrument instrument : availableInstruments){
            System.out.println(instrument.getName());
            if (instrument.getName().equals(ELECTRIC_PIANO)){
                electricPiano=instrument;
            }
        }
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
