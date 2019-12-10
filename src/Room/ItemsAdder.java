package Room;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class ItemsAdder 
{ 
    private static boolean bucketIN;
    private static boolean lifestrawIN;
    private static boolean beerIN;
    
    public ItemsAdder()
    {
    }
    
    public static HBox addStuff()
    {
        HBox itemPane = new HBox();
        itemPane.setMaxWidth(40);
        itemPane.setStyle("-fx-background-color: LIGHTSTEELBLUE");
        if ( Main.Game.items.isEmpty() && !Main.Game.player.getLocation().equals("Jungle"))
        {
            if ( Main.Game.player.getStrawUsed() && Main.Game.player.getLocation().equals("Bathroom"))
            {
                itemPane.getChildren().add(new Items.Bucket("Bucket").getPane());
                bucketIN = false;
            }
            if ( Main.Game.player.getStrawUsed() && Main.Game.player.getLocation().equals("Desert") )
            {
                itemPane.getChildren().add(new Items.Lifestraw("Lifestraw").getPane());
                lifestrawIN = false;
            }
            
        }
        else if ( Main.Game.items.isEmpty() && Main.Game.player.getLocation().equals("Jungle") )
        {
            if ( Main.Game.player.getBeerUsed() )
            {
                itemPane.getChildren().add(new Items.Beer("Beer").getPane());
                beerIN = false;
            }
            if ( Main.Game.player.getStrawUsed() && Main.Game.player.getLocation().equals("Desert") )
            {
                itemPane.getChildren().add(new Items.Lifestraw("Lifestraw").getPane());
                lifestrawIN = false;
            }
            if ( Main.Game.player.getLocation().equals("Bathroom") )
            {
                itemPane.getChildren().add(new Items.Bucket("Bucket").getPane());
                bucketIN = false;
            }
            
        }
        else if ( !Main.Game.items.isEmpty() )
        {
            Main.Game.items.forEach(inventory -> 
            {
                if ( inventory.getName().equals("Beer") && Main.Game.player.getBeerUsed() )
                {
                    beerIN = false;
                }
                else if ( inventory.getName().equals("Lifestraw") && Main.Game.player.getStrawUsed() )
                {
                    lifestrawIN = false;
                }
                else if ( inventory.getName().equals("Bucket") || inventory.getName().equals("Bucket with Water") || inventory.getName().equals("Cleansed Bucket with Water") )
                {
                    bucketIN = false;
                }
            });
            if ( bucketIN == true && Main.Game.player.getLocation().equals("Bathroom") )
            {
                itemPane.getChildren().add(new Items.Bucket("Bucket").getPane());
            }
            if ( lifestrawIN == true && Main.Game.player.getStrawUsed() && Main.Game.player.getLocation().equals("Desert") )
            {
                itemPane.getChildren().add(new Items.Lifestraw("Lifestraw").getPane());
            }
            if ( beerIN && Main.Game.player.getLocation().equals("Jungle") && Main.Game.player.getBeerUsed() )
            {
                itemPane.getChildren().add(new Items.Beer("Beer").getPane());
            }
        }
        bucketIN = true;
        lifestrawIN = true;
        beerIN = true;
        itemPane.setSpacing(5);
        return itemPane;
    }
}
