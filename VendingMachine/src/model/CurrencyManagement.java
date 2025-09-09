package model;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public interface CurrencyManagement {
    Map<Money, Integer> moneyQuantity = new TreeMap<>(Comparator.comparingInt(Money::getValue).reversed());
    AtomicInteger credits = new AtomicInteger(0);

    public boolean checkBalanceToGive(int money);
    public List<Money> getBalance(int money);
    public void addCredits(List<Money> money);
    public void deductCredits(int money);
    public boolean checkCreditAvailabilityForDeduction(int money);


}
