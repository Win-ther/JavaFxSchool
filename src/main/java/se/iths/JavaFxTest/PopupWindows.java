package se.iths.JavaFxTest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import se.iths.JavaFxTest.PopUpBoxes.AlertBox;

public class PopupWindows extends Application {
    Stage window;
    Button button;
    static int d;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Title");

        button = new Button("Click me!");
        button.setOnAction(e -> AlertBox.display("PopUpTitle", "Message for you!"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300,250);
        window.setScene(scene);
        window.show();
    }


}