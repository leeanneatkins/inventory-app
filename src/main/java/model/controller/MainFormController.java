package model.controller;
import model.Inventory;
import model.Part;
import model.Product;

import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


/**
 * Serves as a controller for <code>MainForm.fxml</code>.
 *
 * @author LeeAnne Atkins
 */
public class MainFormController implements Initializable {

    /**
     * The Stage.
     */
    Stage stage;
    /**
     * The Scene.
     */
    Parent scene;

   /* enum ErrorType {
        PartNotFound,
        ProductNotFound,
        NoPartSelected,
        NoProductSelected,
        NoPartSelDelete,
        NoProductSelDelete,
        HasAssocParts
    }
    ErrorType a = ErrorType.PartNotFound;
    ErrorType b = ErrorType.ProductNotFound;
    ErrorType c = ErrorType.NoPartSelected;
    ErrorType d = ErrorType.NoProductSelected;
    ErrorType e = ErrorType.NoPartSelDelete;
    ErrorType f = ErrorType.NoProductSelDelete;
    ErrorType g = ErrorType.HasAssocParts;
    */

    /**
     * The id column of <code>mainPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, Integer> mainPartsIdCol;

    /**
     * The inventory column of <code>mainPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, Integer> mainPartsInvCol;

    /**
     * The name column of <code>mainPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, String> mainPartsNameCol;

    /**
     * The price column of <code>mainPartsTableView</code>.
     */
    @FXML
    private TableColumn<Part, Double> mainPartsPriceCol;

    /**
     * A text field for searching all parts.
     */
    @FXML
    private TextField mainPartsSearchTxt;

    /**
     * A table view of all parts.
     */
    @FXML
    private TableView<Part> mainPartsTableView;

    /**
     * The id column of <code>mainProductsTableView</code>.
     */
    @FXML
    private TableColumn<Product, Integer> mainProductsIdCol;

    /**
     * The inventory column of <code>mainProductsTableView</code>.
     */
    @FXML
    private TableColumn<Product, Integer> mainProductsInvCol;

    /**
     * The name column of <code>mainProductsTableView</code>.
     */
    @FXML
    private TableColumn<Product, String> mainProductsNameCol;

    /**
     * The price column of <code>mainProductsTableView</code>.
     */
    @FXML
    private TableColumn<Product, Double> mainProductsPriceCol;

    /**
     * A text field for searching all products.
     */
    @FXML
    private TextField mainProductsSearchTxt;

    /**
     * A table view of all products.
     */
    @FXML
    private TableView<Product> mainProductsTableView;

    /**
     * Takes user input from <code>mainPartsSearchTxt</code> text field and searches for a part by part id or part name in <code>allParts</code> observable list. The user may enter a partial part name. It is not case-sensitive. If a part matches the user entered part id, the matching part is highlighted in <code>mainPartsTableView</code>. If a part(s) matches the user entered part name, the matching part(s) is displayed in <code>mainPartsTableView</code>.  If a matching part is not found, an alert message is displayed. If user input is an empty string, <code>mainPartsTableView</code> is reset to display all parts.
     *
     * @param actionEvent the enter key is pressed
     */
    public void onActionSearchPart(ActionEvent actionEvent) {
        if (mainPartsSearchTxt.getText().isBlank()) {
            mainPartsTableView.setItems(Inventory.getAllParts());
            mainPartsTableView.scrollTo(0);
        } else {
            try {
                int partId = Integer.parseInt(mainPartsSearchTxt.getText());
                Part part = Inventory.lookupPart(partId);
                if (Inventory.lookupPart(partId) == null) {
                    throw new NumberFormatException();
                } else {
                    mainPartsTableView.getSelectionModel().select(part);
                    mainPartsTableView.scrollTo(part);
                }
            } catch (NumberFormatException e) {
                String p = mainPartsSearchTxt.getText().toLowerCase();
                ObservableList<Part> parts = Inventory.lookupPart(p);
                mainPartsTableView.setItems(parts);
                if (mainPartsTableView.getItems().isEmpty()) {
                    alertMessage(1);
                    mainPartsTableView.setItems(Inventory.getAllParts());
                }
            }
            mainPartsSearchTxt.clear();
        }
    }


