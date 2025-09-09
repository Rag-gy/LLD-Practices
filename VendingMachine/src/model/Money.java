package model;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Money {
    private AtomicInteger value;

    public void setValue(int moneyValue){
        this.value = new AtomicInteger(moneyValue);
    }

    public int getValue(){
        return value.intValue();
    }
}
