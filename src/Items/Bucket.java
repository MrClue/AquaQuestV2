package Items;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Bucket extends Item
{
    public String name;
    public boolean clean = false;

    public Bucket(String name)
    {
        super(name);
        this.name = name;
    }
    @Override
    public StackPane getPane()
    {
        StackPane pane = new StackPane(); 
        Image img = new Image("images/bucket_t.png");
        ImageView imgw = new ImageView(img);
        imgw.setPreserveRatio(true);
        imgw.setFitWidth(40);
        imgw.setRotate(30);
                
        Text txt = new Text("Bucket");
        txt.setFont(Font.font(11));
        txt.setFill(Color.GREEN);
        pane.getChildren().add(imgw);
        pane.getChildren().add(txt);
        pane.setPrefSize(40, 40);
        
        pane.setOnMousePressed(e -> 
        {
            Main.Game.items.add(new Items.Bucket(this.name));
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
    public void setClean()
    {
        this.clean = true;
    }
    @Override
    public String setFilled()
    {
        if ( Main.Game.player.getLocation().equals("River") )
        {
            this.name = "Bucket with Water";
        }
        return this.name;
    }
    
    @Override
    public String toString()
    {
        if (clean)
        {
            this.name = "Cleansed Bucket with Water";
        }
        return this.name;
    }
}
