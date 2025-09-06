package model;

public class Tags {
    String tagName;
    User user;
    public Tags(String tagName, User user){
        this.tagName = tagName;
        this.user = user;
    }
    public String getTag(){
        return tagName;
    }
}
