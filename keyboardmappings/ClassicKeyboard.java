
package keyboardmappings;

import java.util.HashMap;
import javafx.scene.input.KeyCode;

/**
 *
 * @author mattroberts
 */
public class ClassicKeyboard extends AbstractKeyboard{
    
    private HashMap<Integer, HashMap<KeyCode, Integer>> keyMappingsHashMap=new HashMap<>();

    private void setUpkeyMappingsHashMap(){
        makeKeyMappingsHashMap();
        setKeyMapping(key);
    }

    public ClassicKeyboard(int octaveTranslation, MusicalKey mk) {
        super(octaveTranslation, mk);
        setUpkeyMappingsHashMap();
    }

    public ClassicKeyboard(AbstractKeyboard ak) {
        super(ak);
        setUpkeyMappingsHashMap();
    }
    
    protected void makeKeyMappingsHashMap(){
        keyMappingsHashMap.put(0, new ClassicCKeys());
    }
    
    private void setKeyMapping(int key){
        keyHashMap=keyMappingsHashMap.get(key);
    }
    
    @Override
    protected void setKey(MusicalKey mk){
        super.setKey(mk);
        setKeyMapping(key);
    }
    
    @Override
    protected boolean updateKey(KeyCode kc) {
        boolean updated=super.updateKey(kc);
        setKeyMapping(key);
        return updated;
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
    
    
    
}
