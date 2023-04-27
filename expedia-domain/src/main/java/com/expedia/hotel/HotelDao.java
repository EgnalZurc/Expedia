package com.expedia.hotel;

import com.expedia.location.Location;
import com.expedia.review.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The HotelDao class provides methods to access the database and retrieve information about hotels.
 * It communicates with the database using JDBC and executes SQL queries.
 */
public class HotelDao {

    /**
     * The SQL query to retrieve hotel information, including its location and reviews.
     */
    private static final String HOTEL_QUERY =
            "SELECT h.id, h.name, h.description, h.totalPrice, h.image, h.swimmingPoolAvailable, h.location_id, l.name AS location_name, " +
                    "l.date AS location_date, r.id AS review_id, r.rating, r.comment, r.user, r.date " +
                    "FROM hotel h " +
                    "JOIN location l ON h.location_id = l.id " +
                    "JOIN review r ON h.id = r.hotel_id";
    private final String URL;
    private final String USERNAME;
    private final String PASSWORD;

    /**
     * Constructs a new HotelDao instance.
     *
     * @param url      The URL of the database.
     * @param username The username to access the database.
     * @param password The password to access the database.
     */
    public HotelDao(String url, String username, String password) {
        this.URL = url;
        this.USERNAME = username;
        this.PASSWORD = password;
    }

    /**
     * Returns a list of all hotels from the database, including their locations and reviews.
     *
     * @return A list of all hotels.
     */
    public List<Hotel> getAllHotels() {
        Map<String, Hotel.Builder> hotelBuilders = new HashMap<>();

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(HOTEL_QUERY)) {

            while (rs.next()) {
                String hotelId = rs.getString("id");

                // Build location
                Location location = new Location.Builder(rs.getString("location_id"))
                        .withName(rs.getString("location_name"))
                        .withDate(rs.getDate("location_date"))
                        .build();

                // Build review
                Review review = new Review.Builder(rs.getString("review_id"))
                        .withRating(rs.getFloat("rating"))
                        .withComment(rs.getString("comment"))
                        .withUser(rs.getString("user"))
                        .withDate(rs.getDate("date"))
                        .build();

                // Check if hotel builder already exists, otherwise create new builder
                Hotel.Builder hotelBuilder = hotelBuilders.get(hotelId);
                if (hotelBuilder == null) {
                    hotelBuilder = new Hotel.Builder(hotelId)
                            .withName(rs.getString("name"))
                            .withDescription(rs.getString("description"))
                            .withLocation(location)
                            .withTotalPrice(rs.getFloat("totalPrice"))
                            .withImage(rs.getString("image"))
                            .withSwimmingPoolAvailable(rs.getBoolean("swimmingPoolAvailable"));
                    hotelBuilders.put(hotelId, hotelBuilder);
                }

                // Add review to hotel builder
                hotelBuilder.withOneReviewMore(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Build list of hotels from hotel builders
        List<Hotel> hotels = new ArrayList<>();
        for (Hotel.Builder hotelBuilder : hotelBuilders.values()) {
            hotels.add(hotelBuilder.build());
        }
        return hotels;
    }
}
