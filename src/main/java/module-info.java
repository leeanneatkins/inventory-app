module project.inventoryapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens project.inventoryapp to javafx.fxml;
    exports project.inventoryapp;
    exports model;
    opens model to javafx.fxml;
    exports model.controller;
    opens model.controller to javafx.fxml;
}