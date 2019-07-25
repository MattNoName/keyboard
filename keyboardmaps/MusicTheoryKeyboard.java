
package keyboardmaps;

import keyboardmaps.keys.MusicTheoryKeys;
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
    
}
