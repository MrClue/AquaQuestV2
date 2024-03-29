package Main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Game extends Application {
    public static String[] args;
    public static Stage primaryStage;
    public static ObservableList<Items.Item> items = FXCollections.observableArrayList();
    public static Room.Introduction intro = new Room.Introduction();
    public static Settings.Difficulty SETTINGS = new Settings.Difficulty();
    public static Player player = new Player();

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        primaryStage.setScene(new Scenes.Welcome().setWelcomeScene());
        primaryStage.getIcons().add(new Image("images/aq_logo.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
