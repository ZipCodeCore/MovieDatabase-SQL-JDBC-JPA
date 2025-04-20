package io.zipcoder.persistenceapp;

import javax.persistence.*;

@Entity
@Table(name = "HOME")
public class Home {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String address;
    private int homeNumber;

    public Home() {
    }

    public Home(Long id, String address, int homeNumber) {
        this.id = id;
        this.address = address;
        this.homeNumber = homeNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }
}
