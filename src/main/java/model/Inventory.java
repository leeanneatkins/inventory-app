package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory{

    //-allParts:ObservableList<Part> DONE
        private static ObservableList<Part> allParts = FXCollections.observableArrayList();

    //- allProducts:ObservableList<Product> DONE
        private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    //+ addPart(newPart:Part):void DONE
        public static void addPart(Part part)
        {
            allParts.add(part);
        }

    //+ addProduct(newProduct:Product):void DONE
        public static void addProduct(Product product)
         {
             allProducts.add(product);
         }

    //+ getAllParts():ObservableList<Part> DONE
        public static ObservableList<Part> getAllParts()
        {
            return allParts;
        }
    //+ getAllProducts():ObservableList<Product> DONE
        public static ObservableList<Product> getAllProducts()
    {
        return allProducts;
    }

    //+ updatePart(index:int, selectedPart:Part):void
    public static void updatePart(Part selectedPart, int index)
    {
        //FIXME write method here
    }

    //+ updateProduct(index:int, newProduct:Product):void
    public static void updateProduct(Product selectedProduct, int index)
    {
        //FIXME write method here
    }


    //+ deletePart(selectedPart:Part):boolean
    public static boolean deletePart(Part selectedPart)
    {
        //FIXME write method here
        return false;
    }


    //+ deleteProduct(selectedProduct:Product):boolean
    public static boolean deleteProduct(Product selectedProduct)
    {
        //FIXME write method here
        return false;
    }

    //FIXME + lookupPart(partId:int):Part ERROR
    //public static Part lookupPart(int partId)
    //{
    //return Part();
    //}

    //FIXME + lookupProduct(productId:int):Product ERROR
    //public static Product lookupProduct(int productId)
    //{
    //return Product;
    //}


    //FIXME + lookupPart(partName:String):ObservableList<Part> ERROR
    //public static ObservableList<Part> lookupPart(String partName)
    //{
    //return Part;
    //}

    //FIXME + lookupProduct(productName:String):ObservableList<Product> ERROR
    //public static ObservableList<Product> lookupProduct(String productName)
    // {
    //return Product;
    // }


}
