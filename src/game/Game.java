package game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application {

    @Override
    public void start(Stage stage) {
        
        Enter name = new Enter();

        Scene scene = new Scene(name);
        scene.setOnMouseClicked(e -> {
            new GameStage();
            stage.close();
        });
        stage.setScene(scene);

        stage.setFullScreen(true);
        stage.show();
        name.fit();

    }

    public static void main(String[] args) {

        launch(args);

    }

}
