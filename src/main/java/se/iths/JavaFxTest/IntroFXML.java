package se.iths.JavaFxTest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IntroFXML extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(IntroFXML.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300,200);

        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
