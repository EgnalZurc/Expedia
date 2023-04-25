package com.expedia.location;

import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.assertEquals;

public class LocationTest {

    @Test
    public void testSetAndGetId() {
        Location location = new Location();
        String id = "123";
        location.setId(id);
        String result = location.getId();
        assertEquals(id, result);
    }

    @Test
    public void testSetAndGetName() {
        Location location = new Location();
        String name = "Paris";
        location.setName(name);
        String result = location.getName();
        assertEquals(name, result);
    }

    @Test
    public void testSetAndGetDate() {
        Location location = new Location();
        Date date = new Date();
        location.setDate(date);
        Date result = location.getDate();
        assertEquals(date, result);
    }
}
