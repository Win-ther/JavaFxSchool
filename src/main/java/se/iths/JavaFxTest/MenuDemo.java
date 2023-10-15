package se.iths.JavaFxTest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import se.iths.JavaFxTest.PopUpBoxes.AlertBox;
import se.iths.JavaFxTest.PopUpBoxes.ConfirmBox;

public class MenuDemo extends Application {
    Stage window;
    BorderPane layout;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Menu Demo");

        //File menu
        Menu fileMenu = new Menu("_File");

        //Menu Items
        MenuItem newFile = new MenuItem("New...");
        newFile.setOnAction(e -> AlertBox.display("New File","You created a new file."));
        fileMenu.getItems().add(newFile);
        MenuItem openFile = new MenuItem("Open...");
        openFile.setOnAction(e -> AlertBox.display("Open File","You Opened a file."));
        fileMenu.getItems().add(openFile);
        MenuItem saveFile = new MenuItem("Save...");
        saveFile.setOnAction(e -> ConfirmBox.display("Save File","Are you sure you want to save the file?"));
        fileMenu.getItems().add(saveFile);
        fileMenu.getItems().add(new SeparatorMenuItem());
        MenuItem settingFile = new MenuItem("Settings...");
        settingFile.setOnAction(e -> AlertBox.display("Settings","This is settings, hello"));
        fileMenu.getItems().add(settingFile);
        MenuItem exitFile = new MenuItem("Exit...");
        exitFile.setOnAction(e -> ConfirmBox.display("Exit","Are you sure you want exit?"));
        fileMenu.getItems().add(exitFile);

        //Edit menu
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));

        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> AlertBox.display("Paste","Ate some paste"));
        editMenu.getItems().add(paste);
        paste.setDisable(true);

        //Help menu CheckMenuItem
        Menu helpMenu = new Menu("_Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setOnAction(e -> showLinesClicked(showLines));

        CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLines, autoSave);

        //Difficulty RadioMenuItem
        Menu difficultyMenu = new Menu("_Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);

        difficultyMenu.getItems().addAll(easy, medium, hard);

        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);


        layout = new BorderPane();
        layout.setTop(menuBar);

        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }

    private static void showLinesClicked(CheckMenuItem showLine) {
        if (showLine.isSelected())
            AlertBox.display("Show Lines","Program will now display line numbers");
        else
            AlertBox.display("Show Lines", "Hiding line numbers");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
