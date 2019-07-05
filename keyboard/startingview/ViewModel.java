
package keyboard.startingview;

/**
 *
 * @author mattroberts
 */
public class ViewModel {
    
    String getThankYouText(){
        StringBuilder strBuilder=new StringBuilder();
        strBuilder.append("Thank you to Osa for introducing me to the Java midi sound library which is used to create sound with your computer.\n\n");
        
        strBuilder.append("Thank you to Osa again and to Vanely for encouraging me to create this keyboard.\n\n");
        
        strBuilder.append("Thank you to Wayne for testing it on Windows so we could find why it didn't initially work on Windows.\n\n");
        
        strBuilder.append("Thank you to Tsung-Lin for testing it on Windows again once it was made compatible with Windows.");
        return strBuilder.toString();
    }
    
    String getTeachingText(boolean spoken){
        StringBuilder strBuilder=new StringBuilder();
        strBuilder.append("This app lets your computer keyboard act as an electric keyboard that plays the notes as you play the keys.\n\n");
        
        strBuilder.append("Its window must be the last thing you clicked on for it to play the notes you play. ");
        strBuilder.append("No keyboard will show up on your screen, and the window of this application must have focus (such as by being the last thing you clicked on) in order for it to play notes when you play the keys.\n\n");
        
        strBuilder.append("It is really meant for a QWERTY keyboard (a keyboard where the top left letters are, from left to right, Q, W, E, R T, Y).  ");
        strBuilder.append("This is important because you want the keys for the notes to be where you want them to be.  ");
        strBuilder.append("All the keys for notes are within the two rows of keys that are below the number keys.\n\n");
        
        strBuilder.append("It has two keyboards: a piano keyboard and a music theory keyboard.  ");
        strBuilder.append("To use the piano keyboard, type N.  ");
        strBuilder.append("To use the music theory keyboard, type M.\n\n");
        
        strBuilder.append("For the piano keyboard, the keys are like those on an electric keyboard or a piano.  ");
        strBuilder.append("The first key on your keyboard of the key you are using is A or Q for all keys.\n\n");
        
        strBuilder.append("The music theory keyboard has each note one key away from the next on the keyboard.  ");
        strBuilder.append("Go up and to the right or down and to the left to go up a note.  ");
        strBuilder.append("Go down and to the left or up and to the left to go down a note.\n\n");
        
        strBuilder.append("For either keyboard, switch octaves by pressing Z, X, C, V, or B.  ");
        strBuilder.append("C gives you a keyboard that uses middle C.  ");
        strBuilder.append("X is down one octave from middle C and Z is down two.  ");
        strBuilder.append("V is up one octave from middle C and B is up two.\n\n");
        
        strBuilder.append("To change keys, use the number keys, the minus key, and the equals key.  ");
        if(spoken){
            strBuilder.append("1 is for C, 2 is for C sharp, 3 is for D, 4 is for D sharp, 5 is for E, 6 is for F, 7 is for F sharp, 8 is for G, 9 is for G sharp, 0 is for A, minus is for B sharp, and equals is for B.\n\n");
        }else{
            strBuilder.append("1 is for C, 2 is for C# (C sharp), 3 is for D, 4 is for D# (D sharp), 5 is for E, 6 is for F, 7 is for F# (F sharp), 8 is for G, 9 is for G# (G sharp), 0 is for A, minus is for A# (A sharp), and equals is for B.\n\n");
        }
        strBuilder.append("To make notes keep playing after you lift your fingers, press caps lock.  ");
        strBuilder.append("To stop this, press caps lock again.  ");
        strBuilder.append("On a piano, this is done by the sustaining pedal.\n\n");
        
        strBuilder.append("To make just the notes you are already playing play after you have lifted your fingers, press and hold space bar.  ");
        strBuilder.append("Let go of space bar to stop their playing.  ");
        strBuilder.append("On a piano, this is done by the sostenuto pedal.");
        
        return strBuilder.toString();
    }
}
