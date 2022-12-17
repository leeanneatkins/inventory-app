package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    @FXML
    private TableColumn<?, ?> mainPartsIdCol;

    @FXML
    private TableColumn<?, ?> mainPartsInvCol;

    @FXML
    private TableColumn<?, ?> mainPartsNameCol;

    @FXML
    private TableColumn<?, ?> mainPartsPriceCol;

    @FXML
    private TextField mainPartsSearchTxt;

    @FXML
    private TableView<?> mainPartsTableView;

    @FXML
    private TableColumn<?, ?> mainProductsIdCol;

    @FXML
    private TableColumn<?, ?> mainProductsInvCol;

    @FXML
    private TableColumn<?, ?> mainProductsNameCol;

    @FXML
    private TableColumn<?, ?> mainProductsPriceCol;

    @FXML
    private TextField mainProductsSearchTxt;

    @FXML
    private TableView<?> mainProductsTableView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}