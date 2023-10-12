package se.iths.JavaFxTest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import se.iths.JavaFxTest.PopUpBoxes.ConfirmBox;

public class ExitDemo extends Application {
    Stage window;
    Button button;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("ExitDemo");
        window.setOnCloseRequest(this::closeProgram);

        button = new Button("Close Program");
        button.setOnAction(e -> closeProgram(null));


        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram(WindowEvent e) {
        if (e != null)
            e.consume();
        boolean answer = ConfirmBox.display("Title title", "Are you sure you want to exit the program?");
        if (answer)
            window.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
