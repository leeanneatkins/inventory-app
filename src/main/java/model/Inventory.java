package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import model.controller.MainFormController;

/**
 * This class depends on the Part class and Product class.
 * @author    LeeAnne Atkins
 */

public class Inventory {

    /** This method FILL IN HERE! */
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();

    /** This method FILL IN HERE! */
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /** This method adds a new Part to the ObservableList allParts. */
    public static void addPart(Part newPart) {
            allParts.add(newPart);
        }

    /** This method adds a new Product to the ObservableList allProducts. */
    public static void addProduct(Product newProduct) {
             allProducts.add(newProduct);
         }

    /**This method looks up a Part by partId. */
    public static Part lookupPart (int partId) {
        for (Part part : Inventory.getAllParts()) {
            if(part.getId() == partId) {
                return part;
            }
        }
        return null;
    }

    /** This method looks up a Product by productId. */
    public static Product lookupProduct (int productId)
    {
        for (Product product : Inventory.getAllProducts()) {
            if(product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    /**
     * This method looks up a Part by partName.
     */
    public static ObservableList<Part> lookupPart (String partName) {

        ObservableList<Part> namedParts = FXCollections.observableArrayList();

        ObservableList<Part> allParts = Inventory.getAllParts();

        for (Part p : allParts) {
            if (p.getName().contains(partName)) {
                namedParts.add(p);
            }
        }
        return namedParts;
    }

    /** This method looks up a Product by productName. */
    public static ObservableList<Product> lookupProduct (String productName) {
    ObservableList<Product> namedProducts = FXCollections.observableArrayList();

    ObservableList<Product> allProducts = Inventory.getAllProducts();

        for (Product p : allProducts) {
        if (p.getName().contains(productName)) {
            namedProducts.add(p);
            }
        }
        return namedProducts;
    }


    /** This method updates the selectedPart. */
    public static void updatePart(int index, Part selectedPart) {
            boolean partUpdated = true;
            allParts.set(index, selectedPart);
        }


    /** This method updates the selectedProduct. */
    public static void updateProduct(int index, Product selectedProduct) {
        boolean productUpdated = true;
        allProducts.set(index, selectedProduct);
    }

    /** This method deletes the selectedPart. */
    public static boolean deletePart(Part selectedPart) {
        allParts.remove(selectedPart);
       return false;
    }

    /** This method deletes the selectedProduct. */
    public static boolean deleteProduct(Product selectedProduct) {
        //FIXME write method here
        return false;
    }

    /**
     * @return the allParts
     */
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    /**
     * @return the allProducts
     */
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }

}

