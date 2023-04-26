package com.expedia.hotel;

import java.util.List;

public class HotelService {

    private final HotelDao hotelDao;

    public HotelService(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = hotelDao.getAllHotels();
        sortByRating(hotels); // sort hotels by rating
        return hotels;
    }

    public void sortByRating(List<Hotel> hotels) {
        hotels.sort((h1, h2) -> Float.compare(h2.getAverageRating(), h1.getAverageRating()));
    }
}