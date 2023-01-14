package model.controller;
import model.InHouse;
import model.Inventory;
import model.Outsourced;
import model.Part;

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
//import java.util.Optional;
import java.util.ResourceBundle;


/**
 * Serves as a controller for <code>ModifyPart.fxml</code>.
 *
 * @author LeeAnne Atkins
 */
public class ModifyPartController implements Initializable {

    /**
     * Initializes new Part.
     */
    private Part modPart = new InHouse(0,null, 0, 0, 0, 0, 0);
    /**
     * Initializes new InHouse.
     */
    //private InHouse inHouse = new InHouse(0, null, 0, 0, 0, 0, 0);
    /**
     * Initializes new Outsourced.
     */
    //private Outsourced outsourced = new Outsourced(0, null, 0, 0, 0, 0, null);
    /**
     * The Stage.
     */
    Stage stage;
    /**
     * The Scene.
     */
    Parent scene;

    /**
     * The toggle group includes <code>modPartInHouseRadBtn</code> and <code>modPartOutsourcedRadBtn</code>.
     */
    @FXML
    private ToggleGroup ModPartTG;

    /**
     * A text field for part id.
     */
    @FXML
    private TextField modPartIdTxt;

    /**
     * A radio button to indicate the part is made inhouse.
     */
    @FXML
    private RadioButton modPartInHouseRadBtn;

    /**
     * A text field for quantity of the part in inventory.
     */
    @FXML
    private TextField modPartInvTxt;

    /**
     * A label for <code>modPartMachineIdTxt</code> text field. If <code>modPartInHouseRadBtn</code> radio button is selected, label is set to "Machine ID." If <code>modPartOutsourcedRadBtn</code> radio button is selected, label is set to "Company Name."
     */
    @FXML
    private Label modPartMachineIdLbl;

    /**
     * A text field for machine id or company name. If the part is inhouse, it has a machine id. If the part is outsourced, it has a company name.
     */
    @FXML
    private TextField modPartMachineIdTxt;

    /**
     * A text field for maximum quantity of the part that can be in inventory.
     */
    @FXML
    private TextField modPartMaxTxt;

    /**
     * A text field for minimum quantity of the part that can be in inventory.
     */
    @FXML
    private TextField modPartMinTxt;

    /**
     * A text field for part name.
     */
    @FXML
    private TextField modPartNameTxt;

    /**
     * A radio button to indicate the part is outsourced.
     */
    @FXML
    private RadioButton modPartOutsourcedRadBtn;

    /**
     * A text field for part price.
     */
    @FXML
    private TextField modPartPriceTxt;

    /**
     * Updates the part with user modified data and calls the <code>backToMainForm</code> method to change scene to <code>MainForm.fxml</code>.
     *
     * <p> RUNTIME ERROR: Line 145: Put id instead of index as first argument in updatePart() which caused an IndexOutOfBoundsException. Replaced id with index to fix error. </p>
     *
     * @param event the save button is clicked
     */
    @FXML
    void onActionSaveModifyPart(ActionEvent event) {
        try {
            int index = Inventory.getAllParts().indexOf(modPart);
            int id = modPart.getId();
            String name = modPartNameTxt.getText();
            double price = Double.parseDouble(modPartPriceTxt.getText());
            int stock = Integer.parseInt(modPartInvTxt.getText());
            int min = Integer.parseInt(modPartMinTxt.getText());
            int max = Integer.parseInt(modPartMaxTxt.getText());
            boolean fieldsAllValid = false;

            if (name.isEmpty()) {
                alertMessage(1);
            } else if (min >= max) {
                alertMessage(2);
            } else if (stock > max || stock < min) {
                alertMessage(3);
            } else {
                if (modPartInHouseRadBtn.isSelected()) {
                    try {
                        int machineId = Integer.parseInt(modPartMachineIdTxt.getText());
                        Inventory.updatePart(index, new InHouse(id, name, price, stock, min, max, machineId));
                        fieldsAllValid = true;
                    } catch (Exception e) {
                        alertMessage(4);
                    }
                } else if (modPartOutsourcedRadBtn.isSelected()) {
                    String companyName = modPartMachineIdTxt.getText();
                    Inventory.updatePart(index, new Outsourced(id, name, price, stock, min, max, companyName));
                    fieldsAllValid = true;
                }
                if (fieldsAllValid) {
                    backToMainForm(event);
                }
            }
        } catch (NumberFormatException e) {
            alertMessage(5);
        } catch (Exception e) {
            alertMessage(6);
        }
    }

