package state;

import model.coffee.Coffee;
import vendingmachine.VendingMachine;

public class PaidState implements VendingMachineState{
    @Override
    public void dispense(VendingMachine machine) {
        machine.dispenseCoffee();
    }

    @Override
    public void cancel(VendingMachine machine) {
        System.out.println("Cancelling the transaction. Refunding the money");
        machine.returnBalance();
    }

    @Override
    public void insertMoney(VendingMachine machine, Integer money) {
        System.out.println("We have enough money brother");
    }

    @Override
    public void selectCoffee(VendingMachine machine, Coffee coffee) {
        System.out.println("Coffee already selected.");
    }
}
