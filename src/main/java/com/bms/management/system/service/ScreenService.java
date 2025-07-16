package com.bms.management.system.service;

import com.bms.management.system.dto.CreateScreenRequest;
import com.bms.management.system.dto.SeatPosition;
import com.bms.management.system.enums.SeatType;
import com.bms.management.system.model.Screen;
import com.bms.management.system.repository.ScreenRepository;
import com.bms.management.system.model.Seat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ScreenService implements ScreenServiceI {

    private final ScreenRepository screenRepository;
    private SeatServiceI seatService;

    @Override
    public Screen createScreen(CreateScreenRequest createScreenRequest) {
        Screen screen=Screen.builder()
                .name(createScreenRequest.getName())
                .features(createScreenRequest.getFeatures())
                .build();
        Screen initialScreen = screenRepository.save(screen);
        createScreenRequest=createScreenRequest.seatsCreation();
        List<Seat> seats = toSeats(createScreenRequest.getSeats(), initialScreen);

        return screenRepository.save(initialScreen.toBuilder()
                .seats(seatService.saveAll(seats)).build());
    }

    private List<Seat> toSeats(Map<SeatType, List<SeatPosition>> seats, Screen initialScreen) {

        return seats.entrySet().stream().
                flatMap(entry -> entry.getValue().stream()
                        .map(seatPosition -> Seat.builder()
                                .seatType(entry.getKey())
                                .rowNo(seatPosition.getRow())
                                .columnNo(seatPosition.getColumn())
                                .screen(initialScreen)
                                .build()))
                .toList();
    }

    @Override
    public Screen getScreenById(Long id) {
        return screenRepository.findById(id)
                .orElse(null);
    }


}
