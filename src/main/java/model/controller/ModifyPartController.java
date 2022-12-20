package model.controller;

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

public class ModifyPartController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private ToggleGroup AddPartTG;

    @FXML
    private TextField modPartIdTxt;

    @FXML
    private RadioButton modPartInHouseRadBtn;

    @FXML
    private TextField modPartInvTxt;

    @FXML
    private Label modPartMachineIdLbl;

    @FXML
    private TextField modPartMachineIdTxt;

    @FXML
    private TextField modPartMaxTxt;

    @FXML
    private TextField modPartMinText;

    @FXML
    private TextField modPartNameTxt;

    @FXML
    private RadioButton modPartOutsourcedRadBtn;

    @FXML
    private TextField modPartPriceTxt;

    @FXML
    void onActionCancelModifyPart(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionSaveModifyPart(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onInHouse(ActionEvent actionEvent) {
        modPartMachineIdLbl.setText("Machine ID");
    }

    public void onOutsourced(ActionEvent actionEvent) {
        modPartMachineIdLbl.setText("Company name");
    }
}
