package com.guestbook.models;

public class CommentRequest {

    private String name;
    private String comment;

    public CommentRequest(String name, String commment) {
        this.name = name;
        this.comment = commment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
