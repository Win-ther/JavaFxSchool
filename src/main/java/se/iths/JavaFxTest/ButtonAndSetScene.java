package se.iths.JavaFxTest;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class ButtonAndSetScene extends Application{

    Button button;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Title of the Window");
        button = new Button();
        button.setText("Click me!");

        button.setOnAction(e -> button.setText("BUTT!"));
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300,250);
        stage.setScene(scene);
        stage.show();
    }
}
