/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
