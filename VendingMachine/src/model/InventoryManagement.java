package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface InventoryManagement {
    List<Product> products = new ArrayList<>();
    Map<Integer, Product> productMap = new HashMap<>();
    Map<Product, Integer> productQuantityMap = new HashMap<>();


    public void addProduct(Product productToAdd, int quantity);

    public void dispenseProduct(Integer productCode, int quantity);

    public void restockProduct(Product productToRestock, int quantity);

    public boolean checkProductAvailability(Product productToCheck, int quantity);

    public boolean checkProductExists(Product productToCheck);

    public boolean checkProductCodeExists(Integer productCode);

    public default List<Product> getProductsList(){
        return products;
    }

    public default Map<Integer, Product> getProductsMap(){
        return productMap;
    }

    public default Map<Product, Integer> getProductsQuantityMap(){
        return productQuantityMap;
    }

}
