package project.inventoryapp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
import model.controller.AddProductController;


/**
 * This app allows users to search, add, modify, and delete items in an inventory.
 *
 * <p> FUTURE ENHANCEMENT: Add functionality to ensure a part cannot not deleted if the part is associated with a product. Add functionality to ensure price of a product is higher than the sum of the prices of all its associated parts. </p>
 *
 * @author LeeAnne Atkins
 */
public class MainApplication extends Application {

    /** Sets the stage and displays the scene <code>MainForm.fxml</code> upon start. */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/view/MainForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 440);
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Adds sample parts and products to the inventory.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        InHouse inhouse1 = new InHouse (101, "light walnut table top", 699.99, 4, 1, 6, 122);
        InHouse inhouse2 = new InHouse (102, "dark walnut table top", 799.99, 3, 1, 6, 776);
        InHouse inhouse3 = new InHouse (103, "oak extendable table top" , 849.99, 2, 1, 6, 456);
        InHouse inhouse4 = new InHouse (104, "faux marble table top", 399.99, 2, 2, 6, 234);
        InHouse inhouse5 = new InHouse (105,"mid-century mod walnut chair - 2 pk", 249.99, 6, 6, 12, 227);
        InHouse inhouse6 = new InHouse (106,"mod spindle black chair - 2 pk", 399.99, 12, 6, 12, 228);
        InHouse inhouse7 = new InHouse (107,"gold upholstered chair - 2 pk", 199.99, 12, 6, 12, 228);

        Outsourced outsourced1 = new Outsourced(108, "black hairpin table leg - 4 pk", 41.99, 2, 1, 6, "SJA Co");
        Outsourced outsourced2 = new Outsourced(109, "light walnut table leg - 4 pk", 59.99, 2, 1, 6, "Legs 'R Us");
        Outsourced outsourced3 = new Outsourced(110, "dark walnut table leg - 4 pk", 59.99, 2, 1, 6, "Legs 'R Us");
        Outsourced outsourced4 = new Outsourced(111, "gold pedestal table base", 64.99 , 2, 1, 6, "Legs 'R Us");
        Outsourced outsourced5 = new Outsourced(112, "hd table leg hardware - 4 pk", 9.99, 15, 10, 40, "BlackCat Inc");

       Product product1 = new Product(1001, "Mid-century mod dining table", 1749.99, 2, 1, 4);
       Product product2 = new Product(1002, "Madera extendable dining table", 1799.99, 2, 1, 4);
       Product product3 = new Product(1003, "Erno dining table", 1549.99, 2, 1, 4);
       Product product4 = new Product(1004, "Susan faux marble dining set", 1349.99, 2, 1, 4);

        Inventory.addPart(inhouse1);
        Inventory.addPart(inhouse2);
        Inventory.addPart(inhouse3);
        Inventory.addPart(inhouse4);
        Inventory.addPart(inhouse5);
        Inventory.addPart(inhouse6);
        Inventory.addPart(inhouse7);

        Inventory.addPart(outsourced1);
        Inventory.addPart(outsourced2);
        Inventory.addPart(outsourced3);
        Inventory.addPart(outsourced4);
        Inventory.addPart(outsourced5);

        Inventory.addProduct(product1);
        product1.addAssociatedPart(inhouse2);
        product1.addAssociatedPart(outsourced3);
        product1.addAssociatedPart(outsourced5);

        Inventory.addProduct(product2);
        product2.addAssociatedPart(inhouse3);
        product2.addAssociatedPart(outsourced1);
        product2.addAssociatedPart(outsourced5);

        Inventory.addProduct(product3);
        product3.addAssociatedPart(inhouse1);
        product3.addAssociatedPart(outsourced2);
        product3.addAssociatedPart(outsourced5);

        Inventory.addProduct(product4);
        product4.addAssociatedPart(inhouse4);
        product4.addAssociatedPart(outsourced4);
        product4.addAssociatedPart(inhouse7);


        launch();
    }
}