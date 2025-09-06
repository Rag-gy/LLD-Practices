package model;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Vote {

    private AtomicInteger vote = new AtomicInteger(0);

    public void upVote(){
        this.vote.addAndGet(1);
    }

    public void downVote(){
        this.vote.addAndGet(-1);
    }

    public int getVote(){
        return vote.get();
    }
}
