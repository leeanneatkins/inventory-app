package model.controller;
import model.Inventory;
import model.Part;
import model.Product;

//import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
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
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Serves as a controller for <code>ModifyProduct.fxml</code>.
 *
 * <p> RUNTIME ERROR: Add a detailed description of a logical or runtime error that you corrected in the code and a detailed description of how you corrected it above the line of code you are referring to. (place it in the header where the error occurred). </p>
 *
 * @author LeeAnne Atkins
 */
public class ModifyProductController implements Initializable {

    /**
     * A variable for storing data of a modified product.
     */
    private Product modProduct;
    /**
     * The Stage.
     */
    Stage stage;
    /**
     * The Scene.
     */
    Parent scene;

    /**
     * The id column of <code>modProductAllPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, Integer> modProductAllPartsIdCol;

    /**
     * The inventory column of <code>modProductAllPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, Integer> modProductAllPartsInvCol;

    /**
     * The name column of <code>modProductAllPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, String> modProductAllPartsNameCol;

    /**
     * The price column of <code>modProductAllPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, Double> modProductAllPartsPriceCol;

    /**
     * A table view of all parts.
     */
    @FXML
    private TableView<Part> modProductAllPartsTableView;

    /**
     * The id column of <code>modProductAssocPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, Integer> modProductAssocPartsIdCol;

    /**
     * The inventory column of <code>modProductAssocPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, Integer> modProductAssocPartsInvCol;

    /**
     * The name column of <code>modProductAssocPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, String> modProductAssocPartsNameCol;

    /**
     * The price column of <code>modProductAssocPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, Double> modProductAssocPartsPriceCol;

    /**
     * The table view of associated parts for the product.
     */
    @FXML
    private TableView<Part> modProductAssocPartsTableView;

    /**
     * A text field for product id.
     */
    @FXML
    private TextField modProductIdTxt;

    /**
     * A text field for quantity of the product in inventory.
     */
    @FXML
    private TextField modProductInvTxt;

    /**
     * A text field for maximum quantity of the product that can be in inventory.
     */
    @FXML
    private TextField modProductMaxTxt;

    /**
     * A text field for minimum quantity of the product that can be in inventory.
     */
    @FXML
    private TextField modProductMinTxt;

    /**
     * A text field for product name.
     */
    @FXML
    private TextField modProductNameTxt;

    /**
     * A text field for product price.
     */
    @FXML
    private TextField modProductPriceTxt;

    /**
     * A text field for searching all parts.
     */
    @FXML
    private TextField modProductSearchTxt;

    //ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    /**
     * Takes user input from <code>modProductSearchTxt</code> text field and searches for a part by part id or part name in <code>allParts</code> observable list. The user may enter a partial part name. It is not case-sensitive. If a part matches the user entered part id, the matching part is highlighted in <code>modProductAllPartsTableView</code>. If a part(s) matches the user entered part name, the matching part(s) is displayed in <code>modProductAllPartsTableView</code>.  If a matching part is not found, an alert message is displayed. If user input is an empty string, <code>modProductAllPartsTableView</code> is reset to display all parts.
     *
     * @param actionEvent the enter key is pressed
     */
    public void onActionSearchPart(ActionEvent actionEvent) {
        if (modProductSearchTxt.getText().isBlank()) {
            modProductAllPartsTableView.setItems(Inventory.getAllParts());
            modProductAllPartsTableView.scrollTo(0);
        } else {
            try {
                int partId = Integer.parseInt(modProductSearchTxt.getText());
                Part part = Inventory.lookupPart(partId);
                if (Inventory.lookupPart(partId) == null) {
                    throw new NumberFormatException();
                } else {
                    modProductAllPartsTableView.getSelectionModel().select(part);
                    modProductAllPartsTableView.scrollTo(part);
                }
            } catch (NumberFormatException e) {
                String p = modProductSearchTxt.getText().toLowerCase();
                ObservableList<Part> parts = Inventory.lookupPart(p);
                modProductAllPartsTableView.setItems(parts);
                if (modProductAllPartsTableView.getItems().isEmpty()) {
                    alertMessage(1);
                    modProductAllPartsTableView.setItems(Inventory.getAllParts());
                }
            }
            modProductSearchTxt.clear();
        }
    }

    /**
     * Adds the user selected part to the <code>associatedParts</code> observable list of the product.
     *
     * @param event the add button is clicked
     */
    @FXML
    void onActionAddPartToProduct(ActionEvent event) {
        Part selectedItem = modProductAllPartsTableView.getSelectionModel().getSelectedItem();
        modProduct.addAssociatedPart(selectedItem);
        modProductAssocPartsTableView.setItems(modProduct.getAllAssociatedParts());
    }

