package com.bms.management.system.controller;

import com.bms.management.system.dto.CreateBookingRequest;
import com.bms.management.system.model.Booking;
import com.bms.management.system.service.BookingServiceI;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {
    private final BookingServiceI bookingService;

    public Booking createBooking(CreateBookingRequest request) {
        return bookingService.createBooking(request); // Placeholder return, replace with actual logic
    }
}
