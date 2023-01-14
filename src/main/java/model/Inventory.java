package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.scene.control.Alert;
//import model.controller.MainFormController;

/**
 * Represents an inventory of parts and products.
 *
 * @author LeeAnne Atkins
 */
public class Inventory {

    /**
     * The part id counter is the next id for a new part. It is incremented each time a new part is added.
     */
    public static int partId = 113;
    /**
     * The product id counter is the next id for a new product. It is incremented each time a new product is added.
     */
    public static int productId = 1005;
    /**
     * Indicates if a part is found after a search.
     */
    public static boolean partFound;
    /**
     * Indicates if a product is found after a search.
     */
    public static boolean productFound;
    /**
     * An observable list of all parts.
     */
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    /**
     * An observable list of all products.
     */
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /**
     * Adds a new part to <code>allParts</code> observable list.
     *
     * @param newPart the new part
     */
    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    /**
     * Adds a new product to <code>allProducts</code> observable list.
     *
     * @param newProduct the new product
     */
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    /**
     * Looks up a part by part id in <code>allParts</code> observable list.
     *
     * @param partId the part id
     * @return the matching part
     */
    public static Part lookupPart (int partId) {
        //partFound = false;
        for (Part part : Inventory.getAllParts()) {
            if (part.getId() == partId) {
                //partFound = true;
                return part;
            }
        }
        return null;
    }

    /**
     * Looks up a product by product id in <code>allProducts</code> observable list.
     *
     * @param productId the product id
     * @return the matching product
     */
    public static Product lookupProduct (int productId) {
        productFound = false;
        for (Product product : Inventory.getAllProducts()) {
            if (product.getId() == productId) {
                productFound = true;
                return product;
            }
        }
        return null;
    }

    /**
     * Looks up a part by part name in <code>allParts</code> observable list.
     *
     * @param partName the part name
     * @return the observable list of matching part(s)
     */
    public static ObservableList<Part> lookupPart (String partName) {
        ObservableList<Part> namedParts = FXCollections.observableArrayList();
        //partFound = false;
        for (Part p : allParts) {
            if (p.getName().toLowerCase().contains(partName)) {
                namedParts.add(p);
            }
        }
        //if (!namedParts.isEmpty()) {
            //partFound = true;
            return namedParts;
        }
        //return allParts;
    //}

    /**
     * Looks up a product by product name in <code>allProducts</code> observable list.
     *
     * @param productName the product name
     * @return the observable list of matching products(s)
     */
    public static ObservableList<Product> lookupProduct (String productName) {
        ObservableList<Product> namedProducts = FXCollections.observableArrayList();
        //productFound = false;
        for (Product p : allProducts) {
            if (p.getName().toLowerCase().contains(productName)) {
                namedProducts.add(p);
            }
        }
        //if (!namedProducts.isEmpty()) {
            //productFound = true;
            return namedProducts;
        }
        //return allProducts;
    //}

    /**
     * Updates the selected part in <code>allParts</code> observable list.
     *
     * @param index the part index
     * @param selectedPart the selected part
     */
    public static void updatePart(int index, Part selectedPart) {
        //boolean partUpdated = true;
        allParts.set(index, selectedPart);
    }

    /**
     * Updates the selected product in <code>allProducts</code> observable list.
     *
     * @param index the product index
     * @param selectedProduct the selected product
     */
    public static void updateProduct(int index, Product selectedProduct) {
        //boolean productUpdated = true;
        allProducts.set(index, selectedProduct);
    }

    /**
     * Deletes the selected part from <code>allParts</code> observable list.
     *
     * @param selectedPart the selected part
     * @return the boolean
     */
    public static boolean deletePart(Part selectedPart) {
        allParts.remove(selectedPart);
        return false;
    }

    /**
     * Deletes the selected product from <code>allProducts</code> observable list.
     *
     * @param selectedProduct the selected product
     * @return the boolean
     */
    public static boolean deleteProduct(Product selectedProduct) {
        allProducts.remove(selectedProduct);
        return false;
    }

    /**
     * Gets all parts.
     *
     * @return the allParts
     */
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    /**
     * Gets all products.
     *
     * @return the allProducts
     */
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
}

