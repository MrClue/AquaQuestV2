package Room;

import Main.Game;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Left 
{
    public Action.Tkst playInfo = new Action.Tkst();
    public static ListView<Items.Item> list;
    
    public Left()
    {
    }
    
    public VBox setLeft()
    {
        list = new ListView<Items.Item>(Game.items);
        list.setMaxHeight(200);
        VBox pane = new VBox();
        HBox box = new HBox();
        box.setMaxWidth(50);
        pane.setMaxWidth(50);
        box.setSpacing(10);
        pane.setSpacing(10);
        box.setAlignment(Pos.CENTER);
        box.getChildren().add(new Action.Btns().setUse());
        pane.setPadding(new Insets(20));
        pane.getChildren().add(topPane());
        pane.getChildren().add(new Action.Tkst().showDifficulty());
        pane.getChildren().add(list);
        pane.getChildren().add(box); 
        return pane;
    }
    
    public VBox topPane()
    {
        VBox pane = new VBox(); 
        HBox box = new HBox(); 
        
        box.getChildren().addAll(playInfo.showHealth(), playInfo.showThirst());
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);
        
        pane.getChildren().add(new Action.Tkst().showName());
        pane.getChildren().add(box);
        pane.getChildren().add(new Action.Tkst().showLocation());
        pane.setPadding(new Insets(20));
        pane.setAlignment(Pos.CENTER);
        return pane;
    }
}
