package com.expedia.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public List<Hotel> getAllHotelsSortedByRatingDescending() {
        List<Hotel> hotels = hotelRepository.findAll();
        hotels.sort((hotel1, hotel2) -> Float.compare(hotel2.getRatingAverage(), hotel1.getRatingAverage()));
        return hotels;
    }

    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(String id) {
        hotelRepository.deleteById(id);
    }
}
