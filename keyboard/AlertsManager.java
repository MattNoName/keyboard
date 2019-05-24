
package keyboard;

import javafx.scene.control.Alert;

/**
 *
 * @author mattroberts
 */
public class AlertsManager {
    
    public static void showAlert(Exception e){
        showAlert(AlertModel.makeAlertData(e));
    }
    
    public static void showAlert(AlertModel model){
        Alert alert=new Alert(Alert.AlertType.NONE);
        alert.setTitle(model.getTitle());
        alert.setContentText(model.getDescription());
        alert.showAndWait();
    }
    
}
