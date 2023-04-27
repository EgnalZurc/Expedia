package com.expedia.hotel;

import com.expedia.review.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HotelServiceTest {

    @Mock
    private HotelRepository hotelRepository;

    @InjectMocks
    private HotelService hotelService;

    @Test
    public void testGetHotelById() {
        String id = "1";
        Hotel hotel = new Hotel();
        hotel.setId(id);
        when(hotelRepository.findById(id)).thenReturn(Optional.of(hotel));
        Hotel result = hotelService.getHotelById(id);
        assertEquals(id, result.getId());
    }

    @Test
    public void testGetAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel());
        hotels.add(new Hotel());
        when(hotelRepository.findAll()).thenReturn(hotels);
        List<Hotel> result = hotelService.getAllHotels();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetAllHotelsSortedByRatingDescending() {
        List<Hotel> hotels = Arrays.asList(
                new Hotel.Builder("1").withOneReviewMore(new Review.Builder("Review 1").withRating(3.0F).build()).build(),
                new Hotel.Builder("2").withOneReviewMore(new Review.Builder("Review 1").withRating(4.0F).build()).build()
        );
        when(hotelRepository.findAll()).thenReturn(hotels);

        List<Hotel> result = hotelService.getAllHotelsSortedByRatingDescending();

        assertEquals(4.0F, result.get(0).getRatingAverage(), 0);
        assertEquals(3.0F, result.get(1).getRatingAverage(), 0);
    }

    @Test
    public void testSaveHotel() {
        Hotel hotel = new Hotel();
        when(hotelRepository.save(hotel)).thenReturn(hotel);
        Hotel result = hotelService.saveHotel(hotel);
        assertEquals(hotel, result);
    }

    @Test
    public void testDeleteHotel() {
        String id = "1";
        hotelService.deleteHotel(id);
        verify(hotelRepository, times(1)).deleteById(id);
    }
}

