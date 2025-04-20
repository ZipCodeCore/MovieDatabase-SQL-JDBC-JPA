package io.zipcoder.persistenceapp;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "mobile")
    private String mobile;
//    @Temporal(TemporalType.DATE)
//    @Column(name = "birthDate")
//    private Date birthDate;
    @Column(name = "home_id")
    private Long home_id;

    public Person() {
    }

    public Person(Long id, String firstName, String lastName, String mobile, Long home_id) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
//        this.birthDate = birthDate;
        this.home_id = home_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

//    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }

    public Long getHome_id() {
        return home_id;
    }

    public void setHome_id(Long home_id) {
        this.home_id = home_id;
    }
}
