package com.expedia.location;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
    public void testBuilder() {
        final String id = "123";
        final String name = "Paris";

        final Location location = new Location.Builder(id)
                .withName(name)
                .build();

        assertEquals(id, location.getId());
        assertEquals(name, location.getName());
    }

    @Test
    public void testBuilderWithRequiredFields() {
        final String id = "123";

        final Location location = new Location.Builder(id)
                .build();

        assertEquals(id, location.getId());
        assertNull(location.getName());
    }
}
