package game;

import Levels.Level;
import Objects.fire;
import Objects.Bullet;
import Objects.Egg;
import Objects.Enemy;
import Objects.Player;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

class GameStage extends Stage {

    private GamePane gamepane;
    private Scene scene;
    private Enemy enemy;
    private ArrayList<fire> firedHandler = new ArrayList();
    Timeline animate;
    private long previous = 0;
    private double LastY;
    private double LastX;
    private boolean flag = true;
    private boolean isAlive = true;

    public GameStage() {

        Pane pane = new Pane();

        // Starting start sound
        String path = "src/audio/s2.mp3";
        Media soundpath = new Media(new File(path).toURI().toString());
        MediaPlayer sound = new MediaPlayer(soundpath);
        sound.play();

        // Background
        image bg = new image("/image/bg2.jpg");
        bg.setLayoutX(0);
        bg.setLayoutY(0);
        pane.getChildren().add(bg);

        // set Fan
        image fan = new image("/image/fan.png");
        fan.setLayoutX(1366 * .5 - fan.getBoundsInParent().getWidth() * .5);
        fan.setLayoutY(0);
        fan.setScaleX(3);
        fan.setScaleY(3);
        animateFan(fan);
        pane.getChildren().add(fan);

        // Loge Image
        image logo = new image("/image/logo3.png");
        logo.setLayoutX(1366 * .5 - logo.getBoundsInParent().getWidth() * .5);
        logo.setLayoutY(-100);
        logo.setScaleY(.9);
        pane.getChildren().add(logo);

        //Start Button
        image start = new image("/image/start.png");
        pane.getChildren().add(start);
        start.setLayoutX(1366 * .5 - start.getBoundsInParent().getWidth() * .5);
        start.setLayoutY(logo.getBoundsInParent().getHeight() - 120);
        //Start Button Handler
        start.setOnMouseClicked(e -> {
            Startinggame();
            sound.pause();
        });

        //End Button
        image end = new image("/image/end.png");
        pane.getChildren().add(end);
        end.setLayoutX(1366 * .5 - start.getBoundsInParent().getWidth() * .5);
        end.setLayoutY(logo.getBoundsInParent().getHeight() - 120 + start.getBoundsInParent().getHeight() + 20);
        //End Button Hundler
        end.setOnMouseClicked(e -> {
            this.close();
        });

        scene = new Scene(pane);
        scene.setCamera(new PerspectiveCamera());
      //  scene.setCursor(Cursor.cursor("file:H:\\project\\final image\\main item\\cons.png"));
        scene.setCursor(Cursor.WAIT);
        this.setScene(scene);
        this.setTitle("M.B.Q");
        this.setFullScreen(true);
        this.show();

    }

