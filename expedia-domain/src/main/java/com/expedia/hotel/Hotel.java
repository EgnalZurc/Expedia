package com.expedia.hotel;

import com.expedia.location.Location;
import com.expedia.review.Review;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a hotel entity that contains hotel information such as id, name, description, location,
 * total price, image, reviews, and whether swimming pool is available or not. It also has a nested Builder class
 * that helps to construct a Hotel object with only required information.
 */
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;
    @Column(name = "totalPrice")
    private float totalPrice;
    @Column(name = "image")
    private String image;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;
    @Column(name = "swimmingPoolAvailable")
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

    public float getRatingAverage() {
        if (reviews == null || reviews.isEmpty()) {
            return 0.0F;
        }
        return reviews.stream().map(Review::getRating).reduce(0.0f, Float::sum) / reviews.size();
    }

    public static class Builder {
        final private String id;
        private String name;
        private String description;
        private Location location;
        private float totalPrice;
        private String image;
        private List<Review> reviews;
        private boolean swimmingPoolAvailable;

        public Builder(String id) {
            this.id = id;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withLocation(Location location) {
            this.location = location;
            return this;
        }

        public Builder withTotalPrice(float totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder withImage(String image) {
            this.image = image;
            return this;
        }

        public Builder withReviews(List<Review> reviews) {
            this.reviews = reviews;
            return this;
        }

        public Builder withOneReviewMore(Review review) {
            if (reviews == null) {
                reviews = new ArrayList<>();
            }
            reviews.add(review);
            return this;
        }

        public Builder withSwimmingPoolAvailable(boolean swimmingPoolAvailable) {
            this.swimmingPoolAvailable = swimmingPoolAvailable;
            return this;
        }

        public Hotel build() {
            final Hotel hotel = new Hotel();
            hotel.setId(this.id);
            hotel.setName(this.name);
            hotel.setDescription(this.description);
            hotel.setLocation(this.location);
            hotel.setTotalPrice(this.totalPrice);
            hotel.setImage(this.image);
            hotel.setReviews(this.reviews);
            hotel.setSwimmingPoolAvailable(this.swimmingPoolAvailable);
            return hotel;
        }
    }
}
