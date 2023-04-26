package com.expedia.api;

import com.expedia.hotel.HotelController;
import com.expedia.hotel.HotelDao;
import com.expedia.hotel.HotelReadDelegate;
import com.expedia.hotel.HotelService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/expedia-endpoints")
public class ExpediaApiBaseApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(HotelController.class);
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        Set<Object> singletons = new HashSet<>();
        HotelDao hotelDao = new HotelDao("jdbc:mysql://localhost:3306/hotels", "user", "password");
        HotelService hotelService = new HotelService(hotelDao);
        HotelReadDelegate hotelReadDelegate = new HotelReadDelegate(hotelService);
        HotelController hotelController = new HotelController(hotelReadDelegate);
        singletons.add(hotelDao);
        singletons.add(hotelService);
        singletons.add(hotelReadDelegate);
        singletons.add(hotelController);
        return singletons;
    }
}
