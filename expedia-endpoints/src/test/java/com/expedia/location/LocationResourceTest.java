package com.expedia.location;

import org.junit.Test;

import static org.junit.Assert.*;

public class LocationResourceTest {

    @Test
    public void testConstructor() {
        final Location location = new Location.Builder("1").withName("New York").build();
        LocationResource resource = new LocationResource(location);

        assertEquals("1", resource.getId());
        assertEquals("New York", resource.getName());
    }

    @Test
    public void testSetAndGetId() {
        LocationResource location = new LocationResource();
        String id = "123";
        location.setId(id);
        String result = location.getId();
        assertEquals(id, result);
    }

    @Test
    public void testSetAndGetName() {
        LocationResource location = new LocationResource();
        String name = "Paris";
        location.setName(name);
        String result = location.getName();
        assertEquals(name, result);
    }
}