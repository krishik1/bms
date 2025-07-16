package com.bms.management.system.model;

import com.bms.management.system.enums.PaymentMethodType;
import com.bms.management.system.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.experimental.SuperBuilder;


@Getter
@Entity
@Table(name = "bms_payments")
public class Payment extends BaseModel {
    private String reference;
    private Double amount;

    @Enumerated
    private PaymentMethodType providerType;

    @Enumerated
    private PaymentStatus status;
}
