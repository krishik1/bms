package com.bms.management.system.service;

import com.bms.management.system.dto.CreateBookingRequest;
import com.bms.management.system.enums.BookingStatus;
import com.bms.management.system.enums.SeatStatus;
import com.bms.management.system.exceptions.AlreadyBookedException;
import com.bms.management.system.model.Booking;
import com.bms.management.system.model.Show;
import com.bms.management.system.model.ShowSeat;
import com.bms.management.system.model.User;
import com.bms.management.system.repository.BookingRepository;
import com.bms.management.system.strategy.PricingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BookingService implements BookingServiceI {
    private final BookingRepository bookingRepository;
    private final ShowServiceI showService;
    private final UserServiceI userService;
    private final  ShowSeatservice showSeatService;
    private final PricingStrategy pricingStrategy;


    @Override
    public Booking createBooking(CreateBookingRequest request) {
        //Validate the user
        User user = userService.getUserById(request.getUserId());
        if(user == null) {
            throw new NoSuchElementException("User not found with ID: " + request.getUserId());
        }
        //Validate the show
        Show show = showService.getShowById(request.getShowId());
        if(show == null) {
            throw new NoSuchElementException("Show not found with ID: " + request.getShowId());
        }
        List<ShowSeat> lockedSeats = getShowSeats(request);
        showSeatService.saveAll(lockedSeats);
        double totalAmount = lockedSeats.stream()
                .map(pricingStrategy::calculatePrice)
                .reduce(0.0, Double::sum);
        Booking booking = Booking.builder()
                .user(user)
                .show(show)
                .seats(lockedSeats)
                .amount(totalAmount)
                .bookedAt(LocalDate.now())
                .status(BookingStatus.PENDING)
                .build();
        return booking;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<ShowSeat> getShowSeats(CreateBookingRequest request) {
        //validate the show-seats
        List<ShowSeat> showSeats = showSeatService.getAllByShowId(request.getShowSeatIds());
        List<Long> seatIds = showSeats.stream().filter(showSeat -> showSeat.getStatus()!= SeatStatus.AVAILABLE)
                .map(showSeat -> showSeat.getId()).toList();
        if(!seatIds.isEmpty()) {
            throw new AlreadyBookedException("Seats with IDs " + seatIds + " are not available for booking.");
        }

        List<ShowSeat> lockedSeats = showSeats.stream().map(showSeat -> showSeat.toBuilder().status(SeatStatus.LOCKED).build()).toList();
        return lockedSeats;
    }

    //need to add payment flow
}