    public void Startinggame() {

        gamepane = new GamePane();

        scene = new Scene(gamepane);

        scene.setOnKeyPressed(e -> {
            if (e.getEventType().equals(KeyEvent.KEY_PRESSED)) {
                if (e.getCode().equals(KeyCode.RIGHT) || e.getCode().equals(KeyCode.D)) {
                    gamepane.getCurrentLevel().getPlayer().setSpeed(5.0);
                    gamepane.getCurrentLevel().getPlayer().setDirection(0.0);
                } else if (e.getCode().equals(KeyCode.LEFT) || e.getCode().equals(KeyCode.A)) {
                    gamepane.getCurrentLevel().getPlayer().setSpeed(5.0);
                    gamepane.getCurrentLevel().getPlayer().setDirection(180.0);
                } else if (e.getCode().equals(KeyCode.UP) || e.getCode().equals(KeyCode.W)) {
                    gamepane.getCurrentLevel().getPlayer().setSpeed(5.0);
                    gamepane.getCurrentLevel().getPlayer().setDirection(270.0);
                } else if (e.getCode().equals(KeyCode.DOWN) || e.getCode().equals(KeyCode.S)) {

                    gamepane.getCurrentLevel().getPlayer().setSpeed(5.0);
                    gamepane.getCurrentLevel().getPlayer().setDirection(90.0);
                } else if (e.getCode().equals(KeyCode.SPACE)) {
                    firedHandler.add(gamepane.getCurrentLevel().fireBullet());
                } else if (e.getCode().equals(KeyCode.ESCAPE)) {

                    this.hide();
           
                }
            }

            scene.setOnKeyReleased(e1 -> {
                if (e1.getEventType().equals(KeyEvent.KEY_RELEASED)) {
                    if (e1.getCode().isArrowKey() || e1.getCode().equals(KeyCode.W) || e1.getCode().equals(KeyCode.D) || e1.getCode().equals(KeyCode.A) || e1.getCode().equals(KeyCode.S)) {
                        gamepane.getCurrentLevel().getPlayer().setSpeed(0.0);
                    }
                }
            });

        });

        // init
        LastX = 0;
        LastY = 0;
        //init

        if (isAlive) {
            scene.setOnMouseMoved(e -> {
                if (!flag) {
                    Player p = gamepane.getCurrentLevel().getPlayer();
                    p.setX(e.getX());
                    p.setY(e.getY());
                    LastX = e.getX();
                    LastY = e.getY();
                }
            });
        }

        scene.setOnMouseClicked(e -> {
            if (gamepane.getCurrentLevel().getPlayer() != null) {
                if (isAlive) {
                    firedHandler.add(gamepane.getCurrentLevel().fireBullet());
                }
            }
            if (flag) {
                Player p = gamepane.getCurrentLevel().getPlayer();
                m((int) p.getX(), (int) p.getY());
                flag = false;
            }
        });

        animate = new Timeline(new KeyFrame(Duration.millis(15), e -> {
            gameAnimation();
          
        }));
        animate.setCycleCount(Timeline.INDEFINITE);
        animate.play();
        scene.setCursor(Cursor.NONE);
        this.setScene(scene);
        this.setFullScreen(true);
        this.show();

    }

    public void endinggame() {

        this.hide();

    }

    private void animateFan(image fan) {

        Timeline animateFan = new Timeline(new KeyFrame(Duration.millis(25), e -> {

//            fan.setRotationAxis(Rotate.X_AXIS);
//            fan.setRotate(fan.getRotate()+1);
//            System.out.println(fan.getRotate());
            fan.setRotationAxis(Rotate.Z_AXIS);
            fan.setRotate(fan.getRotate() + .5);

//                      Rotate Around 2 Axis
//            Rotate rotateAboutX = new Rotate(60, Rotate.Z_AXIS);
//            Rotate rotateAboutZ = new Rotate(fan.getRotate() + .5, Rotate.Z_AXIS);
//            fan.getTransforms().addAll(rotateAboutX/*, rotateAboutY*/);
//                      anthr way
//            fan.getTransforms().add(new Rotate(60, Rotate.X_AXIS));
//            fan.getTransforms().add(new Rotate(fan.getRotate() + .5, Rotate.Z_AXIS));
        }));
        animateFan.setCycleCount(Timeline.INDEFINITE);
        animateFan.play();
    }

    public void m(int x, int y) {

        Platform.runLater(() -> {
            try {
                Robot r = new Robot();
                r.mouseMove(x, y);

            } catch (AWTException e) {

            }

        });

    }

    private void gameAnimation() {

        gamepane.getCurrentLevel().getPlayer().move();
        gamepane.getCurrentLevel().getPlayer().objectMoveLimets(gamepane);
        checkWin();
        DrobEgg();
        moveEgg();
        moveEnemy();
        EnemyMoveLimet();
        DrobGift() ;

        if (isAlive) {
            Collisions();
        }

    }

    private void moveEnemy() {
        for (int i = 0; i < gamepane.getCurrentLevel().getEnemyRows(); i++) {
            for (int j = 0; j < gamepane.getCurrentLevel().getEnemyColumns(); j++) {
                if (gamepane.getCurrentLevel().getEnemy(i, j) != null) {
                    gamepane.getCurrentLevel().getEnemy(i, j).move();
                }
            }
        }
    }

