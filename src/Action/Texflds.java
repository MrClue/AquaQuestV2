package Action;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class Texflds 
{
    public static TextField textfield = new TextField("Enter Your name..."); 
    public TextField setEntryName()
    {
        textfield.setAlignment(Pos.CENTER);
        textfield.setOnMousePressed(e ->
        {
            textfield.setText("");
        });
        return textfield;
    }   
}
