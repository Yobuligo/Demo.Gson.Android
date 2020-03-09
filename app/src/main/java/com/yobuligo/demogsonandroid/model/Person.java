package com.yobuligo.demogsonandroid.model;

public class Person {

    private Long id;
    private String firstname;
    private String lastname;
    private Gender gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String showMe() {
        return "I'm " + getFirstname() + " " + getLastname() + "\n I'm a " + getGender() + " and have id " + getId();
    }
}
