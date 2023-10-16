package se.iths.JavaFxTest;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BindingPropertiesDemo extends Application {
    Stage window;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Binding Properties Demo");

        //Input and labels
        TextField userInput = new TextField();
        userInput.setMaxWidth(200);
        Label firstLabel = new Label("Welcome to the site ");
        Label secondLabel = new Label();

        HBox bottomText = new HBox(firstLabel,secondLabel);
        bottomText.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(10,userInput,bottomText);
        vBox.setAlignment(Pos.CENTER);

        secondLabel.textProperty().bind(userInput.textProperty());

        Scene scene = new Scene(vBox,300,200);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
