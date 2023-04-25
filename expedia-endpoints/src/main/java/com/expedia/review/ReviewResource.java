package com.expedia.review;

import java.util.Date;

public class ReviewResource {
    private String id;
    private int rating;
    private String comment;
    private String user;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
}