package com.example.customerapi.controller;

import com.example.customerapi.entity.Customer;
import com.example.customerapi.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Customer> getCustomers() {
        return this.customerRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Customer> getCustomer(@PathVariable Long id) {
        return this.customerRepository.findById(id);
    }

    @GetMapping("/getByName/{name}")
    @ResponseBody
    public List<Customer> getCustomerByFirstName(@PathVariable String name) {
       //fin customer by first or last name
        return this.customerRepository.findByFirstnameOrLastname(name, name);
    }

    @PostMapping("/add")
    @ResponseBody
    public Customer createCustomer(@RequestBody Customer customer) {
        return this.customerRepository.save(customer);
    }

    @PutMapping("/{id}/{firstName}")
    @ResponseBody
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @PathVariable String firstName) {
        var customer = this.customerRepository.findById(id);
        if (customer.isPresent()) {
            customer.get().setFirstname(firstName);
            return new ResponseEntity<>(this.customerRepository.save(customer.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        System.out.println(customer);
        var optionalCustomer = this.customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            var customerUpdate = optionalCustomer.get();
            customerUpdate.setFirstname(customer.getFirstname());
            customerUpdate.setLastname(customer.getLastname());
            customerUpdate.setEmail(customer.getEmail());
            customerUpdate.setAddress(customer.getAddress());
            return new ResponseEntity<>(this.customerRepository.save(customerUpdate), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteCustomer(@PathVariable Long id) {
        this.customerRepository.deleteById(id);
    }

}
