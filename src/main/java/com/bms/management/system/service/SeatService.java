package com.bms.management.system.service;

import com.bms.management.system.model.Seat;
import com.bms.management.system.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class SeatService implements SeatServiceI {


    private final SeatRepository seatRepository;

    @Override
    public List<Seat> saveAll(List<Seat> seats) {
        return seatRepository.saveAll(seats);
    }

    @Override
    public List<Seat> getAllSeatsByScreenId(Long screenId) {
        return seatRepository.findAllByScreenId(screenId);
    }
}
