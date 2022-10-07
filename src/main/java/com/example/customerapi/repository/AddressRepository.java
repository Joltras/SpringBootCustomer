package com.example.customerapi.repository;
import com.example.customerapi.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for address entities.
 */
public interface AddressRepository extends JpaRepository<Address, Long> {}

