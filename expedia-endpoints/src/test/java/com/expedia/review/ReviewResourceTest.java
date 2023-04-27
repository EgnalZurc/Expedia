package com.expedia.review;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReviewResourceTest {

    @Test
    public void testConstructor() {
        final Review review = new Review.Builder("1234").withRating(4.5f).withComment("Good hotel").withUser("John").build();

        ReviewResource reviewResource = new ReviewResource(review);

        assertEquals("1234", reviewResource.getId());
        assertEquals(4.5f, reviewResource.getRating(), 0.1);
        assertEquals("Good hotel", reviewResource.getComment());
        assertEquals("John", reviewResource.getUser());
    }


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
        float rating = 4;
        review.setRating(rating);
        assertEquals(rating, review.getRating(), 0);
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