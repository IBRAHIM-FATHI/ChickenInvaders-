package Objects;

import game.GamePane;
import javafx.geometry.Bounds;

public class Player extends gameObject {
    

    public Player(String imageFilePath, double startingX, double startingY) {
        super(imageFilePath, startingX, startingY);
    }

  

    @Override
    public void objectMoveLimets(GamePane gamepane) {
        if (gamepane.getCurrentLevel().getPlayer().getX() <= 0.0) {
            gamepane.getCurrentLevel().getPlayer().setX(5.0);
        }
        if (gamepane.getCurrentLevel().getPlayer().getX() >= 1300.0) {
            gamepane.getCurrentLevel().getPlayer().setX(1295.0);
        }
        if (gamepane.getCurrentLevel().getPlayer().getY() <= 0) {
            gamepane.getCurrentLevel().getPlayer().setY(5);
        }
        if (gamepane.getCurrentLevel().getPlayer().getY() >= 700) {
            gamepane.getCurrentLevel().getPlayer().setY(695);
        }
    }

    @Override
    public int getHP() {
        return 0 ;
    }

    @Override
    public void setHP(int HP) {
    }
    
      @Override
    public Bounds getBoundrs() {
        return this.getBoundsInLocal();
    }


}
