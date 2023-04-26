package com.expedia.hotel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class HotelReadDelegateTest {

    private HotelReadDelegate hotelDelegate;

    @Mock
    private HotelService hotelServiceMock;

    @Before
    public void setUp() {
        hotelDelegate = new HotelReadDelegate(hotelServiceMock);
    }

    @Test
    public void testReadResources() {
        List<Hotel> expectedHotels = new ArrayList<>();
        expectedHotels.add(new Hotel.Builder("1").build());
        expectedHotels.add(new Hotel.Builder("2").build());
        when(hotelServiceMock.getAllHotels()).thenReturn(expectedHotels);

        List<Hotel> actualHotels = hotelDelegate.readResources();

        assertEquals(expectedHotels, actualHotels);
        verify(hotelServiceMock, times(1)).getAllHotels();
    }

    @Test(expected = RuntimeException.class)
    public void testReadResourcesThrowsRuntimeException() {
        when(hotelServiceMock.getAllHotels()).thenThrow(new RuntimeException());

        hotelDelegate.readResources();
    }
}
