package com.expedia.hotel;

import com.expedia.review.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.*;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DriverManager.class)
public class HotelDaoTest {

    private static final String URL = "jdbc:mysql://localhost:3306/hotels";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";
    private static final String HOTEL_QUERY =
            "SELECT h.id, h.name, h.description, h.totalPrice, h.image, h.swimmingPoolAvailable, l.id AS location_id, l.name AS location_name, " +
                    "l.date AS location_date, r.id AS review_id, r.rating, r.comment, r.user, r.date " +
                    "FROM hotel h " +
                    "JOIN location l ON h.location_id = l.id " +
                    "JOIN review r ON h.id = r.hotel_id";

    @Test
    public void testGetAllHotels() throws SQLException {
        HotelDao hotelDao = new HotelDao(URL, USERNAME, PASSWORD);
        // Mock Connection, Statement and ResultSet
        Connection conn = mock(Connection.class);
        Statement stmt = mock(Statement.class);
        ResultSet rs = mock(ResultSet.class);
        when(conn.createStatement()).thenReturn(stmt);
        when(stmt.executeQuery(HOTEL_QUERY)).thenReturn(rs);

        // Mock DriverManager
        try (MockedStatic<DriverManager> driverManagerMock = Mockito.mockStatic(DriverManager.class)) {
            driverManagerMock.when(() -> DriverManager.getConnection(URL, USERNAME, PASSWORD)).thenReturn(conn);

            // Mock data
            String hotelId = "123";
            String hotelName = "Hotel ABC";
            String hotelDescription = "A lovely hotel";
            float hotelPrice = 100.0f;
            String hotelImage = "image.jpg";
            boolean poolAvailable = true;
            String locationId = "456";
            String locationName = "Location XYZ";
            Date locationDate = Date.valueOf("2022-01-01");
            String reviewId = "789";
            float rating = 4.5f;
            String comment = "Great hotel!";
            String user = "John Doe";
            Date reviewDate = Date.valueOf("2022-02-01");

            when(rs.next()).thenReturn(true, false);
            when(rs.getString("id")).thenReturn(hotelId);
            when(rs.getString("name")).thenReturn(hotelName);
            when(rs.getString("description")).thenReturn(hotelDescription);
            when(rs.getFloat("totalPrice")).thenReturn(hotelPrice);
            when(rs.getString("image")).thenReturn(hotelImage);
            when(rs.getBoolean("swimmingPoolAvailable")).thenReturn(poolAvailable);
            when(rs.getString("location_id")).thenReturn(locationId);
            when(rs.getString("location_name")).thenReturn(locationName);
            when(rs.getDate("location_date")).thenReturn(locationDate);
            when(rs.getString("review_id")).thenReturn(reviewId);
            when(rs.getFloat("rating")).thenReturn(rating);
            when(rs.getString("comment")).thenReturn(comment);
            when(rs.getString("user")).thenReturn(user);
            when(rs.getDate("date")).thenReturn(reviewDate);

            // Execute method to be tested
            List<Hotel> hotels = hotelDao.getAllHotels();

            // Verify the result
            assertEquals(1, hotels.size());
            Hotel hotel = hotels.get(0);
            assertEquals("1", hotel.getId());
            assertEquals("Hotel 1", hotel.getName());
            assertEquals("Description 1", hotel.getDescription());
            assertEquals(100.0f, hotel.getTotalPrice(), 0);
            assertEquals("Image 1", hotel.getImage());
            assertTrue(hotel.isSwimmingPoolAvailable());
            assertEquals("1", hotel.getLocation().getId());
            assertEquals("Location 1", hotel.getLocation().getName());
            assertEquals(new java.sql.Date(System.currentTimeMillis()), hotel.getLocation().getDate());
            assertEquals(1, hotel.getReviews().size());
            Review review = hotel.getReviews().get(0);
            assertEquals("1", review.getId());
            assertEquals(4.5f, review.getRating(), 0.1);
            assertEquals("Comment 1", review.getComment());
            assertEquals("User 1", review.getUser());
            assertEquals(new java.sql.Date(System.currentTimeMillis()), review.getDate());
        }
    }
}
