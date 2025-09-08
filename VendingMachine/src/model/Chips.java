package model;

public class Chips extends Product{
    public Chips(int price, int quantity, String name){
        super(quantity, price, name + " Chips");
    }
}
