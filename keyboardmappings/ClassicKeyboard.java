
package keyboardmappings;

import musictheory.MusicalKey;
import keyboardmappings.classickeys.ClassicGSharpKeys;
import keyboardmappings.classickeys.ClassicEKeys;
import keyboardmappings.classickeys.ClassicFSharpKeys;
import keyboardmappings.classickeys.ClassicASharpKeys;
import keyboardmappings.classickeys.ClassicGKeys;
import keyboardmappings.classickeys.ClassicAKeys;
import keyboardmappings.classickeys.ClassicFKeys;
import keyboardmappings.classickeys.ClassicBKeys;
import keyboardmappings.classickeys.ClassicDSharpKeys;
import keyboardmappings.classickeys.ClassicDKeys;
import keyboardmappings.classickeys.ClassicCSharpKeys;
import keyboardmappings.classickeys.ClassicCKeys;
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
        keyMappingsHashMap.put(1, new ClassicCSharpKeys());
        keyMappingsHashMap.put(2, new ClassicDKeys());
        keyMappingsHashMap.put(3, new ClassicDSharpKeys());
        keyMappingsHashMap.put(4, new ClassicEKeys());
        keyMappingsHashMap.put(5, new ClassicFKeys());
        keyMappingsHashMap.put(6, new ClassicFSharpKeys());
        keyMappingsHashMap.put(7, new ClassicGKeys());
        keyMappingsHashMap.put(8, new ClassicGSharpKeys());
        keyMappingsHashMap.put(9, new ClassicAKeys());
        keyMappingsHashMap.put(10, new ClassicASharpKeys());
        keyMappingsHashMap.put(11, new ClassicBKeys());
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
