package com.bms.management.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Customer extends BaseModel {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String city;
    @OneToOne
    private User user;
}
