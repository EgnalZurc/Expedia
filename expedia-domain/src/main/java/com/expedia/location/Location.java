package com.expedia.location;

import javax.persistence.*;

/**
 * The Location class represents a location where a hotel is located.
 * It contains the information about the location, including the ID, name, and date.
 */
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public static class Builder {
        private final String id;
        private String name;
        public Builder(final String id) {
            this.id = id;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Location build() {
            final Location location = new Location();
            location.setId(id);
            location.setName(name);
            return location;
        }
    }

}