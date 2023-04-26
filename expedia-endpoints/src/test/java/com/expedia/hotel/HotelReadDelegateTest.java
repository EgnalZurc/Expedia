package com.expedia.hotel;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

public class HotelReadDelegateTest {

    @Mock
    private HotelService hotelService;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReadResources() {
        HotelReadDelegate hotelReadDelegate = new HotelReadDelegate(hotelService);
        List<Hotel> expectedHotels = new ArrayList<>();
        expectedHotels.add(new Hotel.Builder("Hotel A").build());
        expectedHotels.add(new Hotel.Builder("Hotel B").build());
        expectedHotels.add(new Hotel.Builder("Hotel C").build());

        // Mock the behavior of getAllHotels and sortByRating methods
        when(hotelService.getAllHotels()).thenReturn(expectedHotels);

        List<Hotel> actualHotels = hotelReadDelegate.readResources();

        assertEquals(expectedHotels, actualHotels);
        verify(hotelService, times(1)).sortByRating(expectedHotels);
    }

    @Test(expected = NullPointerException.class)
    public void testReadResourcesWithNullHotelService() {
        HotelReadDelegate hotelReadDelegate = new HotelReadDelegate(null);
        hotelReadDelegate.readResources();
    }
}
