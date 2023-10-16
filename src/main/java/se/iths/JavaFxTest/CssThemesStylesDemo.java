package se.iths.JavaFxTest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;


public class CssThemesStylesDemo extends Application {
    Stage window;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("CSS themes and Styles");
        //Gridpane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name Label
        Label nameLabel = new Label("Username:");
        nameLabel.setId("bold-label");
        GridPane.setConstraints(nameLabel,0,0);
        //Name Input
        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput,1,0);
        nameInput.setPromptText("Enter username");
        //Password Label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel,0,1);
        //Password input
        TextField passInput = new TextField();
        passInput.setPromptText("Enter password");
        GridPane.setConstraints(passInput,1,1);
        //Login Button
        Button logInButton = new Button("Log In");
        GridPane.setConstraints(logInButton,1,2);
        //Sign up
        Button signupButton = new Button("Sign Up");
        signupButton.getStyleClass().add("button-blue");
        GridPane.setConstraints(signupButton,1,3);



        grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput, logInButton, signupButton);
        Scene scene = new Scene(grid,300,200);
        scene.getStylesheets().add("Bob.css");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
