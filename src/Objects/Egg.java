package Objects;

import game.GamePane;
import game.Sound;
import javafx.geometry.Bounds;

public class Egg extends fire {

    public Egg(String imageFilePath, double X, double Y, double speed) {
        super(imageFilePath, X, Y, speed);
        this.setDirection(90);

        new Sound("src/audio/drobegg.mp3");

    }

    @Override
    public Bounds getBoundrs() {
        return this.getBoundsInLocal();
    }

    @Override
    public void objectMoveLimets(GamePane gamepane) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHP() {
        return 0;
    }

    @Override
    public void setHP(int HP) {
    }
    


}
