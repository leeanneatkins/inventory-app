package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyProductController implements Initializable{

    @FXML
    private TableColumn<?, ?> modProductAllPartsIdCol;

    @FXML
    private TableColumn<?, ?> modProductAllPartsInvCol;

    @FXML
    private TableColumn<?, ?> modProductAllPartsNameCol;

    @FXML
    private TableColumn<?, ?> modProductAllPartsPriceCol;

    @FXML
    private TableView<?> modProductAllPartsTableView;

    @FXML
    private TableColumn<?, ?> modProductAssocPartsIdCol;

    @FXML
    private TableColumn<?, ?> modProductAssocPartsInvCol;

    @FXML
    private TableColumn<?, ?> modProductAssocPartsNameCol;

    @FXML
    private TableColumn<?, ?> modProductAssocPartsPriceCol;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
