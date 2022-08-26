package com.example.customerapi.entity;

import javax.persistence.*;

@Entity
public class Customer {

    public Customer(Long customerId, String firstname, String lastname, String email, Address address) {
        this.customerId = customerId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
    }


    public Customer() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    private String firstname;

    private String lastname;

    private String  email;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
