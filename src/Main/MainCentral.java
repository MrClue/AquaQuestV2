package Main;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainCentral
{
    public MainCentral() {

    }
    private Stage primarystage = new Stage(); 
    public static Scene scene;
    
    public void changeScene(Scene scene)
    {
        this.scene = scene;
        this.primarystage.setScene(scene);
    }
}
