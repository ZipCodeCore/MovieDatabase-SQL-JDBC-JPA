package io.zipcoder.persistenceapp.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @NotEmpty
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotEmpty
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "BIRTHDAY")
    private String birthday;

    @NotEmpty
    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "HOME_ID")
    private short homeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public short getHomeId() {
        return homeId;
    }

    public void setHomeId(short homeId) {
        this.homeId = homeId;
    }
}
