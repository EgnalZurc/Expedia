package com.expedia.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

/**
 * The HotelController class represents the REST controller for the Hotel resource.
 * <p>
 * It defines the endpoints for handling HTTP requests related to hotels.
 */
@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    /**
     * Constructs a new instance of HotelController and injects the provided HotelService.
     *
     * @param hotelService The HotelService to be used by the controller.
     */
    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    /**
     * Handles GET requests for the list of hotels sorted by rating in descending order.
     *
     * @return A ResponseEntity containing the list of hotels sorted by rating in descending order.
     */
    @GetMapping("")
    public ResponseEntity<List<HotelResource>> getHotels() {
        List<Hotel> hotels = hotelService.getAllHotelsSortedByRatingDescending();
        return ResponseEntity.ok(hotels.stream().map(HotelResource::new).toList());
    }

    @GetMapping("")
    public ResponseEntity<List<HotelResource>> getHotelsFiltered(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Date checkin_date,
            @RequestParam(required = false) Date checkout_date,
            @RequestParam(required = false) List<Float> price_range) {

        List<Hotel> hotels = hotelService.getHotelsSortedByRatingDescending(location, new java.sql.Date(checkin_date.getTime()), new java.sql.Date(checkout_date.getTime()), price_range);
        return ResponseEntity.ok(hotels.stream().map(HotelResource::new).toList());
    }

}
