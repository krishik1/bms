package com.bms.management.system.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateCustomerDto {
    private String fullName;
    private String city;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;
}
