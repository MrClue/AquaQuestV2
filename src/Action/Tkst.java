package Action;

import java.text.DecimalFormat;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tkst 
{
    public DecimalFormat numberFormat = new DecimalFormat("#.0");
    
    public Text showHealth()
    {
        Text text = new Text("Health: " + numberFormat.format(Main.Game.player.getHealth()));
        text.setFill(Color.BLACK);
        text.setFont(Font.font(16));
        return text;
    }
    public Text showThirst()
    {
        Text text = new Text("  Thirst: " + numberFormat.format(Main.Game.player.getThirst()));
        text.setFill(Color.BLACK);
        text.setFont(Font.font(16));
        return text;
    }
    public Text showName()
    {
        Text text = new Text(Main.Game.player.getName());
        text.setFill(Color.BLACK);
        text.setFont(Font.font(20));
        return text;
    }
    public Text showLocation()
    {
        Text text = new Text("Location: " + Main.Game.player.getLocation());
        text.setFill(Color.BLACK);
        text.setFont(Font.font(16));
        return text;
    }
    public Text showDifficulty()
    {
        Text text = new Text("Difficulty: " + Main.Game.SETTINGS.getDifficulty());
        switch (Main.Game.SETTINGS.getDifficulty()) {
            case "Easy":
                text.setFill(Color.GREEN);
                text.setFont(Font.font(16));
                break;
            case "Medium":
                text.setFill(Color.ORANGE);
                text.setFont(Font.font(16));
                break;
            case "Hard":
                text.setFill(Color.RED);
                text.setFont(Font.font(16));
                break;
        }
        return text;
    }
}
