package project.inventoryapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.Outsourced;


/**
 * This class creates an app that allows users to search, add, modify, and delete items in an inventory.
 * <p> Add a detailed description of a logical or runtime error that you corrected in the code and a detailed description of how you corrected it above the line of code you are referring to. (place it in the header where the error occurred). </p>
 * <p> Add a compatible feature to extend functionality HERE. </p>
 * @author    LeeAnne Atkins
 */

public class Main extends Application {

    /** This method sets the stage and displays the scene MainForm.fxml upon start. */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 388);
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }
    /** This is the main method. This is the first method that is called when the program is run. */
    public static void main(String[] args) {

        InHouse inhouse1 = new InHouse (1, "drop leaf table top", 399.99, 2, 1, 6, 122);
        InHouse inhouse2 = new InHouse (2, "leg", 100.00, 8, 4, 20, 776);
        InHouse inhouse3 = new InHouse (3, "glass protector" , 30.50, 2, 1, 6, 456);
        InHouse inhouse4 = new InHouse (4, "faux marble table top", 299.99, 2, 1, 6, 234);

        Outsourced outsourced1 = new Outsourced(5, "bracket", 0.99, 2, 1, 6, "Ikea");
        Outsourced outsourced2 = new Outsourced(6, "polish", 12.99, 2, 1, 6, "Ikea");
        Outsourced outsourced3 = new Outsourced(7, "screws", 0.99, 2, 1, 6, "Ikea");
        Outsourced outsourced4 = new Outsourced(8, "feet", 9.99, 2, 1, 6, "Ikea");

        Inventory.addPart(inhouse1);
        Inventory.addPart(inhouse2);
        Inventory.addPart(inhouse3);
        Inventory.addPart(inhouse4);
        Inventory.addPart(outsourced1);
        Inventory.addPart(outsourced2);
        Inventory.addPart(outsourced3);
        Inventory.addPart(outsourced4);


        launch();
    }
}