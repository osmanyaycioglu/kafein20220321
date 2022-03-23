package com.training.spring.person.rest.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.training.spring.validation.CheckTwoField;
import com.training.spring.validation.StartWith;

@CheckTwoField(2)
public class PersonRest {

    @NotEmpty(message = "name boş olamaz")
    @Size(min = 2, max = 20, message = "isim {min} ile {max} arasında olmalı")
    @StartWith("n:")
    private String  name;
    @Size(min = 3, max = 25)
    @NotEmpty(message = "surname boş olamaz")
    private String  surname;
    @Positive
    @NotNull
    @Max(300)
    @Min(50)
    private Integer height;
    @Max(300)
    @Min(10)
    private Integer weight;
    @NotEmpty
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
             message = "password min 8 karakter bir sayı bir büyük karakter bir özel karakter barındırmalı")
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


}
