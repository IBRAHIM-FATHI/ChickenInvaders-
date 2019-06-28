package Levels;

import Objects.Enemy;
import Objects.Player;
import game.GamePane;

public class LevelTwo extends Level {

    private final int EnemyStartingX = 100;
    private final int EnemyEndingX = 50;
    private final int EnemyStartingY = 100;
    private final int EnemyEndingY = 50;

    public LevelTwo() {
        levelOneEnemyColumns = 10;
        levelOneEnemyRows = 3;
        NoCh = levelOneEnemyColumns * levelOneEnemyRows;

        enemy = new Enemy[levelOneEnemyRows][levelOneEnemyColumns];
        for (int i = 1; i <= levelOneEnemyRows; i++) {
            for (int j = 1; j <= levelOneEnemyColumns; j++) {
                enemy[i - 1][j - 1] = new Enemy("/image/greenChicken.gif", j * EnemyStartingX, i * EnemyStartingY, 1.0, 100);
                this.getChildren().add(enemy[i - 1][j - 1]);
            }
        }

        player = new Player("/image/fiter.png", 650, 550);
        this.getChildren().add(player);

        this.setPrefHeight(GamePane.getGamePaneHeight());
        this.setPrefWidth(GamePane.getGamePaneWidth());

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

    @Override
    public int getNoCh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNoCh(int getNoCh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
