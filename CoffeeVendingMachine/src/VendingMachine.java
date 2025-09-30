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
//  Initially the machine will be in Ready State
    private Map<Ingredients, Integer> ingredients = new HashMap<Ingredients, Integer>();

    public void selectCoffee(Coffee coffee){
        if(!(currentState instanceof ReadyState)){
            System.out.println("Coffee Already Selected or ");
        }
        selectedCoffee = coffee;
    }

    public void addMoney(Integer money){
        if(!(currentState instanceof SelectedState)){
            System.out.println("Coffee not selected. Please select your coffee");
        }
        else if(money<0){
            System.out.println("Money cannot be negative!!");
        }
        else {
            this.balance+=money;
            if(selectedCoffee.getPrice() <= this.balance){
                currentState = new PaidState();
            }
        }
    }

    public void dispenseCoffee(){
        if(!(currentState instanceof PaidState)){
            System.out.println("No coffee selected for dispense");
            return;
        }
        // Check ingredients availability and Dispense coffee and reduce the ingredients
    }

    public void returnBalance(){
        // Check and return the balances accordingly
    }

    public void refillIngredients(Ingredients ingredient, int quantity){
        if(quantity <= 0){
            System.out.println("Add Valid Quantity Count");
            return;
        }
        int ingredientCount = ingredients.getOrDefault(ingredient, 0);
        ingredients.put(ingredient, ingredientCount+quantity);
        System.out.println("Refilled ingredients successfully");
    }

}
