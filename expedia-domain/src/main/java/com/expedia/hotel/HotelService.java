package com.expedia.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class provides the business logic for managing hotels by using the HotelRepository.
 */
@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    /**
     * Retrieves a hotel by its id.
     *
     * @param id the id of the hotel to be retrieved.
     * @return the hotel with the given id, or null if not found.
     */
    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves all hotels.
     *
     * @return a list of all hotels.
     */
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    /**
     * Retrieves all hotels sorted by their rating in descending order.
     *
     * @return a list of all hotels sorted by rating in descending order.
     */
    public List<Hotel> getAllHotelsSortedByRatingDescending() {
        List<Hotel> hotels = hotelRepository.findAll();
        hotels.sort((hotel1, hotel2) -> Float.compare(hotel2.getRatingAverage(), hotel1.getRatingAverage()));
        return hotels;
    }

    /**
     * Saves a hotel.
     *
     * @param hotel the hotel to be saved.
     * @return the saved hotel.
     */
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    /**
     * Deletes a hotel by its id.
     *
     * @param id the id of the hotel to be deleted.
     */
    public void deleteHotel(String id) {
        hotelRepository.deleteById(id);
    }
}
