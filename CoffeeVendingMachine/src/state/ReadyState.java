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
        System.out.println("Returning the balance if any....");
        machine.returnBalance();
    }

    @Override
    public void insertMoney(VendingMachine machine, Integer money) {
        System.out.println("Select coffee first");
    }


    @Override
    public void selectCoffee(VendingMachine machine, Coffee coffee) {
        machine.selectCoffee(coffee);
    }
}
