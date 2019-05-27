package keyboard;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author mattroberts
 */
public class Keyboard extends Application {
    
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
