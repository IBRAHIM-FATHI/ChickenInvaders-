package Objects;

import game.GamePane;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;

public abstract class gameObject extends ImageView {

    private double direction;
    private double speed;
    protected int HP;


    public gameObject(String imageFilePath, double startingX, double startingY) {
        super(imageFilePath);
        this.setX(startingX);
        this.setY(startingY);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public void move() {
        this.setX(this.getX() + speed * Math.cos(direction * (Math.PI) / 180));
        this.setY(this.getY() + speed * Math.sin(direction * (Math.PI) / 180));
    }

    public abstract int getHP();

    public abstract void setHP(int HP);

    public abstract void objectMoveLimets(GamePane gamepane);

    public abstract Bounds getBoundrs();
}
