package model.controller;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class serves as a controller for the AddProduct view. (AddProduct.fxml)
 * @author    LeeAnne Atkins
 */

public class AddProductController implements Initializable{

    Stage stage;
    Parent scene;

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


    /** This method adds the user selected Part to the Product when the Add button is clicked. */
    @FXML
    void onActionAddPartToProduct(ActionEvent event) {
    }

    /** This method returns the scene to MainForm.fxml when the Cancel button is clicked. */
    @FXML
    void onActionCancelAddProduct(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /** This method removes the user selected Part from the Product when the Remove Associated Part button is clicked. */
    @FXML
    void onActionRemoveAssocPart(ActionEvent event) {

    }

    /** This method saves the user selected Part/s to the Product when the Save button is clicked. */
    @FXML
    void onActionSaveAddProduct(ActionEvent event) {

    }

    /** This method initializes the scene AddProduct.fxml. */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addProductAllPartsTableView.setItems(Inventory.getAllParts());
        addProductAssocPartsTableView.setItems(Inventory.getAllParts());
    }
}
