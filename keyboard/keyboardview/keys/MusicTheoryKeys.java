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
public class MusicTheoryKeys extends AbstractKey{
    
    private String[] keyOfStrArray={"C", "C Sharp", "D", "D Sharp",
        "E", "F", "F Sharp", "G", "G Sharp", "A", "A Sharp, B"};
    
    public MusicTheoryKeys() {
        for (int i=0; i<12; i++){
            add(i);
        }
    }
    
    public void setKey(int index){
        keyOfString=keyOfStrArray[index];
    }
    
}
