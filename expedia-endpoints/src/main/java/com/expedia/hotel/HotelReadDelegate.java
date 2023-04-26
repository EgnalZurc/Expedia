package com.expedia.hotel;

import java.util.List;

/**
 * The HotelReadDelegate class is responsible for reading and sorting HotelResource objects
 * using the HotelService class to retrieve and sort the data. It contains a reference to a HotelService
 * instance that is used to retrieve the HotelResource objects.
 */
public class HotelReadDelegate {

    private final HotelService hotelService;

    /**
     * Creates a new instance of the HotelReadDelegate class with the specified HotelService object.
     *
     * @param hotelService the HotelService object to use for retrieving HotelResource objects.
     */
    public HotelReadDelegate(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    /**
     * Retrieves a list of HotelResource objects from the HotelService, sorts them by rating using the
     * sortByRating method, and returns the sorted list.
     *
     * @return a sorted list of HotelResource objects.
     */
    public List<HotelResource> readResources() {
        List<HotelResource> hotels = hotelService.getAllHotels();
        hotelService.sortByRating(hotels);
        return hotels;
    }
}
