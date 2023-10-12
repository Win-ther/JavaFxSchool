package se.iths.JavaFxTest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxDemo extends Application {
    Stage window;
    Scene scene;
    Button button;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("ChoiceBox Demo");
        button = new Button("Click Me!");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        //getItems returns the ObservableList object which you can add items to
        choiceBox.getItems().add("Carrot");
        choiceBox.getItems().add("Broccoli");
        choiceBox.getItems().addAll("Guitar","Spinach","Football");
        //Set a default value
        choiceBox.setValue("Carrot");

        button.setOnAction(e -> getChoice(choiceBox));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(choiceBox,button);

        scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }

    private void getChoice(ChoiceBox<String> choiceBox) {
        String food = choiceBox.getValue();
        System.out.println(food);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
