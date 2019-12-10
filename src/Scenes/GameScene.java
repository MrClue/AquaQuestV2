package Scenes;

import Room.Left;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class GameScene 
{
    public Scene scene;
    public GameScene()
    {
    }
    public Scene setGameScene()
    {
        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-color: LIGHTSTEELBLUE");
        this.scene = new Scene(pane); 
        return scene;
    }
}
