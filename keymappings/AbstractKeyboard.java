/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keymappings;

import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author mattroberts
 */
public abstract class AbstractKeyboard implements KeyboardInterface {

    private SimpleIntegerProperty octaveTranslation = new SimpleIntegerProperty(0);

    private int key = 0;

    public int getOctaveTranslation() {
        return octaveTranslation.intValue();
    }

    public int getKey() {
        return key;
    }

    public AbstractKeyboard(int octaveTranslation, int key) {
        this.octaveTranslation = new SimpleIntegerProperty(octaveTranslation);
        this.key = key;
    }

    public AbstractKeyboard(AbstractKeyboard ak) {
        this.octaveTranslation = new SimpleIntegerProperty(ak.getOctaveTranslation());
        this.key = ak.getKey();
    }

    public void setOctaveTranslation(int octaveTranslation) {
        this.octaveTranslation = new SimpleIntegerProperty(octaveTranslation);
    }

    public void setKey(int key) {
        this.key = key;
    }

    private void setUpChangeListeners() {
        
        //octaveTranslation.addListener(octaveListener);
    }

}
