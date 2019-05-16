
package keyboard;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author mattroberts
 */
public class Keyboard extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        /*
        Almost no GUI
        a keyboard for macOs, Windows, and maybe Linux
        19 keys at a time
        start with f?
        many octaves
        two octave step keys
        
        set up sound
        
        add key listener--on key pressed
            have switch based on key code
            set to enum
        
        have play note function
            based on enum, pass in note
        based on another enum, choose octave
        
            
        */
        
        
        StackPane root = new StackPane();
        
        Scene scene = new Scene(root, 300, 250);
        
        EventHandler<KeyEvent> keyPressed=(final KeyEvent keyEvent) -> {
            switch (keyEvent.getCode()){
                case A:
                    System.out.println("A pressed");
                    break;
                case W:
                    System.out.println("W pressed");
                    break;
                case S:
                    break;
                case E:
                    break;
                case D:
                    break;
                case R:
                    break;
                case F:
                    break;
                case G:
                    break;
                case Y:
                    break;
                case H:
                    break;
                case U:
                    break;
                case J:
                    break;
                case K:
                    break;
                case O:
                    break;
                case L:
                    break;
                case P:
                    break;
                case SEMICOLON:
                    break;
                case BRACELEFT:
                    break;
                case QUOTE:
                    break;
                case BRACERIGHT:
                    break;
            }
            
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        };
        
        EventHandler<KeyEvent> keyReleased=new EventHandler<KeyEvent>(){
            @Override
            public void handle(final KeyEvent keyEvent) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        
        scene.setOnKeyPressed(keyPressed);
        scene.setOnKeyReleased(keyReleased);
        
        primaryStage.setTitle("Keyboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
