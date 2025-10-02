package model.coffee;

import java.util.Map;

public class Americano extends Coffee{

    public Americano() throws Exception {
        super(120, Map.of(Ingredients.COFFEE, 7, Ingredients.SUGAR, 0));
    }
}
