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
 * This class serves as a controller for the AddPart view. (AddPart.fxml)
 * @author    LeeAnne Atkins
 */

public class AddPartController implements Initializable{

    Stage stage;
    Parent scene;

    public static int partIdCounter = 110;

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


    /** This method calls the method backToMainForm() when the cancel button is clicked. */
    @FXML
    void onActionCancelAddPart(ActionEvent event) throws IOException {
        backToMainForm(event);
    }

    /** This method saves the user entered data for the Part when the save button is clicked and calls the method backToMainForm(). */
    @FXML
    void onActionSavePart(ActionEvent event) throws IOException {
        //boolean inHouse;
        //boolean outSourced;
        int id = ++partIdCounter;
        //int id = Integer.parseInt(addPartIdTxt.getText());
        String name = addPartNameTxt.getText();
        double price = Double.parseDouble(addPartPriceTxt.getText());
        int stock = Integer.parseInt(addPartInvTxt.getText());
        int min = Integer.parseInt(addPartMinTxt.getText());
        int max = Integer.parseInt(addPartMaxTxt.getText());

        if(addPartInHouseRadBtn.isSelected()) {
            //inHouse = true;
            int machineId = Integer.parseInt(addPartMachineIdTxt.getText());
            Inventory.addPart(new InHouse(id, name, price, stock, min, max, machineId));
            }
        else if(addPartOutsourcedRadBtn.isSelected()) {
            //outSourced = true;
            String companyName = addPartMachineIdTxt.getText();
            Inventory.addPart(new Outsourced(id, name, price, stock, min, max, companyName));
            }
        backToMainForm(event);
    }

    /** This method sets the text of addPartMachineIdLbl to "Machine ID" when the InHouse radial button is selected. */
    public void onInHouse(ActionEvent actionEvent) {
        addPartMachineIdLbl.setText("Machine ID");
    }

    /** This method sets the text of addPartMachineIdLbl to "Company name" when the Outsourced radial button is selected. */
    public void onOutsourced(ActionEvent actionEvent) {
        addPartMachineIdLbl.setText("Company name");
    }

    /** This method returns the scene to MainForm.fxml. */
    public void backToMainForm(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /** This method initializes the scene AddPart.fxml. */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
