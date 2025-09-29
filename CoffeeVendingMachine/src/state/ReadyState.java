package state;

import model.coffee.Coffee;
import vendingmachine.VendingMachine;

public class ReadyState implements VendingMachineState{

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Select coffee first");
    }

    @Override
    public void cancel(VendingMachine machine) {
        System.out.println("No coffee selected. Nothing to cancel");
    }

    @Override
    public void insertMoney(VendingMachine machine, int money) {
        System.out.println("Select coffee first");
    }

    @Override
    public void selectCoffee(VendingMachine machine, Coffee coffee) {
        machine.selectCoffee(coffee);
    }
}
