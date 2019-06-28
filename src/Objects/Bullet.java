package Objects;

import game.GamePane;
import game.Sound;
import javafx.geometry.Bounds;

public class Bullet extends fire {
    
    private int effect ;

    public Bullet(String imageFilePath, double X, double Y, double speed) {
        super(imageFilePath, X, Y, speed);
        this.setDirection(270);
        new Sound("src/audio/firebullet.mp3");
        setEffect(60) ;

    }

    @Override
    public Bounds getBoundrs() {
        return this.getBoundsInLocal();
    }

    @Override
    public void objectMoveLimets(GamePane gamepane) {
    }

    @Override
    public int getHP() {
        return 0 ;
    }

    public int geteffect() {
        return effect;
    }

    public void setEffect(int effect) {
        this.effect = effect;
    }

    @Override
    public void setHP(int HP) {
    }
    


}
