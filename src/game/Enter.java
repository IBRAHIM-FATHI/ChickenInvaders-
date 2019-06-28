package game;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Enter extends Pane {

    Label[] text;

    public Enter() {

        text = new Label[13];
        
        

        image bg = new image("/image/bg2.jpg");
        bg.setLayoutX(0);
        bg.setLayoutY(0);
        this.getChildren().add(bg);

        text[0] = new Label("The Game is Designed Under");
        text[0].setFont(Font.font("Old English Text MT", FontWeight.BOLD, FontPosture.ITALIC, 40));

        text[1] = new Label("The Supervision of ");
        text[1].setFont(Font.font("Old English Text MT", FontWeight.BOLD, FontPosture.ITALIC, 30));
       

        text[2] = new Label("Dr: Hitham Mohammed");
        text[2].setFont(Font.font("Blackadder ITC", FontWeight.BOLD, FontPosture.ITALIC, 50));

        text[3] = new Label("With The Assisance Of");
        text[3].setFont(Font.font("Old English Text MT", FontWeight.BOLD, FontPosture.ITALIC, 30));

        text[4] = new Label("Eng : Ahmed Abd-ElBaset");
        text[4].setFont(Font.font("Blackadder ITC", FontWeight.BOLD, FontPosture.ITALIC, 40));

        text[5] = new Label("Eng :Mahmoud Ibrahim");
        text[5].setFont(Font.font("Blackadder ITC", FontWeight.BOLD, FontPosture.ITALIC, 40));

        text[6] = new Label("Done by");
        text[6].setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 25));

        text[7] = new Label("Ahmed Mohammed Samy Mohammed El-Eraki Salem");
        text[7].setFont(Font.font("Engravers MT", FontWeight.BOLD, FontPosture.ITALIC, 20));

        text[8] = new Label("Ahmed Mohammed Reda Goda");
        text[8].setFont(Font.font("Engravers MT", FontWeight.BOLD, FontPosture.ITALIC, 20));

        text[9] = new Label("Karim Soilman AbdElMawla");
        text[9].setFont(Font.font("Engravers MT", FontWeight.BOLD, FontPosture.ITALIC, 20));

        text[10] = new Label("Saeed Mohamadi Mohammed Mohamdi");
        text[10].setFont(Font.font("Engravers MT", FontWeight.BOLD, FontPosture.ITALIC, 20));

        text[11] = new Label("Abd-Elrhman ElSayed Mohamed");
        text[11].setFont(Font.font("Engravers MT", FontWeight.BOLD, FontPosture.ITALIC, 20));

        text[12] = new Label("Omar Soliman Elsayed");
        text[12].setFont(Font.font("Engravers MT", FontWeight.BOLD, FontPosture.ITALIC, 20));
        

        for (int i = 0; i < text.length; i++) {
            this.getChildren().add(text[i]);
        }

        animate();
    }

    public void fit() {
        text[0].setLayoutX((this.getWidth() - text[0].getWidth()) / 2);
        text[1].setLayoutX((this.getWidth() - text[1].getWidth()) / 2);
        text[2].setLayoutX((this.getWidth() - text[2].getWidth()) / 2);
        text[3].setLayoutX((this.getWidth() - text[3].getWidth()) / 2);
        text[4].setLayoutX((this.getWidth() - text[4].getWidth()) / 2);
        text[5].setLayoutX((this.getWidth() - text[5].getWidth()) / 2);
        text[6].setLayoutX((this.getWidth() - text[6].getWidth()) / 2);
        text[7].setLayoutX((this.getWidth() - text[7].getWidth()) / 2);
        text[8].setLayoutX((this.getWidth() - text[8].getWidth()) / 2);
        text[9].setLayoutX((this.getWidth() - text[9].getWidth()) / 2);
        text[10].setLayoutX((this.getWidth() - text[10].getWidth()) / 2);
        text[11].setLayoutX((this.getWidth() - text[11].getWidth()) / 2);
        text[12].setLayoutX((this.getWidth() - text[12].getWidth()) / 2);
//        text[13].setLayoutX((this.getWidth() - text[13].getWidth()) / 2);

        text[0].setLayoutY(this.getHeight() * .05);
        text[1].setLayoutY(text[0].getLayoutY() + text[0].getHeight() + 10);
        text[2].setLayoutY(text[1].getLayoutY() + text[1].getHeight() + 10);
        text[3].setLayoutY(text[2].getLayoutY() + text[2].getHeight() + 10);
        text[4].setLayoutY(text[3].getLayoutY() + text[3].getHeight() + 10);
        text[5].setLayoutY(text[4].getLayoutY() + text[4].getHeight() + 10);
        text[6].setLayoutY(text[5].getLayoutY() + text[5].getHeight() + 10);
        text[7].setLayoutY(text[6].getLayoutY() + text[6].getHeight() + 10);
        text[8].setLayoutY(text[7].getLayoutY() + text[7].getHeight() + 10);
        text[9].setLayoutY(text[8].getLayoutY() + text[8].getHeight() + 10);
        text[10].setLayoutY(text[9].getLayoutY() + text[9].getHeight() + 10);
        text[11].setLayoutY(text[10].getLayoutY() + text[10].getHeight() + 10);
        text[12].setLayoutY(text[11].getLayoutY() + text[11].getHeight() + 10);
       // text[13].setLayoutY(text[12].getLayoutY() + text[12].getHeight() + 10);
    }

    public void animate() {

        for (int i = 0; i < text.length; i++) {
            text[i].setTextFill(Color.WHITE);

            text[i].setLayoutY(text[i].getLayoutY() + 3);

        }

    }
}
