package com.expedia.review;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ReviewTest {

    @Test
    public void testSetAndGetId() {
        Review review = new Review();
        String id = "12345";
        review.setId(id);
        assertEquals(id, review.getId());
    }

    @Test
    public void testSetAndGetRating() {
        Review review = new Review();
        int rating = 4;
        review.setRating(rating);
        assertEquals(rating, review.getRating());
    }

    @Test
    public void testSetAndGetComment() {
        Review review = new Review();
        String comment = "Great product!";
        review.setComment(comment);
        assertEquals(comment, review.getComment());
    }

    @Test
    public void testSetAndGetUser() {
        Review review = new Review();
        String user = "johndoe";
        review.setUser(user);
        assertEquals(user, review.getUser());
    }

    @Test
    public void testSetAndGetDate() {
        Review review = new Review();
        Date date = new Date();
        review.setDate(date);
        assertEquals(date, review.getDate());
    }
}