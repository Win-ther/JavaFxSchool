package se.iths.JavaFxTest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PropertiesDemo extends Application {
    Stage window;
    Button button;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Properties Demo");

        Person person = new Person();

        person.firstNameProperty().addListener((v, oldValue, newValue) -> listenerAction(newValue, person));

        button = new Button("Submit");
        button.setOnAction(e -> person.setFirstName("Lasse Stefans"));

        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        Scene scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }

    private static void listenerAction(String newValue, Person person) {
        System.out.println("Name changed to "+ newValue);
        System.out.println("firstNameProperty(): "+ person.firstNameProperty());
        System.out.println("getFirstName(): "+ person.getFirstName());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
