package keyboard;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author mattroberts
 */
public class Keyboard extends Application {

    /*
        Almost no GUI
        a keyboard for macOS, Windows, and maybe Linux
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
    /*
        Buttons as part of view
        view object as part of controller
        actions in controller
     */
    
    @Override
    public void start(Stage primaryStage) {

        KeyboardManager keyboardManager = new KeyboardManager(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
