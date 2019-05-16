
package keyboard;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
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
        
        KeyboardManager keyboardManager=new KeyboardManager(scene);
        
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
