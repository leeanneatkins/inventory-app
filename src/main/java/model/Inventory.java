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
    public static ObservableList<Part> allParts = FXCollections.observableArrayList();

    /** This method FILL IN HERE! */
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /** This method adds a new Part to the ObservableList allParts. */
    public static void addPart(Part part) {
            allParts.add(part);
        }

    /** This method adds a new Product to the ObservableList allProducts. */
        public static void addProduct(Product product) {
             allProducts.add(product);
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
    //FIXME + lookupPart(partName:String):ObservableList<Part> ERROR

    //Kinkaid video
    /*public static ObservableList<Part> lookupPart(String partName) {
        return null;
    }
    */
    /*public void getResultsHandler(ActionEvent actionEvent) {
        String p = MainFormController.mainPartsSearchTxt.getText();

        ObservableList<Part> parts = lookupPart(p);

        MainFormController.mainPartsTableView.setItems(parts);

        MainFormController.mainPartsSearchTxt.setText("");
    }


    public static ObservableList<Part> lookupPart(String partName){
            ObservableList<Part> namedParts = FXCollections.observableArrayList();

            ObservableList<Part> allParts = getAllParts();

            for(Part p : allParts){
                if(p.getName().contains(partName)){
                    namedParts.add(p);
                }
            }

            return namedParts;

        }
*/

    /** This method looks up a Product by productName. */
        //FIXME + lookupProduct(productName:String):ObservableList<Product> ERROR
        //public static ObservableList<Product> lookupProduct(String productName)
        // {
        //return Product;
        // }


    /** This method updates the selectedPart. */
    public static void updatePart(int index, Part selectedPart) {
            boolean partUpdated = true;
            allParts.set(index, selectedPart);
        }


    /** This method updates the selectedProduct. */
    public static void updateProduct(int index, Product selectedProduct) {
        //FIXME write method here
    }

    /** This method deletes the selectedPart. */
    public static boolean deletePart(Part selectedPart) {
        //FIXME write method here
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
