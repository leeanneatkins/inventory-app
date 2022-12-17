package controller;

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

public class AddProductController implements Initializable{

    Stage stage;
    Parent scene;

    @FXML
    private TableColumn<?, ?> addProductAllPartsIdCol;

    @FXML
    private TableColumn<?, ?> addProductAllPartsInvCol;

    @FXML
    private TableColumn<?, ?> addProductAllPartsNameCol;

    @FXML
    private TableColumn<?, ?> addProductAllPartsPriceCol;

    @FXML
    private TableView<?> addProductAllPartsTableView;

    @FXML
    private TableColumn<?, ?> addProductAssocPartsIdCol;

    @FXML
    private TableColumn<?, ?> addProductAssocPartsInvCol;

    @FXML
    private TableColumn<?, ?> addProductAssocPartsNameCol;

    @FXML
    private TableColumn<?, ?> addProductAssocPartsPriceCol;

    @FXML
    private TableView<?> addProductAssocPartsTableView;

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

    @FXML
    void onActionAddPartToProduct(ActionEvent event) {

    }

    @FXML
    void onActionCancelAddProduct(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionRemoveAssocPart(ActionEvent event) {

    }

    @FXML
    void onActionSaveAddProduct(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
