package io.zipcoder.persistenceapp.domain;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "PERSON_ID")
    private Long Id;

    @Column(name = "LAST_NAME")
    private String LAST_NAME;

    @Column(name = "FIRST_NAME")
    private String FIRST_NAME;

    @Column(name = "MOBILE")
    private String MOBILE;

    @Column(name = "BIRTHDAY")
    private Long BIRTHDAY;

    @Column(name = "HOME_ID")
    private Integer HOME_ID;

    public Person(){

    }
    public Person(Long Id, String FIRST_NAME, String LAST_NAME, String MOBILE){
        this.Id = Id;
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.MOBILE = MOBILE;

    }
    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getMOBILE() {
        return MOBILE;
    }

    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE;
    }

    public Long getBIRTHDAY() {
        return BIRTHDAY;
    }

    public void setBIRTHDAY(Long BIRTHDAY) {
        this.BIRTHDAY = BIRTHDAY;
    }

    public int getHOME_ID() {
        return HOME_ID;
    }

    public void setHOME_ID(Integer HOME_ID) {
        this.HOME_ID = HOME_ID;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

//    public String toString(){
//        return String.format("[%s, %s, %s, %s, %d]", FIRST_NAME, LAST_NAME, MOBILE, BIRTHDAY, HOME_ID);
//    }
}
