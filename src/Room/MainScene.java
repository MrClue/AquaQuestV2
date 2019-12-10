package Room;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class MainScene {
    public Left left = new Left();

    public MainScene() {
    }

    public Scene setScene() {
        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-color: LIGHTSTEELBLUE");
        pane.setLeft(new Left().setLeft());
        pane.setCenter(new Room.Center().setCenter());
        pane.setBottom(new Room.Bottom().setBottom());
        pane.setPadding(new Insets(10));

        Scene scene = new Scene(pane);
        Main.MainCentral.scene = scene;
        return scene;
    }
}
