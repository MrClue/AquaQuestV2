package Action;

import Main.Game;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.HBox;

public class Btns {

    private int sizeW = 70, sizeH = 30;
    private boolean remBeer = false, removeStraw = false, bucketIN = false, lifestrawIN = false, beerIN = false;

    public Button setPickup() {
        Button button = new Button("Pickup");
        button.setPrefSize(sizeW, sizeH);
        return button;
    }

    public Button setUse() {
        this.bucketIN = false;
        this.lifestrawIN = false;
        this.beerIN = false;
        Button button = new Button("Use");
        button.setPrefSize(sizeW, sizeH);
        button.setOnAction(e ->
        {
            Main.Game.items.forEach(Item -> {
                switch (Item.getName()) {
                    case "Bucket":
                    case "Bucket with Water":
                    case "Cleansed Bucket with Water":
                        this.bucketIN = true;
                        break;
                    case "Lifestraw":
                        this.lifestrawIN = true;
                        break;
                    case "Beer":
                        this.beerIN = true;
                        break;
                }
                if (Room.Left.list.getSelectionModel().getSelectedItem().getName().equals("Bucket") && Main.Game.player.getLocation().equals("River")) {
                    Room.Left.list.getSelectionModel().getSelectedItem().setFilled();
                    Room.Left.list.refresh();
                }
            });

            if (Room.Left.list.getSelectionModel().getSelectedItem().getName().equals("Lifestraw")) {
                Main.Game.items.forEach(Item2 -> {
                    if (Item2.getName().equals("Bucket with Water")) {
                        Main.Game.player.setStrawUsed();
                        Item2.setClean();
                        this.removeStraw = true;
                    }
                });
                if (this.removeStraw && Room.Left.list.getSelectionModel().getSelectedItem().getName().equals("Lifestraw")) {
                    Main.Game.items.remove(Room.Left.list.getSelectionModel().getSelectedItem());
                    this.removeStraw = false;
                }
            } else if (Room.Left.list.getSelectionModel().getSelectedItem().getName().equals("Beer")) {
                Main.Game.player.addHealth();
                Main.Game.items.remove(Room.Left.list.getSelectionModel().getSelectedItem());
                switch (Game.player.getLocation()) {
                    case "Town":
                    case "Desert":
                    case "River":
                    case "Livingroom":
                    case "Jungle":
                    case "Entrance":
                    case "Bathroom":
                        Game.primaryStage.setScene(new Room.MainScene().setScene());
                        break;
                }
            }
        });
        return button;
    }

