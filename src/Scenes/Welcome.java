package Scenes;

import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class Welcome 
{
    public Scene setWelcomeScene()
    {
        Scene scene = new Scene(Main.Game.intro.setIntroScene()); 
        scene.setFill(Color.AQUA);
        return scene;
    }
}
