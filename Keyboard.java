
package keyboard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author mattroberts
 */
public class Keyboard extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        StackPane root = new StackPane();
        
        Scene scene = new Scene(root, 300, 250);
        
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
