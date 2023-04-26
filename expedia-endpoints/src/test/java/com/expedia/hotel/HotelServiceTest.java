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

        List<HotelResource> sortedHotels = hotelService.getAllHotels();

        assertEquals(sortedHotels.get(0).getName(), "Hotel A");
        assertEquals(sortedHotels.get(1).getName(), "Hotel B");
        assertEquals(sortedHotels.get(2).getName(), "Hotel C");
    }

    @Test
    public void testSortByRating() {
        final List<HotelResource> hotels = new ArrayList<>();
        final List<Review> reviewList1 = new ArrayList<>();
        final List<Review> reviewList2 = new ArrayList<>();
        final List<Review> reviewList3 = new ArrayList<>();

        reviewList1.add(new Review.Builder("1").withRating(4.5F).build());
        reviewList1.add(new Review.Builder("2").withRating(4.1F).build());
        reviewList2.add(new Review.Builder("3").withRating(3.5F).build());
        reviewList2.add(new Review.Builder("4").withRating(3.1F).build());
        reviewList3.add(new Review.Builder("5").withRating(2.5F).build());
        reviewList3.add(new Review.Builder("6").withRating(2.1F).build());

        hotels.add(new HotelResource(new Hotel.Builder("1").withName("Hotel A").withTotalPrice(100.0f).withReviews(reviewList1).build()));
        hotels.add(new HotelResource(new Hotel.Builder("2").withName("Hotel B").withTotalPrice(200.0f).withReviews(reviewList2).build()));
        hotels.add(new HotelResource(new Hotel.Builder("3").withName("Hotel C").withTotalPrice(300.0f).withReviews(reviewList3).build()));

        hotelService.sortByRating(hotels);

        assertEquals(hotels.get(0).getName(), "Hotel A");
        assertEquals(hotels.get(1).getName(), "Hotel B");
        assertEquals(hotels.get(2).getName(), "Hotel C");
    }

    @Test
    public void testGetAverageRatingWithNoReviews() {
        Hotel hotel = new Hotel.Builder("1").build();
        assertEquals(0.0f, HotelService.getHotelAverageRating(new HotelResource(hotel)), 0.01f);
    }

    @Test
    public void testGetAverageRatingWithOneReview() {
        Review review = new Review.Builder("1").withRating(4.0f).build();
        Hotel hotel = new Hotel.Builder("1").withOneReviewMore(review).build();
        assertEquals(4.0f, HotelService.getHotelAverageRating(new HotelResource(hotel)), 0.01f);
    }

    @Test
    public void testGetAverageRatingWithMultipleReviews() {
        Review review1 = new Review.Builder("1").withRating(4.0f).build();
        Review review2 = new Review.Builder("2").withRating(5.0f).build();
        Review review3 = new Review.Builder("3").withRating(3.0f).build();
        Hotel hotel = new Hotel.Builder("1")
                .withOneReviewMore(review1)
                .withOneReviewMore(review2)
                .withOneReviewMore(review3)
                .build();
        assertEquals(4.0f, HotelService.getHotelAverageRating(new HotelResource(hotel)), 0.01f);
    }

}
