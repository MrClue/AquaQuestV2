package Room;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class Center 
{
    public Center()
    {
    }
    
    public BorderPane setCenter()
    {
        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-color: LIGHTSTEELBLUE");
        
        if ( Main.Game.player.getLocation().equals("Bathroom") )
        {
            pane.setCenter(new ImageView(new Image("images/bathroom.png")));
        }
        else if ( Main.Game.player.getLocation().equals("Desert") )
        {
            pane.setCenter(new ImageView(new Image("images/desert.png")));
        }
        else if ( Main.Game.player.getLocation().equals("Entrance") )
        {
            pane.setCenter(new ImageView(new Image("images/entrance.png")));
        }
        else if ( Main.Game.player.getLocation().equals("Jungle") )
        {
            pane.setCenter(new ImageView(new Image("images/jungle.jpg")));
        }
        else if ( Main.Game.player.getLocation().equals("Livingroom") )
        {
            pane.setCenter(new ImageView(new Image("images/livingroom.png")));
        }
        else if ( Main.Game.player.getLocation().equals("River") )
        {
            pane.setCenter(new ImageView(new Image("images/river.png")));
        }
        else if ( Main.Game.player.getLocation().equals("Town") )
        {
            pane.setCenter(new ImageView(new Image("images/town.png")));
        }
        pane.setBottom(ItemsAdder.addStuff());
        
        Scene scene = new Scene(pane);
        Main.MainCentral.scene = scene;
        return pane;
    }
}
