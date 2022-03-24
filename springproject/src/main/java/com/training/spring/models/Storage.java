package com.training.spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name = "department_id_gen",
                initialValue = 0,
                allocationSize = 100,
                table = "id_gen",
                pkColumnName = "id_name",
                pkColumnValue = "depart",
                valueColumnName = "id_value")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "department_id_gen")
    private Long   storageId;
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

    public Long getStorageId() {
        return this.storageId;
    }

    public void setStorageId(final Long storageIdParam) {
        this.storageId = storageIdParam;
    }


}
