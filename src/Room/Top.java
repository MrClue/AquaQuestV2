/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Room;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Top {
    public Top() {

    }

    public VBox topPane() {
        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(new Action.Tkst().showName());

        HBox box = new HBox();
        box.getChildren().addAll(new Action.Tkst().showHealth(), new Action.Tkst().showThirst());
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);

        pane.getChildren().add(box);
        pane.setPadding(new Insets(20));
        pane.setAlignment(Pos.CENTER);
        return pane;
    }
}
