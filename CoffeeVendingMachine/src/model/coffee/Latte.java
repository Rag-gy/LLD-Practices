package model.coffee;

import java.util.Map;

public class Latte extends Coffee{

    public Latte() throws Exception {
        super(140, Map.of(Ingredients.COFFEE, 3, Ingredients.SUGAR, 3, Ingredients.MILK, 15));
    }
}
