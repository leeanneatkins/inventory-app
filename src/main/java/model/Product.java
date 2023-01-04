package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class creates Product objects. This class depends on the Part class.
 * @author    LeeAnne Atkins
 */

public class Product {

    private static ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    public int id;
    private static int productIdCounter = 1000;
    public String name;
    public double price;
    public int stock;
    public int  min;
    public int max;

    public Product(int id, String name, double price, int stock, int min, int max) {
        this.id = productIdCounter++;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }
    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }
    /**
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }
    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }
    /**
     * @param max the id to max
     */
    public void setMax(int max) {
        this.max = max;
    }

    /** This method adds a new associatedPart to a Product. */
    //public static void addAssociatedPart(Part part)
    //{
        //associatedParts.add(part);
    //}

    /** This method deletes the selected associatedPart from a Product. */
    //public static boolean deleteAssociatedPart(selectedAssociatedPart:Part)
   //{
        //associatedParts.remove(part);
   //}

    /**
     * @return the associatedParts
     */
    public static ObservableList<Part> getAllAssociatedParts() {
        return associatedParts;
    }

}
