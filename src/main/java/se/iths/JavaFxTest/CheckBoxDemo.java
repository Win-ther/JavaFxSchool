package se.iths.JavaFxTest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxDemo extends Application {
    Stage window;
    Scene scene;
    Button button;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Just Meat Subs!");

        //CheckBoxes
        CheckBox box1 = new CheckBox("Bacon");
        CheckBox box2 = new CheckBox("Tuna");
        box2.setSelected(true);

        //Button
        button = new Button("Order Now!");
        button.setOnAction(e -> handleOptions(box1,box2));
        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(box1, box2,button);

        scene = new Scene(layout,400,250);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(CheckBox box1, CheckBox box2) {
        String message = "Users order:\n";
        if (box1.isSelected())
            message += box1.getText()+"\n";
        if (box2.isSelected())
            message += box2.getText()+"\n";

        if (!box1.isSelected() && !box2.isSelected())
            message += "Bread sandwich\n";
        System.out.println(message);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
