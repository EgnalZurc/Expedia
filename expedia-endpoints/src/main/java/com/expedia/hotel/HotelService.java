package com.expedia.hotel;

import com.expedia.review.ReviewResource;

import java.util.List;

/**
 * The HotelService class provides services related to hotels such as retrieving all hotels and sorting hotels by rating.
 */
public class HotelService {

    private final HotelDao hotelDao;

    /**
     * Constructor for HotelService that sets the HotelDao object.
     *
     * @param hotelDao The HotelDao object to set.
     */
    public HotelService(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    /**
     * Calculates the average rating for a hotel.
     *
     * @param hotel The hotel to calculate the average rating for.
     * @return The average rating of the hotel.
     */
    public static float getHotelAverageRating(HotelResource hotel) {
        float averageRating = 0;
        List<ReviewResource> reviews = hotel.getReviews();
        if (reviews == null || reviews.isEmpty()) {
            return averageRating;
        }
        for (ReviewResource review : reviews) {
            averageRating += review.getRating();
        }
        return averageRating / reviews.size();
    }

    /**
     * Retrieves all hotels and maps them to a list of HotelResource objects.
     *
     * @return A list of HotelResource objects.
     */
    public List<HotelResource> getAllHotels() {
        return hotelDao.getAllHotels().stream().map(HotelResource::new).toList();
    }

    /**
     * Sorts a list of hotels by rating in descending order.
     *
     * @param hotels The list of hotels to sort.
     */
    public void sortByRating(List<HotelResource> hotels) {
        hotels.sort((h1, h2) -> Float.compare(HotelService.getHotelAverageRating(h2), HotelService.getHotelAverageRating(h1)));
    }
}