
package alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import keyboard.AppAlertModel;

/**
 *
 * @author mattroberts
 */
public class AlertView {
    public static Alert makeAlert(AppAlertModel model){
        Alert alert=new Alert(AlertType.NONE);
        alert.setTitle(model.getTitle());
        alert.setContentText(model.getDescription());
        return alert;
    }
}
