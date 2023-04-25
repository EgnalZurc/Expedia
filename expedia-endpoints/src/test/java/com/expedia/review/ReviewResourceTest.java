package com.expedia.review;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ReviewResourceTest {
    
    @Test
    public void testSetAndGetId() {
        ReviewResource review = new ReviewResource();
        String id = "12345";
        review.setId(id);
        assertEquals(id, review.getId());
    }

    @Test
    public void testSetAndGetRating() {
        ReviewResource review = new ReviewResource();
        int rating = 4;
        review.setRating(rating);
        assertEquals(rating, review.getRating());
    }

    @Test
    public void testSetAndGetComment() {
        ReviewResource review = new ReviewResource();
        String comment = "Great product!";
        review.setComment(comment);
        assertEquals(comment, review.getComment());
    }

    @Test
    public void testSetAndGetUser() {
        ReviewResource review = new ReviewResource();
        String user = "johndoe";
        review.setUser(user);
        assertEquals(user, review.getUser());
    }
}