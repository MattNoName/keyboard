
package keyboardmappings;

import java.util.HashMap;
import javafx.scene.input.KeyCode;

/**
 *
 * @author mattroberts
 */
public class TraditionalKeyboard extends AbstractKeyboard{
    
    private HashMap<KeyCode, HashMap<KeyCode, Integer>> keyMappingsHashMap=new HashMap<>();


    public TraditionalKeyboard(int octaveTranslation, int key) {
        super(octaveTranslation, key);
    }

    public TraditionalKeyboard(AbstractKeyboard ak) {
        super(ak);
    }
    
    

    @Override
    public int getIntFromKey(KeyCode key) throws UnusedKeyCodeException{
        return getCIntFromKey(key);
    }
    
    private int getEIntFromKey(KeyCode key) throws UnusedKeyCodeException {
        switch (key) {
            case A:
                return -8;
            case S:
                return -7;
            case E:
                return -6;
            case D:
                return -5;
            case R:
                return -3;
            case F:
                return -2;
            case G:
                return -1;
            case H:
                return 0;
            case U:
                return 1;
            case J:
                return 2;
            case I:
                return 3;
            case K:
                return 4;
            case L:
                return 5;
            case P:
                return 6;
            case SEMICOLON:
                return 7;
            case BRACELEFT:
                return 8;
            case QUOTE:
                return 9;
            case BRACERIGHT:
                return 10;
        }
        throw new UnusedKeyCodeException();
    }
    
    private int getCIntFromKey(KeyCode key) throws UnusedKeyCodeException {
        switch (key) {
            case A:
                return 0;
            case W:
                return 1;
            case S:
                return 2;
            case E:
                return 3;
            case D:
                return 4;
            case F:
                return 5;
            case T:
                return 6;
            case G:
                return 7;
            case Y:
                return 8;
            case H:
                return 9;
            case U:
                return 10;
            case J:
                return 11;
            case K:
                return 12;
            case O:
                return 13;
            case L:
                return 14;
            case P:
                return 15;
            case SEMICOLON:
                return 16;
            case QUOTE:
                return 17;
            case CLOSE_BRACKET:
                return 18;
        }
        
        throw new UnusedKeyCodeException();
    }
    
}
