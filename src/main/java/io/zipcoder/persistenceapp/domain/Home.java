package io.zipcoder.persistenceapp.domain;

public class Home{
    private Integer id;
    private String address;
    private String homenumber;

    public Home() {
    }

    public Home(String address, String homenumber) {

        this.address = address;
        this.homenumber = homenumber;
    }

    public Home(Integer id, String address, String homenumber) {
        this.id = id;
        this.address = address;
        this.homenumber = homenumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomenumber() {
        return homenumber;
    }

    public void setHomenumber(String homenumber) {
        this.homenumber = homenumber;
    }
}
