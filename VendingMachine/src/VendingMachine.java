import model.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class VendingMachine implements InventoryManagement, CurrencyManagement {

    AtomicInteger productCode = new AtomicInteger(1);


    Chips lays = new Chips(5, 10, "Lays");

    @Override
    public synchronized void addProduct(Product productToAdd, int quantity) {
        if(quantity <= 0){
            System.out.println("Provide valid quantity");
            return;
        }

        if(checkProductExists(productToAdd)){
            System.out.println("Product already existing, increasing product count");
            restockProduct(productToAdd, quantity);
        }
        else{
            List<Product> products = getProductsList();
            Map<Product, Integer> productQuantityMap = getProductsQuantityMap();
            Map<Integer, Product> productsMap = getProductsMap();

            productToAdd.setCode(productCode.getAndAdd(1));

            products.add(productToAdd);
            productsMap.put(productToAdd.getCode(), productToAdd);
            productQuantityMap.put(productToAdd, quantity);

            System.out.println("Product added successfully");
        }
    }

    @Override
    public synchronized void dispenseProduct(Integer productCode, int quantity) {
        Map<Integer, Product> productCodeMap = getProductsMap();
        Map<Product, Integer> productQuantityMap = getProductsQuantityMap();
        if(!checkProductCodeExists(productCode) || !checkProductAvailability(productCodeMap.get(productCode), quantity)){
            System.out.println("Product is not available for the quantity you requested");
            return;
        }

        // TODO: check credits availability and balance availability will be executed later as part of currencyManagement

        Product productToDispense = productCodeMap.get(productCode);
        productQuantityMap.put(productToDispense, productQuantityMap.get(productToDispense)-quantity);
        System.out.println("Product Dispensed Successfully. Please collect it");

        // TODO: update current credit and close current transaction if credit is zero
    }

    @Override
    public synchronized void restockProduct(Product productToRestock, int quantity) {
        if(quantity <= 0){
            System.out.println("Provide valid quantity");
            return;
        }
        if(checkProductExists(productToRestock)){
            Map<Product, Integer> productQuantityMap = getProductsQuantityMap();
            productQuantityMap.put(productToRestock, productQuantityMap.get(productToRestock) + quantity);
            System.out.println("Product Restocked Successfully");
            return;
        }
        System.out.println("Product does not exist. Adding new product");
        addProduct(productToRestock, quantity);
    }

    @Override
    public boolean checkProductCodeExists(Integer productCode){
        Map<Integer, Product> productCodeMap = getProductsMap();
        return productCodeMap.containsKey(productCode);
    }

    @Override
    public boolean checkProductExists(Product productToCheck) {
        Map<Product, Integer> productQuantityMap = getProductsQuantityMap();
        return productQuantityMap.containsKey(productToCheck);
    }

    @Override
    public boolean checkProductAvailability(Product productToCheck, int quantity) {
        Map<Product, Integer> productQuantityMap = getProductsQuantityMap();
        return productQuantityMap.containsKey(productToCheck) && productQuantityMap.get(productToCheck) >= quantity;
    }

    //  TODO: IMPLEMENT THESE FUNCTIONS ACCORDINGLY

    @Override
    public boolean checkBalanceToGive(int moneyToReturn) {
        return false;
    }

    @Override
    public int getBalance() {
        return 0;
    }

    @Override
    public void addCredits(int money) {

    }

    @Override
    public void deductCredits(int money) {

    }
}
