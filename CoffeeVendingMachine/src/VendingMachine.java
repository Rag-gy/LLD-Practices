package vendingmachine;

import model.coffee.Coffee;
import model.coffee.Ingredients;
import state.*;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private int balance = 0;
    private Coffee selectedCoffee = null;
    private VendingMachineState currentState = new ReadyState();
    private Map<Ingredients, Integer> ingredients = new HashMap<Ingredients, Integer>();

    public void selectCoffee(Coffee coffee){
        if(!(this.currentState instanceof ReadyState)){
            System.out.println("Coffee Already Selected or ");
        }
        this.selectedCoffee = coffee;
    }

    public void addMoney(Integer money){
        if(!(this.currentState instanceof SelectedState)){
            System.out.println("Coffee not selected. Please select your coffee");
        }
        else if(money<0){
            System.out.println("Money cannot be negative!!");
        }
        else {
            this.balance+=money;
            if(this.selectedCoffee.getPrice() <= this.balance){
                this.currentState = new PaidState();
            }
        }
    }

    public void dispenseCoffee(){
        if(!(this.currentState instanceof PaidState) || this.selectedCoffee == null){
            System.out.println("No coffee selected for dispense");
            return;
        }
        Map<Ingredients, Integer> ingredientsToMakeCoffee = this.selectedCoffee.getIngredients();
        ingredientsToMakeCoffee.forEach((ingredient, count) -> {
            if(!this.ingredients.containsKey(ingredient) || this.ingredients.get(ingredient) < count){
                System.out.println("Insufficient ingredient");
                this.currentState = new OutOfIngredientState();
                return;
            }
        });
        ingredientsToMakeCoffee.forEach((ingredient, count) -> {
            this.ingredients.put(ingredient, this.ingredients.get(ingredient)-count);
        });
        this.currentState = new ReadyState();
    }

    public void returnBalance(){
        if(this.selectedCoffee != null){
            System.out.println("A coffee is currently selected. Either pay up or cancel the current transaction");
            return;
        }
        System.out.println("Returning the balance..." + this.balance);
        this.balance = 0;
    }

    public void refillIngredients(Ingredients ingredient, int quantity){
        if(quantity <= 0){
            System.out.println("Add Valid Quantity Count");
            return;
        }
        int ingredientCount = this.ingredients.getOrDefault(ingredient, 0);
        this.ingredients.put(ingredient, ingredientCount+quantity);
        System.out.println("Refilled ingredients successfully");
    }

}
