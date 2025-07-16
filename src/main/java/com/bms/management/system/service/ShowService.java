package com.bms.management.system.service;

import com.bms.management.system.dto.CreateShowRequestDto;
import com.bms.management.system.model.*;
import com.bms.management.system.repository.ShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShowService implements ShowServiceI {
    private final ShowRepository showRepository;
    private final MovieServiceI movieService;
    private final ScreenServiceI screenService;
    private final SeatServiceI seatService;
    private final ShowSeatservice showSeatservice;

    @Override
    public Show createShow(CreateShowRequestDto requestDto) {
        Movie movie = movieService.getMovie(requestDto.getMovieId());
        Screen screen = screenService.getScreenById(requestDto.getScreenId());
        if (movie == null || screen == null) {
            throw new IllegalArgumentException("Movie or Screen not found");
        }
        Show show = Show.builder()
                .movie(movie)
                .screen(screen)
                .startTime(requestDto.getStartTime())
                .build();
        Show savedShow = showRepository.save(show);
        List<Seat> seats = seatService.getAllSeatsByScreenId(screen.getId());
        if (seats == null || seats.isEmpty()) {
            throw new IllegalArgumentException("No seats available for the screen");
        }
        List<ShowSeat> showSeats = seats.stream().map(seat -> ShowSeat.builder()
                .seat(seat)
                .show(savedShow)
                .build())
                .toList();
        List<ShowSeat> savedShowSeats = showSeatservice.saveAll(showSeats);

        return showRepository.save(savedShow.toBuilder()
                .showSeats(savedShowSeats)
                .build());
    }

    @Override
    public Show getShowById(Long id) {
        return showRepository.findById(id)
                .orElse(null);
    }
}
