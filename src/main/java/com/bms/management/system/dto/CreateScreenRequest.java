package com.bms.management.system.dto;

import com.bms.management.system.enums.MovieFeature;
import com.bms.management.system.enums.SeatType;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@Data
public class CreateScreenRequest {
    private String name;
    private List<MovieFeature> features = new ArrayList<>();
    private Map<SeatType, List<SeatPosition>> seats = new HashMap<>();

    public static CreateScreenRequest seatsCreation() {
        Map<SeatType, List<SeatPosition>> seats = new HashMap<>();
        seats.put(SeatType.GOLD, List.of(
                new SeatPosition(0,1),
                new SeatPosition(0,2)
        ));
        seats.put(SeatType.VIP, List.of(
                new SeatPosition(10, 0),
                new SeatPosition(10, 1),
                new SeatPosition(10, 2)
        ));

        return CreateScreenRequest.builder()
                .name("Screen 1")
                .features(List.of(MovieFeature.DOLBY_DIGITAL, MovieFeature.THREE_D))
                .seats(seats)
                .build();
    }

}