     /*
    public void onActionSearchPart(ActionEvent actionEvent) {
    if(mainPartsSearchTxt.getText().isBlank()) {
        mainPartsTableView.setItems(Inventory.getAllParts());
        mainPartsTableView.scrollTo(0);
    } else

    {
        try {
            int partId = Integer.parseInt(mainPartsSearchTxt.getText());
            Part part = Inventory.lookupPart(partId);
            if (Inventory.partFound) {
                mainPartsTableView.getSelectionModel().select(part);
                mainPartsTableView.scrollTo(part);
            } else {
                //alertMessage(1);
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            String p = mainPartsSearchTxt.getText().toLowerCase();
            ObservableList<Part> parts = Inventory.lookupPart(p);
            mainPartsTableView.setItems(parts);
            if (!Inventory.partFound) {
                alertMessage(1);

                //mainPartsSearchTxt.clear();
            }
        }
        mainPartsSearchTxt.clear();
    }

}



      */


    /**
     * Takes user input from <code>mainProductsSearchTxt</code> text field and searches for a product by product id or product name in <code>allProducts</code> observable list. The user may enter a partial product name. It is not case-sensitive. If a product matches the user entered product id, the matching product is highlighted in <code>mainProductsTableView</code>. If a product(s) matches the user entered product name, the matching product(s) is displayed in <code>mainProductsTableView</code>.  If a matching product is not found, an alert message is displayed. If user input is an empty string, <code>mainProductsTableView</code> is reset to display all products.
     *
     * @param actionEvent the enter key is pressed
     */
    public void onActionSearchProduct(ActionEvent actionEvent) {
        if (mainProductsSearchTxt.getText().isBlank()) {
            mainProductsTableView.setItems(Inventory.getAllProducts());
            mainProductsTableView.scrollTo(0);
        } else {
            try {
                int productId = Integer.parseInt(mainProductsSearchTxt.getText());
                Product product = Inventory.lookupProduct(productId);
                if (Inventory.lookupProduct(productId) == null) {
                    throw new NumberFormatException();
                } else {
                    mainProductsTableView.getSelectionModel().select(product);
                    mainProductsTableView.scrollTo(product);
                }
            } catch (NumberFormatException e) {
                String p = mainProductsSearchTxt.getText().toLowerCase();
                ObservableList<Product> products = Inventory.lookupProduct(p);
                mainProductsTableView.setItems(products);
                if (mainProductsTableView.getItems().isEmpty()) {
                    alertMessage(2);
                    mainProductsTableView.setItems(Inventory.getAllProducts());
                }
            }
            mainProductsSearchTxt.clear();
        }
    }

    /**
     * Changes the scene to <code>AddPart.fxml</code>.
     *
     * @param event the add button under <code>mainPartsTableView</code> is clicked
     * @throws IOException if an error occurs loading the next form
     */
    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddPart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * Changes the scene to <code>AddProduct.fxml</code>.
     *
     * @param event the add button under <code>mainProductsTableView</code> is clicked
     * @throws IOException if an error occurs loading the next form
     */
    @FXML
    void onActionAddProduct(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * Changes the scene to <code>ModifyPart.fxml</code> and sends the data for the selected part.
     *
     * @param event the modify button under <code>mainPartsTableView</code> is clicked
     * @throws IOException if an error occurs loading the next form
     */
    @FXML
    void onActionModifyPart(ActionEvent event) throws IOException {
        Part selectedItem = mainPartsTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ModifyPart.fxml"));
            loader.load();

            ModifyPartController MPController = loader.getController();
            MPController.sendPart(mainPartsTableView.getSelectionModel().getSelectedItem());

            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();
        } else {
            alertMessage(3);
        }
    }

