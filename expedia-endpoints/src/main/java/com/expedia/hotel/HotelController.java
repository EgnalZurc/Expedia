package com.expedia.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        System.out.println("Loaded!!!");
        this.hotelService = hotelService;
    }

    @GetMapping("")
    public ResponseEntity<List<HotelResource>> getHotels() {
        List<Hotel> hotels = hotelService.getAllHotelsSortedByRatingDescending();
        return ResponseEntity.ok(hotels.stream().map(HotelResource::new).toList());
    }
}
