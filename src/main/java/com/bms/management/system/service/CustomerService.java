package com.bms.management.system.service;

import com.bms.management.system.dto.CreateCustomerDto;
import com.bms.management.system.exceptions.CustomerNotFoundException;
import com.bms.management.system.exceptions.EmailAlreadyExitsException;
import com.bms.management.system.model.Customer;
import com.bms.management.system.model.User;
import com.bms.management.system.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService implements CustomerServiceI {
    private final CustomerRepository customerRepository;
    private final UserServiceI userService;
    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.
                findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public Customer createCustomer(CreateCustomerDto createCustomerDto) {
        Optional<Customer> customer = customerRepository.findByEmail(createCustomerDto.getEmail());
        if(customer.isPresent()) {
            throw new EmailAlreadyExitsException(createCustomerDto.getEmail());
        }
        //Create User
        User user = userService.createUser(createCustomerDto.getEmail(), createCustomerDto.getPassword());
        //Create Customer
        Customer newCustomer = Customer.builder().
                                user(user).
                                fullName(createCustomerDto.getFullName()).
                                email(createCustomerDto.getEmail()).
                                phoneNumber(createCustomerDto.getPhoneNumber()).
                                city(createCustomerDto.getCity())
                                .build();
        return customerRepository.save(newCustomer);
    }
}
