package model.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import model.Inventory;
import model.Part;
import model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class serves as a controller for the MainForm view. (MainForm.fxml)
 * @author    LeeAnne Atkins
 */

public class MainFormController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private TableColumn<Part, Integer> mainPartsIdCol;

    @FXML
    private TableColumn<Part, Integer> mainPartsInvCol;

    @FXML
    private TableColumn<Part, String> mainPartsNameCol;

    @FXML
    private TableColumn<Part, Double> mainPartsPriceCol;

    @FXML
    private TextField mainPartsSearchTxt;

    @FXML
    private TableView<Part> mainPartsTableView;

    @FXML
    private TableColumn<Product, Integer> mainProductsIdCol;

    @FXML
    private TableColumn<Product, Integer> mainProductsInvCol;

    @FXML
    private TableColumn<Product, String> mainProductsNameCol;

    @FXML
    private TableColumn<Product, Double> mainProductsPriceCol;

    @FXML
    private TextField mainProductsSearchTxt;

    @FXML
    private TableView<Product> mainProductsTableView;

    public void onActionSearchPart(ActionEvent actionEvent) {
        try {
            int partId = Integer.parseInt(mainPartsSearchTxt.getText());
            Part part = Inventory.lookupPart(partId);
            mainPartsTableView.getSelectionModel().select(part);
            mainPartsTableView.scrollTo(part);

        } catch(NumberFormatException e){
            String p = mainPartsSearchTxt.getText().toLowerCase();
            ObservableList<Part> parts = Inventory.lookupPart(p);
            mainPartsTableView.setItems(parts);
        }
    }

    public void onActionSearchProduct(ActionEvent actionEvent) {
        try {
            int productId = Integer.parseInt(mainProductsSearchTxt.getText());
            Product product = Inventory.lookupProduct(productId);
            mainProductsTableView.getSelectionModel().select(product);
            mainProductsTableView.scrollTo(product);

        } catch(NumberFormatException e){
            //String productName = mainProductsSearchTxt.getText();
            String p = mainProductsSearchTxt.getText();
            ObservableList<Product> products = Inventory.lookupProduct(p);
            mainProductsTableView.setItems(products);
            mainProductsSearchTxt.setText("");
        }
    }

    /**
     * This method changes the scene to AddPart.fxml when the Add button under mainPartsTableView is clicked.
     */

    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddPart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * This method changes the scene to AddProduct.fxml when the Add button under mainProductsTableView is clicked.
     */
    @FXML
    void onActionAddProduct(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * This method changes the scene to ModifyPart.fxml when the Modify button under mainPartsTableView is clicked.
     */
    @FXML
    void onActionModifyPart(ActionEvent event) throws IOException {
        Part selectedItem = mainPartsTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ModifyPart.fxml"));
            loader.load();

            ModifyPartController MPController = loader.getController();
            MPController.sendPart(mainPartsTableView.getSelectionModel().getSelectedItem());

            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();
        }
        else {
            //FIXME write else statement here
            System.out.println("Please select a part to modify.");
        }
    }

    /**
     * This method changes the scene to ModifyProduct.fxml when the Modify button under mainProductsTableView is clicked.
     */
    @FXML
    void onActionModifyProduct(ActionEvent event) throws IOException {
        Product selectedItem = mainProductsTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ModifyProduct.fxml"));
            loader.load();

            ModifyProductController MProdController = loader.getController();
            MProdController.sendProduct(mainProductsTableView.getSelectionModel().getSelectedItem());

            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();
        }
        else {
            //FIXME write else statement here
            System.out.println("Please select a product to modify.");
        }
    }

    /**
     * This method removes the selected Part from the mainPartsTableView when the Delete button is clicked.
     */
    @FXML
    void onActionDeletePart(ActionEvent event) {
        Part selectedItem = mainPartsTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            Inventory.deletePart(selectedItem);
        }
        else {
            //FIXME write else statement here
            System.out.println("Please select a part to delete.");
        }
    }

    /**
     * This method removes the selected Product from the mainProductsTableView when the Delete button is clicked.
     */
    @FXML
    void onActionDeleteProduct(ActionEvent event) {
        //FIXME write this method
        System.out.println("Delete product button clicked");
    }

    /**
     * This method exits the program when the Exit button is clicked.
     */
    @FXML
    void onActionExitProgram(ActionEvent event) {
        System.exit(0);
    }

    /**
     * This method initializes the scene MainForm.fxml.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainPartsTableView.setItems(Inventory.getAllParts());
        mainPartsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        mainPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        mainPartsInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        mainPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        mainProductsTableView.setItems(Inventory.getAllProducts());
        mainProductsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        mainProductsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        mainProductsInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        mainProductsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
