package se.iths.JavaFxTest;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BindingDemo extends Application {
    Stage window;
    Button button;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Binding Demo");

        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty();

        y.bind(x.multiply(10));
        System.out.println("X = "+x.getValue() + "\nY = "+y.getValue());
        x.setValue(9);
        System.out.println("X = "+x.getValue() + "\nY = "+y.getValue());

        button = new Button("Submit");

        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        Scene scene = new Scene(layout, 300,250);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
