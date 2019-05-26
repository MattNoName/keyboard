
package alerts;

/**
 *
 * @author mattroberts
 */
public class AlertModel {
    
    protected String title;
    protected String description;

    public AlertModel() {
        
    }
    
    

    public AlertModel(String title, String description) {
        this.title = title;
        this.description = description;
    }
    
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    
    public AlertModel(Exception exception){
            title="Exception";
            
            description=exception.toString();
    }
    
}
