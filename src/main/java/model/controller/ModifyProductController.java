package model.controller;

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
 * This class serves as a controller for the ModifyProduct view. (ModifyProduct.fxml)
 * @author    LeeAnne Atkins
 */

public class ModifyProductController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private TableColumn<Part, Integer> modProductAllPartsIdCol;

    @FXML
    private TableColumn<Part, Integer> modProductAllPartsInvCol;

    @FXML
    private TableColumn<Part, String> modProductAllPartsNameCol;

    @FXML
    private TableColumn<Part, Double> modProductAllPartsPriceCol;

    @FXML
    private TableView<?> modProductAllPartsTableView;

    @FXML
    private TableColumn<Part, Integer> modProductAssocPartsIdCol;

    @FXML
    private TableColumn<Part, Integer> modProductAssocPartsInvCol;

    @FXML
    private TableColumn<Part, String> modProductAssocPartsNameCol;

    @FXML
    private TableColumn<Part, Double> modProductAssocPartsPriceCol;

    @FXML
    private TableView<?> modProductAssocPartsTableView;

    @FXML
    private TextField modProductIdTxt;

    @FXML
    private TextField modProductInvTxt;

    @FXML
    private TextField modProductMaxTxt;

    @FXML
    private TextField modProductMinTxt;

    @FXML
    private TextField modProductNameTxt;

    @FXML
    private TextField modProductPriceTxt;

    @FXML
    private TextField modProductSearchTxt;

    /** This method adds the user selected Part/s to the Product when the Add button is clicked. */
    @FXML
    void onActionAddPartToProduct(ActionEvent event) {

    }

    /** This method returns the scene to MainForm.fxml when the Cancel button is clicked. */
    @FXML
    void onActionCancelModifyProduct(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /** This method removes the user selected Part/s from the Product when the Remove Associated Part button is clicked */
    @FXML
    void onActionRemoveAssocPart(ActionEvent event) {

    }

    /** This method saves the user modified Product when the Save button is clicked. */
    @FXML
    void onActionSaveModifyProduct(ActionEvent event) {

    }

    /** This method initializes the scene ModifyProduct.fxml. */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
