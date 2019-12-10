package Items;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Beer extends Item {
    public String name;

    public Beer(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public StackPane getPane() {
        StackPane pane = new StackPane();
        VBox box = new VBox();
        Image img = new Image("images/beer_t.png");
        ImageView imgw = new ImageView(img);
        imgw.setPreserveRatio(true);
        imgw.setFitWidth(40);
        imgw.setRotate(30);

        Text txt = new Text("[Legendary]");
        Text txt2 = new Text("Beer");
        box.getChildren().addAll(txt, txt2);
        box.setAlignment(Pos.CENTER);
        txt.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 11));
        txt2.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 11));
        txt.setFill(Color.ORANGE);
        txt2.setFill(Color.ORANGE);
        pane.getChildren().add(imgw);
        pane.getChildren().add(box);
        pane.setPrefSize(40, 40);

        pane.setOnMousePressed(e ->
        {
            if (Main.Game.player.getBeerUsed()) {
                Main.Game.items.add(new Items.Beer(this.name));
                Main.Game.player.setBeerUsed();
                pane.setOpacity(0);
                pane.setDisable(true);
            }
        });
        return pane;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
