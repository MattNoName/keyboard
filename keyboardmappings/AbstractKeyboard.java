package keyboardmappings;

import musictheory.MusicalKey;
import java.util.HashMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author mattroberts
 */
public abstract class AbstractKeyboard implements KeyboardInterface {


    protected int octaveTranslation = 60;

    protected int key = 0;

    protected int octaveKeyTranslation = 0;
    
    protected HashMap<KeyCode, Integer> changeKeyHashMap=new HashMap<>();
    
    protected HashMap<KeyCode, Integer> keyHashMap=new HashMap<>();
    
    protected HashMap<MusicalKey, Integer> musicalKeyHashMap=new HashMap<>();
    
    public AbstractKeyboard(){
        makeChangeKeyHashMap();
        makeMusicalKeyHashMap();
        setOctaveKeyTranslation();
    }

    public final int getOctaveTranslation() {
        return octaveTranslation;
    }

    public final int getKey() {
        return key;
    }

    public AbstractKeyboard(int octaveTranslation, MusicalKey mk) {
        this();
        this.octaveTranslation = octaveTranslation;
        this.key = musicalKeyHashMap.get(mk);
    }

    public AbstractKeyboard(AbstractKeyboard ak) {
        this();
        this.octaveTranslation = ak.getOctaveTranslation();
        this.key = ak.getKey();
    }

    public final void setOctaveTranslation(int octaveTranslation) {
        this.octaveTranslation = octaveTranslation;
    }

    protected void setKey(MusicalKey mk){
        key=musicalKeyHashMap.get(mk);
    }

    private void setOctaveKeyTranslation() {
        //System.out.println(octaveTranslation);
        //System.out.println(key);
        octaveKeyTranslation = octaveTranslation + key;
    }

    public final int getOctaveKeyTranslation() {
        return octaveKeyTranslation;
    }

    public final boolean updateOctaveAndKey(KeyEvent keyEvent) {
        KeyCode kc = keyEvent.getCode();
        if (updateOctave(kc) || updateKey(kc)) {
            System.out.println("Updated Octave or Key");
            setOctaveKeyTranslation();
            return true;
        }
        return false;
    }

    private boolean updateOctave(KeyCode kc) {
        switch (kc) {
            case Z:
                octaveTranslation = 36;
                return true;
            case X:
                octaveTranslation = 48;
                return true;
            case C:
                octaveTranslation = 60;
                return true;
            case V:
                octaveTranslation = 72;
                return true;
            case B:
                octaveTranslation = 84;
                return true;
            case SHIFT:
                
                if (octaveTranslation == 36) {
                
                } else {
                    System.out.println("Octave shifted down");
                    octaveTranslation -= 12;
                }
                return true;
            case ENTER:
                
                if (octaveTranslation == 84) {
                    
                } else {
                    System.out.println("Octave shifted up");
                    octaveTranslation += 12;
                }
                
                return true;
        }
        return false;
    }
    
    public int getOctave(){
        return octaveTranslation/12;
    }
    
    private void makeChangeKeyHashMap(){
        changeKeyHashMap.put(KeyCode.DIGIT1, 0);
        changeKeyHashMap.put(KeyCode.DIGIT2, 1);
        changeKeyHashMap.put(KeyCode.DIGIT3, 2);
        changeKeyHashMap.put(KeyCode.DIGIT4, 3);
        changeKeyHashMap.put(KeyCode.DIGIT5, 4);
        changeKeyHashMap.put(KeyCode.DIGIT6, 5);
        changeKeyHashMap.put(KeyCode.DIGIT7, 6);
        changeKeyHashMap.put(KeyCode.DIGIT8, 7);
        changeKeyHashMap.put(KeyCode.DIGIT9, 8);
        changeKeyHashMap.put(KeyCode.DIGIT0, 9);
        changeKeyHashMap.put(KeyCode.MINUS, 10);
        changeKeyHashMap.put(KeyCode.EQUALS, 11);
    }
    
    private void makeMusicalKeyHashMap(){
        musicalKeyHashMap.put(MusicalKey.C, 0);
        musicalKeyHashMap.put(MusicalKey.C_SHARP, 1);
        musicalKeyHashMap.put(MusicalKey.D, 2);
        musicalKeyHashMap.put(MusicalKey.D_SHARP, 3);
        musicalKeyHashMap.put(MusicalKey.E, 4);
        musicalKeyHashMap.put(MusicalKey.F, 5);
        musicalKeyHashMap.put(MusicalKey.F_SHARP, 6);
        musicalKeyHashMap.put(MusicalKey.G, 7);
        musicalKeyHashMap.put(MusicalKey.G_SHARP, 9);
        musicalKeyHashMap.put(MusicalKey.A, 10);
        musicalKeyHashMap.put(MusicalKey.A_SHARP, 11);
        musicalKeyHashMap.put(MusicalKey.B, 12);
    }
    
    protected boolean updateKey(KeyCode kc) {
    
        Integer foundKey=changeKeyHashMap.get(kc);
        if (foundKey!=null){
            key=foundKey;
            return true;
        }
        return false;
    }
    
    @Override
    public final int getIntFromKey(KeyCode key) throws UnusedKeyCodeException {
        
        Integer foundKey=keyHashMap.get(key);
        if (foundKey!=null){
            return foundKey;
        }
        throw new UnusedKeyCodeException();
    }
    
    
    

}
