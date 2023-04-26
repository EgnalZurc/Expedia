package com.expedia.location;

/**
 * A resource representation of a location entity, used for serialization and deserialization in API responses.
 */
public class LocationResource {
    private String id;
    private String name;

    public LocationResource() {
    }

    public LocationResource(Location location) {
        this.id = location.getId();
        this.name = location.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}