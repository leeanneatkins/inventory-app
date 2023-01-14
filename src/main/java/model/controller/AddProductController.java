package model.controller;
import model.Inventory;
import model.Part;
import model.Product;
import model.InHouse;

import javafx.collections.FXCollections;
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
 * Serves as a controller for <code>AddProduct.fxml</code>.
 *
 * @author LeeAnne Atkins
 */
public class AddProductController implements Initializable {

    /**
     * Initializes new Product.
     */
    private Product newProduct = new Product(0, null, 0, 0, 0, 0);
    /**
     * The Stage.
     */
    Stage stage;
    /**
     * The Scene.
     */
    Parent scene;

    /**
     * The id column of <code>addProductAllPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, Integer> addProductAllPartsIdCol;

    /**
     * The inventory column of <code>addProductAllPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, Integer> addProductAllPartsInvCol;

    /**
     * The name column of <code>addProductAllPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, String> addProductAllPartsNameCol;

    /**
     * The price column of <code>addProductAllPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, Double> addProductAllPartsPriceCol;

    /**
     * The table view of all parts.
     */
    @FXML
    private TableView<Part> addProductAllPartsTableView;

    /**
     * The id column of <code>addProductAssocPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, Integer> addProductAssocPartsIdCol;

    /**
     * The inventory column of <code>addProductAssocPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, Integer> addProductAssocPartsInvCol;

    /**
     * The name column of <code>addProductAssocPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, String> addProductAssocPartsNameCol;

    /**
     * The price column of <code>addProductAssocPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, Double> addProductAssocPartsPriceCol;

    /**
     * A table view of associated parts for the product.
     */
    @FXML
    private TableView<Part> addProductAssocPartsTableView;

    /**
     * A text field for product id.
     */
    @FXML
    private TextField addProductIdTxt;

    /**
     * A text field for quantity of the product in inventory.
     */
    @FXML
    private TextField addProductInvTxt;

    /**
     * A text field for maximum quantity of the product that can be in inventory.
     */
    @FXML
    private TextField addProductMaxTxt;

    /**
     * A text field for minimum quantity of the product that can be in inventory.
     */
    @FXML
    private TextField addProductMinTxt;

    /**
     * A text field for product name.
     */
    @FXML
    private TextField addProductNameTxt;

    /**
     * A text field for product price.
     */
    @FXML
    private TextField addProductPriceTxt;

    /**
     * A text field for searching all parts.
     */
    @FXML
    private TextField addProductSearchTxt;

    /**
     * An observable list of associated parts for the product.
     */
    ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    /**
     * Takes user input from <code>addProductSearchTxt</code> text field and searches for a part by part id or part name in <code>allParts</code> observable list. The user may enter a partial part name. It is not case-sensitive. If a part matches the user entered part id, the matching part is highlighted in <code>addProductAllPartsTableView</code>. If a part(s) matches the user entered part name, the matching part(s) are displayed in <code>addProductAllPartsTableView</code>.  If a matching part is not found, an alert message is displayed. If user input is an empty string, <code>addProductAllPartsTableView</code> is reset to display all parts.
     *
     * @param actionEvent the enter key is pressed
     */
    public void onActionSearchPart(ActionEvent actionEvent) {
        if (addProductSearchTxt.getText().isBlank()) {
            addProductAllPartsTableView.setItems(Inventory.getAllParts());
            addProductAllPartsTableView.scrollTo(0);
        } else {
            try {
                int partId = Integer.parseInt(addProductSearchTxt.getText());
                Part part = Inventory.lookupPart(partId);
                if (Inventory.lookupPart(partId) == null) {
                    throw new NumberFormatException();
                } else {
                    addProductAllPartsTableView.getSelectionModel().select(part);
                    addProductAllPartsTableView.scrollTo(part);
                }
            } catch (NumberFormatException e) {
                String p = addProductSearchTxt.getText().toLowerCase();
                ObservableList<Part> parts = Inventory.lookupPart(p);
                addProductAllPartsTableView.setItems(parts);
                if (addProductAllPartsTableView.getItems().isEmpty()) {
                    alertMessage(1);
                    addProductAllPartsTableView.setItems(Inventory.getAllParts());
                }
            }
            addProductSearchTxt.clear();
        }
    }

