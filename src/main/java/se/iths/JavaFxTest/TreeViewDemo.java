package se.iths.JavaFxTest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeViewDemo extends Application {
    Stage window;
    TreeView<String> tree;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("TreeView Demo");

        TreeItem<String> root, spooky, notSpooky;
        //Root
        root = new TreeItem<>();
        root.setExpanded(true);

        //spooky
        spooky = makeBranch("spooky", root);
        makeBranch("Halloween",spooky);
        makeBranch("Friday 13th",spooky);
        makeBranch("Nightmare on elm street", spooky);

        //notSpooky
        notSpooky = makeBranch("notSpooky", root);
        makeBranch("Christmas",notSpooky);
        makeBranch("Ice cream",notSpooky);
        makeBranch("Puppies",notSpooky);

        //Create tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> printValue(newValue));


        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }

    private static void printValue(TreeItem<String> newValue) {
        if (newValue != null)
            System.out.println(newValue.getValue());
    }

    public TreeItem<String> makeBranch(String name, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(name);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
