package Levels;

import Objects.Bullet;
import javafx.scene.layout.Pane;
import Objects.Egg;
import Objects.Enemy;
import Objects.Player;
import Objects.fire;
import game.Sound;
import game.image;

public abstract class Level extends Pane {

    protected int noTry = 5;
    protected Enemy[][] enemy;
    protected Player player;
    protected int levelOneEnemyColumns;
    protected int levelOneEnemyRows ;
    protected int NoCh;

    public int getNoTry() {
        return noTry;
    }

    public void setNoTry(int noTry) {
        this.noTry = noTry;
    }

    public Enemy getEnemy(int row, int column) {
        if (enemy[row][column] != null) {
            return enemy[row][column];
        } else {
            return null;
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void explode() {
        image explode = new image("/image/ex.gif");
        explode.setLayoutX(player.getX());
        explode.setLayoutY(player.getY());
        this.getChildren().add(explode);
        new Sound("src/audio/explode.mp3");

    }

    public void eggBroke(int x, int y) {
        image eggBroke = new image("/image/eggBroke.gif");
        eggBroke.setLayoutX(x);
        eggBroke.setLayoutY(y);
        eggBroke.setScaleX(2);
        eggBroke.setScaleY(2);
        this.getChildren().add(eggBroke);
        // new Sound("src/audio/explode.mp3");

    }

    public fire fireBullet() {
        fire bullet = new Bullet("/image/bullet1.png", player.getX()+ player.getLayoutBounds().getWidth()/2 - 15, player.getY(), 5);
        this.getChildren().add(bullet);
        return bullet;
    }

    public fire dropBomb(Enemy enemy) {
        fire egg = new Egg("/image/egg2.png", enemy.getX() + 25, enemy.getY() + 25, 3);
        egg.setScaleX(.7);
        egg.setScaleY(.7);

        this.getChildren().add(egg);
        return egg;
    }
    
    public fire dropGift(Enemy enemy) {
        fire egg = new Egg("/image/cons.png", enemy.getX() + 25, enemy.getY() + 25, 3);
        egg.setScaleX(.7);
        egg.setScaleY(.7);

        this.getChildren().add(egg);
        return egg;
    }

    public void killEnemy(int row, int column) {
        if (row == 0 && column == 0) {
            enemy[row][column].setVisible(false);
        } else {
            this.getChildren().remove(enemy[row][column]);
            enemy[row][column] = null;
        }

        new Sound("src/audio/killChicken.mp3");
    }

    public void losegame() {

    }

    public void removefire(fire fired) {
        this.getChildren().remove(fired);
    }

    public void removePlayer(Player player) {
        this.getChildren().remove(player);
    }

    public void addplayer() {

        Player player = new Player("/image/fiter.png", 650, 550);
        this.getChildren().add(player);
        this.setPlayer(player);
    }
    
    public abstract int getNoCh() ;

    public abstract void setNoCh(int getNoCh) ;

    public abstract int getEnemyColumns();

    public abstract int getEnemyRows();

    public abstract int getEnemyStartingX();

    public abstract int getEnemyStartingY();

    public abstract int getEnemyEndingX();

    public abstract int getEnemyEndingY();

    public abstract int getStartingNumEnemy();

}
