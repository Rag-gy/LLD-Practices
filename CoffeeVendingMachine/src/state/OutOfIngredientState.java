package state;

import model.coffee.Coffee;
import vendingmachine.VendingMachine;

public class OutOfIngredientState implements VendingMachineState{
    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Machine out of ingredients");
    }

    @Override
    public void cancel(VendingMachine machine) {
        new ReadyState().cancel(machine);
    }

    @Override
    public void insertMoney(VendingMachine machine, Integer money) {
        System.out.println("Machine out of ingredients, Returning money");
    }

    @Override
    public void selectCoffee(VendingMachine machine, Coffee coffee) {
        machine.selectCoffee(coffee);
    }
}
