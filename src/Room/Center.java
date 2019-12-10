package Room;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class Center {
    public Center() {
    }

    public BorderPane setCenter() {
        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-color: LIGHTSTEELBLUE");

        switch (Main.Game.player.getLocation()) {
            case "Bathroom":
                pane.setCenter(new ImageView(new Image("images/bathroom.png")));
                break;
            case "Desert":
                pane.setCenter(new ImageView(new Image("images/desert.png")));
                break;
            case "Entrance":
                pane.setCenter(new ImageView(new Image("images/entrance.png")));
                break;
            case "Jungle":
                pane.setCenter(new ImageView(new Image("images/jungle.jpg")));
                break;
            case "Livingroom":
                pane.setCenter(new ImageView(new Image("images/livingroom.png")));
                break;
            case "River":
                pane.setCenter(new ImageView(new Image("images/river.png")));
                break;
            case "Town":
                pane.setCenter(new ImageView(new Image("images/town.png")));
                break;
        }
        pane.setBottom(ItemsAdder.addStuff());

        Main.MainCentral.scene = new Scene(pane);
        return pane;
    }
}
