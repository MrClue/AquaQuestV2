package Main;

public class Player {
    protected double health = 80, thirstFactor = 3, thirstRate = 0.3;
    protected String name, location;
    protected boolean beerUsed = true, lifestrawUsed = true;

    public Player() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getHealth() {
        return this.health;
    }

    public void addHealth() {
        this.health += 150;
    }

    public void remHealth() {
        this.health = health - this.thirstFactor;
    }

    public void addThirst() {
        this.thirstFactor += this.thirstRate;
    }

    public double getThirst() {
        return this.thirstFactor;
    }

    public boolean getBeerUsed() {
        return this.beerUsed;
    }

    public void setBeerUsed() {
        this.beerUsed = false;
    }

    public boolean getStrawUsed() {
        return this.lifestrawUsed;
    }

    public void setStrawUsed() {
        this.lifestrawUsed = false;
    }

    public void setDifficulty() {
        switch (Game.SETTINGS.getDifficulty()) {
            case "Easy":
                this.health = 100;
                this.thirstFactor = 2;
                this.thirstRate = 0.2;
                break;
            case "Medium":
                this.health = 100;
                this.thirstFactor = 4;
                this.thirstRate = 0.5;
                break;
            case "Hard":
                this.health = 100;
                this.thirstFactor = 8;
                this.thirstRate = 1;
                break;
        }
    }
}
