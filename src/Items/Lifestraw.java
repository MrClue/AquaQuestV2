package Items;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Lifestraw extends Item
{
    public String name;
    
    public Lifestraw(String name)
    {
        this.name = name;
    }
    
    @Override
    public StackPane getPane()
    {
        StackPane pane = new StackPane(); 
        Image img = new Image("images/lifestraw_t.png");
        ImageView imgw = new ImageView(img);
        imgw.setPreserveRatio(true);
        imgw.setRotate(30);
        imgw.setFitWidth(40);
        
        Text txt = new Text("Lifestraw");
        txt.setFont(Font.font(11));
        txt.setFill(Color.GREEN);
        pane.getChildren().add(imgw);
        pane.getChildren().add(txt);
        pane.setPrefSize(40, 40);
        
        pane.setOnMousePressed(e -> 
        {
            Main.Game.items.add(new Items.Lifestraw(this.name));
            pane.setOpacity(0);
            pane.setDisable(true);
        });
        return pane;
    }

    public String getName()
    {
        return this.name;
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }
}
