package com.example.customerapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Objects of this class are representing addresses.
 * An address object contains a street, a city, a state and a zip.
 */
@Entity
public class Address {

    /**
     * Id of the address
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addressId;

    /**
     * Name of the street
     */
    private String street;

    /**
     * Name of the City
     */
    private String city;

    /**
     * Name of the state
     */
    private String state;

    /**
     * Zip code
     */
    private String zip;

    /**
     * Creates a new address object.
     */
    public Address() {}

    /**
     * Creates a new address object with the given values.
     * @param street name of the street
     * @param city name of the city
     * @param state name of the state
     * @param zip zip
     */
    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    /**
     * Returns the id of the address.
     * @return address id
     */
    public long getAddressId() {
        return addressId;
    }

    /**
     * Changes the id of the address.
     * @param addressId new id for the address
     */
    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    /**
     * Returns the name of the street of the address.
     * @return street name
     */
    public String getStreet() {
        return street;
    }

    /**
     * Changes the street of the address.
     * @param street new street for the address
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Returns the city of the address.
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * Changes the city of the address.
     * @param city new city for the address
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns the state of the address.
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Changes the state of the address.
     * @param state new state for the address.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Returns the zip of the address.
     * @return zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Changes the zip of the zip.
     * @param zip new zip for the address
     */
    public void setZip(String zip) {
        this.zip = zip;
    }
}
