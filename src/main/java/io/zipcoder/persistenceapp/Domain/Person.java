package io.zipcoder.persistenceapp.Domain;

import java.util.Date;

public class Person {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private Date birthDate;
    private int homeId;
    private int id;

    public Person(){
    }
    public Person(String firstName, String lastName, String mobileNumber, Date birthDate, int homeId, int id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.birthDate = birthDate;
        this.homeId = homeId;
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

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return String.format("[%s, %s, %s, %s, %d]", firstName, lastName, mobileNumber, birthDate, homeId);
    }
}
