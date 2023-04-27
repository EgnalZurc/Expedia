package com.expedia.hotel;

import com.expedia.location.Location;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class HotelControllerTest {

    @Mock
    private HotelService hotelService;

    private HotelController hotelController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        hotelController = new HotelController(hotelService);
    }

    @Test
    public void testGetHotels() {
        // Arrange
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel.Builder("1").withName("Hotel A").withDescription("Description A").withLocation(new Location())
                .withTotalPrice(100.0f).withImage("Image A").withReviews(new ArrayList<>()).build());
        hotels.add(new Hotel.Builder("2").withName("Hotel B").withDescription("Description B").withLocation(new Location())
                .withTotalPrice(100.0f).withImage("Image B").withReviews(new ArrayList<>()).build());
        when(hotelService.getAllHotelsSortedByRatingDescending()).thenReturn(hotels);

        // Act
        ResponseEntity<List<HotelResource>> responseEntity = hotelController.getHotels();
        List<HotelResource> hotelResources = responseEntity.getBody();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assert hotelResources != null;
        assertEquals(hotels.get(0).getId(), hotelResources.get(0).getId());
        assertEquals(hotels.get(0).getName(), hotelResources.get(0).getName());
        assertEquals(hotels.get(0).getDescription(), hotelResources.get(0).getDescription());
        assertEquals(hotels.get(0).getTotalPrice(), hotelResources.get(0).getTotalPrice(), 0);
        assertEquals(hotels.get(0).getImage(), hotelResources.get(0).getImage());
        assertEquals(hotels.get(0).getLocation().getId(), hotelResources.get(0).getLocation().getId());
        assertEquals(hotels.get(0).getLocation().getName(), hotelResources.get(0).getLocation().getName());
        assertEquals(hotels.get(0).getReviews().size(), hotelResources.get(0).getReviews().size());
    }
}
