package se.iths.JavaFxTest;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewDemo extends Application {
    Stage window;
    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("TableView Demo");

        //Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        //Price column
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        //Quantity column
        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //nameInput
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);
        //priceInput
        priceInput = new TextField();
        priceInput.setPromptText("Price");
        priceInput.setMinWidth(100);
        //quantityInput
        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");
        quantityInput.setMinWidth(100);

        //Buttons
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);


        table = new TableView<>();
        table.setItems(getProducts());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();

    }

    private void deleteButtonClicked() {
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();
        productSelected.forEach(allProducts::remove);
        productSelected.stream().map(Product::getName).forEach(System.out::println);
    }

    private void addButtonClicked() {
        Product product = new Product();
        product.setName(nameInput.getText());
        try {
            product.setPrice(Double.parseDouble(priceInput.getText()));
            product.setQuantity(Integer.parseInt(quantityInput.getText()));

        } catch (NumberFormatException e) {
            return;
        }
        table.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //Get products for demo
    public ObservableList<Product> getProducts() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 859.00, 20));
        products.add(new Product("Toilet", 99.00, 2));
        products.add(new Product("Bread", 2.49, 15));
        products.add(new Product("Julmust", 2.99, 200));
        products.add(new Product("Talrik", 150.00, 8));
        return products;
    }
}
