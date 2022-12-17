package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyPartController implements Initializable{

    @FXML
    private ToggleGroup AddPartTG;

    @FXML
    private TextField modPartIdTxt;

    @FXML
    private RadioButton modPartInHouseRadBtn;

    @FXML
    private TextField modPartInvTxt;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
