package com.expedia.hotel;

import com.expedia.location.Location;
import com.expedia.review.Review;

import java.util.List;

public class Hotel {
    private String id;
    private String name;
    private String description;
    private Location location;
    private int totalPrice;
    private String image;
    private List<Review> reviews;
    private boolean swimmingPoolAvailable;

    public String getId() {
        return id;
    }
    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(final String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(final Location location) {
        this.location = location;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(final int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getImage() {
        return image;
    }
    public void setImage(final String image) {
        this.image = image;
    }

    public List<Review> getReviews() {
        return reviews;
    }
    public void setReviews(final List<Review> reviews) {
        this.reviews = reviews;
    }

    public boolean isSwimmingPoolAvailable() {
        return swimmingPoolAvailable;
    }
    public void setSwimmingPoolAvailable(final boolean swimmingPoolAvailable) {
        this.swimmingPoolAvailable = swimmingPoolAvailable;
    }
}
