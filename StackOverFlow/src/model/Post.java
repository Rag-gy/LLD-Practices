package model;

import exception.AlreadyApproved;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Post {
    private String content;
    private  String postId;
    private User user;
    private Vote vote;
    private Boolean approved = false;
    private LocalDateTime timePosted;

    public Post(String postContent, User userPosted){
        this.content = postContent;
        this.user = userPosted;
        this.timePosted = LocalDateTime.now();
        this.postId = UUID.randomUUID().toString();
    }

    public void approvePost(){
        if(this.approved){
            throw new AlreadyApproved("Already approved");
        }
        this.approved = true;
    }

    public synchronized void upVote(){
        this.vote.upVote();
    }

    public synchronized void downVote(){
        this.vote.downVote();
    }

    public User getUser(){
        return user;
    }

}
