package Objects;

import game.GamePane;
import javafx.geometry.Bounds;

public class Enemy extends gameObject {

    GamePane gamepane;

    public Enemy(String imageFilePath, double X, double Y, double speed , int HP) {
        super(imageFilePath, X, Y);
        this.setDirection(0.0);
        this.setSpeed(speed);
        this.HP=HP;


    }

    public void moveEnemy() {
        for (int i = 0; i < gamepane.getCurrentLevel().getEnemyRows(); i++) {
            for (int j = 0; j < gamepane.getCurrentLevel().getEnemyColumns(); j++) {
                if (gamepane.getCurrentLevel().getEnemy(i, j) != null) {
                    gamepane.getCurrentLevel().getEnemy(i, j).move();
                }
            }
        }
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
        return HP;
    }

    @Override
    public void setHP(int HP) {
        this.HP=HP;
    }



}
