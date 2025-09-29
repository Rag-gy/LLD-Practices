package state;

import model.coffee.Coffee;
import vendingmachine.VendingMachine;

public class PaidState implements VendingMachineState{
    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Dispensing coffee..");
        machine.dispense();
    }

    @Override
    public void cancel(VendingMachine machine) {
        System.out.println("Cancelling the transaction. Refunding the money");
        machine.returnMoney();
    }

    @Override
    public void insertMoney(VendingMachine machine, Integer money) {

    }

    @Override
    public void selectCoffee(VendingMachine machine, Coffee coffee) {
        System.out.println("Coffee already selected.");
    }
}
