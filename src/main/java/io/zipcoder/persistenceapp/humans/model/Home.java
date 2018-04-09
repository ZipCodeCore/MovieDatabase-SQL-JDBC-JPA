package io.zipcoder.persistenceapp.humans.model;

import io.zipcoder.persistenceapp.core.model.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class Home extends BaseEntity {

    private static final Long serialVersionUID = 123456789L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @NotEmpty
    @Column(name = "ADDRESS")
    private String address;

    @NotEmpty
    @Column(name = "HOMENUMBER")
    private String homeNumber;

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

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

}
