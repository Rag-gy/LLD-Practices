package model.coffee;

import java.util.Map;

public class Cappucino extends Coffee{
    public Cappucino() throws Exception {
        super(100, Map.of(Ingredients.COFFEE, 3, Ingredients.SUGAR, 2, Ingredients.MILK, 10));
    }
}
