package model;

public class Comment extends Post{
    public Comment(String postContent, User userPosted) {
        super(postContent, userPosted);
        userPosted.addComments(this);
    }
}
