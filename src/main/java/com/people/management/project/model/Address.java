package com.people.management.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zipCode;
    private int number;
    private String city;
    private String state;

    public Address() {
    }

    public Address(String street, String zipCode, int number, String city, String state) {
        this.street = street;
        this.zipCode = zipCode;
        this.number = number;
        this.city = city;
        this.state = state;
    }

    public Address(Long id, String street, String zipCode, int number, String city, String state) {
        this.id = id;
        this.street = street;
        this.zipCode = zipCode;
        this.number = number;
        this.city = city;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
