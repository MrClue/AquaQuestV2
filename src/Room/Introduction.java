package Room;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Introduction 
{
    public String difficulty = "Hard";
    public Action.Texflds textf = new Action.Texflds();
    public Introduction()
    {
        
    }
    public BorderPane setIntroScene()
    {
        BorderPane pane = new BorderPane(); 
        VBox box = new VBox(); 
        
        ImageView imgw = new ImageView(new Image("images/aquaquest.png"));
        imgw.setPreserveRatio(true);
        imgw.setFitWidth(600);
        
        box.getChildren().add(imgw); 
        box.getChildren().add(new Action.Texflds().setEntryName());
        box.getChildren().add(new Action.Btns().setDifficulty());
        box.getChildren().add(new Action.Btns().setBegin());
        box.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color: LIGHTSTEELBLUE");
        pane.setTop(box);
        return pane;
    }
    
    public String getDifficulty()
    {
        return this.difficulty;
    }
    
    public void setDifficulty(String difficulty)
    {
        this.difficulty = difficulty;
    }
    
    
}