    private void EnemyMoveLimet() {
        if (gamepane.getCurrentLevel().getEnemy(0, 0).getDirection() == 0.0 && gamepane.getCurrentLevel().getEnemy(0, 0).getX() >= /*gamepane.getCurrentLevel().getEnemyStartingX()*/ +150.0) {
            for (int i = 0; i < gamepane.getCurrentLevel().getEnemyRows(); i++) {
                for (int j = 0; j < gamepane.getCurrentLevel().getEnemyColumns(); j++) {
                    if (gamepane.getCurrentLevel().getEnemy(i, j) != null) {
                        gamepane.getCurrentLevel().getEnemy(i, j).setDirection(90.0);
                    }
                }
            }
        } else if (gamepane.getCurrentLevel().getEnemy(0, 0).getDirection() == 90.0 && gamepane.getCurrentLevel().getEnemy(0, 0).getY() >= /*gamepane.getCurrentLevel().getEnemyStartingY()*/ +150.0) {
            for (int i = 0; i < gamepane.getCurrentLevel().getEnemyRows(); i++) {
                for (int j = 0; j < gamepane.getCurrentLevel().getEnemyColumns(); j++) {
                    if (gamepane.getCurrentLevel().getEnemy(i, j) != null) {
                        gamepane.getCurrentLevel().getEnemy(i, j).setDirection(180.0);
                    }
                }
            }
        } else if (gamepane.getCurrentLevel().getEnemy(0, 0).getDirection() == 180.0 && gamepane.getCurrentLevel().getEnemy(0, 0).getX() <=/* gamepane.getCurrentLevel().getEnemyStartingX()*/ 100) {
            for (int i = 0; i < gamepane.getCurrentLevel().getEnemyRows(); i++) {
                for (int j = 0; j < gamepane.getCurrentLevel().getEnemyColumns(); j++) {
                    if (gamepane.getCurrentLevel().getEnemy(i, j) != null) {
                        gamepane.getCurrentLevel().getEnemy(i, j).setDirection(270.0);
                    }
                }
            }
        } else if (gamepane.getCurrentLevel().getEnemy(0, 0).getDirection() == 270.0 && gamepane.getCurrentLevel().getEnemy(0, 0).getY() <= /*gamepane.getCurrentLevel().getEnemyStartingY()*/ 100) {
            for (int i = 0; i < gamepane.getCurrentLevel().getEnemyRows(); i++) {
                for (int j = 0; j < gamepane.getCurrentLevel().getEnemyColumns(); j++) {
                    if (gamepane.getCurrentLevel().getEnemy(i, j) != null) {
                        gamepane.getCurrentLevel().getEnemy(i, j).setDirection(0.0);
                    }
                }
            }
        }

    }

    private void DrobEgg() {
        Random rand = new Random();
        int fireInt = rand.nextInt(75);
        if (fireInt == 5) {
            int firingChickenRow = rand.nextInt(gamepane.getCurrentLevel().getEnemyRows());
            int firingChickenColumn = rand.nextInt(gamepane.getCurrentLevel().getEnemyColumns());

            if (firingChickenRow == 0 && firingChickenColumn == 0) {
                if (gamepane.getCurrentLevel().getEnemy(firingChickenRow, firingChickenColumn).isVisible()) {
                    firedHandler.add(gamepane.getCurrentLevel().dropBomb(gamepane.getCurrentLevel().getEnemy(firingChickenRow, firingChickenColumn)));
                }
            } else if (gamepane.getCurrentLevel().getEnemy(firingChickenRow, firingChickenColumn) != null) {

                firedHandler.add(gamepane.getCurrentLevel().dropBomb(gamepane.getCurrentLevel().getEnemy(firingChickenRow, firingChickenColumn)));

                new Sound("src/audio/drobegg.mp3");

            }
        }
    }
    
