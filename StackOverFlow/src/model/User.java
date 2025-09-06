package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    String userId;
    Integer ranking;
    String emailAddress;
    List<Question> questions = new ArrayList<>();
    List<Answer> answers = new ArrayList<>();
    List<Comment> comments = new ArrayList<>();

    public void addRanking(){
        this.ranking += 1;
    }

    public User(String emailAddress){
        this.ranking = 0;
        this.emailAddress = emailAddress;
        this.userId = UUID.randomUUID().toString();
    }

    public void addComments(Comment comment){
        this.comments.add(comment);
    }

    public void addQuestions(Question question){
        this.questions.add(question);
    }

    public void addAnswers(Answer answer){
        this.answers.add(answer);
    }

}
