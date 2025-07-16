package com.bms.management.system.controller;

import com.bms.management.system.dto.CreateCustomerDto;
import com.bms.management.system.exceptions.InValidCustomerException;
import com.bms.management.system.model.Customer;
import com.bms.management.system.service.CustomerService;
import com.bms.management.system.service.CustomerServiceI;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerServiceI customerService;
    //Get A Customer By ID
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        // Logic to retrieve a customer by ID
        return customerService.getCustomer(id); // Placeholder for actual customer retrieval logic
    }

    //Create A Customer
    @PostMapping
    public  Customer createCustomer(@RequestBody CreateCustomerDto customer) {
        // Logic to create a new customer
        validateCustomer(customer);
        return customerService.createCustomer(customer); // Placeholder for actual customer creation logic
    }

    private void validateCustomer(CreateCustomerDto customer) {
        if(customer.getEmail()==null || customer.getPassword()==null) {
            throw new InValidCustomerException("Email and password must not be null");
        }
    }
}
//create and get apis for movie,show,seat 
