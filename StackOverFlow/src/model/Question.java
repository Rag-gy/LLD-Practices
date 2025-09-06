package model;

import exception.AlreadyApproved;

import java.util.ArrayList;
import java.util.List;

public class Question extends Post implements IsAnswerable, IsApprovable, IsCommentable, IsVotable{
    List<Comment> comments = new ArrayList<>();
    List<Answer> answers = new ArrayList<>();
    List<Tags> tags = new ArrayList<>();

    public Question(String content, User user){
        super(content, user);
        user.addQuestions(this);
    }


    @Override
    public synchronized void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    @Override
    public synchronized void approve() {
        try{
            super.approvePost();
            User userPostedQuestion = super.getUser();
            userPostedQuestion.addRanking();
            System.out.println("Question approved successfully");
        } catch (AlreadyApproved e) {
            System.out.println("Question already approved");
        }
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
    public synchronized void upVote() {
        super.upVote();
    }

    @Override
    public synchronized void downVote() {
        super.downVote();
    }

    public synchronized void addTag(String tagName, User user){
        Tags tag = new Tags(tagName, user);
        tags.add(tag);
    }
}
