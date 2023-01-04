package project.inventoryapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.Outsourced;
import model.Product;


/**
 * This class creates an app that allows users to search, add, modify, and delete items in an inventory.
 * <p> Add a detailed description of a logical or runtime error that you corrected in the code and a detailed description of how you corrected it above the line of code you are referring to. (place it in the header where the error occurred). </p>
 * <p> Add a compatible feature to extend functionality HERE. </p>
 * @author    LeeAnne Atkins
 */

public class MainApplication extends Application {

    /** This method sets the stage and displays the scene MainForm.fxml upon start. */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/view/MainForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 388);
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }
    /** This is the main method. This is the first method that is called when the program is run. */
    public static void main(String[] args) {

        InHouse inhouse1 = new InHouse (101, "walnut table top", 599.99, 2, 1, 6, 122);
        InHouse inhouse2 = new InHouse (102, "faux concrete table top", 100.00, 8, 4, 20, 776);
        InHouse inhouse3 = new InHouse (103, "round white farmhouse table top" , 30.50, 2, 1, 6, 456);
        InHouse inhouse4 = new InHouse (104, "faux marble table top", 299.99, 2, 1, 6, 234);
        InHouse inhouse5 = new InHouse (105,"mid-century modern walnut chair", 249.99, 12, 6, 24, 227);
        InHouse inhouse6 = new InHouse (106,"mid-century modern black chair", 199.99, 12, 6, 24, 228);


        Outsourced outsourced1 = new Outsourced(107, "black hairpin leg", 0.99, 2, 1, 6, "SJA");
        Outsourced outsourced2 = new Outsourced(108, "walnut square leg", 12.99, 2, 1, 6, "Legs 'R Us");
        Outsourced outsourced3 = new Outsourced(109, "white spindle leg", 0.99, 2, 1, 6, "Legs 'R Us");
        Outsourced outsourced4 = new Outsourced(110, "leg bracket (4)", 9.99, 2, 1, 6, "Modern Inc");

        Product product1 = new Product(1001, "mid-century modern table set", 1999.99, 2, 1, 4);
        Product product2 = new Product(1002, "white farmhouse table set", 2999.99, 2, 1, 4);
        Product product3 = new Product(1003, "faux concrete table set", 3999.99, 2, 1, 4);
        Product product4 = new Product(1004, "faux marble table set", 4999.99, 2, 1, 4);

        Inventory.addPart(inhouse1);
        Inventory.addPart(inhouse2);
        Inventory.addPart(inhouse3);
        Inventory.addPart(inhouse4);
        Inventory.addPart(inhouse5);
        Inventory.addPart(inhouse6);
        Inventory.addPart(outsourced1);
        Inventory.addPart(outsourced2);
        Inventory.addPart(outsourced3);
        Inventory.addPart(outsourced4);
        Inventory.addProduct(product1);
        Inventory.addProduct(product2);
        Inventory.addProduct(product3);
        Inventory.addProduct(product4);

        launch();
    }
}