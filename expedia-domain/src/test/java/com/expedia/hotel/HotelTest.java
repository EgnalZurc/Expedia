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
        int price = 100;
        hotel.setTotalPrice(price);
        assertEquals(price, hotel.getTotalPrice());
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
}
