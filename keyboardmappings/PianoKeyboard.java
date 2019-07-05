
package keyboardmappings;

import musictheory.MusicalKey;
import keyboardmappings.keys.PianoGSharpKeys;
import keyboardmappings.keys.PianoEKeys;
import keyboardmappings.keys.PianoFSharpKeys;
import keyboardmappings.keys.PianoASharpKeys;
import keyboardmappings.keys.PianoGKeys;
import keyboardmappings.keys.PianoAKeys;
import keyboardmappings.keys.PianoFKeys;
import keyboardmappings.keys.PianoBKeys;
import keyboardmappings.keys.PianoDSharpKeys;
import keyboardmappings.keys.PianoDKeys;
import keyboardmappings.keys.PianoCSharpKeys;
import keyboardmappings.keys.PianoCKeys;
import java.util.HashMap;
import javafx.scene.input.KeyCode;

/**
 *
 * @author mattroberts
 */
public class PianoKeyboard extends AbstractKeyboard{
    
    private HashMap<Integer, HashMap<KeyCode, Integer>> keyMappingsHashMap=new HashMap<>();

    private void setUpkeyMappingsHashMap(){
        makeKeyMappingsHashMap();
        setKeyMapping(key);
    }

    public PianoKeyboard(int octaveTranslation, MusicalKey mk) {
        super(octaveTranslation, mk);
        setUpkeyMappingsHashMap();
    }

    public PianoKeyboard(AbstractKeyboard ak) {
        super(ak);
        setUpkeyMappingsHashMap();
    }
    
    private void makeKeyMappingsHashMap(){
        keyMappingsHashMap.put(0, new PianoCKeys());
        keyMappingsHashMap.put(1, new PianoCSharpKeys());
        keyMappingsHashMap.put(2, new PianoDKeys());
        keyMappingsHashMap.put(3, new PianoDSharpKeys());
        keyMappingsHashMap.put(4, new PianoEKeys());
        keyMappingsHashMap.put(5, new PianoFKeys());
        keyMappingsHashMap.put(6, new PianoFSharpKeys());
        keyMappingsHashMap.put(7, new PianoGKeys());
        keyMappingsHashMap.put(8, new PianoGSharpKeys());
        keyMappingsHashMap.put(9, new PianoAKeys());
        keyMappingsHashMap.put(10, new PianoASharpKeys());
        keyMappingsHashMap.put(11, new PianoBKeys());
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

    
}
