package model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public interface CurrencyManagement {
    Map<Money, Integer> moneyQuantity = new HashMap<>();
    AtomicInteger credits = new AtomicInteger(0);

    public boolean checkBalanceToGive(int money);
    public int getBalance();
    public void addCredits(int money);
    public void deductCredits(int money);
}
