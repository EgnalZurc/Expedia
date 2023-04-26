package com.expedia.hotel;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.expedia.review.Review;
import org.junit.Before;
import org.junit.Test;

public class HotelServiceTest {

    private HotelDao hotelDao;
    private HotelService hotelService;

    @Before
    public void setUp() {
        hotelDao = mock(HotelDao.class);
        hotelService = new HotelService(hotelDao);
    }

    @Test
    public void testGetAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel.Builder("1").withName("Hotel A").withTotalPrice(100.0f).build());
        hotels.add(new Hotel.Builder("2").withName("Hotel B").withTotalPrice(200.0f).build());
        hotels.add(new Hotel.Builder("3").withName("Hotel C").withTotalPrice(300.0f).build());

        when(hotelDao.getAllHotels()).thenReturn(hotels);

        List<Hotel> sortedHotels = hotelService.getAllHotels();

        assertEquals(sortedHotels.get(0).getName(), "Hotel A");
        assertEquals(sortedHotels.get(1).getName(), "Hotel B");
        assertEquals(sortedHotels.get(2).getName(), "Hotel C");
    }

    @Test
    public void testSortByRating() {
        final List<Hotel> hotels = new ArrayList<>();
        final List<Review> reviewList1 = new ArrayList<>();
        final List<Review> reviewList2 = new ArrayList<>();
        final List<Review> reviewList3 = new ArrayList<>();

        reviewList1.add(new Review.Builder("1").withRating(4.5F).build());
        reviewList1.add(new Review.Builder("2").withRating(4.1F).build());
        reviewList2.add(new Review.Builder("3").withRating(3.5F).build());
        reviewList2.add(new Review.Builder("4").withRating(3.1F).build());
        reviewList3.add(new Review.Builder("5").withRating(2.5F).build());
        reviewList3.add(new Review.Builder("6").withRating(2.1F).build());

        hotels.add(new Hotel.Builder("1").withName("Hotel A").withTotalPrice(100.0f).withReviews(reviewList1).build());
        hotels.add(new Hotel.Builder("2").withName("Hotel B").withTotalPrice(200.0f).withReviews(reviewList2).build());
        hotels.add(new Hotel.Builder("3").withName("Hotel C").withTotalPrice(300.0f).withReviews(reviewList3).build());

        hotelService.sortByRating(hotels);

        assertEquals(hotels.get(0).getName(), "Hotel A");
        assertEquals(hotels.get(1).getName(), "Hotel B");
        assertEquals(hotels.get(2).getName(), "Hotel C");
    }

}
