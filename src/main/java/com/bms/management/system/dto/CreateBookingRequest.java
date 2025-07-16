package com.bms.management.system.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class CreateBookingRequest {
    private Long showId;
    private Long userId;
    private List<Long> showSeatIds = new ArrayList<>();
}
