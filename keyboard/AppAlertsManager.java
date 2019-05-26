
package keyboard;

import alerts.AlertView;

/**
 *
 * @author mattroberts
 */
public class AppAlertsManager {
    
    public static void showAlert(Exception e){
        AlertView.makeAlert(new AppAlertModel(e)).showAndWait();
    }
    
}
