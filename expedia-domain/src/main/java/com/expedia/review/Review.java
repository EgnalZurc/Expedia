package com.expedia.review;

import com.expedia.hotel.Hotel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Represents a review for a hotel.
 */
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "rating")
    private float rating;
    @Column(name = "comment")
    private String comment;
    @Column(name = "user")
    private String user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private Hotel hotel;

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

    public static class Builder {
        private final String id;
        private float rating;
        private String comment;
        private String user;
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

        public Review build() {
            final Review review = new Review();
            review.setId(id);
            review.setRating(rating);
            review.setComment(comment);
            review.setUser(user);
            return review;
        }
    }
}