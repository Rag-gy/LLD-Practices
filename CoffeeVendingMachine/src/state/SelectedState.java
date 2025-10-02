package state;

import model.coffee.Coffee;
import vendingmachine.VendingMachine;

public class SelectedState implements VendingMachineState{
    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Please pay up completely");
    }

    @Override
    public void cancel(VendingMachine machine) {
        new ReadyState().cancel(machine);
    }

    @Override
    public void insertMoney(VendingMachine machine, Integer money) {
        machine.addMoney(money);
    }


    @Override
    public void selectCoffee(VendingMachine machine, Coffee coffee) {
        System.out.println("Coffee already selected!!");
    }
}
