package model.controller;
import model.InHouse;
import model.Inventory;
import model.Outsourced;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Serves as a controller for <code>AddPart.fxml</code>.
 *
 * @author LeeAnne Atkins
 */
public class AddPartController implements Initializable {

    /**
     * Initializes new Part.
     */
    //private Part newPart = new InHouse(0,null, 0, 0, 0, 0, 0);
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
     * The toggle group includes <code>addPartInHouseRadBtn</code> radio button and <code>addPartOutsourcedRadBtn</code> radio button.
     */
    @FXML
    private ToggleGroup AddPartTG;

    /**
     * A text field for part id.
     */
    @FXML
    private TextField addPartIdTxt;

    /**
     * A radio button to indicate the part is made inhouse.
     */
    @FXML
    private RadioButton addPartInHouseRadBtn;

    /**
     * A text field for quantity of the part in inventory.
     */
    @FXML
    private TextField addPartInvTxt;

    /**
     * A label for <code>addPartMachineIdTxt</code> text field. If <code>addPartInHouseRadBtn</code> radio button is selected, label is set to "Machine ID." If <code>addPartOutsourcedRadBtn</code> radio button is selected, label is set to "Company Name."
     */
    @FXML
    private Label addPartMachineIdLbl;

    /**
     * A text field for machine id or company name. If the part is inhouse, it has a machine id. If the part is outsourced, it has a company name.
     */
    @FXML
    private TextField addPartMachineIdTxt;

    /**
     * A text field for maximum quantity of the part that can be in inventory.
     */
    @FXML
    private TextField addPartMaxTxt;

    /**
     * A text field for minimum quantity of the part that can be in inventory.
     */
    @FXML
    private TextField addPartMinTxt;

    /**
     * A text field for part name.
     */
    @FXML
    private TextField addPartNameTxt;

    /**
     * A radio button to indicate part is outsourced.
     */
    @FXML
    private RadioButton addPartOutsourcedRadBtn;

    /**
     * A text field for part price.
     */
    @FXML
    private TextField addPartPriceTxt;

    /**
     * Saves the user entered data as a new part and calls the <code>backToMainForm</code> method. Increments <code>partId</code>.
     *
     * @param event the save button is clicked
     */
    @FXML
    void onActionSavePart(ActionEvent event) {
        try {
            int id = Inventory.partId;
            String name = addPartNameTxt.getText();
            double price = Double.parseDouble(addPartPriceTxt.getText());
            int stock = Integer.parseInt(addPartInvTxt.getText());
            int min = Integer.parseInt(addPartMinTxt.getText());
            int max = Integer.parseInt(addPartMaxTxt.getText());
            boolean fieldsAllValid = false;

            if (name.isEmpty()) {
                alertMessage(1);
            } else if (min >= max) {
                alertMessage(2);
            } else if (stock > max || stock < min) {
                alertMessage(3);
            } else {
                if (addPartInHouseRadBtn.isSelected()) {
                    try {
                        int machineId = Integer.parseInt(addPartMachineIdTxt.getText());
                        Inventory.addPart(new InHouse(id, name, price, stock, min, max, machineId));
                        fieldsAllValid = true;
                    } catch (Exception e) {
                        alertMessage(4);
                    }
                } else if (addPartOutsourcedRadBtn.isSelected()) {
                    String companyName = addPartMachineIdTxt.getText();
                    Inventory.addPart(new Outsourced(id, name, price, stock, min, max, companyName));
                    fieldsAllValid = true;
                }
                if (fieldsAllValid) {
                    Inventory.partId += 1;
                    backToMainForm(event);
                }
            }
        } catch (NumberFormatException e) {
            alertMessage(5);
        } catch (Exception e) {
            alertMessage(6);
        }
    }

    //can't get it to work with the casting instead of the variables.  error: can't cast an inhouse to outsourced

    /*void onActionSavePart(ActionEvent event) throws IOException {
        try {
            newPart.setId(Integer.parseInt(addPartIdTxt.getText()));
            newPart.setName(addPartNameTxt.getText());
            newPart.setPrice(Double.parseDouble(addPartPriceTxt.getText()));
            newPart.setStock(Integer.parseInt(addPartInvTxt.getText()));
            newPart.setMin(Integer.parseInt(addPartMinTxt.getText()));
            newPart.setMax(Integer.parseInt(addPartMaxTxt.getText()));
            boolean fieldsAllValid = false;

            if (newPart.getName().isEmpty()) {
                alertMessage(1);
            } else {
                if (newPart.getMin() >= newPart.getMax()) {
                    alertMessage(2);
                } else if (newPart.getStock() > newPart.getMax() || newPart.getStock() < newPart.getMin()) {
                    alertMessage(3);
                } else {
                    try {
                        if (addPartInHouseRadBtn.isSelected()) {
                            ((InHouse) newPart).setMachineId(Integer.parseInt(addPartMachineIdTxt.getText()));
                            fieldsAllValid = true;
                        }
                        //partFieldsAllValid = true;
                    } catch (Exception e) {
                        alertMessage(4);
                    }
                }
                if (addPartOutsourcedRadBtn.isSelected()) {
                    ((Outsourced) newPart).setCompanyName(addPartMachineIdTxt.getText());
                    fieldsAllValid = true;
                }
                if (fieldsAllValid) {
                    Inventory.addPart(newPart);
                    Inventory.partId += 1;
                    backToMainForm(event);
                }
            }
        } catch (NumberFormatException e) {
            alertMessage(5);

        }
    }

*/

    /**
     * Calls the <code>backToMainForm</code> method.
     *
     * @param event the cancel button is clicked
     * @throws IOException if an error occurs loading the next form
     */
    @FXML
    void onActionCancelAddPart(ActionEvent event) throws IOException {
        backToMainForm(event);
    }

    /**
     * Changes the scene to <code>MainForm.fxml</code>.
     *
     * @param event the save button or cancel button is clicked
     * @throws IOException if an error occurs loading the next form
     */
    public void backToMainForm(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * Sets the text of <code>addPartMachineIdLbl</code> to "Machine ID".
     *
     * @param actionEvent the InHouse radio button is selected
     */
    public void onInHouse(ActionEvent actionEvent) {
        addPartMachineIdLbl.setText("Machine ID");
    }

    /**
     * Sets the text of <code>addPartMachineIdLbl</code> to "Company Name".
     *
     * @param actionEvent the Outsourced radio button is selected
     */
    public void onOutsourced(ActionEvent actionEvent) {
        addPartMachineIdLbl.setText("Company Name");
    }

    /**
     * Initializes the scene <code>AddPart.fxml</code>.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addPartIdTxt.setText(String.valueOf(Inventory.partId));
    }

    /**
     * Handles all possible user input errors and displays the corresponding alert.
     *
     * @param alertNumber the alertNumber is passed from <code>onActionSavePart</code> method if the user enters invalid input
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
                alert.setHeaderText("Loading error");
                alert.setContentText("An error occurred loading the main form.");
                alert.showAndWait();
                break;
            }
        }
    }
