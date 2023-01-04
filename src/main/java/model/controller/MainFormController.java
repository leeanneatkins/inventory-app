package model.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import model.Inventory;
import model.Part;
import model.Product;
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
import java.util.ResourceBundle;

/**
 * This class serves as a controller for the MainForm view. (MainForm.fxml)
 * @author    LeeAnne Atkins
 */

public class MainFormController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private TableColumn<Part, Integer> mainPartsIdCol;

    @FXML
    private TableColumn<Part, Integer> mainPartsInvCol;

    @FXML
    private TableColumn<Part, String> mainPartsNameCol;

    @FXML
    private TableColumn<Part, Double> mainPartsPriceCol;

    @FXML
    private TextField mainPartsSearchTxt;

    @FXML
    private TableView<Part> mainPartsTableView;

    @FXML
    private TableColumn<Product, Integer> mainProductsIdCol;

    @FXML
    private TableColumn<Product, Integer> mainProductsInvCol;

    @FXML
    private TableColumn<Product, String> mainProductsNameCol;

    @FXML
    private TableColumn<Product, Double> mainProductsPriceCol;

    @FXML
    private TextField mainProductsSearchTxt;

    @FXML
    private TableView<Product> mainProductsTableView;

    /**
     * This method changes the scene to AddPart.fxml when the Add button under mainPartsTableView is clicked.
     */

    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddPart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
//Kinkaid video
   /* public void getResultsHandler(ActionEvent actionEvent) {
        String p = mainPartsSearchTxt.getText();

        ObservableList<Part> parts = lookupPart(p);

        mainPartsTableView.setItems(parts);

        mainPartsSearchTxt.setText("");
    }
*/
//Kinkaid video
    /*
    public static ObservableList<Part> lookupPart(String partName){
        ObservableList<Part> namedParts = FXCollections.observableArrayList();

        ObservableList<Part> allParts = Inventory.getAllParts();

        for(Part p : allParts){
            if(p.getName().contains(partName)){
                namedParts.add(p);
            }
        }

        return namedParts;

    }
*/


    /**
     * This method changes the scene to AddProduct.fxml when the Add button under mainProductsTableView is clicked.
     */
    @FXML
    void onActionAddProduct(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * This method removes the selected Part from the mainPartsTableView when the Delete button is clicked.
     */
    @FXML
    void onActionDeletePart(ActionEvent event) {
        Part selectedItem = mainPartsTableView.getSelectionModel().getSelectedItem();
        mainPartsTableView.getItems().remove(selectedItem);
    }

    /**
     * This method removes the selected Product from the mainProductsTableView when the Delete button is clicked.
     */
    @FXML
    void onActionDeleteProduct(ActionEvent event) {

        System.out.println("Delete product button clicked");
    }

    /**
     * This method exits the program when the Exit button is clicked.
     */
    @FXML
    void onActionExitProgram(ActionEvent event) {
        System.exit(0);
    }

    /**
     * This method changes the scene to ModifyPart.fxml when the Modify button under mainPartsTableView is clicked.
     */
    @FXML
    void onActionModifyPart(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/ModifyPart.fxml"));
        loader.load();

        ModifyPartController MPController = loader.getController();
        MPController.sendPart(mainPartsTableView.getSelectionModel().getSelectedItem());

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * This method changes the scene to ModifyProduct.fxml when the Modify button under mainProductsTableView is clicked.
     */
    @FXML
    void onActionModifyProduct(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/ModifyProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * This method initializes the scene MainForm.fxml.
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

    public void onActionSearchPart(ActionEvent actionEvent) {
        try {
            int partId = Integer.parseInt(mainPartsSearchTxt.getText());
            Part part = Inventory.lookupPart(partId);
            mainPartsTableView.getSelectionModel().select(part);
            mainPartsTableView.scrollTo(part);

        } catch(NumberFormatException e){
            String partName = mainPartsSearchTxt.getText();
        }
    }

    public void onActionSearchProduct(ActionEvent actionEvent) {
        try {
            int productId = Integer.parseInt(mainProductsSearchTxt.getText());
            Product product = Inventory.lookupProduct(productId);
            mainProductsTableView.getSelectionModel().select(product);
            mainProductsTableView.scrollTo(product);

        } catch(NumberFormatException e){
            String productName = mainProductsSearchTxt.getText();
        }
    }
}


       /* FilteredList<Part> filteredData = new FilteredList<>(Inventory.allParts, p -> true);

        mainPartsSearchTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(part -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (part.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });
        SortedList<Part> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(mainPartsTableView.comparatorProperty());

        mainPartsTableView.setItems(sortedData);
    }
}
*/
