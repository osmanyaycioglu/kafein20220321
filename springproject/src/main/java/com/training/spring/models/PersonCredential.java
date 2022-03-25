package com.training.spring.models;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Size;

import com.training.spring.jpa.EncryptorConverter;


@Entity
@Table(name = "hlog")
@TableGenerator(name = "hlog_id_gen",
                initialValue = 0,
                allocationSize = 100,
                table = "id_gen",
                pkColumnName = "id_name",
                pkColumnValue = "hlog",
                valueColumnName = "id_value")
public class PersonCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "hlog_id_gen")
    private Long   logId;
    @Column(name = "level", nullable = false, length = 250)
    @Size(min = 2, max = 250)
    @Convert(converter = EncryptorConverter.class)
    private String username;
    @Column(name = "message", nullable = false, length = 250)
    @Size(min = 2, max = 250)
    @Convert(converter = EncryptorConverter.class)
    private String password;
    @Column(name = "logme_id", nullable = false)
    private Long   personId;


    @PrePersist
    @PreUpdate
    public void before() {
        //        this.username = EncryptionConfig.getEncryptor()
        //                                        .encrypt(this.username);
        //        this.password = EncryptionConfig.getEncryptor()
        //                                        .encrypt(this.password);
        System.out.println("Before");
    }

    @PostPersist
    @PostUpdate
    @PostLoad
    public void after() {
        //        this.username = EncryptionConfig.getEncryptor()
        //                                        .decrypt(this.username);
        //        this.password = EncryptionConfig.getEncryptor()
        //                                        .decrypt(this.password);
        System.out.println("After");
    }

    @PreRemove
    public void beforeRemove() {

    }

    public Long getLogId() {
        return this.logId;
    }

    public void setLogId(final Long logIdParam) {
        this.logId = logIdParam;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
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
