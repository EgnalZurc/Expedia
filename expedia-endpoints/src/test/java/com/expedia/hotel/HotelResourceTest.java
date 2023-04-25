package com.expedia.hotel;

import com.expedia.location.LocationResource;
import com.expedia.review.ReviewResource;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class HotelResourceTest {

    @Test
    public void testSetAndGetId() {
        HotelResource hotel = new HotelResource();
        String id = "12345";
        hotel.setId(id);
        assertEquals(id, hotel.getId());
    }

    @Test
    public void testSetAndGetName() {
        HotelResource hotel = new HotelResource();
        String name = "HotelResource California";
        hotel.setName(name);
        assertEquals(name, hotel.getName());
    }

    @Test
    public void testSetAndGetDescription() {
        HotelResource hotel = new HotelResource();
        String description = "A lovely hotel with beautiful views";
        hotel.setDescription(description);
        assertEquals(description, hotel.getDescription());
    }

    @Test
    public void testSetAndGetLocation() {
        HotelResource hotel = new HotelResource();
        LocationResource location = new LocationResource();
        location.setId("12345");
        location.setName("Los Angeles");
        hotel.setLocation(location);
        assertEquals(location, hotel.getLocation());
    }

    @Test
    public void testSetAndGetTotalPrice() {
        HotelResource hotel = new HotelResource();
        int price = 100;
        hotel.setTotalPrice(price);
        assertEquals(price, hotel.getTotalPrice());
    }

    @Test
    public void testSetAndGetImage() {
        HotelResource hotel = new HotelResource();
        String image = "https://example.com/image.jpg";
        hotel.setImage(image);
        assertEquals(image, hotel.getImage());
    }

    @Test
    public void testSetAndGetReviews() {
        HotelResource hotel = new HotelResource();
        List<ReviewResource> reviews = new ArrayList<>();
        ReviewResource review1 = new ReviewResource();
        review1.setId("1");
        review1.setRating(4);
        review1.setComment("Great hotel");
        review1.setUser("johndoe");
        reviews.add(review1);
        ReviewResource review2 = new ReviewResource();
        review2.setId("2");
        review2.setRating(2);
        review2.setComment("Terrible hotel");
        review2.setUser("janedoe");
        reviews.add(review2);
        hotel.setReviews(reviews);
        assertEquals(reviews, hotel.getReviews());
    }
}
