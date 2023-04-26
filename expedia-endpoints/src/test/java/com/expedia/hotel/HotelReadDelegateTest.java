package com.expedia.hotel;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class HotelReadDelegateTest {

    @Mock
    private HotelService hotelService;

    private HotelReadDelegate hotelDelegate;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        hotelDelegate = new HotelReadDelegate(hotelService);
    }

    @Test
    public void testReadResources() {
        // Setup
        List<Hotel> expectedHotels = Arrays.asList(new Hotel.Builder("hotel1").build(),
                new Hotel.Builder("hotel2").build());
        when(hotelService.getAllHotels()).thenReturn(expectedHotels);

        // Execution
        List<Hotel> actualHotels = hotelDelegate.readResources();

        // Verification
        assertEquals(expectedHotels, actualHotels);
    }
}
