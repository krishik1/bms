package com.bms.management.system.service;

import com.bms.management.system.dto.CreateBookingRequest;
import com.bms.management.system.model.Booking;

public interface BookingServiceI {
    Booking createBooking(CreateBookingRequest request);
}
