package com.cragsupplyco.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    @NotBlank
    private String name;

    @Column(length = 255)
    @NotBlank
    private String streetAddress;

    @Column(length = 50)
    @NotBlank
    private String city;

    @Column(length = 2)
    @NotBlank
    @Pattern(regexp = "^[A-Z]{2}$")
    private String state;

    @Column(length = 10)
    @NotBlank
    @Pattern(regexp = "^\\d{5}(-\\d{4})?$")
    private String zipCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Warehouse [id=" + id + ", name=" + name + ", streetAddress=" + streetAddress + ", city=" + city
                + ", state=" + state + ", zipCode=" + zipCode + "]";
    }

}
