
package keyboardmappings;

import musictheory.MusicalKey;
import keyboardmappings.pianokeys.PianoGSharpKeys;
import keyboardmappings.pianokeys.PianoEKeys;
import keyboardmappings.pianokeys.PianoFSharpKeys;
import keyboardmappings.pianokeys.PianoASharpKeys;
import keyboardmappings.pianokeys.PianoGKeys;
import keyboardmappings.pianokeys.PianoAKeys;
import keyboardmappings.pianokeys.PianoFKeys;
import keyboardmappings.pianokeys.PianoBKeys;
import keyboardmappings.pianokeys.PianoDSharpKeys;
import keyboardmappings.pianokeys.PianoDKeys;
import keyboardmappings.pianokeys.PianoCSharpKeys;
import keyboardmappings.pianokeys.PianoCKeys;
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
    
    protected void makeKeyMappingsHashMap(){
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
