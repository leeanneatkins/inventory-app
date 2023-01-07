package model.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Inventory;
import model.Part;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class serves as a controller for the ModifyProduct view. (ModifyProduct.fxml)
 * @author    LeeAnne Atkins
 */

public class ModifyProductController implements Initializable {

    // added private 1/7
    private Product modProduct;
    Stage stage;
    Parent scene;

    @FXML
    private TableColumn<Part, Integer> modProductAllPartsIdCol;

    @FXML
    private TableColumn<Part, Integer> modProductAllPartsInvCol;

    @FXML
    private TableColumn<Part, String> modProductAllPartsNameCol;

    @FXML
    private TableColumn<Part, Double> modProductAllPartsPriceCol;

    @FXML
    private TableView<Part> modProductAllPartsTableView;

    @FXML
    private TableColumn<Part, Integer> modProductAssocPartsIdCol;

    @FXML
    private TableColumn<Part, Integer> modProductAssocPartsInvCol;

    @FXML
    private TableColumn<Part, String> modProductAssocPartsNameCol;

    @FXML
    private TableColumn<Part, Double> modProductAssocPartsPriceCol;

    @FXML
    private TableView<Part> modProductAssocPartsTableView;

    @FXML
    private TextField modProductIdTxt;

    @FXML
    private TextField modProductInvTxt;

    @FXML
    private TextField modProductMaxTxt;

    @FXML
    private TextField modProductMinTxt;

    @FXML
    private TextField modProductNameTxt;

    @FXML
    private TextField modProductPriceTxt;

    @FXML
    private TextField modProductSearchTxt;

    ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    public void onActionSearchPart(ActionEvent actionEvent) {
        try {
            int partId = Integer.parseInt(modProductSearchTxt.getText());
            Part part = Inventory.lookupPart(partId);
            modProductAllPartsTableView.getSelectionModel().select(part);
            modProductAllPartsTableView.scrollTo(part);

        } catch(NumberFormatException e){
            String p = modProductSearchTxt.getText();
            ObservableList<Part> parts = Inventory.lookupPart(p);
            modProductAllPartsTableView.setItems(parts);
            modProductSearchTxt.setText("");
        }
    }

    /**
     * This method adds the user selected Part to the Product when the Add button is clicked.
     */
    @FXML
    void onActionAddPartToProduct(ActionEvent event) {
        Part selectedItem = modProductAllPartsTableView.getSelectionModel().getSelectedItem();
        //changed on 1/6
        //associatedParts.add(selectedItem);
        modProduct.addAssociatedPart(selectedItem);
        modProductAssocPartsTableView.setItems(modProduct.getAllAssociatedParts());
    }

    /**
     * This method removes the user selected Part from the Product when the Remove Associated Part button is clicked
     */
    @FXML
    void onActionRemoveAssocPart(ActionEvent event) {
        Part selectedItem = modProductAssocPartsTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            //changed on 1/6
            //associatedParts.remove(selectedItem);
            modProduct.deleteAssociatedPart(selectedItem);
        }
        // per CI, add else statement
    }

    /**
     * This method saves the user modified Product when the Save button is clicked.
     */
    @FXML
    void onActionSaveModifyProduct(ActionEvent event) throws IOException {
        //modProduct.setId(++productIdCounter);
        int index = Inventory.getAllProducts().indexOf(modProduct);
        modProduct.setName(modProductNameTxt.getText());
        modProduct.setPrice(Double.parseDouble(modProductPriceTxt.getText()));
        modProduct.setStock(Integer.parseInt(modProductInvTxt.getText()));
        modProduct.setMin(Integer.parseInt(modProductMinTxt.getText()));
        modProduct.setMax(Integer.parseInt(modProductMaxTxt.getText()));
        //product.getAllAssociatedParts().addAll(associatedParts);
        Inventory.updateProduct(index, modProduct);
        backToMainForm(event);

    }


        /*
        int id = Integer.parseInt(modProductIdTxt.getText());
        String name = modProductNameTxt.getText();
        double price = Double.parseDouble(modProductPriceTxt.getText());
        int stock = Integer.parseInt(modProductInvTxt.getText());
        int min = Integer.parseInt(modProductMinTxt.getText());
        int max = Integer.parseInt(modProductMaxTxt.getText());
        Product product = new Product(id, name, price, stock, min, max);
        product.getAllAssociatedParts().addAll(associatedParts);
        Inventory.updateProduct(index, new Product(id, name, price, stock, min, max));
        backToMainForm(event);
    }
*/
    /**
     * This method returns the scene to MainForm.fxml when the Cancel button is clicked.
     */
    @FXML
    void onActionCancelModifyProduct(ActionEvent event) throws IOException {
        backToMainForm(event);
    }

    public void backToMainForm(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void sendProduct(Product product1) {
        modProduct = product1;
        modProductIdTxt.setText(String.valueOf(modProduct.getId()));
        modProductNameTxt.setText(modProduct.getName());
        modProductInvTxt.setText(String.valueOf(modProduct.getStock()));
        modProductPriceTxt.setText(String.valueOf(modProduct.getPrice()));
        modProductMaxTxt.setText(String.valueOf(modProduct.getMax()));
        modProductMinTxt.setText(String.valueOf(modProduct.getMin()));
        modProductAssocPartsTableView.setItems(modProduct.getAllAssociatedParts());


        //modProductAssocPartsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        //modProductAssocPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        //modProductAssocPartsInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        //modProductAssocPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    /**
     * This method initializes the scene ModifyProduct.fxml.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modProductAllPartsTableView.setItems(Inventory.getAllParts());
        modProductAllPartsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        modProductAllPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        modProductAllPartsInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modProductAllPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        //modProductAssocPartsTableView.setItems(associatedParts);
        modProductAssocPartsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        modProductAssocPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        modProductAssocPartsInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modProductAssocPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
