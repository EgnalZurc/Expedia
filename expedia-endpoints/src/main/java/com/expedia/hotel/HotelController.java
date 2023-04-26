package com.expedia.hotel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * The HotelController class provides RESTful API endpoints for querying hotels.
 * <p>
 * It handles HTTP GET requests at the "/hotels" endpoint and returns a list of hotels in JSON format.
 * <p>
 * It uses the HotelReadDelegate class to retrieve and sort hotels based on their ratings.
 */
@Path("/hotel")
public class HotelController {

    private final HotelReadDelegate hotelReadDelegate;

    /**
     * Constructs a new HotelController with a given HotelReadDelegate.
     *
     * @param hotelReadDelegate the delegate used to read and sort hotels.
     */
    public HotelController(HotelReadDelegate hotelReadDelegate) {
        this.hotelReadDelegate = hotelReadDelegate;
    }

    /**
     * Handles HTTP GET requests at the "/hotels" endpoint and returns a list of hotels in JSON format.
     *
     * @return a list of hotels sorted by their ratings.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<HotelResource> query() {
        return hotelReadDelegate.readResources();
    }
}