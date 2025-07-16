package com.bms.management.system.service;

import com.bms.management.system.model.Seat;

import java.util.List;

public interface SeatServiceI {
    List<Seat> saveAll(List<Seat> seats);
    List<Seat> getAllSeatsByScreenId(Long screenId);
}
