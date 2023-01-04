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
import model.Outsourced;
import model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * This class serves as a controller for the ModifyPart view. (ModifyPart.fxml)
 * @author    LeeAnne Atkins
 */

public class ModifyPartController implements Initializable {
    Part modPart;

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
    private TextField modPartMinTxt;

    @FXML
    private TextField modPartNameTxt;

    @FXML
    private RadioButton modPartOutsourcedRadBtn;

    @FXML
    private TextField modPartPriceTxt;

    /** This method returns the scene to MainForm.fxml when the Cancel button is clicked. */
    @FXML
    void onActionCancelModifyPart(ActionEvent event) throws IOException {
        backToMainForm(event);
    }

    /** This method saves the user modified data for the Part when the save button is clicked and returns the scene to MainForm.fxml. */
    @FXML
    void onActionSaveModifyPart(ActionEvent event) throws IOException {
        int index = Inventory.getAllParts().indexOf(modPart);
        int id = Integer.parseInt(modPartIdTxt.getText());
        String name = modPartNameTxt.getText();
        double price = Double.parseDouble(modPartPriceTxt.getText());
        int stock = Integer.parseInt(modPartInvTxt.getText());
        int min = Integer.parseInt(modPartMinTxt.getText());
        int max = Integer.parseInt(modPartMaxTxt.getText());


        if(modPartInHouseRadBtn.isSelected()) {
            //inHouse = true;
            int machineId = Integer.parseInt(modPartMachineIdTxt.getText());
            Inventory.updatePart(index, new InHouse(id, name, price, stock, min, max, machineId));
            backToMainForm(event);
        }
        else if(modPartOutsourcedRadBtn.isSelected()) {
            //outSourced = true;
            String companyName = modPartMachineIdTxt.getText();
            Inventory.updatePart(index, new Outsourced(id, name, price, stock, min, max, companyName));
            backToMainForm(event);
        }
    }

    private void backToMainForm(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void sendPart(Part part1) {
        modPart = part1;
        modPartIdTxt.setText(String.valueOf(modPart.getId()));
        modPartNameTxt.setText(modPart.getName());
        modPartInvTxt.setText(String.valueOf(modPart.getStock()));
        modPartPriceTxt.setText(String.valueOf(modPart.getPrice()));
        modPartMaxTxt.setText(String.valueOf(modPart.getMax()));
        modPartMinTxt.setText(String.valueOf(modPart.getMin()));
        if (modPart instanceof InHouse) {
            modPartMachineIdTxt.setText(String.valueOf(((InHouse) modPart).getMachineId()));
            modPartInHouseRadBtn.setSelected(true);
            modPartMachineIdLbl.setText("Machine ID");
        }
        if (modPart instanceof Outsourced) {
            modPartMachineIdTxt.setText(String.valueOf(((Outsourced) modPart).getCompanyName()));
            modPartOutsourcedRadBtn.setSelected(true);
            modPartMachineIdLbl.setText("Company name");
        }
    }

    /** This method initializes the scene ModifyPartController.fxml.*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /** This method sets the text of addPartMachineIdLbl to "Machine ID" when the InHouse radial button is selected. */
    public void onInHouse(ActionEvent actionEvent) {
        modPartMachineIdLbl.setText("Machine ID");
    }

    /** This method sets the text of addPartMachineIdLbl to "Company name" when the Outsourced radial button is selected. */
    public void onOutsourced(ActionEvent actionEvent) {
        modPartMachineIdLbl.setText("Company name");
    }
}
