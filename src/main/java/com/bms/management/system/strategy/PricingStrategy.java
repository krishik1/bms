package com.bms.management.system.strategy;

import com.bms.management.system.model.Booking;
import com.bms.management.system.model.ShowSeat;

public interface PricingStrategy {
    Double calculatePrice(ShowSeat seat);
}
