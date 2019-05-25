package keyboardmappings;

import java.util.HashMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author mattroberts
 */
public abstract class AbstractKeyboard implements KeyboardInterface {

    protected int octaveTranslation = 0;

    protected int key = 0;

    protected int octaveKeyTranslation = 0;
    
    protected HashMap<KeyCode, Integer> changeKeyHashMap=new HashMap<>();
    
    protected HashMap<KeyCode, Integer> keyHashMap=new HashMap<>();
    
    public AbstractKeyboard(){
        makeChangeKeyHashMap();
    }

    public int getOctaveTranslation() {
        return octaveTranslation;
    }

    public int getKey() {
        return key;
    }

    public AbstractKeyboard(int octaveTranslation, int key) {
        this.octaveTranslation = octaveTranslation;
        this.key = key;
    }

    public AbstractKeyboard(AbstractKeyboard ak) {
        this.octaveTranslation = ak.getOctaveTranslation();
        this.key = ak.getKey();
    }

    public void setOctaveTranslation(int octaveTranslation) {
        this.octaveTranslation = octaveTranslation;
    }

    public void setKey(int key) {
        this.key = key;
    }

    private void setOctaveKeyTranslation() {
        octaveKeyTranslation = octaveTranslation + key;
    }

    public int getOctaveKeyTranslation() {
        return octaveKeyTranslation;
    }

    public boolean updateOctaveAndKey(KeyEvent keyEvent) {
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
                octaveTranslation = -24;
                return true;
            case X:
                octaveTranslation = -12;
                return true;
            case C:
                octaveTranslation = 0;
                return true;
            case V:
                octaveTranslation = 12;
                return true;
            case B:
                octaveTranslation = 24;
                return true;
            case SHIFT:
                if (octaveTranslation == -24) {

                } else {
                    octaveTranslation -= 12;
                }
                return true;
            case ENTER:
                if (octaveTranslation == 24) {

                } else {
                    octaveTranslation += 12;
                }
                return true;
        }
        return false;
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
    
    private boolean updateKey(KeyCode kc) {
    
        Integer foundKey=changeKeyHashMap.get(kc);
        if (foundKey!=null){
            key=foundKey;
            return true;
        }
        return false;
    }

    /*
    private boolean updateKey(KeyCode kc) {
        switch (kc) {
            case DIGIT1:
                key = 0;
                return true;
            case DIGIT2:
                key = 1;
                return true;
            case DIGIT3:
                key = 2;
                return true;
            case DIGIT4:
                key = 3;
                return true;
            case DIGIT5:
                key = 4;
                return true;
            case DIGIT6:
                key = 5;
                return true;
            case DIGIT7:
                key = 6;
                return true;
            case DIGIT8:
                key = 7;
                return true;
            case DIGIT9:
                key = 8;
                return true;
            case DIGIT0:
                key = 10;
                return true;
            case MINUS:
                key = 10;
                return true;
            case EQUALS:
                key = 11;
                return true;
        }
        return false;
    }
*/

}
