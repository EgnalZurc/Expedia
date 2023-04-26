package com.expedia.api;

import com.expedia.hotel.HotelController;
import com.expedia.hotel.HotelDao;
import com.expedia.hotel.HotelReadDelegate;
import com.expedia.hotel.HotelService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ExpediaApiBaseApplicationTest {

    private ExpediaApiBaseApplication expediaApiBaseApplication;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        expediaApiBaseApplication = new ExpediaApiBaseApplication();
    }

    @Test
    public void testGetClasses() {
        Set<Class<?>> expectedClasses = new HashSet<>();
        expectedClasses.add(HotelController.class);
        assertEquals(expectedClasses, expediaApiBaseApplication.getClasses());
    }

    @Test
    public void testGetSingletons() {
        Set<Object> singletons = expediaApiBaseApplication.getSingletons();
        assertEquals(4, singletons.size());
        assertEquals(HotelService.class, singletons.toArray()[0].getClass());
        assertEquals(HotelController.class, singletons.toArray()[1].getClass());
        assertEquals(HotelDao.class, singletons.toArray()[2].getClass());
        assertEquals(HotelReadDelegate.class, singletons.toArray()[3].getClass());
    }
}
