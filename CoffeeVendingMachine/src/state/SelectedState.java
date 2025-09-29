package state;

import model.coffee.Coffee;
import vendingmachine.VendingMachine;

public class SelectedState implements VendingMachineState{
    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Please pay up");
    }

    @Override
    public void cancel(VendingMachine machine) {
        new PaidState().cancel(machine);
    }

    @Override
    public void insertMoney(VendingMachine machine, int money) {
        machine.topup(money);
    }

    @Override
    public void selectCoffee(VendingMachine machine, Coffee coffee) {

    }
}
