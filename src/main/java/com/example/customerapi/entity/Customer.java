package com.example.customerapi.entity;

import javax.persistence.*;

/**
 * Objects of this class are representing customers.
 * A customer object contains an id, a first name, a last name, an email and an address.
 */
@Entity
public class Customer {

    /**
     * Id of the customer
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    /**
     * First name of the customer
     */
    private String firstname;

    /**
     * Last name of the customer
     */
    private String lastname;


    /**
     * Email address of the customer
     */
    private String  email;

    /**
     * Creates a new customer object.
     */
    public Customer() {}



    /**
     * Address of the customer
     */
    @OneToOne(cascade = CascadeType.REMOVE)
    private Address address;

    /**
     * Creates a new customer object with the given values.
     * @param firstname first name for the customer
     * @param lastname last name for the customer
     * @param email email address for the customer
     * @param address address for the customer
     */
    public Customer(String firstname, String lastname, String email, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
    }

    /**
     * Returns the address of the customer.
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Changes the address of the customer.
     * @param address new address for the customer
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Returns the id of the customer.
     * @return
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Changes the id of the customer.
     * @param customerId new id for the customer
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * Returns the first name of the customer.
     * @return first name
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Changes the first name of the customer.
     * @param firstName new first name for the customer
     */
    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    /**
     * Returns the last name of the customer.
     * @return last name
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Changes the last name of the customer.
     * @param lastName new last name for the customer
     */
    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    /**
     * Returns the email address of the customer.
     * @return email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Changes the email address of the customer.
     * @param email new email address for the customer
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
