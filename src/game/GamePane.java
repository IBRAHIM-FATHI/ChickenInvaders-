package game;

import Levels.Level;
import Levels.LevelOne;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class GamePane extends Pane {

    private static final int HEIGHT = 1000;
    private static final int WIDTH = 650;

    private Level currentLevel;

    public GamePane() {

        setBackground(new Background(new BackgroundImage(new Image("/image/bg2.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        currentLevel = new LevelOne();

        this.getChildren().add(currentLevel);

//        this.setPrefHeight(HEIGHT);
//        this.setPrefWidth(WIDTH);
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }

    public static int getGamePaneHeight() {
        return HEIGHT;
    }

    public static int getGamePaneWidth() {
        return WIDTH;
    }

}
