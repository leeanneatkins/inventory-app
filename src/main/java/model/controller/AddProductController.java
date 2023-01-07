package model.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import model.InHouse;
import model.Inventory;
import model.Part;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class serves as a controller for the AddProduct view. (AddProduct.fxml)
 * @author    LeeAnne Atkins
 */

public class AddProductController implements Initializable{

    private Product newProduct = new Product(0, "test", 2.99, 5, 5, 10);
    Stage stage;
    Parent scene;

    public static int productIdCounter = 1006;

    @FXML
    private TableColumn<Part, Integer> addProductAllPartsIdCol;

    @FXML
    private TableColumn<Part, Integer> addProductAllPartsInvCol;

    @FXML
    private TableColumn<Part, String> addProductAllPartsNameCol;

    @FXML
    private TableColumn<Part, Double> addProductAllPartsPriceCol;

    @FXML
    private TableView<Part> addProductAllPartsTableView;

    @FXML
    private TableColumn<Part, Integer> addProductAssocPartsIdCol;

    @FXML
    private TableColumn<Part, Integer> addProductAssocPartsInvCol;

    @FXML
    private TableColumn<Part, String> addProductAssocPartsNameCol;

    @FXML
    private TableColumn<Part, Double> addProductAssocPartsPriceCol;

    @FXML
    private TableView<Part> addProductAssocPartsTableView;

    @FXML
    private TextField addProductIdTxt;

    @FXML
    private TextField addProductInvTxt;

    @FXML
    private TextField addProductMaxTxt;

    @FXML
    private TextField addProductMinTxt;

    @FXML
    private TextField addProductNameTxt;

    @FXML
    private TextField addProductPriceTxt;

    @FXML
    private TextField addProductSearchTxt;

    ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    public void onActionSearchPart(ActionEvent actionEvent) {
        try {
            int partId = Integer.parseInt(addProductSearchTxt.getText());
            Part part = Inventory.lookupPart(partId);
            addProductAllPartsTableView.getSelectionModel().select(part);
            addProductAllPartsTableView.scrollTo(part);

        } catch(NumberFormatException e){
            //String productName = addProductSearchTxt.getText();
            String p = addProductSearchTxt.getText();
            ObservableList<Part> parts = Inventory.lookupPart(p);
            addProductAllPartsTableView.setItems(parts);
            addProductSearchTxt.setText("");
        }
    }

    /** This method adds the user selected Part to the Product when the Add button is clicked. */
    @FXML
    void onActionAddPartToProduct(ActionEvent event) {
        Part selectedItem = addProductAllPartsTableView.getSelectionModel().getSelectedItem();
        //associatedParts.add(selectedItem);
        newProduct.addAssociatedPart(selectedItem);
        addProductAssocPartsTableView.setItems(newProduct.getAllAssociatedParts());
    }

    /** This method removes the user selected Part from the Product when the Remove Associated Part button is clicked. */
    @FXML
    void onActionRemoveAssocPart(ActionEvent event) {
        Part selectedItem = addProductAssocPartsTableView.getSelectionModel().getSelectedItem();
        if(selectedItem != null) {
            //associatedParts.remove(selectedItem);
            newProduct.deleteAssociatedPart(selectedItem);
        }
        // per CI, add else statement
    }

    /** This method saves the user entered data and the associated Part/s to the Product when the Save button is clicked. */
    @FXML
    void onActionSaveAddProduct(ActionEvent event) throws IOException {
        newProduct.setId(++productIdCounter);
        newProduct.setName(addProductNameTxt.getText());
        newProduct.setPrice(Double.parseDouble(addProductPriceTxt.getText()));
        newProduct.setStock(Integer.parseInt(addProductInvTxt.getText()));
        newProduct.setMin(Integer.parseInt(addProductMinTxt.getText()));
        newProduct.setMax(Integer.parseInt(addProductMaxTxt.getText()));
        //product.getAllAssociatedParts().addAll(associatedParts);
        Inventory.addProduct(newProduct);
        backToMainForm(event);
    }

    /** This method returns the scene to MainForm.fxml when the Cancel button is clicked. */
    @FXML
    void onActionCancelAddProduct(ActionEvent event) throws IOException {
        backToMainForm(event);
    }

    /** This method returns the scene to MainForm.fxml. */
    public void backToMainForm(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /** This method initializes the scene AddProduct.fxml. */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addProductAllPartsTableView.setItems(Inventory.getAllParts());
        addProductAllPartsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        addProductAllPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addProductAllPartsInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addProductAllPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        addProductAssocPartsTableView.setItems(associatedParts);
        addProductAssocPartsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        addProductAssocPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addProductAssocPartsInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addProductAssocPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        }
    }
