import model.*;

import java.util.ArrayList;
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
        Product productToDispense = productCodeMap.get(productCode);
        if(!checkCreditAvailabilityForDeduction(productToDispense.getPrice()*quantity)){
            System.out.println("Not enough credits to dispense product. Please add more credits");
            return;
        }
        productQuantityMap.put(productToDispense, productQuantityMap.get(productToDispense)-quantity);
        System.out.println("Product Dispensed Successfully. Please collect it");
        deductCredits(productToDispense.getPrice()*quantity);
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

    @Override
    public boolean checkBalanceToGive(int moneyToReturn) {
        AtomicInteger remaining = new AtomicInteger(moneyToReturn);
        moneyQuantity.forEach((money, quantity) ->  {
            while(quantity > 0 && remaining.get() > money.getValue()){
                quantity -= 1;
                remaining.addAndGet(-money.getValue());
            }
        });
        return remaining.get() == 0;
    }

    @Override
    public synchronized List<Money> getBalance(int moneyToReturn) {
        List<Money> balance = new ArrayList<>();
        if(!checkBalanceToGive(moneyToReturn)){
            System.out.println("Machine doesn't have enough balance. Please buy some more products");
            return balance;
        }
        AtomicInteger remaining = new AtomicInteger(moneyToReturn);
        moneyQuantity.forEach((money, quantity) ->  {
            int count = 0;
            while(quantity > 0 && remaining.get() > money.getValue()){
                quantity--;
                remaining.addAndGet(-money.getValue());
                count++;
            }
            moneyQuantity.put(money, quantity);
            while(count > 0){
                balance.add(money);
                count--;
            }
        });
        return balance;
    }

    @Override
    public synchronized void addCredits(List<Money> moneyList) {
        for(Money money : moneyList){
            credits.addAndGet(money.getValue());
            if(!moneyQuantity.containsKey(money)){
                moneyQuantity.put(money, 0);
            }
            moneyQuantity.put(money, moneyQuantity.get(money)+1);
            System.out.println("Credits added successfully");
        }
    }

    @Override
    public synchronized void deductCredits(int money) {
        if(!checkCreditAvailabilityForDeduction(money)){
            System.out.println("Not enough credits");
            return;
        }
        credits.addAndGet(-money);
    }

    @Override
    public boolean checkCreditAvailabilityForDeduction(int money){
        return credits.get() >= money;
    }
}
