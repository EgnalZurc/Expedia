package com.expedia.review;

import java.util.Date;

public class Review {
    private String id;
    private float rating;
    private String comment;
    private String user;
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(final float rating) {
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

    public static class Builder {
        private final String id;
        private float rating;
        private String comment;
        private String user;
        private Date date;

        public Builder(final String id) {
            this.id = id;
        }

        public Builder withRating(float rating) {
            this.rating = rating;
            return this;
        }

        public Builder withComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder withUser(String user) {
            this.user = user;
            return this;
        }

        public Builder withDate(Date date) {
            this.date = date;
            return this;
        }

        public Review build() {
            final Review review = new Review();
            review.setId(id);
            review.setRating(rating);
            review.setComment(comment);
            review.setUser(user);
            review.setDate(date);
            return review;
        }
    }
}