    public Button setBegin() {
        Button button = new Button("Begin!");
        button.setPrefSize(sizeW, sizeH);
        button.setOnMousePressed(e -> {
            if (Main.Game.intro.textf.setEntryName().getText().equals("Enter Your name...") || Main.Game.intro.textf.setEntryName().getText().length() < 3) {
                Stage stage = new Stage();
                StackPane pane = new StackPane();
                pane.setAlignment(Pos.CENTER);
                Text txt = new Text("Please enter a valid name!");
                pane.getChildren().add(txt);
                Scene scene = new Scene(pane, 200, 100);

                scene.setOnMousePressed(eff -> stage.close());
                stage.setTitle("");
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);
                stage.show();
            } else {
                Game.player.setName(Main.Game.intro.textf.setEntryName().getText());
                Game.player.setDifficulty();
                Main.Game.player.setLocation("Bathroom");
                Game.primaryStage.setScene(new Room.MainScene().setScene());

                Stage stage2 = new Stage();
                VBox pane2 = new VBox();
                pane2.setSpacing(8);
                pane2.setAlignment(Pos.CENTER);

                Text txt1 = new Text("Welcome to Aquaquest " + Main.Game.player.getName());
                Text txt2 = new Text("You have been assigned a task by your parents.");
                Text txt3 = new Text("Your task is to collect a bucket filled with delicious clean water!");
                Text txt4 = new Text("But you must be quick!...");
                Text txt5 = new Text("Your thirsty family are waiting back home, and won't live long without some water to drink!");
                Text txt6 = new Text("Go to the river with a bucket to pickup water.");
                Text txt7 = new Text("Be careful! You may face a few obstacles along your way.");
                Text txt8 = new Text("Click on window to close");
                txt1.setFont(Font.font("Courier", FontWeight.BOLD, 28));
                txt2.setFont(Font.font("Courier", FontWeight.BOLD, 11));
                txt3.setFont(Font.font("Courier", FontWeight.BOLD, 11));
                txt4.setFont(Font.font("Courier", FontWeight.BOLD, 11));
                txt5.setFont(Font.font("Courier", FontWeight.BOLD, 11));
                txt6.setFont(Font.font("Courier", FontWeight.BOLD, 11));
                txt7.setFont(Font.font("Courier", FontWeight.BOLD, 11));
                txt8.setFont(Font.font("Courier", FontWeight.BOLD, 18));
                txt1.setFill(Color.GREEN);
                pane2.getChildren().addAll(txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8);

                Scene scene = new Scene(pane2);
                scene.setFill(Color.LIGHTSTEELBLUE);

                scene.setOnMousePressed(eff -> stage2.close());
                stage2.setTitle("");
                stage2.setAlwaysOnTop(true);
                stage2.initStyle(StageStyle.UNDECORATED);
                stage2.setScene(scene);
                stage2.show();
            }
        });
        return button;
    }

    public Button setQuit() {
        Button button = new Button("Quit");
        button.setPrefSize(sizeW, sizeH);
        button.setOnMousePressed(e -> Game.primaryStage.close());
        return button;
    }

    public Button setEntrance() {
        Button button = new Button("Entrance");
        button.setPrefSize(sizeW, sizeH);
        button.setOnMousePressed(e -> {
            if (Main.Game.player.getHealth() - Main.Game.player.getThirst() < 0) {
                Game.primaryStage.setScene(new Scenes.Finish().setFailedScene());
            } else {
                Main.Game.player.addThirst();
                Main.Game.player.remHealth();
                Main.Game.player.setLocation("Entrance");
                Game.primaryStage.setScene(new Room.MainScene().setScene());
            }
        });
        return button;
    }

    public Button setJungle() {
        Button button = new Button("Jungle");
        button.setPrefSize(sizeW, sizeH);
        button.setOnMousePressed(e -> {
            if (Main.Game.player.getHealth() - Main.Game.player.getThirst() < 0) {
                Game.primaryStage.setScene(new Scenes.Finish().setFailedScene());
            } else {
                Main.Game.player.addThirst();
                Main.Game.player.remHealth();
                Main.Game.player.setLocation("Jungle");
                Game.primaryStage.setScene(new Room.MainScene().setScene());
            }
        });
        return button;
    }

    public Button setLivingroom() {
        Button button = new Button("Livingroom");
        button.setPrefSize(sizeW, sizeH);
        button.setOnMousePressed(e -> {
            if (Main.Game.player.getHealth() - Main.Game.player.getThirst() < 0) {
                Game.primaryStage.setScene(new Scenes.Finish().setFailedScene());
            } else {
                Main.Game.player.addThirst();
                Main.Game.player.remHealth();
                Main.Game.player.setLocation("Livingroom");
                Game.primaryStage.setScene(new Room.MainScene().setScene());
            }
        });
        return button;
    }

    public Button setBathroom() {
        Button button = new Button("Bathroom");
        button.setPrefSize(sizeW, sizeH);
        button.setOnMousePressed(e -> {

            if (Main.Game.player.getHealth() - Main.Game.player.getThirst() < 0) {
                Game.primaryStage.setScene(new Scenes.Finish().setFailedScene());
            } else {
                Main.Game.player.addThirst();
                Main.Game.player.remHealth();
                Main.Game.player.setLocation("Bathroom");
                Game.primaryStage.setScene(new Room.MainScene().setScene());
            }
        });
        return button;
    }

    public Button setDesert() {
        Button button = new Button("Desert");
        button.setPrefSize(sizeW, sizeH);
        button.setOnMousePressed(e
                -> {
            if (Main.Game.player.getHealth() - Main.Game.player.getThirst() < 0) {
                Game.primaryStage.setScene(new Scenes.Finish().setFailedScene());
            } else {
                Main.Game.player.addThirst();
                Main.Game.player.remHealth();
                Main.Game.player.setLocation("Desert");
                Game.primaryStage.setScene(new Room.MainScene().setScene());
            }
        });
        return button;
    }

    public Button setRiver() {
        Button button = new Button("River");
        button.setPrefSize(sizeW, sizeH);
        button.setOnMousePressed(e -> {
            if (Main.Game.player.getHealth() - Main.Game.player.getThirst() < 0) {
                Game.primaryStage.setScene(new Scenes.Finish().setFailedScene());
            } else {
                Main.Game.player.addThirst();
                Main.Game.player.remHealth();
                Main.Game.player.setLocation("River");
                Game.primaryStage.setScene(new Room.MainScene().setScene());
            }
        });
        return button;
    }

    public Button setTown() {
        Button button = new Button("Town");
        button.setPrefSize(sizeW, sizeH);
        button.setOnMousePressed(e
                -> {
            if (Main.Game.player.getHealth() - Main.Game.player.getThirst() < 0) {
                Game.primaryStage.setScene(new Scenes.Finish().setFailedScene());
            } else {
                Main.Game.player.addThirst();
                Main.Game.player.remHealth();
                Main.Game.player.setLocation("Town");
                Game.primaryStage.setScene(new Room.MainScene().setScene());
            }
        });
        return button;
    }

    public Button setWinButton() {
        Button button = new Button("FINISH");
        button.setPrefSize(sizeW, sizeH);
        button.setStyle("-fx-background-color:#00ff00;" + "-fx-background-radius:0;" + "-fx-border-color:black;" + "-fx-border-width: 1 1 1 1;" + "-fx-background-insets: 0;");
        button.setOnMousePressed(e -> {
            if (Main.Game.player.getLocation().equals("Livingroom")) {
                Game.primaryStage.setScene(new Scenes.Finish().setWinScene());
            }
        });
        return button;
    }

    public HBox setDifficulty() {
        HBox pane = new HBox();
        pane.setPadding(new Insets(30));
        pane.setSpacing(14);
        ToggleButton tbut1 = new ToggleButton("Easy");
        tbut1.setOnMouseClicked(l -> Game.SETTINGS.setDifficulty("Easy"));
        ToggleButton tbut2 = new ToggleButton("Medium");
        tbut2.setOnMouseClicked(k -> Game.SETTINGS.setDifficulty("Medium"));
        ToggleButton tbut3 = new ToggleButton("Hard");
        tbut3.setOnMouseClicked(j -> Game.SETTINGS.setDifficulty("Hard"));
        tbut1.setStyle("-fx-base: green");
        tbut2.setStyle("-fx-base: orange");
        tbut3.setStyle("-fx-base: red");
        tbut1.setPrefSize(sizeW, sizeH);
        tbut2.setPrefSize(sizeW, sizeH);
        tbut3.setPrefSize(sizeW, sizeH);

        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(tbut1, tbut2, tbut3);
        return pane;
    }
}