    /**
     * Changes the scene to <code>ModifyProduct.fxml</code>.
     *
     * @param event the modify button under <code>mainProductsTableView</code> is clicked
     * @throws IOException if an error occurs loading the next form
     */
    @FXML
    void onActionModifyProduct(ActionEvent event) throws IOException {
        Product selectedItem = mainProductsTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ModifyProduct.fxml"));
            loader.load();

            ModifyProductController MProdController = loader.getController();
            MProdController.sendProduct(mainProductsTableView.getSelectionModel().getSelectedItem());

            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();
        } else {
            alertMessage(4);
        }
    }

    /**
     * Removes the selected part from the <code>allParts</code> observable list.
     *
     * @param event the delete button is clicked
     */
    @FXML
    void onActionDeletePart(ActionEvent event) {
        Part selectedItem = mainPartsTableView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            alertMessage(5);
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this part?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Inventory.deletePart(selectedItem);
            }
        }
    }

    /**
     * Removes the selected product from <code>allProducts</code> observable list if the selected product does not have associated parts. If the selected product does have associated parts, user is alerted that associated parts must be deleted before the product can be deleted.
     *
     * @param event the delete button is clicked
     */
    @FXML
    void onActionDeleteProduct(ActionEvent event) {
        Product selectedItem = mainProductsTableView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            alertMessage(6);
        } else {
            if (selectedItem.getAllAssociatedParts().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this product?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                Inventory.deleteProduct(selectedItem);
                }
            } else {
                alertMessage(7);
            }
        }
    }

    /**
     * Exits the program.
     *
     * @param event the exit button is clicked
     */
    @FXML
    void onActionExitProgram(ActionEvent event) {
        System.exit(0);
    }

    /**
     * Initializes the scene <code>MainForm.fxml</code>. Fills the <code>mainPartsTableView</code> with parts from the <code>allParts</code> observable list. Fills the <code>mainProductsTableView</code> with products from the <code>allProducts</code> observable list .
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainPartsTableView.setItems(Inventory.getAllParts());
        mainPartsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        mainPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        mainPartsInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        mainPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        mainProductsTableView.setItems(Inventory.getAllProducts());
        mainProductsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        mainProductsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        mainProductsInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        mainProductsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
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
                alert.setHeaderText("Error");
                alert.setContentText("Part not found.");
                alert.showAndWait();
                break;
            case 2:
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Product not found.");
                alert.showAndWait();
                break;
            case 3:
                alert.setTitle("Error");
                alert.setHeaderText("Invalid selection");
                alert.setContentText("Select a part to modify.");
                alert.showAndWait();
                break;
            case 4:
                alert.setTitle("Error");
                alert.setHeaderText("Invalid selection");
                alert.setContentText("Select a product to modify.");
                alert.showAndWait();
                break;
            case 5:
                alert.setTitle("Error");
                alert.setHeaderText("Invalid selection");
                alert.setContentText("Select a part to delete.");
                alert.showAndWait();
                break;
            case 6:
                alert.setTitle("Error");
                alert.setHeaderText("Invalid selection");
                alert.setContentText("Select a product to delete.");
                alert.showAndWait();
                break;
            case 7:
                alert.setTitle("Error");
                alert.setHeaderText("Deletion error");
                alert.setContentText("Product has associated parts and cannot be deleted.\nClick modify and remove associated parts before deleting product.");
                alert.showAndWait();
                break;
        }

       /* switch (errorType) {
            case a:
                alert.setTitle("Error");
                alert.setContentText("Part not found.");
                alert.showAndWait();
                break;
            case b:
                alert.setTitle("Error");
                alert.setContentText("Product not found.");
                alert.showAndWait();
                break;
            case c:
                alert.setTitle("Error");
                alert.setHeaderText("Invalid selection");
                alert.setContentText("Select a part to modify.");
                alert.showAndWait();
                break;
            case d:
                alert.setTitle("Error");
                alert.setHeaderText("Invalid selection");
                alert.setContentText("Select a product to modify.");
                alert.showAndWait();
                break;
            case e:
                alert.setTitle("Error");
                alert.setHeaderText("Invalid selection");
                alert.setContentText("Select a part to delete.");
                alert.showAndWait();
                break;
            case f:
                alert.setTitle("Error");
                alert.setHeaderText("Invalid selection");
                alert.setContentText("Select a product to delete.");
                alert.showAndWait();
                break;
            case g:
                alert.setTitle("Error");
                alert.setContentText("Product cannot be deleted because it has associated parts.\nAssociated parts must be deleted first.");
                alert.showAndWait();
                break;

        */
            }
        }

