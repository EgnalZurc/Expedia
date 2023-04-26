package com.expedia.hotel;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

import com.expedia.location.Location;
import com.expedia.review.Review;

public class HotelTest {
    @Test
    public void testSetAndGetId() {
        Hotel hotel = new Hotel();
        String id = "12345";
        hotel.setId(id);
        assertEquals(id, hotel.getId());
    }

    @Test
    public void testSetAndGetName() {
        Hotel hotel = new Hotel();
        String name = "Hotel California";
        hotel.setName(name);
        assertEquals(name, hotel.getName());
    }

    @Test
    public void testSetAndGetDescription() {
        Hotel hotel = new Hotel();
        String description = "A lovely hotel with beautiful views";
        hotel.setDescription(description);
        assertEquals(description, hotel.getDescription());
    }

    @Test
    public void testSetAndGetLocation() {
        Hotel hotel = new Hotel();
        Location location = new Location();
        location.setId("12345");
        location.setName("Los Angeles");
        hotel.setLocation(location);
        assertEquals(location, hotel.getLocation());
    }

    @Test
    public void testSetAndGetTotalPrice() {
        Hotel hotel = new Hotel();
        float price = 100.1F;
        hotel.setTotalPrice(price);
        assertEquals(price, hotel.getTotalPrice(), 0.1);
    }

    @Test
    public void testSetAndGetImage() {
        Hotel hotel = new Hotel();
        String image = "https://example.com/image.jpg";
        hotel.setImage(image);
        assertEquals(image, hotel.getImage());
    }

    @Test
    public void testSetAndGetReviews() {
        Hotel hotel = new Hotel();
        List<Review> reviews = new ArrayList<>();
        Review review1 = new Review();
        review1.setId("1");
        review1.setRating(4);
        review1.setComment("Great hotel");
        review1.setUser("johndoe");
        review1.setDate(new Date());
        reviews.add(review1);
        Review review2 = new Review();
        review2.setId("2");
        review2.setRating(2);
        review2.setComment("Terrible hotel");
        review2.setUser("janedoe");
        review2.setDate(new Date());
        reviews.add(review2);
        hotel.setReviews(reviews);
        assertEquals(reviews, hotel.getReviews());
    }

    @Test
    public void testSetAndGetSwimmingPool() {
        Hotel hotel = new Hotel();
        boolean hasSwimmingPool = true;
        hotel.setSwimmingPoolAvailable(hasSwimmingPool);
        assertEquals(hasSwimmingPool, hotel.isSwimmingPoolAvailable());
    }

    @Test
    public void testWithOneReviewMore() {
        Review review1 = new Review.Builder("1")
                .withRating(4.5f)
                .withComment("Great hotel!")
                .withUser("John")
                .build();

        Review review2 = new Review.Builder("2")
                .withRating(3.0f)
                .withComment("Not bad, but not great either.")
                .withUser("Jane")
                .build();

        Hotel hotel = new Hotel.Builder("100")
                .withName("Hotel ABC")
                .withDescription("A lovely hotel with great amenities.")
                .withTotalPrice(200.0f)
                .withImage("https://example.com/image.jpg")
                .withSwimmingPoolAvailable(true)
                .withOneReviewMore(review1)
                .withOneReviewMore(review2)
                .build();

        assertEquals(2, hotel.getReviews().size());
        List<Review> reviews = hotel.getReviews();
        assertEquals(review1, reviews.get(0));
        assertEquals(review2, reviews.get(1));
    }

    @Test
    public void testGetAverageRatingWithNoReviews() {
        Hotel hotel = new Hotel.Builder("1").build();
        assertEquals(0.0f, hotel.getAverageRating(), 0.01f);
    }

    @Test
    public void testGetAverageRatingWithOneReview() {
        Review review = new Review.Builder("1").withRating(4.0f).build();
        Hotel hotel = new Hotel.Builder("1").withOneReviewMore(review).build();
        assertEquals(4.0f, hotel.getAverageRating(), 0.01f);
    }

    @Test
    public void testGetAverageRatingWithMultipleReviews() {
        Review review1 = new Review.Builder("1").withRating(4.0f).build();
        Review review2 = new Review.Builder("2").withRating(5.0f).build();
        Review review3 = new Review.Builder("3").withRating(3.0f).build();
        Hotel hotel = new Hotel.Builder("1")
                .withOneReviewMore(review1)
                .withOneReviewMore(review2)
                .withOneReviewMore(review3)
                .build();
        assertEquals(4.0f, hotel.getAverageRating(), 0.01f);
    }

    @Test
    public void testBuilder() {
        String id = "hotel1";
        String name = "Test Hotel";
        String description = "This is a test hotel";
        Location location = new Location.Builder("location1").build();
        float totalPrice = 100.1f;
        String image = "test_image.jpg";
        List<Review> reviews = new ArrayList<>();
        boolean swimmingPoolAvailable = true;

        Hotel hotel = new Hotel.Builder(id)
                .withName(name)
                .withDescription(description)
                .withLocation(location)
                .withTotalPrice(totalPrice)
                .withImage(image)
                .withReviews(reviews)
                .withSwimmingPoolAvailable(swimmingPoolAvailable)
                .build();

        assertEquals(id, hotel.getId());
        assertEquals(name, hotel.getName());
        assertEquals(description, hotel.getDescription());
        assertEquals(location, hotel.getLocation());
        assertEquals(totalPrice, hotel.getTotalPrice(), 0.1);
        assertEquals(image, hotel.getImage());
        assertEquals(reviews, hotel.getReviews());
        assertEquals(swimmingPoolAvailable, hotel.isSwimmingPoolAvailable());
    }
}
