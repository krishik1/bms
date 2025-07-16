package com.bms.management.system.service;

import com.bms.management.system.dto.CreateCustomerDto;
import com.bms.management.system.model.Customer;

public interface CustomerServiceI {
    Customer getCustomer(Long id);
    Customer createCustomer(CreateCustomerDto createCustomerDto);
}
