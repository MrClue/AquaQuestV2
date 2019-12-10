package Items;

import javafx.scene.layout.StackPane;

public abstract class Item 
{
    private String name;
    
    public Item(String name)
    {
        this.name = name;
    }
    
    public abstract StackPane getPane();
    
    public String getName()
    {
        return this.name;
    }
    
    public String setFilled()
    {
       return this.name;
    }
    
    public void setClean()
    {
        
    }
}
