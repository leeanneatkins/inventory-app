package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddProductController implements Initializable{

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
