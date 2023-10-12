package se.iths.JavaFxTest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExtractAndValidateInputDemo extends Application {
    Stage window;
    Scene scene;
    Button button;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("TITLETITLETITLETITLETITLETITLETITLETITLETITLE");

        //Form
        TextField nameInput = new TextField();
        nameInput.setPromptText("ENTER TEXT HERE");

        button = new Button("Click here!");
        button.setOnAction(e -> isInt(nameInput,nameInput.getText()));

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(nameInput, button);

        scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }

    private boolean isInt(TextField input, String message) {
        try {
            int age = Integer.parseInt(input.getText());
            System.out.println("User is: "+age);
            return true;
        }catch (NumberFormatException e){
            System.out.println("Error: "+message+" is not a number");
            return false;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