    /**
     * Removes the user selected part from the <code>associatedParts</code> observable list of the product.
     *
     * @param event the remove associated part button is clicked
     */
    @FXML
    void onActionRemoveAssocPart(ActionEvent event) {
        Part selectedItem = modProductAssocPartsTableView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
           alertMessage(2);
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to remove this associated part?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                modProduct.deleteAssociatedPart(selectedItem);
            }
        }
    }

    /**
     * Updates the product with user modified data and calls the <code>backToMainForm</code> method to change scene to <code>MainForm.fxml</code>.
     *
     * @param event the save button is clicked
     */
    @FXML
    void onActionSaveModifyProduct(ActionEvent event) {
        try {
            int index = Inventory.getAllProducts().indexOf(modProduct);
            modProduct.setName(modProductNameTxt.getText());
            modProduct.setPrice(Double.parseDouble(modProductPriceTxt.getText()));
            modProduct.setStock(Integer.parseInt(modProductInvTxt.getText()));
            modProduct.setMin(Integer.parseInt(modProductMinTxt.getText()));
            modProduct.setMax(Integer.parseInt(modProductMaxTxt.getText()));

            if (modProduct.getName().isEmpty()) {
                alertMessage(3);
            } else {
                if (modProduct.getMin() >= modProduct.getMax()) {
                    alertMessage(4);
                } else if (modProduct.getStock() > modProduct.getMax() || modProduct.getStock() < modProduct.getMin()) {
                    alertMessage(5);
                } else {
                    Inventory.updateProduct(index, modProduct);
                    backToMainForm(event);
                }
            }
        } catch (NumberFormatException e) {
            alertMessage(6);
        } catch (Exception e) {
            alertMessage(7);
        }
    }

    /**
     * Calls the <code>backToMainForm</code> method to change scene to <code>MainForm.fxml</code>.
     *
     * @param event the cancel button is clicked
     * @throws IOException if an error occurs loading the next form
     */
    @FXML
    void onActionCancelModifyProduct(ActionEvent event) throws IOException {
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
     * Fills text fields of <code>ModifyProduct.fxml</code> with the data for the user selected product from <code>mainProductsTableView</code>. Fills the <code>modProductTableView</code> with the associated parts for the product.
     *
     * @param product1 the user selected product from <code>MainFormController</code>
     */
    public void sendProduct(Product product1) {
        modProduct = product1;
        modProductIdTxt.setText(String.valueOf(modProduct.getId()));
        modProductNameTxt.setText(modProduct.getName());
        modProductInvTxt.setText(String.valueOf(modProduct.getStock()));
        modProductPriceTxt.setText(String.valueOf(modProduct.getPrice()));
        modProductMaxTxt.setText(String.valueOf(modProduct.getMax()));
        modProductMinTxt.setText(String.valueOf(modProduct.getMin()));
        modProductAssocPartsTableView.setItems(modProduct.getAllAssociatedParts());
    }

    /**
     * Initializes the scene <code>ModifyProduct.fxml</code>.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modProductAllPartsTableView.setItems(Inventory.getAllParts());
        modProductAllPartsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        modProductAllPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        modProductAllPartsInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modProductAllPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        modProductAssocPartsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        modProductAssocPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        modProductAssocPartsInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modProductAssocPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
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
                alert.setContentText("Part not found.");
                alert.showAndWait();
                break;
            case 2:
                alert.setTitle("Error");
                alert.setHeaderText("Invalid selection");
                alert.setContentText("Select a part to delete.");
                alert.showAndWait();
                break;
            case 3:
                alert.setTitle("Error");
                alert.setHeaderText("Missing data");
                alert.setContentText("Enter a product name.");
                alert.showAndWait();
                break;
            case 4:
                alert.setTitle("Error");
                alert.setHeaderText("Logical error");
                alert.setContentText("Min value must be less than max value.");
                alert.showAndWait();
                break;
            case 5:
                alert.setTitle("Error");
                alert.setHeaderText("Logical error");
                alert.setContentText("Inventory must be between min and max values.");
                alert.showAndWait();
                break;
            case 6:
                alert.setTitle("Error");
                alert.setHeaderText("Invalid data");
                alert.setContentText("Check that all fields are correct.\n\nInventory must be an integer.\nPrice must be a double.\nMax must be an integer.\nMin must be an integer.");
                alert.showAndWait();
                break;
            case 7:
                alert.setTitle("Error");
                alert.setHeaderText("Form loading error");
                alert.setContentText("An error occurred loading the main form");
                alert.showAndWait();
                break;
            }
        }
    }