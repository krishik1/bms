package com.bms.management.system.repository;

import com.bms.management.system.model.Customer;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Custom query methods can be defined here if needed
    // For example, to find a customer by username:
    // Optional<Customer> findByUsername(String username);


     Optional<Customer> findByEmail(String email);

}