 /*void onActionSaveModifyPart(ActionEvent event) throws IOException {
        try {
            int index = Inventory.getAllProducts().indexOf(modPart);
            modPart.setId(Integer.parseInt(modPartIdTxt.getText()));
            modPart.setName(modPartNameTxt.getText());
            modPart.setPrice(Double.parseDouble(modPartPriceTxt.getText()));
            modPart.setStock(Integer.parseInt(modPartInvTxt.getText()));
            modPart.setMin(Integer.parseInt(modPartMinTxt.getText()));
            modPart.setMax(Integer.parseInt(modPartMaxTxt.getText()));
            boolean fieldsAllValid = false;

            if (modPart.getName().isEmpty()) {
                alertMessage(1);
            } else {
                if (modPart.getMin() >= modPart.getMax()) {
                    alertMessage(2);
                } else if (modPart.getStock() > modPart.getMax() || modPart.getStock() < modPart.getMin()) {
                    alertMessage(3);
                } else {
                    try {
                        if (modPartInHouseRadBtn.isSelected()) {
                            ((InHouse) modPart).setMachineId(Integer.parseInt(modPartMachineIdTxt.getText()));
                            fieldsAllValid = true;
                        }
                        //partFieldsAllValid = true;
                    } catch (Exception e) {
                        alertMessage(4);
                    }
                }
                if (modPartOutsourcedRadBtn.isSelected()) {
                    ((Outsourced) modPart).setCompanyName(modPartMachineIdTxt.getText());
                    fieldsAllValid = true;
                }
                if (fieldsAllValid) {
                    Inventory.updatePart(index, modPart);
                    backToMainForm(event);
                }
            }
        } catch (NumberFormatException e) {
            alertMessage(5);

        }
    }
     */





    /**
     * Calls the method <code>backToMainForm</code> to change scene to <code>MainForm.fxml</code>.
     *
     * @param event the cancel button is clicked
     * @throws IOException if an error occurs loading the next form
     */
    @FXML
    void onActionCancelModifyPart(ActionEvent event) throws IOException {
            backToMainForm(event);
        }

    /**
     * Changes the scene to <code>MainForm.fxml</code>.
     *
     * @param event the save button or cancel button is clicked
     * @throws IOException if an error occurs loading the next form
     */
    private void backToMainForm(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * Fills text fields of <code>ModifyPart.fxml</code> with the data for the user selected part from <code>mainPartsTableView</code>. Selects the appropriate radio button (inhouse or outsourced) for the part.
     *
     * @param part1 the user selected part from <code>MainFormController</code>
     */
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

    /**
     * Sets the text of <code>modPartMachineIdLbl</code> to "Machine ID".
     *
     * @param actionEvent the InHouse radio button is selected
     */
    public void onInHouse(ActionEvent actionEvent) {
        modPartMachineIdLbl.setText("Machine ID");
    }

    /**
     * Sets the text of <code>modPartMachineIdLbl</code> to "Company Name".
     *
     * @param actionEvent the Outsourced radio button is selected
     */
    public void onOutsourced(ActionEvent actionEvent) {
        modPartMachineIdLbl.setText("Company Name");
    }

    /** Initializes the scene <code>ModifyPartController.fxml</code>.*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /**
     * Handles all possible user input errors and displays the corresponding alert.
     *
     * @param alertNumber the alertNumber is passed from <code>onActionSaveModifyPart</code> method if the user enters invalid input
     */
    private void alertMessage(int alertNumber) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        switch (alertNumber) {
            case 1:
                alert.setTitle("Error");
                alert.setHeaderText("Missing data");
                alert.setContentText("Enter a part name.");
                alert.showAndWait();
                break;
            case 2:
                alert.setTitle("Error");
                alert.setHeaderText("Logical error");
                alert.setContentText("Min value must be less than max value.");
                alert.showAndWait();
                break;
            case 3:
                alert.setTitle("Error");
                alert.setHeaderText("Logical error");
                alert.setContentText("Inventory must be between min and max values.");
                alert.showAndWait();
                break;
            case 4:
                alert.setTitle("Error");
                alert.setHeaderText("Invalid entry");
                alert.setContentText("Machine ID must be a number.");
                alert.showAndWait();
                break;
            case 5:
                alert.setTitle("Error");
                alert.setHeaderText("Invalid data");
                alert.setContentText("Check that all fields are correct.\n\nInventory must be an integer.\nPrice must be a double.\nMax must be an integer.\nMin must be an integer.");
                alert.showAndWait();
                break;
            case 6:
                alert.setTitle("Error");
                alert.setHeaderText("Form loading error");
                alert.setContentText("An error occurred loading the main form.");
                alert.showAndWait();
                break;
            }
        }
    }
