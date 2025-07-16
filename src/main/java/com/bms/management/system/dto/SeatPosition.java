package com.bms.management.system.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SeatPosition {
    private int row;
    private int column;
}
