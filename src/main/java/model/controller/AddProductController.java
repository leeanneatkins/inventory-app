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

    /** This is a variable declaration for variable type Stage named stage. */
    Stage stage;
    /** This is a variable declaration for variable type Parent named scene. */
    Parent scene;

    /** This is a variable declaration for variable type TableColumn named addProductAllPartsIdCol. */
    @FXML
    private TableColumn<Part, Integer> addProductAllPartsIdCol;

    /** This is a variable declaration for variable type TableColumn named addProductAllPartsInvCol. */
    @FXML
    private TableColumn<Part, Integer> addProductAllPartsInvCol;

    /** This is a variable declaration for variable type TableColumn named addProductAllPartsNameCol. */
    @FXML
    private TableColumn<Part, String> addProductAllPartsNameCol;

    /** This is a variable declaration for variable type TableColumn named addProductAllPartsPriceCol. */
    @FXML
    private TableColumn<Part, Double> addProductAllPartsPriceCol;

    /** This is a variable declaration for variable type TableView named addProductAllPartsTableView. */
    @FXML
    private TableView<Part> addProductAllPartsTableView;

    /** This is a variable declaration for variable type TableColumn named addProductAssocPartsIdCol. */
    @FXML
    private TableColumn<Part, Integer> addProductAssocPartsIdCol;

    /** This is a variable declaration for variable type TableColumn named addProductAssocPartsIdCol. */
    @FXML
    private TableColumn<Part, Integer> addProductAssocPartsInvCol;

    /** This is a variable declaration for variable type TableColumn named addProductAssocPartsNameCol. */
    @FXML
    private TableColumn<Part, String> addProductAssocPartsNameCol;

    /** This is a variable declaration for variable type TableColumn named addProductAssocPartsPriceCol. */
    @FXML
    private TableColumn<Part, Double> addProductAssocPartsPriceCol;

    /** This is a variable declaration for variable type TableView named addProductAssocPartsTableView. */
    @FXML
    private TableView<Part> addProductAssocPartsTableView;

    /** This is a variable declaration for variable type TextField named addProductIdTxt. */
    @FXML
    private TextField addProductIdTxt;

    /** This is a variable declaration for variable type TextField named addProductInvTxt. */
    @FXML
    private TextField addProductInvTxt;

    /** This is a variable declaration for variable type TextField named addProductMaxTxt. */
    @FXML
    private TextField addProductMaxTxt;

    /** This is a variable declaration for variable type TextField named addProductMinTxt. */
    @FXML
    private TextField addProductMinTxt;

    /** This is a variable declaration for variable type TextField named addProductNameTxt. */
    @FXML
    private TextField addProductNameTxt;

    /** This is a variable declaration for variable type TextField named addProductPriceTxt. */
    @FXML
    private TextField addProductPriceTxt;

    /** This is a variable declaration for variable type TextField named addProductSearchTxt. */
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

    /** This method saves the user added Part/s to the Product when the Save button is clicked. */
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
