package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddPart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionAddProduct(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionDeletePart(ActionEvent event) {
        System.out.println("Delete part button clicked");
    }

    @FXML
    void onActionDeleteProduct(ActionEvent event) {
        System.out.println("Delete product button clicked");
    }

    @FXML
    void onActionExitProgram(ActionEvent event) {
            System.exit(0);
    }

    @FXML
    void onActionModifyPart(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/ModifyPart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionModifyProduct(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/ModifyProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mainPartsTableView.setItems(Inventory.getAllParts());
        mainProductsTableView.setItems(Inventory.getAllProducts());
    }
}