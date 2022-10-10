package com.example.customerapi.repository;
import com.example.customerapi.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JPA repository for address entities.
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByCity(String city);

    Integer countAddressByCity(String city);

    List<Address> findByStreetOrderByCity(String street);

}

