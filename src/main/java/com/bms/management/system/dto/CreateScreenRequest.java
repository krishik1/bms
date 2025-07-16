package com.bms.management.system.dto;

import com.bms.management.system.enums.SeatType;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class CreateHallRequest {
    private String name;// Comma-separated list of features
    private Long cinemaId;
    private Map<SeatType, List<SeatPosition>> seats;
}
