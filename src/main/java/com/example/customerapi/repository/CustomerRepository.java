package com.example.customerapi.repository;

import com.example.customerapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JPA repository for customer entities.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByFirstnameOrLastname(String firstname, String lastname);
}
