package model;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Product {
    private int price;
    private String name;
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Product(int productQuantity, int productPrice, String productName){
        this.price = productPrice;
        this.name = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
