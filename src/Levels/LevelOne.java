package Levels;

import Objects.Enemy;
import Objects.Player;
import game.GamePane;

public class LevelOne extends Level {

   
    private final int EnemyStartingX = 100;
    private final int EnemyEndingX = 50;
    private final int EnemyStartingY = 100;
    private final int EnemyEndingY = 50;
    

    public LevelOne() {
        
        
        levelOneEnemyColumns= 10 ; 
        levelOneEnemyRows = 3; 
        NoCh = levelOneEnemyColumns * levelOneEnemyRows ;

        enemy = new Enemy[levelOneEnemyRows][levelOneEnemyColumns];
        for (int i = 1; i <= levelOneEnemyRows; i++) {
            for (int j = 1; j <= levelOneEnemyColumns; j++) {
                if ((j - 1) % 2 == 0) {
                    enemy[i - 1][j - 1] = new Enemy("/image/newCh.gif", j * EnemyStartingX, i * EnemyStartingY, 1.0, 150);
   
                    this.getChildren().add(enemy[i - 1][j - 1]);
                } else {
                    enemy[i - 1][j - 1] = new Enemy("/image/chYsmall.gif", j * EnemyStartingX, i * EnemyStartingY, 1.0, 100);
                    enemy[i - 1][j - 1].setFitWidth(94);

                    this.getChildren().add(enemy[i - 1][j - 1]);

                }
            }
        }

        player = new Player("/image/fiter.png", 650, 550);
        this.getChildren().add(player);

        this.setPrefHeight(GamePane.getGamePaneHeight());
        this.setPrefWidth(GamePane.getGamePaneWidth());

    }

    public int getNoCh() {
        return NoCh;
    }

    public void setNoCh(int getNoCh) {
        this.NoCh = getNoCh;
    }

    

    public int getLevelOneEnemyColumns() {
        return levelOneEnemyColumns;
    }

    public int getLevelOneEnemyRows() {
        return levelOneEnemyRows;
    }

    public int getEnemyStartingX() {
        return EnemyStartingX;
    }

    public int getEnemyEndingX() {
        return EnemyEndingX;
    }

    public int getEnemyStartingY() {
        return EnemyStartingY;
    }

    public int getEnemyEndingY() {
        return EnemyEndingY;
    }

    @Override
    public int getEnemyColumns() {
        return levelOneEnemyColumns;
    }

    @Override
    public int getEnemyRows() {
        return levelOneEnemyRows;
    }

    @Override
    public int getStartingNumEnemy() {
        return levelOneEnemyColumns * levelOneEnemyRows;
    }

}
