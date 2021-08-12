package io.zipcoder.persistenceapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Home {

    @Id
    private Long home_id;
    private String address;
    private String homeNumber;

    public Home() {
    }

    public Home(Long home_id, String address, String homeNumber) {
        this.home_id = home_id;
        this.address = address;
        this.homeNumber = homeNumber;
    }

    public Long getHome_id() {
        return home_id;
    }

    public void setHome_id(Long home_id) {
        this.home_id = home_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }
}
