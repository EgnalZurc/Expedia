package com.expedia.hotel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hotels")
public class HotelController {

    private final HotelReadDelegate hotelReadDelegate;

    public HotelController(HotelReadDelegate hotelReadDelegate) {
        this.hotelReadDelegate = hotelReadDelegate;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hotel> query() {
        return hotelReadDelegate.readResources();
    }
}