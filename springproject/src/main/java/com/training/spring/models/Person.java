package com.training.spring.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity
// @SequenceGenerator(initialValue = 10, name = "xyzSeq", allocationSize = 1, sequenceName = "oracleSequence1")
@TableGenerator(name = "person_id_gen",
                initialValue = 10,
                allocationSize = 100,
                table = "id_gen",
                pkColumnName = "id_name",
                pkColumnValue = "person",
                valueColumnName = "id_value")
public class Person {

    @Id
    // @GeneratedValue(generator = "xyzSeq", strategy = GenerationType.SEQUENCE)
    @GeneratedValue(generator = "person_id_gen", strategy = GenerationType.TABLE)
    private Long             personId;
    @Size(min = 2, max = 20)
    private String           name;
    private String           surname;
    private Integer          height;
    private Integer          weight;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "st_id")
    private Storage          storage;

    @Version
    private Long             dataVersion;

    @Transient
    private PersonCredential personCredential;

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

    public Long getPersonId() {
        return this.personId;
    }

    public void setPersonId(final Long personIdParam) {
        this.personId = personIdParam;
    }

    public Storage getStorage() {
        return this.storage;
    }

    public void setStorage(final Storage storageParam) {
        this.storage = storageParam;
    }

    public PersonCredential getPersonCredential() {
        return this.personCredential;
    }

    public void setPersonCredential(final PersonCredential personCredentialParam) {
        this.personCredential = personCredentialParam;
    }

    public Long getDataVersion() {
        return this.dataVersion;
    }

    public void setDataVersion(final Long dataVersionParam) {
        this.dataVersion = dataVersionParam;
    }

}
