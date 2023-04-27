package com.expedia.hotel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class HotelControllerTest {

    @Mock
    private HotelReadDelegate hotelReadDelegate;

    private HotelController hotelController;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        hotelController = new HotelController(hotelReadDelegate);
    }

    @Test
    public void testGetHotelsOrderByRating() {
        List<HotelResource> hotels = new ArrayList<>();
        when(hotelReadDelegate.readResources()).thenReturn(hotels);

        List<HotelResource> result = hotelController.query();

        verify(hotelReadDelegate, times(1)).readResources();
        assertEquals(hotels, result);
    }
}
