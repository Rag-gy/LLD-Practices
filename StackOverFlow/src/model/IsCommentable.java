package model;

import java.util.List;

public interface IsCommentable {
    public void addComment(String commentContent, User user);
    public List<Comment> getComment();
}
