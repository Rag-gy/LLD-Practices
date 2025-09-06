package model;

import exception.AlreadyApproved;

import java.util.ArrayList;
import java.util.List;

public class Answer extends Post implements IsCommentable, IsApprovable, IsVotable {

    List<Comment> comments = new ArrayList<>();

    public Answer(String postContent, User userPosted) {
        super(postContent, userPosted);
        userPosted.addAnswers(this);
    }

    @Override
    public synchronized void addComment(String commentContent, User user) {
        Comment comment = new Comment(commentContent, user);
        this.comments.add(comment);
    }

    @Override
    public List<Comment> getComment() {
        return comments;
    }

    @Override
    public synchronized void approve() {
        try{
            super.approvePost();
            System.out.println("Answer approved successfully");
        } catch (AlreadyApproved e) {
            System.out.println("Answer already approved");
        }
    }

    @Override
    public synchronized void upVote() {
        super.upVote();
    }

    @Override
    public synchronized void downVote() {
        super.downVote();
    }
}
