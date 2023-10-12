package se.iths.JavaFxTest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListeningForSelectionChanges extends Application {
    Stage window;
    Scene scene;
    Button button;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("SelectionChangesListener");
        button = new Button("Click me");
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Carrot","Car","Jimmy Carr","Balloon","Baboon","Buffoon");
        choiceBox.setValue("Carrot");

        //Listener for selection changes
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> System.out.println("From "+oldValue+" to "+newValue));

        VBox layout = new VBox();
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(choiceBox,button);

        scene = new Scene(layout, 300,250);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
