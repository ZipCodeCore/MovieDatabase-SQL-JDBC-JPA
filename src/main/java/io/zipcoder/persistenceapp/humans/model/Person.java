package io.zipcoder.persistenceapp.humans.model;

import io.zipcoder.persistenceapp.core.model.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class Person extends BaseEntity {

    private static final Long serialVersionUID = 123456789L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @NotEmpty
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotEmpty
    @Column(name = "LAST_NAME"/*, nullable = false*/)
    private String lastName;
    // Check to see if nullable=false is better or @NotEmpty is better

    @Column(name = "BIRTHDAY")
    private String birthday;

    @NotEmpty
    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "HOME_ID")
    private Short homeId;

    public Long getId() {
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

    public Short getHomeId() {
        return homeId;
    }

    public void setHomeId(short homeId) {
        this.homeId = homeId;
    }
}
