package com.expedia.hotel;

import com.expedia.location.LocationResource;
import com.expedia.review.ReviewResource;

import java.util.List;

public class HotelResource {
    private String id;
    private String name;
    private String description;
    private LocationResource location;
    private int totalPrice;
    private String image;
    private List<ReviewResource> reviews;

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

    public LocationResource getLocation() {
        return location;
    }
    public void setLocation(final LocationResource location) {
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

    public List<ReviewResource> getReviews() {
        return reviews;
    }
    public void setReviews(final List<ReviewResource> reviews) {
        this.reviews = reviews;
    }

}