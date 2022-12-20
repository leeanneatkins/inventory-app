package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class depends on the Part class and Product class.
 * @author    LeeAnne Atkins
 */

public class Inventory{

    //-allParts:ObservableList<Part> DONE
    /** This method FILL IN HERE! */
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();

    /** This method FILL IN HERE! */
        private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /** This method adds a new Part to the ObservableList allParts. */
        public static void addPart(Part part)
        {
            allParts.add(part);
        }

    /** This method adds a new Product to the ObservableList allProducts. */
        public static void addProduct(Product product)
         {
             allProducts.add(product);
         }

         /** This method looks up a Part by partId. */
        //FIXME + lookupPart(partId:int):Part ERROR
        //public static Part lookupPart(int partId)
        //{
        //return Part();
        //}
    /** This method looks up a Product by productId. */
        //FIXME + lookupProduct(productId:int):Product ERROR
        //public static Product lookupProduct(int productId)
        //{
        //return Product;
        //}

    /** This method looks up a Part by partName. */
        //FIXME + lookupPart(partName:String):ObservableList<Part> ERROR
        //public static ObservableList<Part> lookupPart(String partName)
        //{
        //return Part;
        //}
    /** This method looks up a Product by productName. */
        //FIXME + lookupProduct(productName:String):ObservableList<Product> ERROR
        //public static ObservableList<Product> lookupProduct(String productName)
        // {
        //return Product;
        // }


    /** This method updates the selectedPart. */
    public static void updatePart(Part selectedPart, int index)
    {
        //FIXME write method here
    }

    //+ updateProduct(index:int, newProduct:Product):void
    /** This method updates the selectedProduct. */
    public static void updateProduct(Product selectedProduct, int index)
    {
        //FIXME write method here
    }

    /** This method deletes the selectedPart. */
    public static boolean deletePart(Part selectedPart)
    {
        //FIXME write method here
        return false;
    }

    /** This method deletes the selectedProduct. */
    public static boolean deleteProduct(Product selectedProduct)
    {
        //FIXME write method here
        return false;
    }

    /**
     * @return the allParts
     */
    public static ObservableList<Part> getAllParts()
    {
        return allParts;
    }

    /**
     * @return the allProducts
     */
    public static ObservableList<Product> getAllProducts()
    {
        return allProducts;
    }



}
