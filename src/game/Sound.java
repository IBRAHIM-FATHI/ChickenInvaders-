package game;


import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Sound {
    
    private MediaPlayer sound ;
    private Media soundpath ;

    public Sound(String path) {
        
        soundpath = new Media(new File(path).toURI().toString());
        sound = new MediaPlayer(soundpath);
        sound.play();

    }
    
   
    
   
    
    
    
    
    
}
