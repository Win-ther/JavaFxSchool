package se.iths.JavaFxTest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import se.iths.JavaFxTest.PopUpBoxes.AlertBox;
import se.iths.JavaFxTest.PopUpBoxes.ConfirmBox;

public class GridPaneDemo extends Application {
    Stage window;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("GridPaneDemo");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel,0,0);

        //Name input
        TextField nameInput = new TextField("defaultUser");
        GridPane.setConstraints(nameInput,1,0);

        //Password label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel,0,1);

        //Password input
        TextField passInput = new TextField();
        passInput.setPromptText("BUTT!(password)");
        GridPane.setConstraints(passInput,1,1);

        Button loginButton = new Button("Log In");
        loginButton.setOnAction(e -> AlertBox.display("Logging in", "Log in successful!"));
        GridPane.setConstraints(loginButton,1,2);

        grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,loginButton);

        Scene scene = new Scene(grid,300,200);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
