package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product {

    private static ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    public int id;

    public String name;

    public double price;
    public int stock;
    public int  min;
    public int max;

    public Product(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public static void addAssociatedPart(Part part)
    {
        associatedParts.add(part);
    }

    //public static boolean deleteAssociatedPart(selectedAssociatedPart:Part)
   // {
        //associatedParts.remove(part);
   // }

    public static ObservableList<Part> getAllAssociatedParts()
    {
        return associatedParts;
    }

    //Required methods
    //- associatedParts:ObservableList<Part> DONE
    //+ addAssociatedPart(part:Part):void DONE
    //+ deleteAssociatedPart(selectedAssociatedPart:Part):boolean  PROBLEMS WITH THIS ONE
    //+ getAllAssociatedParts():ObservableList<Part> DONE

}
