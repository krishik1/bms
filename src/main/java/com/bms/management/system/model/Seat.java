package com.bms.management.system.model;

import com.bms.management.system.enums.SeatType;
import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "bms_seats")
public class Seat extends BaseModel{
    private Integer rowNo;
    private Integer columnNo;
    @Enumerated
    private SeatType seatType;
    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

}