        /*if (addProductSearchTxt.getText().isBlank()) {
            addProductAllPartsTableView.setItems(Inventory.getAllParts());
            addProductAllPartsTableView.scrollTo(0);
        } else {
            try {
                int partId = Integer.parseInt(addProductSearchTxt.getText());
                Part part = Inventory.lookupPart(partId);
                if (Inventory.partFound) {
                    addProductAllPartsTableView.getSelectionModel().select(part);
                    addProductAllPartsTableView.scrollTo(part);
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                String p = addProductSearchTxt.getText().toLowerCase();
                ObservableList<Part> parts = Inventory.lookupPart(p);
                addProductAllPartsTableView.setItems(parts);
                if (!Inventory.partFound) {
                    alertMessage(1);
                }
            }
            addProductSearchTxt.clear();
        }
    }


         */
    /**
     * Adds the user selected part to the <code>associatedParts</code> observable list of the product.
     *
     * @param event the add button is clicked
     */
    @FXML
    void onActionAddPartToProduct(ActionEvent event) {
        Part selectedItem = addProductAllPartsTableView.getSelectionModel().getSelectedItem();
        newProduct.addAssociatedPart(selectedItem);
        addProductAssocPartsTableView.setItems(newProduct.getAllAssociatedParts());
    }

    /**
     * Removes the user selected part from the <code>associatedParts</code> observable list of the product.
     *
     * @param event the remove associated part button is clicked
     */
    @FXML
    void onActionRemoveAssocPart(ActionEvent event) {
        Part selectedItem = addProductAssocPartsTableView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
          alertMessage(2);
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to remove this associated part?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                newProduct.deleteAssociatedPart(selectedItem);
            }
        }
    }

    /**
     * Saves the user entered data to create a new product and calls the <code>backToMainForm</code> method. Increments <code>productId</code>.
     *
     * @param event the save button is clicked
     */
    @FXML
    void onActionSaveAddProduct(ActionEvent event) {
        try {
            newProduct.setId(Inventory.productId);
            newProduct.setName(addProductNameTxt.getText());
            newProduct.setPrice(Double.parseDouble(addProductPriceTxt.getText()));
            newProduct.setStock(Integer.parseInt(addProductInvTxt.getText()));
            newProduct.setMin(Integer.parseInt(addProductMinTxt.getText()));
            newProduct.setMax(Integer.parseInt(addProductMaxTxt.getText()));

            if (newProduct.getName().isEmpty()) {
                alertMessage(3);
            } else {
                if (newProduct.getMin() >= newProduct.getMax()) {
                    alertMessage(4);
                } else if (newProduct.getStock() > newProduct.getMax() || newProduct.getStock() < newProduct.getMin()) {
                    alertMessage(5);
                } else {
                    Inventory.addProduct(newProduct);
                    Inventory.productId += 1;
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
     * Calls the <code>backToMainForm</code> method.
     *
     * @param event the cancel button is clicked
     * @throws IOException if an error occurs loading the next form
     */
    @FXML
    void onActionCancelAddProduct(ActionEvent event) throws IOException {
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
     * Initializes the scene <code>AddProduct.fxml</code>. Fills the <code>addProductAllPartsTableView</code> with parts from the observable list <code>allParts</code>. The <code>addProductAssocPartsTableView</code> is set to accept user added associated parts.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addProductIdTxt.setText(String.valueOf(Inventory.productId));

        addProductAllPartsTableView.setItems(Inventory.getAllParts());
        addProductAllPartsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        addProductAllPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addProductAllPartsInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addProductAllPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        addProductAssocPartsTableView.setItems(associatedParts);
        addProductAssocPartsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        addProductAssocPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addProductAssocPartsInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addProductAssocPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    /**
     * Handles all possible user input errors and displays the corresponding alert.
     *
     * @param alertNumber the alertNumber is passed from <code>onActionSaveProduct</code> method if the user enters invalid input
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
                alert.setHeaderText("Loading error");
                alert.setContentText("An error occurred loading the main form.");
                alert.showAndWait();
                break;
            }
        }
    }

/*
 This one works!

        try {
            int id = Inventory.partId;
            String name = addPartNameTxt.getText();
            double price = Double.parseDouble(addPartPriceTxt.getText());
            int stock = Integer.parseInt(addPartInvTxt.getText());
            int min = Integer.parseInt(addPartMinTxt.getText());
            int max = Integer.parseInt(addPartMaxTxt.getText());
            boolean partFieldsAllValid = false;

            if (name.isEmpty()) {
                alertMessage(1);
            } else if (min > max) {
                alertMessage(2);
            } else if (stock > max || stock < min) {
                alertMessage(3);
            } else {
                    if (addPartInHouseRadBtn.isSelected()) {
                        try {
                            int machineId = Integer.parseInt(addPartMachineIdTxt.getText());
                            Inventory.addPart(new InHouse(id, name, price, stock, min, max, machineId));
                            partFieldsAllValid = true;
                        } catch (Exception e) {
                            alertMessage(4);
                        }
                    }
                    else if (addPartOutsourcedRadBtn.isSelected()) {
                        String companyName = addPartMachineIdTxt.getText();
                        Inventory.addPart(new Outsourced(id, name, price, stock, min, max, companyName));
                        partFieldsAllValid = true;
                    }
                    if (partFieldsAllValid) {
                        Inventory.partId += 1;
                        backToMainForm(event);
                    }
                    }

        } catch (Exception e) {
            alertMessage(5);
        }
    }

  */



