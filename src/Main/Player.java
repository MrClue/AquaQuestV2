package Main;

public class Player 
{
    protected double health = 80, thirstFactor = 3, thirstRate = 0.3;
    protected String name, location = "Bathroom";
    protected boolean beerUsed = true, lifestrawUsed = true;

    public Player()
    {
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public String getLocation()
    {
        return this.location;
    }
    public void setLocation(String location)
    {
        this.location = location;
    }
    
    public double getHealth()
    {
        return this.health;
    }
    public double addHealth()
    {
        this.health += 150;
        return this.health;
    }
    public void remHealth()
    {
        this.health = health-this.thirstFactor;
    }
    
    public double addThirst()
    {
        this.thirstFactor += this.thirstRate;
        return this.thirstFactor;
    }
    public double getThirst()
    {
        return this.thirstFactor;
    }
    
    public boolean getBeerUsed()
    {
        return this.beerUsed;
    }
    public void setBeerUsed()
    {
        this.beerUsed = false;
    }
    
    public boolean getStrawUsed()
    {
        return this.lifestrawUsed;
    }
    public void setStrawUsed()
    {
        this.lifestrawUsed = false;
    }
    
    public void setDifficulty()
    {
        if (Main.Game.SETTINGS.getDifficulty().equals("Easy"))
        {
           this.health = 100;
           this.thirstFactor = 2;
           this.thirstRate = 0.2;
        }
        else if (Main.Game.SETTINGS.getDifficulty().equals("Medium"))
        {
           this.health = 60;
           this.thirstFactor = 5;
           this.thirstRate = 0.5;
        }
        else if (Main.Game.SETTINGS.getDifficulty().equals("Hard"))
        {
           this.health = 40;
           this.thirstFactor = 8;
           this.thirstRate = 1;
        }
    }
}
