package com.example.customerapi.controller;
import com.example.customerapi.entity.Customer;
import com.example.customerapi.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * Rest controller for customer entities.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    /**
     * Repository for customer entities
     */
    private final CustomerRepository customerRepository;

    /**
     * Creates a new customer controller with the given repository.
     * @param customerRepository repository for customer entities
     */
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Returns all customers from the repository.
     * @return list of all customers
     */
    @GetMapping("/getAll")
    @ResponseBody
    public List<Customer> getCustomers() {
        return this.customerRepository.findAll();
    }

    /**
     * Returns the customer with the given id from the repository.
     * @param id id for the customer to get
     * @return customer with the given id
     */
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Customer> getCustomer(@PathVariable Long id) {
        return this.customerRepository.findById(id);
    }

    /**
     * Gets a list of customers wich first name or last name matches the given name.
     * @param name to match
     * @return list of customers wich matches the given name
     */
    @GetMapping("/getByName/{name}")
    @ResponseBody
    public List<Customer> getCustomerByFirstNameOrLastName(@PathVariable String name) {
       //fin customer by first or last name
        return this.customerRepository.findByFirstnameOrLastname(name, name);
    }

    /**
     * Adds a new customer to the repository.
     * @param customer customer to add to the repository
     * @return the saved customer
     */
    @PostMapping("/add")
    @ResponseBody
    public Customer createCustomer(@RequestBody Customer customer) {
        return this.customerRepository.save(customer);
    }

    /**
     * Updates the customer with the given id.
     * @param id id for the customer to update
     * @param customer data to update the customer
     * @return returns ok if the update was successfully otherwise not found
     */
    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Customer> updateFirstName(@PathVariable Long id, @RequestBody Customer customer) {
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

    /**
     * Sets a new first name for the customer with the given id.
     * @param id id for the customer to find.
     * @param firstName new first name for the customer
     * @return ok if customer with the given id was found otherwise not found
     */
    @PostMapping("/{id}/{firstName}")
    @ResponseBody
    public ResponseEntity<Customer> updateFirstName(@PathVariable Long id, @PathVariable String firstName) {
        var customer = this.customerRepository.findById(id);
        if (customer.isPresent()) {
            customer.get().setFirstname(firstName);
            return new ResponseEntity<>(this.customerRepository.save(customer.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes the customer with the given id.
     * @param id id for the customer that should be deleted
     */
    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteCustomer(@PathVariable Long id) {
        this.customerRepository.deleteById(id);
    }

}
