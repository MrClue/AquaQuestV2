package Action;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class Texflds 
{
    public static TextField textfield = new TextField("Enter Your name..."); 
    public TextField setEntryName()
    {
        this.textfield.setAlignment(Pos.CENTER);
        this.textfield.setOnMousePressed(e -> 
        {
            this.textfield.setText("");
        });
        return this.textfield;
    }   
}
