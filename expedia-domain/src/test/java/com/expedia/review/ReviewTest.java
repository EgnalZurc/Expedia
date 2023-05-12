package com.expedia.review;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        float rating = 4.1F;
        review.setRating(rating);
        assertEquals(rating, review.getRating(), 0.1);
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
    public void testBuilderPattern() {
        final String id = "1";
        final float rating = 4.5f;
        final String comment = "Great hotel!";
        final String user = "John Doe";

        final Review review = new Review.Builder(id)
                .withRating(rating)
                .withComment(comment)
                .withUser(user)
                .build();

        assertNotNull(review);
        assertEquals(id, review.getId());
        assertEquals(rating, review.getRating(), 0.001);
        assertEquals(comment, review.getComment());
        assertEquals(user, review.getUser());
    }
}