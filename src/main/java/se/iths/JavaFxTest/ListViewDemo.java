package se.iths.JavaFxTest;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewDemo extends Application {
    Stage window;
    Scene scene;
    Button button;
    ListView<String> listView;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("ListView Demo");
        button = new Button("Submit");

        listView = new ListView<>();
        listView.getItems().addAll("Iron Man","Titanic","Hellraiser", "Alien", "100 days of summer","d","p","dg", ".-.","ddjhfghg","C:");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        button.setOnAction(e -> buttonClicked());

        VBox layout = new VBox();
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(listView,button);
        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void buttonClicked() {
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();
        movies.forEach(System.out::println);
        System.out.println();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
