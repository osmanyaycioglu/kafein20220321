package com.training.spring.rest;

import com.training.spring.core.confprop.Person;

public class HelloPostResponse {

    private Person person;
    private String desc;
    private String version;

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(final Person personParam) {
        this.person = personParam;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(final String descParam) {
        this.desc = descParam;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(final String versionParam) {
        this.version = versionParam;
    }


}
