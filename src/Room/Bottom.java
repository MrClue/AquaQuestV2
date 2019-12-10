package Room;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class Bottom {
    public Bottom() {
    }

    public HBox setBottom() {
        HBox box = new HBox();
        switch (Main.Game.player.getLocation()) {
            case "Bathroom":
                box.getChildren().add(new Action.Btns().setEntrance());
                break;
            case "Desert":
            case "Jungle":
            case "River":
                box.getChildren().add(new Action.Btns().setTown());
                break;
            case "Entrance":
                box.getChildren().add(new Action.Btns().setLivingroom());
                box.getChildren().add(new Action.Btns().setBathroom());
                box.getChildren().add(new Action.Btns().setTown());
                break;
            case "Livingroom":
                box.getChildren().add(new Action.Btns().setEntrance());
                Main.Game.items.forEach(inventory ->
                {
                    if (inventory.getName().equals("Cleansed Bucket with Water")) {
                        box.getChildren().add(new Action.Btns().setWinButton());
                    }
                });
                break;
            case "Town":
                box.getChildren().add(new Action.Btns().setEntrance());
                box.getChildren().add(new Action.Btns().setJungle());
                box.getChildren().add(new Action.Btns().setRiver());
                box.getChildren().add(new Action.Btns().setDesert());
                break;
        }
        box.setAlignment(Pos.CENTER);
        box.setSpacing(8);
        return box;
    }
}
