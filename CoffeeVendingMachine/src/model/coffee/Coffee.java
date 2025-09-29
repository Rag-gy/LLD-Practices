package model.coffee;

public abstract class Coffee {
    public int sugarCubeCount;
    public int coffeePercentage;
    public int milkPercentage;
    public int price;

    public Coffee(Integer sugarCubeCount, Integer coffeePercentage, Integer milkPercentage, Integer price) throws Exception {
        if(sugarCubeCount < 0 || price < 0 || coffeePercentage < 0 || coffeePercentage > 100 || milkPercentage < 0 || milkPercentage > 100 || milkPercentage + coffeePercentage != 100){
            throw new Exception("Invalid proportion of sugar, milk, coffee or price ");
        }
        this.coffeePercentage = coffeePercentage;
        this.sugarCubeCount = sugarCubeCount;
        this.milkPercentage = milkPercentage;
        this.price = price;
    }
}
