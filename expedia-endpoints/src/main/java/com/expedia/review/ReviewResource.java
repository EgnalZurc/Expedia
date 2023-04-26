package com.expedia.review;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * This package contains the ReviewResource class which is a representation of a Review object in the API.
 * It includes annotations for Jackson to handle serialization and deserialization of JSON objects, and
 * specifies that null fields should be excluded from the JSON representation.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReviewResource {
    private String id;
    private float rating;
    private String comment;
    private String user;

    public ReviewResource() {
    }

    public ReviewResource(Review review) {
        this.id = review.getId();
        this.rating = review.getRating();
        this.comment = review.getComment();
        this.user = review.getUser();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
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