    private void DrobGift() {
        Random rand = new Random();
        int fireInt = rand.nextInt(125);
        if (fireInt == 5) {
            int firingChickenRow = rand.nextInt(gamepane.getCurrentLevel().getEnemyRows());
            int firingChickenColumn = rand.nextInt(gamepane.getCurrentLevel().getEnemyColumns());

            if (firingChickenRow == 0 && firingChickenColumn == 0) {
                if (gamepane.getCurrentLevel().getEnemy(firingChickenRow, firingChickenColumn).isVisible()) {
                    firedHandler.add(gamepane.getCurrentLevel().dropGift(gamepane.getCurrentLevel().getEnemy(firingChickenRow, firingChickenColumn)));
                }
            } else if (gamepane.getCurrentLevel().getEnemy(firingChickenRow, firingChickenColumn) != null) {

                firedHandler.add(gamepane.getCurrentLevel().dropGift(gamepane.getCurrentLevel().getEnemy(firingChickenRow, firingChickenColumn)));

            //    new Sound("src/audio/drobegg.mp3");

            }
        }
    }

    private void moveEgg() {

        for (int i = 0; i < firedHandler.size(); i++) {
            if (firedHandler.get(i) != null) {
                firedHandler.get(i).move();
            }

        }
    }

    private void Collisions() {

        Level temp = gamepane.getCurrentLevel();
        for (int k = 0; k < firedHandler.size(); k++) {
            fire fire = firedHandler.get(k);
            if (fire instanceof Bullet) {
                for (int i = 0; i < temp.getEnemyRows(); i++) {
                    for (int j = 0; j < temp.getEnemyColumns(); j++) {
                        Enemy selectedEnemy = temp.getEnemy(i, j);
                        if (selectedEnemy != null) {
                            if (fire.getBoundrs().intersects(selectedEnemy.getBoundsInLocal())) {
                                temp.removefire(firedHandler.remove(k));

                                selectedEnemy.setHP(selectedEnemy.getHP() - ((Bullet) fire).geteffect());
                                if (selectedEnemy.getHP() <= 0) {
                                    temp.killEnemy(i, j);
                                    temp.setNoCh(temp.getNoCh() - 1);
                                }

                            }

                        }

                    }
                }
            } else if (fire instanceof Egg) {
                if (fire.getBoundrs().intersects(temp.getPlayer().getLayoutBounds())) {
                    temp.removefire(firedHandler.remove(k));
                    temp.setNoTry(temp.getNoTry() - 1);
                    temp.removePlayer(temp.getPlayer());
                    flag = true;

                    temp.explode();

                    if (temp.getNoTry() <= 0) {
                        isAlive = false;
                        gameLose();
                    } else {
                        temp.addplayer();

                    }
                }

                if (fire.getY() >= 725) {
                    temp.eggBroke((int) fire.getX(), 725);
                    temp.removefire(firedHandler.remove(k));

                }
            }
        }

        for (int i = 0; i < temp.getEnemyRows(); i++) {
            for (int j = 0; j < temp.getEnemyColumns(); j++) {
                if (temp.getEnemy(i, j) != null) {
                    if (temp.getEnemy(i, j).getBoundrs().intersects(temp.getPlayer().getLayoutBounds())) {

                        temp.killEnemy(i, j);
                        temp.removePlayer(temp.getPlayer());
                        temp.setNoTry(temp.getNoTry() - 1);
                        temp.explode();
                        flag = true;

                        if (temp.getNoTry() <= 0) {
                            isAlive = false;
                            gameLose();
                        } else {
                            temp.addplayer();

                        }

                    }
                }
            }
        }

    }

    public void checkWin() {

        Level temp = gamepane.getCurrentLevel();
      

        if (temp.getNoCh() ==1 ) {
           Label win = new Label(" You Win ");
           win.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 120));
           animate.stop();
           win.setLayoutX(450);
           win.setLayoutY(260);
           win.setTextFill(Color.WHITE);
           gamepane.getChildren().add(win);
           // Starting win sound
        String path = "src/audio/win.mp3";
        Media soundpath = new Media(new File(path).toURI().toString());
        MediaPlayer sound = new MediaPlayer(soundpath);
        sound.play();
        
        nextLevel();
           
        }
    }

    private void gameLose() {

        new Sound("src/audio/lose.mp3");

        //timer.stop();
        gamepane.getCurrentLevel().removePlayer(gamepane.getCurrentLevel().getPlayer());
        // gamepane.getCurrentLevel().losegame();

        System.out.println("u lose");

    }

    private void nextLevel() {
        
    }
}
