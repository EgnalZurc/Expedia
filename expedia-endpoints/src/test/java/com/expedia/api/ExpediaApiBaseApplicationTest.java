package com.expedia.api;

import com.expedia.hotel.HotelController;
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

    }
}
