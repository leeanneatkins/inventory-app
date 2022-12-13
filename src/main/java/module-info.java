module project.inventoryapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens project.inventoryapp to javafx.fxml;
    exports project.inventoryapp;
    exports controller;
    opens controller to javafx.fxml;
}