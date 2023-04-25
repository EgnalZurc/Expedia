package com.expedia.location;

import java.util.Date;

public class Location {

    private String id;
    private String name;

    private Date date;

    public void setId(final String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setName(final String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(final Date date) {
        this.date = date;
    }
}