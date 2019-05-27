/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circulararray;

/**
 *
 * @author mattroberts
 */
public class CircularArray <T>{
    
    T [] valuesArray;
    int currentIndex=0;
    
    CircularArray(T [] valuesArray) throws NullOrEmptyException{
        if (valuesArray==null ||valuesArray.length==0){
            throw new NullOrEmptyException();
        }
        this.valuesArray=valuesArray;
    }
    
    void moveForward(){
        if (currentIndex==valuesArray.length-1){
            currentIndex=0;
        }
        else{
            currentIndex++;
        }
    }
    
    void moveBackward(){
        if (currentIndex==0){
            currentIndex=valuesArray.length-1;
        }
        else{
            currentIndex++;
        }
    }
    
    T getCurrent(){
        return valuesArray[currentIndex];
    }
}
