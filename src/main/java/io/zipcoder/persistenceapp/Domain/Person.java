package io.zipcoder.persistenceapp.Domain;

import java.util.Date;

public class Person {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private Date birthDate;
    private Integer homeId;
    Long Id;

    public Person(){
    }
    public Person(Long Id, String firstName, String lastName, String mobileNumber){
        this.Id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;

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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(Integer homeId) {
        this.homeId = homeId;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String toString(){
        return String.format("[%s, %s, %s, %s, %d]", firstName, lastName, mobileNumber, birthDate, homeId);
    }
}
