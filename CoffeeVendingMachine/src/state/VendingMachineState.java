package state;

import model.coffee.Coffee;

public interface VendingMachineState {
    public void dispense(vendingmachine.VendingMachine machine);
    public void cancel(vendingmachine.VendingMachine machine);
    public void insertMoney(vendingmachine.VendingMachine machine, Integer money);
    public void selectCoffee(vendingmachine.VendingMachine machine, Coffee coffee);
}
