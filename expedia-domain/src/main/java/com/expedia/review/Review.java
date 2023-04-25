package com.expedia.review;

import java.util.Date;

public class Review {
    private String id;
    private int rating;
    private String comment;
    private String user;
    private Date date;

    public String getId() {
        return id;
    }
    public void setId(final String id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(final int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(final String comment) {
        this.comment = comment;
    }

    public String getUser() {
        return user;
    }
    public void setUser(final String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(final Date date) {
        this.date = date;
    }
}