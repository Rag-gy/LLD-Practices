package model.coffee;

import java.util.Map;

public abstract class Coffee {

    public Map<Ingredients, Integer> ingredients;
    public int price;

    public Coffee(Integer price, Map<Ingredients, Integer> coffeeIngredients) throws Exception {
        if(price < 0 || coffeeIngredients.isEmpty()){
            throw new Exception("Invalid ingredients or price ");
        }
        this.ingredients = coffeeIngredients;
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }

    public Map<Ingredients, Integer> getIngredients(){
        return this.ingredients;
    }
}
