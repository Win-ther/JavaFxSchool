package se.iths.JavaFxTest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import se.iths.JavaFxTest.PopUpBoxes.ConfirmBox;

public class ConfirmationBoxUser extends Application {
    Stage window;
    Button button;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Title");
        button = new Button("Click me!");

        button.setOnAction(e -> confirmAnswer());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300,250);
        window.setScene(scene);
        window.show();
    }

    private static void confirmAnswer() {
         boolean result = ConfirmBox.display("Title of window", "Are you sure you want to send dudes to Navid?");
        System.out.println(result);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
