package com.training.spring.person.rest.models;

public class StorageRest {

    private String name;
    private String location;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(final String locationParam) {
        this.location = locationParam;
    }


}
