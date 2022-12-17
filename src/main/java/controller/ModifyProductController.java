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

public class ModifyProductController implements Initializable{

    Stage stage;
    Parent scene;

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

    @FXML
    void onActionAddPartToProduct(ActionEvent event) {

    }

    @FXML
    void onActionCancelModifyProduct(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionRemoveAssocPart(ActionEvent event) {

    }

    @FXML
    void onActionSaveModifyProduct(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
