/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.keyboardview.keys;

/**
 *
 * @author mattroberts
 */
public class KeyLabels {
    
    private final char [] changeKeys={'1','2','3','4','5','6','7','8','9','0','-','='};
    private final String [] keyStrings={"C", "C#", "D", "D#", "E", "F", "F#", 
                                        "G", "G#", "A", "A#", "B"};
    private final char [] topKeys={'Q','W','E','R','T','Y','U','I','O','P','[',']'};
    private final char [] bottomKeys={'A','S','D','F','G','H','J','K','L',';','\''};
    
    private final char [] octaveKeys={'Z','X','C','V','B'};
    private final String [] octaveStrings={"-2","-1","C","+1","+2"};
    
    public char[] getChangeKeys() {
        return changeKeys;
    }

    public String[] getKeyStrings() {
        return keyStrings;
    }
    
    public char[] getTopKeys() {
        return topKeys;
    }

    public char[] getBottomKeys() {
        return bottomKeys;
    }

    public char[] getOctaveKeys() {
        return octaveKeys;
    }

    public String[] getOctaveStrings() {
        return octaveStrings;
    }
    
    
    
    
    
}
