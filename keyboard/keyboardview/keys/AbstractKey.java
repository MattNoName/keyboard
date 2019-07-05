/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview.keys;

import java.util.ArrayList;

/**
 *
 * @author mattroberts
 */
public abstract class AbstractKey extends ArrayList<Integer>{
    
    protected String keyOfString="";

    public String getKeyOfString() {
        return keyOfString;
    }
    
    
}
