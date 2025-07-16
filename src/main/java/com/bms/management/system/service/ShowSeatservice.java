package com.bms.management.system.service;

import com.bms.management.system.model.ShowSeat;
import com.bms.management.system.repository.ShowSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShowSeatservice {
    private final ShowSeatRepository showSeatRepository;

    public List<ShowSeat> saveAll(List<ShowSeat> showSeats) {
        return showSeatRepository.saveAll(showSeats);
    }
    public List<ShowSeat> getAllByShowId(List<Long> showIds) {
        return showSeatRepository.findAllById(showIds);
    }
}
