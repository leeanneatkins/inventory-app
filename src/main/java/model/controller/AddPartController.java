package model.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPartController implements Initializable{

    Stage stage;
    Parent scene;


    @FXML
    private ToggleGroup AddPartTG;

    @FXML
    private TextField addPartIdTxt;

    @FXML
    private RadioButton addPartInHouseRadBtn;

    @FXML
    private TextField addPartInvTxt;

    @FXML
    private Label addPartMachineIdLbl;

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
    void onActionCancelAddPart(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionSavePart(ActionEvent event) throws IOException {

        boolean inHouse;
        int id = Integer.parseInt((addPartIdTxt.getText()));
        String name = addPartNameTxt.getText();
        double price = Double.parseDouble(addPartPriceTxt.getText());
        int stock = Integer.parseInt(addPartInvTxt.getText());
        int min = Integer.parseInt(addPartMinTxt.getText());
        int max = Integer.parseInt(addPartMaxTxt.getText());
        int machineId = Integer.parseInt(addPartMachineIdTxt.getText());

        if(addPartInHouseRadBtn.isSelected())
            inHouse = true;
        else
            inHouse = false;

        Inventory.addPart(new InHouse(id, name, price, stock, min, max, machineId));

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onInHouse(ActionEvent actionEvent) {
        addPartMachineIdLbl.setText("Machine ID");
    }

    public void onOutsourced(ActionEvent actionEvent) {
        addPartMachineIdLbl.setText("Company name");
    }
}
