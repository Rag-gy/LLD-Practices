package model;

public class Beverage extends Product{

    public Beverage(int productQuantity, int productPrice, String productName) {
        super(productQuantity, productPrice, productName + " Beverage");
    }
}
