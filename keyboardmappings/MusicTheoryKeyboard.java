
package keyboardmappings;

import musictheory.MusicalKey;

/**
 *
 * @author mattroberts
 */
public class MusicTheoryKeyboard extends AbstractKeyboard{
    
    public MusicTheoryKeyboard(int octaveTranslation, MusicalKey mk) {
        super(octaveTranslation, mk);
        keyHashMap=new MusicTheoryKeys();
    }

    public MusicTheoryKeyboard(AbstractKeyboard ak) {
        super(ak);
        keyHashMap=new MusicTheoryKeys();
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
