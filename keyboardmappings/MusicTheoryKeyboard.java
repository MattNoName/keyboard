
package keyboardmappings;

import javafx.scene.input.KeyCode;

/**
 *
 * @author mattroberts
 */
public class MusicTheoryKeyboard extends AbstractKeyboard{
    
    public MusicTheoryKeyboard(int octaveTranslation, int key) {
        super(octaveTranslation, key);
    }

    public MusicTheoryKeyboard(AbstractKeyboard ak) {
        super(ak);
        keyHashMap.put(KeyCode.TAB, -12);
        keyHashMap.put(KeyCode.Q, -11);
        keyHashMap.put(KeyCode.A, -10);
        keyHashMap.put(KeyCode.W, -9);
        keyHashMap.put(KeyCode.S, -8);
        keyHashMap.put(KeyCode.E, -7);
        keyHashMap.put(KeyCode.D, -6);
        keyHashMap.put(KeyCode.R, -5);
        keyHashMap.put(KeyCode.F, -4);
        keyHashMap.put(KeyCode.T, -3);
        keyHashMap.put(KeyCode.G, -2);
        keyHashMap.put(KeyCode.Y, -1);
        keyHashMap.put(KeyCode.H, 0);
        keyHashMap.put(KeyCode.U, 1);
        keyHashMap.put(KeyCode.J, 2);
        keyHashMap.put(KeyCode.I, 3);
        keyHashMap.put(KeyCode.K, 4);
        keyHashMap.put(KeyCode.O, 5);
        keyHashMap.put(KeyCode.L, 6);
        keyHashMap.put(KeyCode.P, 7);
        keyHashMap.put(KeyCode.SEMICOLON, 8);
        keyHashMap.put(KeyCode.OPEN_BRACKET, 9);
        keyHashMap.put(KeyCode.QUOTE, 10);
        keyHashMap.put(KeyCode.CLOSE_BRACKET, 11);
        keyHashMap.put(KeyCode.BACK_SLASH, 12);
    }
    
    @Override
    public int getIntFromKey(KeyCode key) throws UnusedKeyCodeException {
        
        Integer foundKey=keyHashMap.get(key);
        if (foundKey!=null){
            return foundKey;
        }
        throw new UnusedKeyCodeException();
    }
    
    

    /*
    @Override
    public int getIntFromKey(KeyCode key) throws UnusedKeyCodeException {
        switch (key) {
            case TAB:
                return -12;
            case Q:
                return -11;
            case A:
                return -10;
            case W:
                return -9;
            case S:
                return -8;
            case E:
                return -7;
            case D:
                return -6;
            case R:
                return -5;
            case F:
                return -4;
            case T:
                return -3;
            case G:
                return -2;
            case Y:
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
            case O:
                return 5;
            case L:
                return 6;
            case P:
                return 7;
            case SEMICOLON:
                return 8;
            case OPEN_BRACKET:
                return 9;
            case QUOTE:
                return 10;
            case CLOSE_BRACKET:
                return 11;
            case BACK_SLASH:
                return 12;
        }
        
        throw new UnusedKeyCodeException();
    }
*/
    
}
