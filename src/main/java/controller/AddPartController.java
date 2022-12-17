package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPartController implements Initializable{

    @FXML
    private ToggleGroup AddPartTG;

    @FXML
    private TextField addPartIdTxt;

    @FXML
    private RadioButton addPartInHouseRadBtn;

    @FXML
    private TextField addPartInvTxt;

    @FXML
    private TextField addPartMachineIdTxt;

    @FXML
    private TextField addPartMaxTxt;

    @FXML
    private TextField addPartMinTxt;

    @FXML
    private TextField addPartNameTxt;

    @FXML
    private RadioButton addPartOutsourcedRadBtn;

    @FXML
    private TextField addPartPriceTxt;

    @FXML
    private Label priceTxt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
