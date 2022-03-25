package com.training.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


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
    @Column(name = "level", nullable = false, length = 50)
    private String username;
    @Column(name = "message", nullable = false, length = 50)
    private String password;
    @Column(name = "logId", nullable = false)
    private Long   personId;

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
