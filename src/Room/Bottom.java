package Room;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class Bottom 
{
    public Bottom()
    {
    }
    
    public HBox setBottom()
    {
        HBox box = new HBox(); 
        if (Main.Game.player.getLocation().equals("Bathroom"))
        {
            box.getChildren().add(new Action.Btns().setEntrance());
        }
        else if (Main.Game.player.getLocation().equals("Desert"))
        {
            box.getChildren().add(new Action.Btns().setTown());
        }
        else if (Main.Game.player.getLocation().equals("Entrance"))
        {
            box.getChildren().add(new Action.Btns().setLivingroom());
            box.getChildren().add(new Action.Btns().setBathroom());
            box.getChildren().add(new Action.Btns().setTown());
        }
        else if (Main.Game.player.getLocation().equals("Jungle"))
        {
            box.getChildren().add(new Action.Btns().setTown());
        }
        else if (Main.Game.player.getLocation().equals("Livingroom"))
        {
            box.getChildren().add(new Action.Btns().setEntrance());
            Main.Game.items.forEach(inventory -> 
            {
                if ( inventory.getName().equals("Cleansed Bucket with Water") )
                    {
                        box.getChildren().add(new Action.Btns().setWinButton());
                    }       
            }); 
        }
        else if (Main.Game.player.getLocation().equals("River"))
        {
            box.getChildren().add(new Action.Btns().setTown());
        }
        else if (Main.Game.player.getLocation().equals("Town"))
        {
            box.getChildren().add(new Action.Btns().setEntrance());
            box.getChildren().add(new Action.Btns().setJungle());
            box.getChildren().add(new Action.Btns().setRiver());
            box.getChildren().add(new Action.Btns().setDesert());
        }
        box.setAlignment(Pos.CENTER);
        box.setSpacing(8);
        return box;
    }
}
