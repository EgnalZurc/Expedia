package com.expedia.hotel;

import com.expedia.location.LocationResource;
import com.expedia.review.ReviewResource;

import java.util.List;

/**
 * The HotelResource class represents a resource for a hotel, including its ID, name, description, location,
 * total price, image, and reviews.
 */
public class HotelResource {
    private String id;
    private String name;
    private String description;
    private LocationResource location;
    private float totalPrice;
    private String image;
    private List<ReviewResource> reviews;

    public HotelResource() {
    }

    public HotelResource(Hotel hotel) {
        this.id = hotel.getId();
        this.name = hotel.getName();
        this.description = hotel.getDescription();
        this.totalPrice = hotel.getTotalPrice();
        this.image = hotel.getImage();
        this.location = hotel.getLocation() == null ? null : new LocationResource(hotel.getLocation());
        this.reviews = hotel.getReviews() == null ? null : hotel.getReviews().stream().map(ReviewResource::new).toList();
    }

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

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(final float totalPrice) {
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