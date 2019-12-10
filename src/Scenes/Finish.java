package Scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Finish {
    public Scene setFailedScene() {
        StackPane pane = new StackPane();
        VBox box = new VBox();
        pane.setStyle("-fx-background-color: black");
        box.setStyle("-fx-background-color: black");
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);

        Text text1 = new Text("GAME OVER");
        text1.setFont(Font.font(80));
        text1.setFill(Color.RED);
        Text text2 = new Text("Thank you for playing...");
        text2.setFont(Font.font(30));
        text2.setFill(Color.WHITE);

        ImageView imgw = new ImageView(new Image("images/aquaquest.png"));
        imgw.setPreserveRatio(true);
        imgw.setFitWidth(460);

        box.getChildren().add(text1);
        box.getChildren().add(text2);
        box.getChildren().add(imgw);
        box.getChildren().add(new Action.Btns().setQuit());
        pane.getChildren().add(box);
        Scene scene = new Scene(pane, 600, 600);
        scene.setFill(Color.AQUA);
        return scene;
    }

    public Scene setWinScene() {
        StackPane pane = new StackPane();
        VBox box = new VBox();
        pane.setStyle("-fx-background-color: green");
        box.setStyle("-fx-background-color: green");
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);

        Text text1 = new Text("GAME WON!");
        text1.setFont(Font.font(80));
        text1.setFill(Color.RED);
        Text text2 = new Text("You saved your family, Congratulations!\nThank you for playing...");
        text2.setFont(Font.font(30));
        text2.setFill(Color.WHITE);

        ImageView imgw = new ImageView(new Image("images/aquaquest.png"));
        imgw.setPreserveRatio(true);
        imgw.setFitWidth(460);


        box.getChildren().add(text1);
        box.getChildren().add(text2);
        box.getChildren().add(imgw);
        box.getChildren().add(new Action.Btns().setQuit());
        pane.getChildren().add(box);
        Scene scene = new Scene(pane, 600, 600);
        scene.setFill(Color.AQUA);
        return scene;
    }

}
