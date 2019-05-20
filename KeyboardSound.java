/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class KeyboardSound {
    
    Synthesizer synthesizer;
    
    Receiver receiver;
    
    Instrument electricPiano;
    
    private String ELECTRIC_PIANO="Electric Piano 2";

    public KeyboardSound() throws MidiUnavailableException{
        setUpSound();
    }
    
    private void setUpSound() throws MidiUnavailableException {
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
    
    public void sendToSynethesizer(ShortMessage noteMessage){
        receiver.send(noteMessage, -1);
    }
    
    public void sendToSynethesizer(ArrayList<ShortMessage> noteMessageArrayList){
        for (ShortMessage noteMessage : noteMessageArrayList)
        receiver.send(noteMessage, -1);
    }
    
    
}
