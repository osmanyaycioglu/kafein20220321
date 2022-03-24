package com.training.spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
// @SequenceGenerator(initialValue = 10, name = "xyzSeq", allocationSize = 1, sequenceName = "oracleSequence1")
@TableGenerator(name = "xyzTable",
                initialValue = 10,
                allocationSize = 100,
                table = "id_gen",
                pkColumnName = "id_name",
                pkColumnValue = "xyz",
                valueColumnName = "id_value")
public class Person {

    @Id
    // @GeneratedValue(generator = "xyzSeq", strategy = GenerationType.SEQUENCE)
    @GeneratedValue(generator = "xyzTable", strategy = GenerationType.TABLE)
    private Long    personId;
    private String  name;
    private String  surname;
    private Integer height;
    private Integer weight;
    private String  password;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(final Integer heightParam) {
        this.height = heightParam;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(final Integer weightParam) {
        this.weight = weightParam;
    }

    @Override
    public String toString() {
        return "Person [name="
               + this.name
               + ", surname="
               + this.surname
               + ", height="
               + this.height
               + ", weight="
               + this.weight
               + "]";
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String passwordParam) {
        this.password = passwordParam;
    }

    public Long getPersonId() {
        return this.personId;
    }

    public void setPersonId(final Long personIdParam) {
        this.personId = personIdParam;
    }


}
