package com.expedia.hotel;

import java.util.List;

public class HotelReadDelegate {

    private final HotelService hotelService;

    public HotelReadDelegate(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public List<Hotel> readResources() {
        List<Hotel> hotels = hotelService.getAllHotels();
        hotelService.sortByRating(hotels);
        return hotels;
    }
}
