
package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class image extends Pane {
    
    private Image path ; 
    private ImageView image;
    
    
    public image ( String path){
        
        this.path= new Image(path);
        this.image= new ImageView(this.path);
        
        getChildren().add(image);

    }
    
}
